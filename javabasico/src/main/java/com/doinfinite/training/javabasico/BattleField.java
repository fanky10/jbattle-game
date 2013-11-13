package com.doinfinite.training.javabasico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.doinfinite.training.javabasico.entidades.HeavyTank;
import com.doinfinite.training.javabasico.entidades.LightTank;
import com.doinfinite.training.javabasico.entidades.AttackableUnit;
import com.doinfinite.training.javabasico.entidades.QuickTank;

public class BattleField {
	private List<AttackableUnit> redTeam;
	private List<AttackableUnit> blueTeam;

	public BattleField(List<AttackableUnit> redTeam, List<AttackableUnit> blueTeam) {
		super();
		this.redTeam = redTeam;
		this.blueTeam = blueTeam;
	}
	
	public void battle() {
		boolean winner = false;
		while (!winner) {
			redTeamAttack();
			blueTeamAttack();
			winner = isThereAWinner();
		}
		String winnerMessage = (redTeam.isEmpty() ? "Blue team wins!"
				: (blueTeam.isEmpty() ? "Red team wins!"
						: "There was an issue clearly"));
		System.out.println("Who has won? " + winnerMessage);
	}

	private boolean isThereAWinner() {
		return redTeam.isEmpty() || blueTeam.isEmpty();
	}

	private void blueTeamAttack() {
		System.out.println("Blue team attacks!");
		teamAttack(blueTeam, redTeam);
	}

	private void redTeamAttack() {
		System.out.println("Red team attacks!");
		teamAttack(redTeam, blueTeam);
	}

	private void teamAttack(List<AttackableUnit> attackers,
			List<AttackableUnit> defenders) {

		// red team goes first
		for (AttackableUnit attacker : attackers) {
			Iterator<AttackableUnit> i = defenders.iterator();
			while (i.hasNext()) {
				AttackableUnit defender = i.next();
				int attack = attacker.ataca();
				defender.defiende(attack);
				System.out.println("Defender recibe daño y "+defender);
				// depending on health remove it
				if(defender.isDead()){
					System.out.println("Ha habido una baja!!");
					i.remove();
				}
			}
		}
	}
	
	public static void main(String args[]){
		List<AttackableUnit> blueTeam = new ArrayList<AttackableUnit>();
		blueTeam.add(new HeavyTank(100));
		blueTeam.add(new LightTank(100));
		blueTeam.add(new LightTank(100));
		
		List<AttackableUnit> redTeam = new ArrayList<AttackableUnit>();
		redTeam.add(new HeavyTank(100));
		redTeam.add(new HeavyTank(100));
		redTeam.add(new QuickTank(100));
		
		new BattleField(redTeam, blueTeam).battle();
		
	}


	public List<AttackableUnit> getRedTeam() {
		return redTeam;
	}

	public void setRedTeam(List<AttackableUnit> redTeam) {
		this.redTeam = redTeam;
	}

	public List<AttackableUnit> getBlueTeam() {
		return blueTeam;
	}

	public void setBlueTeam(List<AttackableUnit> blueTeam) {
		this.blueTeam = blueTeam;
	}

}
