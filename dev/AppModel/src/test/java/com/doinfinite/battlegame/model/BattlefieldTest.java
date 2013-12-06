package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.doinfinite.battlegame.model.Unit.UnitType;

public class BattlefieldTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public BattlefieldTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(BattlefieldTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testHeavyTeam() {
		List<Unit> navyTeam = new ArrayList<Unit>();
		navyTeam.add(new Unit("Ship", UnitType.WATER, 100, 50, 10, 70));
		List<Unit> heavyTeam = new ArrayList<Unit>();
		heavyTeam.add(new Unit("Airplane", UnitType.AIR, 100, 50, 10, 70));
		heavyTeam.add(new Unit("Apache Chopper", UnitType.AIR, 100, 50, 10, 70));
		heavyTeam.add(new Unit("QuickTank", UnitType.EARTH, 100, 50, 10, 70));
		heavyTeam.add(new Unit("LightTank", UnitType.EARTH, 100, 50, 10, 70));
		heavyTeam.add(new Unit("Troop", UnitType.EARTH, 100, 50, 10, 70));
		heavyTeam.add(new Unit("Turret", UnitType.EARTH, 100, 50, 10, 70));
		List<BattleEvent> battleEvents = new Battlefield(heavyTeam, navyTeam)
				.battle();
		assertTrue(battleEvents != null && !battleEvents.isEmpty() && battleEvents.size()>1);
	}
}
