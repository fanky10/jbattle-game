package com.doinfinite.battlegame.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doinfinite.battlegame.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}
