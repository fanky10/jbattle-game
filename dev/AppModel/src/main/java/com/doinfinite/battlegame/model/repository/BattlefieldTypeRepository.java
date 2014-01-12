package com.doinfinite.battlegame.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doinfinite.battlegame.model.BattlefieldType;

@Repository
public interface BattlefieldTypeRepository extends
		JpaRepository<BattlefieldType, Integer> {

}
