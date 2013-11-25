package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

	List<Unit> units = new ArrayList<Unit>();

	public Team(List<Unit> units) {
		this.units = units;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

}
