package com.kdk.web;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kdk.security.domain.SessionUserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

  private final HttpSession httpSession;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    SessionUserDto user = (SessionUserDto) httpSession.getAttribute("user");

    if (user != null) {
      model.addAttribute("userName", user.getName());
    }

    return "thymeleaf/oauthLogin";
  }
}
