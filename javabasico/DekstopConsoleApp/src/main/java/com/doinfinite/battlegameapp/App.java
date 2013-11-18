package com.doinfinite.battlegameapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.doinfinite.battlegame.model.Battlefield;
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

/**
 * AppTest
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {

		List<Unit> redTeam = new ArrayList<Unit>();
		List<Unit> blueTeam = new ArrayList<Unit>();

		String unitString;

		String a;
		String b;
		int x = 0;
		int y;

		System.out.println("Chose the team units");

		System.out.println("Red Team Unit");

		System.out.println("1- Light Tank");
		System.out.println("2- Quick Tank");
		System.out.println("3- Heavy Tank");
		System.out.println("4- Troop Tank");
		System.out.println("5- Turret");
		System.out.println("6- Antiaircraft");
		System.out.println("7- Chopper");
		System.out.println("8- Airplane");
		System.out.println("9- Ship");
		System.out.println("9- Submarine");

		BufferedReader read1 = new BufferedReader(new InputStreamReader(
				System.in));
		a=read1.readLine();
		x= Integer.parseInt(a);

		switch (x) {

		case 1:
			redTeam.add(new LightTank(100));
			break;

		case 2:
			redTeam.add(new QuickTank(100));
			break;

		case 3:
			redTeam.add(new HeavyTank(100));

			break;

		case 4:
			redTeam.add(new Troop(100));
			break;

		case 5:
			redTeam.add(new Turret(100));
			break;

		case 6:
			redTeam.add(new Antiaircraft(100));
			break;

		case 7:
			redTeam.add(new Chopper(100));
			break;

		case 8:
			redTeam.add(new Airplane(100));
			break;

		case 9:
			redTeam.add(new Ship(100));
			break;

		case 10:
			redTeam.add(new Submarine(100));
			break;

		default:
			unitString = "Undefined unit";}

			System.out.println("Blue Team Unit");

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

			BufferedReader read2 = new BufferedReader(new InputStreamReader(
					System.in));

			b=read2.readLine();
			y= Integer.parseInt(b);
			

			switch (y) {

			case 1:
				blueTeam.add(new LightTank(100));
				break;

			case 2:
				blueTeam.add(new QuickTank(100));
				break;

			case 3:
				blueTeam.add(new HeavyTank(100));

				break;

			case 4:
				blueTeam.add(new Troop(100));
				break;

			case 5:
				blueTeam.add(new Turret(100));
				break;

			case 6:
				blueTeam.add(new Antiaircraft(100));
				break;

			case 8:
				blueTeam.add(new Chopper(100));
				break;

			case 9:
				blueTeam.add(new Airplane(100));
				break;

			case 10:
				blueTeam.add(new Ship(100));
				break;

			case 11:
				blueTeam.add(new Submarine(100));
				break;

			default:
				unitString = "Undefined unit";

			}

			new Battlefield(redTeam, blueTeam).battle();

		}
	}

