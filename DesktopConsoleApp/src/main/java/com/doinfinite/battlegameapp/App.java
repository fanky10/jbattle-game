package com.doinfinite.battlegameapp;

import java.io.IOException;
import java.util.List;

import com.doinfinite.battlegame.model.BattleEvent;
import com.doinfinite.battlegame.model.Battlefield;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegameapp.Menu.BattleType;

/**
 * AppTest
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		menu.setBattleType(BattleType.THREE_UNITS_IA);
		System.out.println("Select the corresponding units for the red team!");
		List<Unit> redTeam = menu.getSelectedUnits();
		System.out.println("Select the corresponding units for the blue team!");
		List<Unit> blueTeam = menu.getSelectedUnits();
		System.out.println("Let's battle!");
		Battlefield bf = new Battlefield(redTeam, blueTeam);
		bf.battle();
		for (BattleEvent evt : bf.getBattleEvents()) {
			System.out.println("EVT: " + evt.getMessage());
		}

	}
}
