package com.doinfinite.battlegame.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.model.repository.UserRepository;
import com.doinfinite.battlegame.services.DuplicateUserEmailException;
import com.doinfinite.battlegame.services.UsersManager;

@Service
public class UsersManagerImpl implements UsersManager {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) throws DuplicateUserEmailException {
		User userByEmail = getUserRepository().findByEmail(user.getEmail());
		if (userByEmail != null) {
			throw new DuplicateUserEmailException();
		}
		return getUserRepository().save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return getUserRepository().findByEmail(email);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
