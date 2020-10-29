package com.kdk.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.domain.Member;
import com.kdk.service.MemberSerivice;
import com.kdk.util.CommonConstant;

@RestController
@RequestMapping(CommonConstant.API_REQUEST_MEMBER)
public class MemberRestController {

  @Autowired
  private MemberSerivice service;

  @RequestMapping(value = CommonConstant.API_TYPE_LIST, method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> selectMemberList() {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("type", CommonConstant.API_TYPE_LIST);
    result.put("datas", service.selectMemberList());
    result.put("resultCode", CommonConstant.ResponseUtil.API_RESULT_CODE_SUCC);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = CommonConstant.API_TYPE_GET + "/{idx}", method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> selectMember(@PathVariable("idx") Long idx) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("type", CommonConstant.API_TYPE_GET);
    result.put("data", service.selectMember(idx));
    result.put("resultCode", CommonConstant.ResponseUtil.API_RESULT_CODE_SUCC);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = CommonConstant.API_TYPE_POST, method = RequestMethod.POST,
      produces = "application/json; charset=UTF-8")
  public ResponseEntity<Map<String, Object>> insertMember(@RequestBody Member member) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("type", CommonConstant.API_TYPE_POST);
    result.put("resultCode", service.insertMember(member));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = CommonConstant.API_TYPE_PUT, method = RequestMethod.PUT,
      produces = "application/json; charset=UTF-8")
  public ResponseEntity<Map<String, Object>> updateMember(@RequestBody Member member) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("type", CommonConstant.API_TYPE_PUT);
    result.put("resultCode", service.updateMember(member));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = CommonConstant.API_TYPE_DELETE + "/{idx}", method = RequestMethod.DELETE)
  public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable Long idx) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("type", CommonConstant.API_TYPE_DELETE);
    result.put("resultCode", service.deleteMember(idx));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
