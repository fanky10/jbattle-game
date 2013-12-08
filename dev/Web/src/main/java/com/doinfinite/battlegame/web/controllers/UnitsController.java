package com.doinfinite.battlegame.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doinfinite.battlegame.datafields.GameTypePropertyEditor;
import com.doinfinite.battlegame.model.Game.GameType;
import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class UnitsController extends BaseController {
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(GameType.class,
				new GameTypePropertyEditor());
	}

	@RequestMapping(value = "/units/select/{gameType}", method = RequestMethod.GET)
	public String showUnitsSelection(
			@PathVariable(value = "gameType") GameType gameType, ModelMap map) {
		map.put("availableUnits", getUnits());
		map.put("maxUnits", gameType.getMaxUnits());

		return WebAppConstants.UNITS_SELECT;
	}

	@RequestMapping(value = "/units/select/{gameType}", method = RequestMethod.POST)
	public String saveUnitSelection(
			@PathVariable(value = "gameType") GameType gameType, ModelMap map) {
		map.put("availableUnits", getUnits());
		map.put("maxUnits", gameType.getMaxUnits());

		return WebAppConstants.UNITS_SELECT;
	}
}
