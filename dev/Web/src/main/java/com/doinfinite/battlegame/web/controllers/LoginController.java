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
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.doinfinite.battlegame.model.Role;
import com.doinfinite.battlegame.model.SocialMediaService;
import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.services.DuplicateUserEmailException;
import com.doinfinite.battlegame.web.constants.WebAppConstants;
import com.doinfinite.battlegame.web.form.SelectUnitsForm;
import com.doinfinite.battlegame.web.form.UserForm;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private HomeController homeController;

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model map) {

		return getHomeController().home(map);
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model map) {

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
			} catch (DuplicateUserEmailException ex) {
				//do nothing then
			}
			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(generatedUser, null, generatedUser.getAuthorities()));
			ProviderSignInUtils.handlePostSignUp(generatedUser.getEmail(), webRequest);
			return "redirect:/";
		}
		map.addAttribute("userForm",new UserForm());
		// show signup
		return WebAppConstants.SIGNUP_PAGE;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignup(@ModelAttribute UserForm userForm, HttpServletRequest httpRequest, WebRequest webRequest,
			HttpServletResponse response, Model map) {
		
		map.addAttribute("userForm",userForm);
		return WebAppConstants.SIGNUP_PAGE;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String redirectSignin(HttpServletRequest httpRequest, WebRequest webRequest, HttpServletResponse response,
			Model map) {
		return "redirect:/";
	}

	private User createUser(Connection<?> connection) {
		User generatedUser = new User();
		ConnectionKey providerKey = connection.getKey();

		SocialMediaService socialMediaService = SocialMediaService.valueOf(providerKey.getProviderId().toUpperCase());
		Date now = new Date(System.currentTimeMillis());
		UserProfile socialMediaProfile = null;
		if (socialMediaService.equals(SocialMediaService.FACEBOOK)) {
			socialMediaProfile = ((Connection<Facebook>) connection).fetchUserProfile();
		} else if (socialMediaService.equals(SocialMediaService.TWITTER)) {
			socialMediaProfile = ((Connection<Twitter>) connection).fetchUserProfile();
		} else {
			throw new IllegalArgumentException("unrecognized social media service");
		}
		generatedUser.setFirstName(socialMediaProfile.getFirstName());
		generatedUser.setLastName(socialMediaProfile.getLastName());
		generatedUser.setCreationTime(now);
		generatedUser.setModificationTime(now);
		generatedUser.setRole(Role.ROLE_USER);
		generatedUser.setSignInProvider(socialMediaService);

		if (!StringUtils.hasText(socialMediaProfile.getEmail())) {
			generatedUser.setEmail(socialMediaProfile.getUsername() + "@" + providerKey);
		} else {
			generatedUser.setEmail(socialMediaProfile.getEmail());
		}

		return generatedUser;

	}

	public HomeController getHomeController() {
		return homeController;
	}

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
}
