package com.kdk.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.kdk.util.CommonConstant;

@Service
public class RealTimeService {

  @Value("${open-api.key}")
  private String apiKey;

  private static String getTagValue(String tag, Element eElement) {
    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
    Node nValue = (Node) nlList.item(0);
    if (nValue == null)
      return null;
    return nValue.getNodeValue();
  }

  public Map<String, Object> trafficAPiCall(long timestamp) throws Exception {
    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    String url = CommonConstant.OPEN_API_DOMAIN + CommonConstant.OPEN_API_TYPE 
        + "?serviceKey=" + apiKey;

    DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
    Document doc = dBuilder.parse(url);

    NodeList nList = doc.getElementsByTagName("list");

    List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

    for (int temp = 0; temp < nList.getLength(); temp++) {
      Node nNode = nList.item(temp);
      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();

        Element eElement = (Element) nNode;
        dataMap.put("trafficAmout", getTagValue("trafficAmout", eElement)); // 교통량
        dataMap.put("speed", getTagValue("speed", eElement)); // 속도
        dataMap.put("routeNo", getTagValue("routeNo", eElement)); // 노선번호
        dataMap.put("routeName", getTagValue("routeName", eElement)); // 도로명

        dataList.add(dataMap);
      }
    }

    resultMap.put("data", dataList);

    return resultMap;
  }

  public int openTSDataInsert(String metric, long timestamp, int value, JSONObject tags) throws JSONException {
    RestTemplate restTemplate = new RestTemplate();
    URI url = URI.create(CommonConstant.TSDB_DOMAIN + CommonConstant.TSDB_TYPE_PUT + "?details");

    JSONObject jsonReq = new JSONObject();
    jsonReq.put("metric", metric);
    jsonReq.put("timestamp", timestamp);
    jsonReq.put("value", value);
    jsonReq.put("tags", tags);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", "*/*");
    headers.add("Content-Type", "application/json;charset=UTF-8");

    HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(jsonReq, headers);
    ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

    Gson gson = new Gson();
    TypeToken<Map<String, Object>> typeToken = new TypeToken<Map<String, Object>>() {};
    Map<String, Object> resBody = gson.fromJson(res.getBody(), typeToken.getType());

    return Integer.parseInt(resBody.get("success").toString());
  }

  public int minuteScheduleF(long timestamp) {
    int result = 0;

    try {

      trafficAPiCall(timestamp);
      result = 1;

    } catch(Exception e) {
      result = 0;
    }

    return result;
  }
}
