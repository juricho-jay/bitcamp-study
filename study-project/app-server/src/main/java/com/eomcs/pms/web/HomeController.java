package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
  @GetMapping("/home")
  public String home(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "메인화면");
    mv.addObject("contentUrl", "/home.jsp");
    mv.setViewName("template1");
    return "template1";
  }
}







