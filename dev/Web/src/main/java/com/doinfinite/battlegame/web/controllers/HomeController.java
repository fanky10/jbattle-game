package com.doinfinite.battlegame.web.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class HomeController extends BaseController {

	@Resource
	private String homeMessage;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model map) {
		map.addAttribute("mensaje", getHomeMessage());
		return WebAppConstants.HOME_PAGE;
	}

	public String getHomeMessage() {
		return homeMessage;
	}

	public void setHomeMessage(String homeMessage) {
		this.homeMessage = homeMessage;
	}
}
