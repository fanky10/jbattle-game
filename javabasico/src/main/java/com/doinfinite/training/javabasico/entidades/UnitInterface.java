package com.doinfinite.training.javabasico.entidades;

public interface ObjetoAtacable {
	public static final Integer DEFAULT_HEALTH = 100;
	public void defiende(int ataque);
	public int ataca();
	public boolean isDead();
}
