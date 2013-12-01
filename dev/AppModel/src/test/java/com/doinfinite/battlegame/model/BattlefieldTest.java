package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.doinfinite.battlegame.model.air.Airplane;
import com.doinfinite.battlegame.model.air.Chopper;
import com.doinfinite.battlegame.model.earth.HeavyTank;
import com.doinfinite.battlegame.model.earth.LightTank;
import com.doinfinite.battlegame.model.earth.QuickTank;
import com.doinfinite.battlegame.model.earth.Turret;
import com.doinfinite.battlegame.model.water.Ship;

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
		List<Unit> blueTeam = new ArrayList<Unit>();
		blueTeam.add(new Ship(100, 50, 10));
		List<Unit> redTeam = new ArrayList<Unit>();
		redTeam.add(new Turret(100, 50, 10));
		redTeam.add(new Airplane(100, 50, 10));
		redTeam.add(new Chopper(100, 50, 10));
		redTeam.add(new QuickTank(100, 50, 10));
		redTeam.add(new LightTank(100, 50, 10));
		redTeam.add(new HeavyTank(100, 50, 10));
		List<BattleEvent> battleEvents = new Battlefield(redTeam, blueTeam)
				.battle();
		assertTrue(battleEvents != null && !battleEvents.isEmpty());
	}
}
