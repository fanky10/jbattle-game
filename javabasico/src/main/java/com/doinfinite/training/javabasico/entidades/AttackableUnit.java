package com.doinfinite.training.javabasico.entidades;

public interface AttackableUnit {
	public static final Integer DEFAULT_HEALTH = 100;
	public static final Integer DEFAULT_SPEED = 50;
	

	public void defiende(int ataque);

	public int ataca();

	public boolean isDead();
}
