package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {
	
	@RequestMapping(path="/simple.html")
	public Object simplePage(){
		return new ModelAndView("Simple");
		
	}

}
