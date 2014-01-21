package com.doinfinite.battlegame.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.doinfinite.battlegame.model.Role;
import com.doinfinite.battlegame.model.SocialMediaService;
import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.services.DuplicateUserException;
import com.doinfinite.battlegame.web.constants.WebAppConstants;
import com.doinfinite.battlegame.web.form.UserForm;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private HomeController homeController;
	@Autowired
	private UserProfileController userProfileController;

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model map) {

		return getHomeController().home(map);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model map) {
		if (getAuthorizationProfile() != null) {
			return getUserProfileController().show(map);
		}
		return WebAppConstants.LOGIN_PAGE;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showSignup(HttpServletRequest httpRequest, WebRequest webRequest, HttpServletResponse response,
			Model map) {
		Connection<?> connection = ProviderSignInUtils.getConnection(webRequest);
		if (connection != null) {
			User generatedUser = createUser(connection);
			//is already added? :O
			try {
				getServicesManager().saveUser(generatedUser);
			} catch (DuplicateUserException ex) {
				//do nothing then! it's already there in our database :D
			}
			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(generatedUser, null, generatedUser.getAuthorities()));
			ProviderSignInUtils.handlePostSignUp(generatedUser.getUsername(), webRequest);
			return "redirect:/";
		}
		map.addAttribute("userForm", new UserForm());
		// show signup
		return WebAppConstants.SIGNUP_PAGE;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignup(@ModelAttribute UserForm userForm, HttpServletRequest httpRequest, WebRequest webRequest,
			HttpServletResponse response, Model map) {

		try {
			User generatedUser = createUser(userForm);
			getServicesManager().saveUser(generatedUser);
		} catch (DuplicateUserException ex) {
			//add binding result error.
			//is already added? :O
		}
		map.addAttribute("userForm", userForm);
		return WebAppConstants.SIGNUP_PAGE;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String redirectSignin(@RequestParam("error") String errorMessage, HttpServletRequest httpRequest,
			HttpServletResponse response, Model map) {
		if (StringUtils.hasText(errorMessage)) {
			return "redirect:/error?statusCode=500&error=" + errorMessage;
		}
		//if no error from ProviderSignInController
		return "redirect:/";
	}

	private User createUser(Connection<?> connection) {
		ConnectionKey providerKey = connection.getKey();
		SocialMediaService socialMediaService = SocialMediaService.valueOf(providerKey.getProviderId().toUpperCase());
		Date now = new Date(System.currentTimeMillis());
		UserProfile socialMediaProfile = connection.fetchUserProfile();

		User generatedUser = new User();
		generatedUser.setFirstName(socialMediaProfile.getFirstName());
		generatedUser.setLastName(socialMediaProfile.getLastName());
		generatedUser.setCreationTime(now);
		generatedUser.setModificationTime(now);
		generatedUser.setRole(Role.ROLE_USER);
		generatedUser.setSignInProvider(socialMediaService);
		generatedUser.setEmail(socialMediaProfile.getEmail());
		generatedUser.setUsername(socialMediaProfile.getUsername() + "@" + socialMediaService.name());

		return generatedUser;

	}

	private User createUser(UserForm userForm) {
		Date now = new Date(System.currentTimeMillis());
		User generated = new User();
		User generatedUser = new User();
		generatedUser.setFirstName(userForm.getFirstName());
		generatedUser.setLastName(userForm.getLastName());
		generatedUser.setCreationTime(now);
		generatedUser.setModificationTime(now);
		generatedUser.setRole(Role.ROLE_USER);
		generatedUser.setSignInProvider(SocialMediaService.NONE);
		generatedUser.setEmail(userForm.getEmail());
		generatedUser.setUsername(userForm.getUsername());//it does not require special diferentiation
		return generated;
	}

	public HomeController getHomeController() {
		return homeController;
	}

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}

	public UserProfileController getUserProfileController() {
		return userProfileController;
	}

	public void setUserProfileController(UserProfileController userProfileController) {
		this.userProfileController = userProfileController;
	}
}
