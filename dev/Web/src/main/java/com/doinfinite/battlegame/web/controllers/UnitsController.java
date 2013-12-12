package com.doinfinite.battlegame.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doinfinite.battlegame.datafields.GameTypePropertyEditor;
import com.doinfinite.battlegame.datafields.UnitPropertyEditor;
import com.doinfinite.battlegame.model.Game.GameType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.web.constants.WebAppConstants;
import com.doinfinite.battlegame.web.form.SelectUnitsForm;

@Controller
public class UnitsController extends BaseController {
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(GameType.class,
				new GameTypePropertyEditor());
		binder.registerCustomEditor(Unit.class, new UnitPropertyEditor(getServicesManager()));
	}

	@RequestMapping(value = "/units/select/{gameType}", method = RequestMethod.GET)
	public String showUnitsSelection(HttpServletRequest httpRequest,
			@PathVariable(value = "gameType") GameType gameType, ModelMap map) {
		SelectUnitsForm form = new SelectUnitsForm();
		List<Unit> selectedUnits = getSelectedUnits(httpRequest, gameType);
		if (!selectedUnits.isEmpty()) {
			form.setSelectedUnits(selectedUnits);
		}
		map.put("availableUnits", getUnits());
		map.put("maxUnits", gameType.getMaxUnits());
		map.put("selectUnitsForm", form);

		return WebAppConstants.UNITS_SELECT;
	}

	@RequestMapping(value = "/units/select/{gameType}", method = RequestMethod.POST)
	public String saveUnitSelection(HttpServletRequest httpRequest,
			@PathVariable(value = "gameType") GameType gameType,
			@ModelAttribute SelectUnitsForm form, ModelMap map) {
		map.put("availableUnits", getUnits());
		map.put("maxUnits", gameType.getMaxUnits());
		map.put("selectUnitsForm", form);
		List<Unit> selectedUnits = form.getSelectedUnits();
		updateSelectedUnits(httpRequest, gameType, selectedUnits);

		return WebAppConstants.UNITS_SELECT;
	}
}
