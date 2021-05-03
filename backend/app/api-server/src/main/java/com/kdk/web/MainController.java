package com.kdk.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {

    return "thymeleaf/oauthLogin";
  }
}
