package com.doinfinite.battlegame.services;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doinfinite.battlegame.model.BattlefieldType;
import com.doinfinite.battlegame.model.Unit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class ServiceManagerTest extends TestCase {

	@Autowired
	private ServicesManager servicesManager;

	@Test
	public void testGetUnits() {
		List<Unit> units = servicesManager.getUnits();
		assertTrue(units != null && !units.isEmpty());
	}

	@Test
	public void testGetBattlefieldTypes() {
		List<BattlefieldType> battlefieldType = servicesManager
				.getBattlefieldTypes();
		assertTrue(battlefieldType != null && !battlefieldType.isEmpty());
	}
}