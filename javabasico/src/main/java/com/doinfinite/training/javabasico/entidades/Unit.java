package com.doinfinite.training.javabasico.entidades;

public abstract class Unit implements AttackableUnit {
	protected Integer health = DEFAULT_HEALTH;

	public Unit(Integer health) {
		this.health = health;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public String toString() {
		return this.getClass() + " - health: " + health;
	}

	public boolean isDead() {
		return this.health <= 0;
	}
}
