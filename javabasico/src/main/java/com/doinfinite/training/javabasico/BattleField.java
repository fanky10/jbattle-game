package com.doinfinite.training.javabasico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.doinfinite.training.javabasico.entidades.HeavyTank;
import com.doinfinite.training.javabasico.entidades.LightTank;
import com.doinfinite.training.javabasico.entidades.ObjetoAtacable;
import com.doinfinite.training.javabasico.entidades.QuickTank;

public class BattleField {
	private List<ObjetoAtacable> redTeam;
	private List<ObjetoAtacable> blueTeam;

	public BattleField(List<ObjetoAtacable> redTeam, List<ObjetoAtacable> blueTeam) {
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

	private void teamAttack(List<ObjetoAtacable> attackers,
			List<ObjetoAtacable> defenders) {

		// red team goes first
		for (ObjetoAtacable attacker : attackers) {
			Iterator<ObjetoAtacable> i = defenders.iterator();
			while (i.hasNext()) {
				ObjetoAtacable defender = i.next();
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
		List<ObjetoAtacable> blueTeam = new ArrayList<ObjetoAtacable>();
		blueTeam.add(new HeavyTank(100));
		blueTeam.add(new LightTank(100));
		blueTeam.add(new LightTank(100));
		
		List<ObjetoAtacable> redTeam = new ArrayList<ObjetoAtacable>();
		redTeam.add(new HeavyTank(100));
		redTeam.add(new HeavyTank(100));
		redTeam.add(new QuickTank(100));
		
		new BattleField(redTeam, blueTeam).battle();
		
	}


	public List<ObjetoAtacable> getRedTeam() {
		return redTeam;
	}

	public void setRedTeam(List<ObjetoAtacable> redTeam) {
		this.redTeam = redTeam;
	}

	public List<ObjetoAtacable> getBlueTeam() {
		return blueTeam;
	}

	public void setBlueTeam(List<ObjetoAtacable> blueTeam) {
		this.blueTeam = blueTeam;
	}

}
