package com.doinfinite.battlegame.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doinfinite.battlegame.model.Unit;

@Repository
public interface UnitsRepository extends JpaRepository<Unit, Integer> {
	@Query(value = "SELECT units FROM Unit units WHERE units.name like :name")
	List<Unit> findUnitsByName(@Param("name") String name);
}
