package com.doinfinite.battlegame.web.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doinfinite.battlegame.model.Game;
import com.doinfinite.battlegame.model.Game.GameMode;
import com.doinfinite.battlegame.model.Game.GameType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.services.ServicesManager;
import com.doinfinite.battlegame.web.constants.WebAppConstants;

public abstract class BaseController {
	
	@Autowired
	private ServicesManager servicesManager;
	
	@Value("${home.url}")
	protected String homeUrl;

	protected List<Unit> getUnits() {
		return servicesManager.getUnits();
	}

	/**
	 * Looks for error code param in the request
	 * 
	 * @param request
	 * @return the status code integer value
	 */
	protected Integer getStatusCode(HttpServletRequest request) {

		String statusCode = request.getParameter("statusCode");
		Integer statusCodeValue = 500;
		try {
			statusCodeValue = Integer.valueOf(statusCode);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		return statusCodeValue;
	}

	@ModelAttribute("homeURL")
	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	protected List<Unit> getSelectedUnits(HttpServletRequest httpRequest,
			GameType gameType) {
		if (gameType == null) {
			throw new IllegalArgumentException(
					"not a valid game type specified");
		}

		List<Unit> selectedUnits = (List<Unit>) httpRequest
				.getSession()
				.getAttribute(WebAppConstants.SESSION_SELECTED_UNITS + gameType);
		if(selectedUnits==null){
			selectedUnits = new ArrayList<Unit>();
		}
		return selectedUnits;
	}

	protected void updateSelectedUnits(HttpServletRequest httpRequest,
			GameType gameType, List<Unit> selectedUnits) {
		if (gameType == null) {
			throw new IllegalArgumentException(
					"not a valid game type specified");
		}
		httpRequest.getSession().setAttribute(
				WebAppConstants.SESSION_SELECTED_UNITS + gameType,
				selectedUnits);
	}

	protected List<Unit> getFoeSelectedUnits(GameMode gameMode,
			GameType gameType) {
		if (gameType == null || gameMode == null || gameMode == GameMode.PVP) {
			throw new IllegalArgumentException(
					"not a valid game type specified");
		}
		List<Unit> randomUnits = getUnits();
		Collections.shuffle(randomUnits);
		List<Unit> selectedUnits = new ArrayList<Unit>();
		// TODO: check that if gameMode == PVP look for PVP
		for (int i = 0; i < gameType.getMaxUnits(); i++) {
			selectedUnits.add(randomUnits.get(i));
		}
		
		return selectedUnits;
	}

	protected void setGameSettings(HttpServletRequest httpRequest, Game game) {
		httpRequest.getSession().setAttribute(
				WebAppConstants.SESSION_GAME_SETTINGS, game);
	}

	protected Game getGameSettings(HttpServletRequest httpRequest) {
		return (Game) httpRequest.getSession().getAttribute(
				WebAppConstants.SESSION_GAME_SETTINGS);
	}

	public ServicesManager getServicesManager() {
		return servicesManager;
	}

	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}
}
