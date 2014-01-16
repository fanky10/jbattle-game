package com.doinfinite.battlegame.services;

import java.util.List;

import com.doinfinite.battlegame.model.BattlefieldType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.User;

public interface ServicesManager {
	public List<Unit> getUnits();

	public List<BattlefieldType> getBattlefieldTypes();
	
	public User saveUser(User user)throws DuplicateUserEmailException;
	
	public User findUserByEmail(String email);
	 
}
