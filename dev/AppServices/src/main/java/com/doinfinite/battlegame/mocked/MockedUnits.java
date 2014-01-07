package com.doinfinite.battlegame.mocked;

import java.util.ArrayList;
import java.util.List;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.Unit.UnitType;

public class MockedUnits {
	public static List<Unit> getQuickTeam() {
		List<Unit> quickUnits = new ArrayList<Unit>();
		for (Unit unit : getAvailableUnits()) {
			if (unit.getSpeed() > 50) {
				quickUnits.add(unit);
			}
		}
		return quickUnits;
	}

	public static List<Unit> getNavyTeam() {
		List<Unit> quickUnits = new ArrayList<Unit>();
		for (Unit unit : getAvailableUnits()) {
			if (unit.getUnitType() == UnitType.WATER) {
				quickUnits.add(unit);
			}
		}
		return quickUnits;
	}

	public static List<Unit> getHeavyTeam() {
		List<Unit> quickUnits = new ArrayList<Unit>();
		for (Unit unit : getAvailableUnits()) {
			if (unit.getHealth() > 200) {
				quickUnits.add(unit);
			}
		}
		return quickUnits;
	}

	public static List<Unit> getAvailableUnits() {
		List<Unit> availableUnits = new ArrayList<Unit>();
		availableUnits.add(new Unit("Airplane", UnitType.AIR, 300, 50, 10, 70,
				20));
		availableUnits.add(new Unit("Apache Chopper", UnitType.AIR, 150, 70,
				10, 100, 20));
		availableUnits.add(new Unit("Biplaned", UnitType.AIR, 150, 70, 10, 100,
				20));
		availableUnits.add(new Unit("SingleEngine", UnitType.AIR, 150, 70, 10,
				100, 20));
		availableUnits.add(new Unit("Jet and rocket", UnitType.AIR, 150, 70,
				10, 100, 20));
		availableUnits.add(new Unit("Bomber", UnitType.AIR, 150, 70, 10, 100,
				20));

		availableUnits.add(new Unit("Antiaircraft", UnitType.EARTH, 70, 50, 10,
				100, 20));
		availableUnits.add(new Unit("HeavyTank", UnitType.EARTH, 500, 50, 10,
				100, 20));
		availableUnits.add(new Unit("QuickTank", UnitType.EARTH, 100, 100, 10,
				130, 20));
		availableUnits.add(new Unit("LightTank", UnitType.EARTH, 100, 150, 10,
				120, 20));
		availableUnits.add(new Unit("Troop", UnitType.EARTH, 100, 50, 10, 70,
				20));
		availableUnits.add(new Unit("Turret", UnitType.EARTH, 100, 50, 10, 100,
				20));

		availableUnits
				.add(new Unit("Ship", UnitType.WATER, 300, 50, 10, 70, 200));
		availableUnits.add(new Unit("Aircraft carrier", UnitType.WATER, 300,
				50, 10, 70, 20));
		availableUnits.add(new Unit("Assault ship", UnitType.WATER, 300, 50,
				10, 70, 20));
		availableUnits.add(new Unit("Destroyer", UnitType.WATER, 300, 50, 10,
				70, 20));
		availableUnits.add(new Unit("Submarine", UnitType.WATER, 200, 60, 10,
				70, 20));

		return availableUnits;
	}
}
