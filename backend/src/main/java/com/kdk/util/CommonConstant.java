package com.kdk.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
abstract public class CommonConstant {

  abstract public static class ResponseUtil {

    public static final String API_RESULT_CODE_KEY = "resultCode";
    public static final Long API_RESULT_CODE_SUCC = 1L;
    public static final Long API_RESULT_CODE_FAIL = 0L;

    public static Map<String, Object> createErrorObj(String statusName, Object statusCode) {
      Map<String, Object> result = new HashMap<>();
      result.put(API_RESULT_CODE_KEY, API_RESULT_CODE_FAIL);
      result.put("statusCode", statusCode);
      result.put("statusMessage", statusName);
      return Collections.unmodifiableMap(result);
    }
  }

  public static final String API_TYPE_GET = "get";
  public static final String API_TYPE_LIST = "list";
  public static final String API_TYPE_POST = "post";
  public static final String API_TYPE_PUT = "put";
  public static final String API_TYPE_DELETE = "delete";

  public static final String API_REQUEST_MEMBER = "/api/member/";
}
