package com.doinfinite.training.javabasico.entidades;

public class Airplane extends AirUnit {

	public Airplane(Integer health) {
		super(health);
	}
	
	public Airplane(){
		this(100);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque*3;
	}

	@Override
	public int ataca() {
		return 90;
	}

}
