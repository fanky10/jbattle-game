package com.doinfinite.battlegame.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class GameController extends BaseController {
	@RequestMapping(value = "/game/units/select", method = RequestMethod.GET)
	public String showGameSelect(ModelMap map) {
		map.put("availableUnits", getUnits());
		return WebAppConstants.UNITS_SELECT;
	}
}
