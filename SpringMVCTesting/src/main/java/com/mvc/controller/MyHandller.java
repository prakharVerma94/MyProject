package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyHandller {
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		model.addAttribute("name",name);
		return "greeting";
	}
	
	@RequestMapping("/help")
	public String help(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		model.addAttribute("name",name);
		return "help";
	}
	
	 @RequestMapping("/myView")
	    public String handler(Model model) {
	        model.addAttribute("msg",
	                           "a jar packaging example");
	        return "myView";
	    }

	 @RequestMapping("/prakhar")
	    public String prakhar(Model model) {
		 System.out.println("inside the prakhar...............................................");
	        model.addAttribute("msg",
	                           "a jar packaging example");
	        return "prakhar";
	    }
}
