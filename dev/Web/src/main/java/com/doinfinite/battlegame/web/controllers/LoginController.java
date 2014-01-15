package com.doinfinite.battlegame.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.doinfinite.battlegame.model.SocialMediaService;
import com.doinfinite.battlegame.model.User;
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

	@RequestMapping(value = "/signup")
	public String signup(HttpServletRequest httpRequest, WebRequest webRequest,
			HttpServletResponse response, Model map) {
		Connection<?> connection = ProviderSignInUtils
				.getConnection(webRequest);
		if (connection != null) {
			User generatedUser = createUser(connection);
			throw new UnsupportedOperationException("signup with social not supported");
			// add user + authorize user + redirect home
		}
		// show signup
		return WebAppConstants.LOGIN_PAGE;
	}

	private User createUser(Connection<?> connection) {
		User generatedUser = new User();
		UserProfile socialMediaProfile = connection.fetchUserProfile();
		generatedUser.setEmail(socialMediaProfile.getEmail());
		generatedUser.setFirstName(socialMediaProfile.getFirstName());
		generatedUser.setLastName(socialMediaProfile.getLastName());

		ConnectionKey providerKey = connection.getKey();
		generatedUser.setSignInProvider(SocialMediaService.valueOf(providerKey
				.getProviderId().toUpperCase()));
		return generatedUser;

	}

	public HomeController getHomeController() {
		return homeController;
	}

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
}
