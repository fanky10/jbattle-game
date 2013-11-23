package com.doinfinite.training.javabasico.entidades;

public class Troop extends EarthUnit {

	public Troop(Integer health) {
		super(health);
	}
	
	public Troop(){
		this(100);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque*3;

	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 10;
	}

}
