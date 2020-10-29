package com.kdk.web;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kdk.util.CommonConstant;

@Controller
public class ErrorController {

  @RequestMapping(value = "/api/error/NOT_FOUND", method = RequestMethod.GET)
  public String error404() {
    return "thymeleaf/error404";
  }

  @RequestMapping(value = "/api/error/{statusName}", method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> errorStatusResponse(@PathVariable("statusName") String statusName) {
    return new ResponseEntity<>((CommonConstant.ResponseUtil.createErrorObj(statusName,
        HttpStatus.valueOf(statusName).value())), HttpStatus.OK);
  }
}