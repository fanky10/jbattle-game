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

import com.doinfinite.battlegame.model.BattlefieldType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/dataAccessContext.xml" })
@Transactional
public class BattlefieldTypeRepositoryTest extends TestCase {

	@Autowired
	private BattlefieldTypeRepository battlefieldTypeRepository;

	@Before
	public void buildData() {

	}

	@Test
	public void testGetBattlefieldTypes() {
		List<BattlefieldType> units = getBattlefieldTypeRepository().findAll();
		assertTrue(units != null && !units.isEmpty());
	}

	public BattlefieldTypeRepository getBattlefieldTypeRepository() {
		return battlefieldTypeRepository;
	}

	public void setBattlefieldTypeRepository(
			BattlefieldTypeRepository battlefieldTypeRepository) {
		this.battlefieldTypeRepository = battlefieldTypeRepository;
	}

}