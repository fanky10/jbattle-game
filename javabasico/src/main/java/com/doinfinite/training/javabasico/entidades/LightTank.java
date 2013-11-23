package com.doinfinite.training.javabasico.entidades;

public class LightTank extends Tank {

	public LightTank(Integer health) {
		super(health);
	}

	public LightTank() {
		this(100);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
	}

	@Override
	public int ataca() {
		return 10;
	}

}
