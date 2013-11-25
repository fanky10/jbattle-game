package com.doinfinite.battlegameapp;

import java.io.IOException;
import java.util.List;

import com.doinfinite.battlegame.model.Battlefield;
import com.doinfinite.battlegame.model.Unit;

/**
 * AppTest
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		System.out.println("Select the corresponding units for the red team!");
		List<Unit> redTeam = menu.getSelectedUnitsByHealth();
		System.out.println("Select the corresponding units for the blue team!");
		List<Unit> blueTeam = menu.getSelectedUnitsByHealth();
		System.out.println("Let's battle!");
		new Battlefield(redTeam, blueTeam);
	}
}
