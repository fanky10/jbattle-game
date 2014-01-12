package com.doinfinite.battlegame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.BattlefieldType;
import com.doinfinite.battlegame.model.repository.BattlefieldTypeRepository;
import com.doinfinite.battlegame.services.BattlefieldTypesManager;

@Service
public class BattlefieldTypesManagerImpl implements BattlefieldTypesManager {
	@Autowired
	private BattlefieldTypeRepository battlefieldTypeRepository;

	@Override
	public List<BattlefieldType> getBattlefieldTypes() {
		return getBattlefieldTypeRepository().findAll();
	}

	public BattlefieldTypeRepository getBattlefieldTypeRepository() {
		return battlefieldTypeRepository;
	}

	public void setBattlefieldTypeRepository(
			BattlefieldTypeRepository battlefieldTypeRepository) {
		this.battlefieldTypeRepository = battlefieldTypeRepository;
	}

}
