package com.doinfinite.battlegame.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.air.Airplane;
import com.doinfinite.battlegame.model.air.Chopper;
import com.doinfinite.battlegame.model.earth.Antiaircraft;
import com.doinfinite.battlegame.model.earth.HeavyTank;
import com.doinfinite.battlegame.model.earth.LightTank;
import com.doinfinite.battlegame.model.earth.QuickTank;
import com.doinfinite.battlegame.model.earth.Troop;
import com.doinfinite.battlegame.model.earth.Turret;
import com.doinfinite.battlegame.model.water.Ship;
import com.doinfinite.battlegame.model.water.Submarine;

public abstract class BaseController {
	@Value("${home.url}")
	protected String homeUrl;

	protected List<Unit> getUnits() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(new Antiaircraft());
		units.add(new Airplane());
		units.add(new Chopper());
		units.add(new HeavyTank());
		units.add(new LightTank());
		units.add(new QuickTank());
		units.add(new Ship());
		units.add(new Submarine());
		units.add(new Troop());
		units.add(new Turret());

		return units;
	}

	/**
	 * Looks for error code param in the request
	 * 
	 * @param request
	 * @return the status code integer value
	 */
	public Integer getStatusCode(HttpServletRequest request) {

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
}
