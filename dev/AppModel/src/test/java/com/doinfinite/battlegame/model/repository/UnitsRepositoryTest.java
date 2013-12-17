package com.doinfinite.battlegame.model.repository;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.Unit.UnitType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class UnitsRepositoryTest extends TestCase {
	private Unit unit = new Unit();

	@Autowired
	private UnitsRepository unitsRepository;

	@Before
	public void buildData() {
		unit.setAccuracy(10);
		unit.setHealth(100);
		unit.setName("Plane");
		unit.setSpeed(100);
		unit.setDamage(200);
		unit.setUnitType(UnitType.AIR);

		unit = unitsRepository.save(unit);
	}

	@Test
	public void testGuardarJugador() {
		assertTrue(unitsRepository.exists(unit.getId()));
		assertTrue(unitsRepository.count() > 0);
	}

	@Test
	public void testGetUnitsByName() {
		List<Unit> units = getUnitsRepository().findUnitsByName("Submarine");
		assertTrue(units != null && !units.isEmpty());
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public UnitsRepository getUnitsRepository() {
		return unitsRepository;
	}

	public void setUnitsRepository(UnitsRepository unitsRepository) {
		this.unitsRepository = unitsRepository;
	}

}
