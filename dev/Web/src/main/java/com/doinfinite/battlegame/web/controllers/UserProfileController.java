package com.doinfinite.battlegame.web.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class UserProfileController extends BaseController {

	@RequestMapping(value = {"/profile" })
	public String show(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "redirect:/";

		}
		model.addAttribute("profile", (User) auth.getPrincipal());
		return WebAppConstants.PROFILE_PAGE;
	}
}
