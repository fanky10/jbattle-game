package com.doinfinite.battlegame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.services.ServicesManager;
import com.doinfinite.battlegame.services.UnitsManager;
@Service
public class ServicesManagerImpl implements ServicesManager {
	@Autowired
	private UnitsManager unitsManager;

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

}
