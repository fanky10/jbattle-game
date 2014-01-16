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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.doinfinite.battlegame.model.Role;
import com.doinfinite.battlegame.model.SocialMediaService;
import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.services.DuplicateUserEmailException;
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
			//is already added? :O
			try{
				getServicesManager().saveUser(generatedUser);
			}catch(DuplicateUserEmailException ex){
				//do nothing then
			}
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(generatedUser, null, generatedUser.getAuthorities()));
			ProviderSignInUtils.handlePostSignUp(generatedUser.getEmail(), webRequest);
			return "redirect:/";
		}
		// show signup
		return WebAppConstants.LOGIN_PAGE;
	}

	private User createUser(Connection<?> connection) {
		User generatedUser = new User();
		ConnectionKey providerKey = connection.getKey();
		
		SocialMediaService socialMediaService = SocialMediaService.valueOf(providerKey
				.getProviderId().toUpperCase());
		Date now = new Date(System.currentTimeMillis());
		UserProfile socialMediaProfile = connection.fetchUserProfile();
		generatedUser.setFirstName(socialMediaProfile.getFirstName());
		generatedUser.setLastName(socialMediaProfile.getLastName());
		generatedUser.setCreationTime(now);
		generatedUser.setModificationTime(now);
		generatedUser.setRole(Role.ROLE_USER);		
		generatedUser.setSignInProvider(socialMediaService);
		
		if(socialMediaService == SocialMediaService.TWITTER){
			generatedUser.setEmail("noemail");
		}else{
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
