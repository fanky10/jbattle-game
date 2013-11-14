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
		return this.getClass().getSimpleName() + "<" + health + ">";
	}

	public boolean isDead() {
		return this.health <= 0;
	}

	public boolean canAttack(Object defender) {
		// air units can attack both earth and water types
		if (this instanceof AirUnit) {
			return defender instanceof EarthUnit
					|| defender instanceof WaterUnit;
		}

		// water unit can attack only air and earth units
		if (this instanceof WaterUnit) {
			return defender instanceof EarthUnit || defender instanceof AirUnit;
		}

		// earth can attack any other unit
		if (this instanceof EarthUnit) {
			return true;
		}

		return false;
	}
}
