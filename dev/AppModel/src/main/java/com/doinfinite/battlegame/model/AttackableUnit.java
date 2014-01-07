package com.doinfinite.battlegame.model;

public interface AttackableUnit {
	public static final Integer DEFAULT_HEALTH = 100;
	public static final Integer DEFAULT_SPEED = 50;
	public static final Integer DEFAULT_ACCURACY = 10;
	public static final Integer DEFAULT_DEFENSE = 20;

	public int defend(int attack);

	public int attack();

	public boolean isDead();

}
