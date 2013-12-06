package com.doinfinite.battlegame.model;

import java.io.Serializable;

public class Unit implements AttackableUnit, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5730523172266224078L;

	public static enum UnitType {
		EARTH, WATER, AIR
	};

	private Integer health = DEFAULT_HEALTH;
	private Integer speed = DEFAULT_SPEED;
	private Integer accuracy = DEFAULT_ACCURACY;
	private String name;
	private UnitType unitType;
	private Integer damage;

	public Unit(String name, UnitType unitType, Integer health, Integer speed,
			Integer accuracy, Integer damage) {
		this.name = name;
		this.unitType = unitType;
		this.health = health;
		this.speed = speed;
		this.accuracy = accuracy;
		this.damage = damage;
	}

	@Override
	public int defend(int attack) {
		//TODO: add effectiveness
		this.health = health - attack;
		return attack;
	}

	@Override
	public int attack() {
		//TODO: add critical probability
		return damage;
	}

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return getName();
	}

	public boolean isDead() {
		return this.health <= 0;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public void setName(String name) {
		this.name = name;
	}
}
