package com.Project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class MainController {
    
  @RequestMapping("users")
  public String user() {
	  
	  return "redirect:/user";
  }
    
}
