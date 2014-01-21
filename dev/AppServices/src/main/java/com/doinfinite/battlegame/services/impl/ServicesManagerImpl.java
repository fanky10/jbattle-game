package com.doinfinite.battlegame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.BattlefieldType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.services.BattlefieldTypesManager;
import com.doinfinite.battlegame.services.DuplicateUserException;
import com.doinfinite.battlegame.services.ServicesManager;
import com.doinfinite.battlegame.services.UnitsManager;
import com.doinfinite.battlegame.services.UsersManager;

@Service
public class ServicesManagerImpl implements ServicesManager {
	@Autowired
	private UnitsManager unitsManager;
	@Autowired
	private BattlefieldTypesManager battlefieldTypesManager;
	@Autowired
	private UsersManager usersManager;

	@Override
	public List<Unit> getUnits() {
		return getUnitsManager().getUnits();
	}

	@Override
	public List<BattlefieldType> getBattlefieldTypes() {
		return getBattlefieldTypesManager().getBattlefieldTypes();
	}

	@Override
	public User saveUser(User user) throws DuplicateUserException {
		return getUsersManager().save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return getUsersManager().findUserByUsername(username);
	}

	public UnitsManager getUnitsManager() {
		return unitsManager;
	}

	public void setUnitsManager(UnitsManager unitsManager) {
		this.unitsManager = unitsManager;
	}

	public BattlefieldTypesManager getBattlefieldTypesManager() {
		return battlefieldTypesManager;
	}

	public void setBattlefieldTypesManager(BattlefieldTypesManager battlefieldTypesManager) {
		this.battlefieldTypesManager = battlefieldTypesManager;
	}

	public UsersManager getUsersManager() {
		return usersManager;
	}

	public void setUsersManager(UsersManager usersManager) {
		this.usersManager = usersManager;
	}

}
