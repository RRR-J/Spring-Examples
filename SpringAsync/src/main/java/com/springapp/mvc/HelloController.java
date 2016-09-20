package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	TestService testService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");

		System.out.println("HelloController.printWelcome " + Thread.currentThread().getName());

		// Calling test service which will be executed asynchronously.
		try {
			testService.someBackgroundProcess();
			testService.someBackgroundProcess();
			testService.someBackgroundProcess();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "hello";
	}
}