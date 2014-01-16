package com.doinfinite.battlegame.services;

import com.doinfinite.battlegame.model.User;

public interface UsersManager {
	public User save(User user) throws DuplicateUserEmailException;

	public User findUserByEmail(String email);
}
