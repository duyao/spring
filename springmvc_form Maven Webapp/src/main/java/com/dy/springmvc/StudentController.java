package com.dy.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView studnet() {
		//?
		return new ModelAndView("student", "command", new Student());
	}

	//uri是addStudent
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	//@ModelAttribute()??
	public String addStudent(@ModelAttribute("springWeb") Student student,
			ModelMap model) {
		System.out.println(student.getName());
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());
		//return jsp with name-result.jsp
		return "result";
	}

}
