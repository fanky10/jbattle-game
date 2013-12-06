package com.doinfinite.battlegame.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doinfinite.battlegame.mocked.MockedUnits;
import com.doinfinite.battlegame.model.Game;
import com.doinfinite.battlegame.model.Game.GameMode;
import com.doinfinite.battlegame.model.Game.GameType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.web.constants.WebAppConstants;

public abstract class BaseController {
	@Value("${home.url}")
	protected String homeUrl;

	protected List<Unit> getUnits() {
		return MockedUnits.getAvailableUnits();
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
		if (selectedUnits == null || selectedUnits.isEmpty()) {
			// TODO: delete this and implement the correct go to select your
			// units link (:
			selectedUnits = new ArrayList<Unit>();
			int maxUnits = 0;
			if (gameType == GameType.THREE_VS_THREE) {
				maxUnits = 3;
			}
			if (gameType == GameType.FIVE_VS_FIVE) {
				maxUnits = 5;
			}
			for (int i = 0; i < maxUnits; i++) {
				selectedUnits.add(MockedUnits.getHeavyTeam().get(i));
			}
			httpRequest.getSession().setAttribute(
					WebAppConstants.SESSION_SELECTED_UNITS + gameType,
					selectedUnits);
		}

		return selectedUnits;
	}

	protected List<Unit> getFoeSelectedUnits(GameMode gameMode,
			GameType gameType) {
		if (gameType == null || gameMode == null || gameMode == GameMode.PVP) {
			throw new IllegalArgumentException(
					"not a valid game type specified");
		}

		List<Unit> selectedUnits = new ArrayList<Unit>();
		// TODO: check that if gameMode == PVP look for PVP
		int maxUnits = 0;
		if (gameType == GameType.THREE_VS_THREE) {
			maxUnits = 3;
		}
		if (gameType == GameType.FIVE_VS_FIVE) {
			maxUnits = 5;
		}

		for (int i = 0; i < maxUnits; i++) {
			selectedUnits.add(MockedUnits.getNavyTeam().get(i));
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
}
