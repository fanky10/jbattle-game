package com.doinfinite.battlegame.web.controllers;

import javax.annotation.Resource;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class HomeController extends BaseController {

	@Resource
	private String homeMessage;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			model.addAttribute("profile", auth.getPrincipal());
		}
		model.addAttribute("message", getHomeMessage());
		return WebAppConstants.HOME_PAGE;
	}

	public String getHomeMessage() {
		return homeMessage;
	}

	public void setHomeMessage(String homeMessage) {
		this.homeMessage = homeMessage;
	}
}
