package com.kdk.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.seervice.MemberSerivice;
import com.kdk.util.CommonConstant;

@RestController
@RequestMapping(CommonConstant.API_REQUEST_MEMBER)
public class MemberRestController {

  @Autowired
  private MemberSerivice service;

  @RequestMapping(value = CommonConstant.API_TYPE_LIST, method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> selectMemberList() {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("datas", service.selectMemberList());
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
