package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.TelBook;
import model.User;

@Controller
public class SimpleController {
	
	@Autowired
	TelBook telBook;
	
	@RequestMapping(path="/simple.html")
	public ModelAndView simplePage(){
		ModelAndView mv =  new ModelAndView("Simple");
		mv.addObject("basicText", " Witam na naszej Stronie");
		User u = new User("Adam","1234");
		mv.addObject("user",u);
		return mv;
		
	}
	
	@RequestMapping(path="/user/{name}")
	public ModelAndView userGetOperation(@PathVariable String name){
		User u = telBook.book.get(name);
		if (u==null) {
			return new ModelAndView("NoUser");
		}
		ModelAndView mv =  new ModelAndView("Simple");
		mv.addObject("user",u);
		mv.addObject("basicText", "");
		return mv;
	}

	@RequestMapping(path="/user/{name}/{tel}", method=RequestMethod.POST)
	public ModelAndView userPostOperation(@PathVariable String name, @PathVariable String tel){
		User u = new User(name,tel);
		telBook.book.put(name,u);
		
		ModelAndView mv =  new ModelAndView("Simple");
		mv.addObject("user",u);
		mv.addObject("basicText", "Dodano do bazy");
		return mv;
	}
	
	@RequestMapping(path="/user/{name}", method=RequestMethod.DELETE)
	public ModelAndView userDeleteOperation(@PathVariable String name){
		User u = telBook.book.get(name);
		telBook.book.remove(name);
		ModelAndView mv =  new ModelAndView("Simple");
		mv.addObject("user",u);
		mv.addObject("basicText", "Skasowano");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
