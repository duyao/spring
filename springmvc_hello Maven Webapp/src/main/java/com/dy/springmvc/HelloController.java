package com.dy.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;
@Controller
//@RequestMapping("/hello")
public class HelloController {
	
	//@RequestMapping(method = RequestMethod.GET)
	 @RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap modelMap){
		modelMap.addAttribute("message","Hello Spring MVC Framework!");
		return "hello";
	}
}
