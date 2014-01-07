package com.doinfinite.battlegame.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doinfinite.battlegame.model.Unit.UnitType;
import com.doinfinite.battlegame.model.repository.UnitsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class BattlefieldTest extends TestCase {

	@Autowired
	private UnitsRepository unitsRepository;

	@Test
	public void testHeavyTeam() {
		List<Unit> units = getUnitsRepository().findAll();

		List<Unit> navyTeam = new ArrayList<Unit>();
		List<Unit> heavyTeam = new ArrayList<Unit>();
		for (Unit u : units) {
			if (u.getUnitType() == UnitType.WATER) {
				navyTeam.add(u);
			}
			if (u.getUnitType() == UnitType.EARTH
					|| u.getUnitType() == UnitType.AIR) {
				heavyTeam.add(u);
			}
		}
		List<BattleEvent> battleEvents = new Battlefield(heavyTeam, navyTeam)
				.battle();
		assertTrue(battleEvents != null && !battleEvents.isEmpty()
				&& battleEvents.size() > 1);
	}

	public UnitsRepository getUnitsRepository() {
		return unitsRepository;
	}

	public void setUnitsRepository(UnitsRepository unitsRepository) {
		this.unitsRepository = unitsRepository;
	}
}
