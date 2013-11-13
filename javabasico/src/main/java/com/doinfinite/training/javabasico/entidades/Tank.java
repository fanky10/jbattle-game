package com.doinfinite.training.javabasico.entidades;

public abstract class Tank implements ObjetoAtacable {
	protected Integer health = DEFAULT_HEALTH;

	public Tank(Integer health) {
		this.health = health;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public String toString() {
		return this.getClass().getSimpleName()+ " - health: " + health;
	}

	public boolean isDead() {
		return this.health <= 0;
	}
}
