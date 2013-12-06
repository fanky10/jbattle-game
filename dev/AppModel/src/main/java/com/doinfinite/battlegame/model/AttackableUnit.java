package com.doinfinite.battlegame.model;

public interface AttackableUnit {
	public static final Integer DEFAULT_HEALTH = 100;
	public static final Integer DEFAULT_SPEED = 50;
	public static final Integer DEFAULT_ACCURACY = 10;

	public int defend(int ataque);
	
	public int attack();

	public boolean isDead();
}
