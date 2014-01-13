package com.doinfinite.battlegame.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private HomeController homeController;

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response, Model map) {

		return getHomeController().home(map);
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, Model map) {

		return WebAppConstants.LOGIN_PAGE;
	}

	public HomeController getHomeController() {
		return homeController;
	}

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
}
