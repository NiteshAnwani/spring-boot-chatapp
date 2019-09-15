package com.training.chatapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest req)
	{
		Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status!=null)
		{
			Integer statuscode=Integer.parseInt(status.toString());
			if(statuscode==HttpStatus.NOT_FOUND.value())
			{
				return "error-404";
			}
			if(statuscode==HttpStatus.INTERNAL_SERVER_ERROR.value())
			{
				System.out.println("**************");
				return "error-500";
			}
			
		}
		return "error";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
