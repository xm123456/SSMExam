package com.sakila.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErroController {
	@ExceptionHandler({ Exception.class })
	public ModelAndView erro(Exception ex) {
		ModelAndView mav = new ModelAndView("erro");
		mav.addObject("ex", ex);
		return mav;
	}
}
