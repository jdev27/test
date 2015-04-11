/**
 * 
 */
package com.jdev.test.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jeruortiz
 *
 */
@Controller
@RequestMapping(value = "/")
public class Main
{
	private static final Logger logger = Logger.getLogger(Main.class);

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String error404(@PathVariable String name, ModelMap model)
	{
		model.addAttribute("pageName", name);
		model.addAttribute("defaultPageLink", "/index.jsp");
		model.addAttribute("defaultPage", "first page");
		logger.info("Error Page");
		return "error404";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloWorld(String name, ModelMap model)
	{
		model.put("name", name);
		logger.info("hello");
		return "hello";
	}

	@RequestMapping(value = "/resourceNotFound}", method = RequestMethod.GET)
	public String defaultError404(@PathVariable String name, ModelMap model)
	{

		model.addAttribute("pageName", "");
		model.addAttribute("defaultPageLink", "/index.jsp");
		model.addAttribute("defaultPage", "first page");
		logger.info("Error Page");
		return "error404";
	}

	@RequestMapping(value = "/uncaughtException}", method = RequestMethod.GET)
	public String exceptionError(@PathVariable String name, ModelMap model)
	{
		model.addAttribute("stacktrace", "Error");
		model.addAttribute("defaultPageLink", "/index.jsp");
		model.addAttribute("defaultPage", "first page");
		logger.info("Uncaught Exception Page");
		return "ExceptionError";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test()
	{
		logger.info("test static page");
		System.out.println("/test");
		return "redirect:static/test.html";
	}
}
