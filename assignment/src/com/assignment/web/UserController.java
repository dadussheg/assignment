package com.assignment.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
  @Value("${application.dateFormat}")
  private String dataFormat;
  private static Logger logger = Logger.getLogger(UserController.class);
  @RequestMapping(value="/")
public String root(HttpServletRequest request){
  return "index";
  
}
}
