package com.doinfinite.battlegame.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.model.repository.UserRepository;
import com.doinfinite.battlegame.services.DuplicateUserException;
import com.doinfinite.battlegame.services.UsersManager;

@Service
public class UsersManagerImpl implements UsersManager {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) throws DuplicateUserException {
		User userByEmail = getUserRepository().findByUsernameAndSignInProvider(user.getUsername(),
				user.getSignInProvider());
		if (userByEmail != null) {
			throw new DuplicateUserException();
		}
		return getUserRepository().save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return getUserRepository().findByUsername(username);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
