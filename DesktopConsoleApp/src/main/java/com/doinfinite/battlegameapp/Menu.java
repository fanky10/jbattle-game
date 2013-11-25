package com.doinfinite.battlegameapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.doinfinite.battlegame.model.Team;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.model.air.Airplane;
import com.doinfinite.battlegame.model.air.Chopper;
import com.doinfinite.battlegame.model.earth.Antiaircraft;
import com.doinfinite.battlegame.model.earth.HeavyTank;
import com.doinfinite.battlegame.model.earth.LightTank;
import com.doinfinite.battlegame.model.earth.QuickTank;
import com.doinfinite.battlegame.model.earth.Troop;
import com.doinfinite.battlegame.model.earth.Turret;
import com.doinfinite.battlegame.model.water.Ship;
import com.doinfinite.battlegame.model.water.Submarine;

public class Menu {

	public List<Team> TEAM = new ArrayList<Team>();
	String option;
	public int x = 0;
	public int teamSize;
	public int totalHealth1;
	public int totalHealth2;
	String unitOp;
	public int op;

	public int getTeamSize() {

		BufferedReader read1 = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			option = read1.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			teamSize = Integer.parseInt(option);

		} catch (NumberFormatException ex) {
			System.out.println("Exception object: " + ex);
			System.out.println("Have you tried with a valid option?");
		}

		System.out.println("Choose the sizes of the teams");

		System.out.println("1- 5 vs 5");
		System.out.println("2- 10 vs 10");
		System.out.println("3- 20 vs 20");

		switch (x) {

		case 1:
			teamSize = 5;
			break;

		case 2:
			teamSize = 10;
			break;

		case 3:
			teamSize = 20;

			break;
		}

		return teamSize;

	}

	public int getteamcolor() {

		int color;
		int intT = 0;

		System.out.println("Chose your team");

		System.out.println("1 - Read Team");
		System.out.println("2 - Blue Team");

		BufferedReader Teamcolor = new BufferedReader(new InputStreamReader(
				System.in));

		String chosenColor = null;
		try {
			chosenColor = Teamcolor.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			intT = Integer.parseInt(chosenColor);

		} catch (NumberFormatException ex) {
			System.out.println("Exception object: " + ex);
			System.out.println("Have you tried with a valid number?");
		}

		color = intT;

		return color;
	}

	public ArrayList<Unit> teamaker(int teamSize) {

		ArrayList<Unit> team = new ArrayList<Unit>();
		String a = null;
		int x = 0;

		System.out.println("Chose" + teamSize + "units for your team");

		System.out.println("Red Team Units");

		System.out.println("1- Light Tank");
		System.out.println("2- Quick Tank");
		System.out.println("3- Heavy Tank");
		System.out.println("4- Troop Tank");
		System.out.println("5- Turret");
		System.out.println("6- Antiaircraft");
		System.out.println("7- Chopper");
		System.out.println("8- Airplane");
		System.out.println("9- Ship");
		System.out.println("10- Submarine");

		System.out
				.println("Chose one of the units that are listed to add to your army you can pick a maximum of 5 units, so choose wisely.");
		int maxHealth = teamSize * 100;
		while (totalHealth1 < maxHealth) {

			BufferedReader read1 = new BufferedReader(new InputStreamReader(
					System.in));

			try {
				a = read1.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				x = Integer.parseInt(a);

			} catch (NumberFormatException ex) {
				System.out.println("Exception object: " + ex);
				System.out.println("Have you tried with a valid number?");

			}
			if ((x >= 1) && (x <= 10)) {

				switch (x) {

				case 1:
					team.add(new LightTank());
					System.out
							.println("You had added a Light Tank to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 2:
					team.add(new QuickTank());
					System.out
							.println("You had added a Quick Tank to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 3:
					team.add(new HeavyTank());
					System.out
							.println("You had added a Heavy Tank to your team!");
					totalHealth1 = (totalHealth1 + 100);

					break;

				case 4:
					team.add(new Troop());
					System.out.println("You had added a Troop to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 5:
					team.add(new Turret());
					System.out.println("You had added a Turret to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 6:
					team.add(new Antiaircraft());
					System.out
							.println("You had added an Antiaircraft to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 7:
					team.add(new Chopper());
					System.out.println("You had added a Chopper to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 8:
					team.add(new Airplane());
					System.out
							.println("You had added an Airplane to your team");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 9:
					team.add(new Ship());
					System.out.println("You had added a Ship to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				case 10:
					team.add(new Submarine());
					System.out
							.println("You had added a Submarine to your team!");
					totalHealth1 = (totalHealth1 + 100);
					break;

				default:
				}

				if (totalHealth1 < maxHealth) {
					System.out.println("Pick your next unit!");
				} else {
					System.out.println("Red Team selection completed!");
				}
			}

			else {
				System.out
						.println("You have choosen an invalid unit number, please select again");
			}

		}

		return team;

	}

}