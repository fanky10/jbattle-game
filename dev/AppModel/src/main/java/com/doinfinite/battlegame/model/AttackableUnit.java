package com.doinfinite.battlegame.model;

public interface AttackableUnit {
	public static final Integer DEFAULT_HEALTH = 100;

	public void defiende(int ataque);

	public int ataca();

	public boolean isDead();
}
