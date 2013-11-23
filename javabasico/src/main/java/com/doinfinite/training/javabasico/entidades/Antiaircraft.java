package com.doinfinite.training.javabasico.entidades;

public class Antiaircraft extends EarthUnit {

	public Antiaircraft(Integer health) {
		super(health);
	}
	
	public Antiaircraft(){
		this(100);
	}

	@Override
	public void defiende(int ataque) {
		health = health - ataque;
		
	}

	@Override
	public int ataca() {
		// TODO Auto-generated method stub
		return 70;
	}

}
