package com.example.thirteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author haha
 */
@Controller
public class template {


  @GetMapping("/login")
  public  String login(){
    return "html/login.html";
  }

  @GetMapping("/current.html")
  public  String c(){
    return "html/current.html";
  }

  @GetMapping("/menu.html")
  public  String m(){
    return "html/menu.html";
  }

  @GetMapping("/sort.html")
  public  String s(){
    return "html/sort.html";
  }
  @GetMapping("/result.html")
  public  String r(){
    return "html/result.html";
  }


}
