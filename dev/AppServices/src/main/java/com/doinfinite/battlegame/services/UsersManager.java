package com.doinfinite.battlegame.services;

import com.doinfinite.battlegame.model.User;

public interface UsersManager {
	public User save(User user) throws DuplicateUserException;

	public User findUserByUsername(String username);
}
