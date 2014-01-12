package com.doinfinite.battlegame.services;

import java.util.List;

import com.doinfinite.battlegame.model.BattlefieldType;
import com.doinfinite.battlegame.model.Unit;

public interface ServicesManager {
	public List<Unit> getUnits();

	public List<BattlefieldType> getBattlefieldTypes();
}
