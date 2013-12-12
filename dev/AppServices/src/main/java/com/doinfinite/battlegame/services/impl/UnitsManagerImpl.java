package com.doinfinite.battlegame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.repository.UnitsRepository;
import com.doinfinite.battlegame.services.UnitsManager;

@Service
public class UnitsManagerImpl implements UnitsManager {

	@Autowired
	private UnitsRepository unitsRepository;

	@Override
	public List<Unit> getUnits() {
		return getUnitsRepository().findAll();
	}

	public UnitsRepository getUnitsRepository() {
		return unitsRepository;
	}

	public void setUnitsRepository(UnitsRepository unitsRepository) {
		this.unitsRepository = unitsRepository;
	}

}
