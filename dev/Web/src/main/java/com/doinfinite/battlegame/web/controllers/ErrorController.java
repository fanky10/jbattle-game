package com.doinfinite.battlegame.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class ErrorController extends BaseController {

	@RequestMapping(value = "/error")
	public String showErrorPage(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) throws Exception {
		Integer statusCode = getStatusCode(request);
		response.setStatus(statusCode);
		String title = "Application Error";
		String label = "Unexpected Error";
		String body = "We cannot process your request at the moment";
		if (statusCode == 404) {
			title = "Page not found";
			label = "The page you requested cannot be found";
			body = "Check the url, you might have mispelled something";
		}
		map.addAttribute("title", title);
		map.addAttribute("label", label);
		map.addAttribute("body", body);
		map.addAttribute("statusCode", statusCode);

		return WebAppConstants.STATIC_ERROR_PAGE;
	}
}
