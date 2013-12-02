package com.doinfinite.battlegame.web.controllers;

import java.util.ArrayList;
import java.util.List;

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
	protected List<Unit> getUnits(){
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
}
