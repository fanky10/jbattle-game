package com.doinfinite.battlegame.model;

import java.io.Serializable;

public abstract class Unit implements AttackableUnit, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5730523172266224078L;
	protected Integer health = DEFAULT_HEALTH;
	protected Integer speed = DEFAULT_SPEED;
	protected Integer accuracy = DEFAULT_ACCURACY;

	public Unit(Integer health, Integer speed, Integer accuracy) {
		this.health = health;
		this.speed = speed;
		this.accuracy = accuracy;
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
		return this.getClass().getSimpleName();
	}

	public String toString() {
		return getName();
	}

	public boolean isDead() {
		return this.health <= 0;
	}
}
