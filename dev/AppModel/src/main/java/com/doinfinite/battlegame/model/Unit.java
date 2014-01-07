package com.doinfinite.battlegame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "units")
public class Unit implements AttackableUnit, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5730523172266224078L;

	public static enum UnitType {
		EARTH(0), WATER(1), AIR(2);
		private final int value;

		private UnitType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unit_id", nullable = false)
	private Integer id;
	@Column(name = "unit_health", nullable = false)
	private Integer health = DEFAULT_HEALTH;
	@Column(name = "unit_speed", nullable = false)
	private Integer speed = DEFAULT_SPEED;
	@Column(name = "unit_accuracy", nullable = false)
	private Integer accuracy = DEFAULT_ACCURACY;
	@Column(name = "unit_name", nullable = false)
	private String name;
	@Enumerated
	@Column(name = "unit_type", nullable = false)
	private UnitType unitType;
	@Column(name = "unit_damage", nullable = false)
	private Integer damage;
	@Column(name = "unit_defense", nullable = false)
	private Integer defense = DEFAULT_DEFENSE;

	public Unit() {
		// default impl.
	}

	public Unit(String name, UnitType unitType, Integer health, Integer speed,
			Integer accuracy, Integer damage, Integer defense) {
		this.name = name;
		this.unitType = unitType;
		this.health = health;
		this.speed = speed;
		this.accuracy = accuracy;
		this.damage = damage;
		this.defense = defense;
	}

	public Unit getSnapshot() {
		return new Unit(name, unitType, health, speed, accuracy, damage,
				defense);
	}

	@Override
	public int defend(int attack) {
		if (defense > 0) {
			if (attack > defense) {
				health = health - (attack-defense);
				defense = 0;
			}else{
				defense = defense - attack;
			}
		} else {
			health = health - attack;
		}
		return attack;
	}

	@Override
	public int attack() {
		// TODO: add critical probability
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}
}
