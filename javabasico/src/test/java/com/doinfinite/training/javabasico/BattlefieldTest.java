package com.doinfinite.training.javabasico;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.doinfinite.training.javabasico.entidades.Airplane;
import com.doinfinite.training.javabasico.entidades.Chopper;
import com.doinfinite.training.javabasico.entidades.HeavyTank;
import com.doinfinite.training.javabasico.entidades.LightTank;
import com.doinfinite.training.javabasico.entidades.Ship;
import com.doinfinite.training.javabasico.entidades.Submarine;
import com.doinfinite.training.javabasico.entidades.Unit;

/**
 * Unit test for simple App.
 */
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
		new Battlefield(getRedTeam(), getBlueTeam()).battle();;
		assertTrue(true);
	}
	
	private List<Unit> getBlueTeam(){
		List<Unit> team = new ArrayList<Unit>();
		team.add(new Airplane(100));
		team.add(new Chopper(100));
		team.add(new LightTank(100));
		team.add(new LightTank(100));
		return team;
	}
	private List<Unit> getRedTeam(){
		List<Unit> team = new ArrayList<Unit>();
		team.add(new Ship(100));
		team.add(new Submarine(100));
		team.add(new LightTank(100));
		team.add(new LightTank(100));
		return team;
	}
}
