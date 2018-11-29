package com.fss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fss.model.UserDetails;
import com.fss.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	public UserService getService() {
		return service;
	}
	@RequestMapping(value="/")
	public String showDetails()
	{
		
		return "home";
	}
	
	@RequestMapping(value="/showPage",method=RequestMethod.GET)
	public String showPage(Model model)
	{
		model.addAttribute("user",new UserDetails());
		return "add";
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user") UserDetails user, BindingResult result)
	{
		ModelAndView mav=null;
		boolean validate=service.save(user);
		if(validate)
		{
			mav=new ModelAndView("welcome");
			mav.addObject("user",user);
		}
		else
		{
			mav=new ModelAndView("error");
		}
		return mav;
	}
	
	@ModelAttribute
	public void dropDownList(Model model)
	{
		List<String> type=new ArrayList<>();
		type.add("INTEGER");
		type.add("STRING");
		type.add("CHARACTER");
		type.add("FLOAT");
		type.add("BOOLEAN");
		type.add("SHORT");
		type.add("DOUBLE");
		type.add("LONG");
		
		List<String> cateogry=new ArrayList<>();
		cateogry.add("Cateogry");
		cateogry.add("MERCHANT");
		cateogry.add("TRANSACTION");
		cateogry.add("CUSTOMER");
		
		model.addAttribute("typeList", type);
		model.addAttribute("cateogryList",cateogry);
	}
}
