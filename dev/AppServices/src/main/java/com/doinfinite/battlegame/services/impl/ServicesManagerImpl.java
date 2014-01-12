package com.doinfinite.battlegame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.BattlefieldType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.services.BattlefieldTypesManager;
import com.doinfinite.battlegame.services.ServicesManager;
import com.doinfinite.battlegame.services.UnitsManager;

@Service
public class ServicesManagerImpl implements ServicesManager {
	@Autowired
	private UnitsManager unitsManager;
	@Autowired
	private BattlefieldTypesManager battlefieldTypesManager;

	@Override
	public List<Unit> getUnits() {
		// TODO Auto-generated method stub
		return getUnitsManager().getUnits();
	}

	public UnitsManager getUnitsManager() {
		return unitsManager;
	}

	public void setUnitsManager(UnitsManager unitsManager) {
		this.unitsManager = unitsManager;
	}

	@Override
	public List<BattlefieldType> getBattlefieldTypes() {
		// TODO Auto-generated method stub
		return getBattlefieldTypesManager().getBattlefieldTypes(); 
	}

	public BattlefieldTypesManager getBattlefieldTypesManager() {
		return battlefieldTypesManager;
	}

	public void setBattlefieldTypesManager(
			BattlefieldTypesManager battlefieldTypesManager) {
		this.battlefieldTypesManager = battlefieldTypesManager;
	}

}
