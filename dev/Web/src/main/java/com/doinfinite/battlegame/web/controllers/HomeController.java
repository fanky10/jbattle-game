package com.doinfinite.battlegame.web.controllers;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class HomeController extends BaseController {

	@Resource
	private String homeMessage;
	@Inject
	private ConnectionRepository connectionRepository;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
		if (connection == null) {
			return "redirect:/connect/facebook";
		}
		FacebookProfile facebookProfile = connection.getApi().userOperations().getUserProfile();
		model.addAttribute("profile", facebookProfile);
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
