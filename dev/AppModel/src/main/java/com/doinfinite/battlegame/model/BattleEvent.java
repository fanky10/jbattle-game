package com.doinfinite.battlegame.model;

public class BattleEvent implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1914019520930129539L;

	public static enum EventStatus {
		ATTACKING, UNDER_ATTACK, WIN, LOSE;
	}

	public static enum EffectivenessMessage {
		NOT_VERY_EFFECTIVE, VERY_EFFECTIVE, NORMAL;
	}

	private Unit localUnit;
	private Unit enemyUnit;
	private Float damage;
	private EffectivenessMessage effectiveness = EffectivenessMessage.NORMAL;
	private EventStatus status;

	public String getMessage() {
		if(status==EventStatus.WIN || status==EventStatus.LOSE){
			return "You "+status;
		}
		StringBuilder sb = new StringBuilder();
		if(status == EventStatus.ATTACKING){
			sb.append("Your Unit: ");
		}
		if(status == EventStatus.UNDER_ATTACK){
			sb.append("Enemy Unit: ");
		}
		sb.append(localUnit).append(" attacks ").append(enemyUnit).append(" DEALING: ").append(damage).append("dmg");
		sb.append(" health left: ").append(enemyUnit.getHealth());
		if(localUnit.isDead()){
			sb.append(" Your unit has fallen in combat...");
		}
		return sb.toString();
	}
	
	@Override
	public String toString(){
		return getMessage();
	}

	public Unit getLocalUnit() {
		return localUnit;
	}

	public void setLocalUnit(Unit localUnit) {
		this.localUnit = localUnit;
	}

	public Unit getEnemyUnit() {
		return enemyUnit;
	}

	public void setEnemyUnit(Unit enemyUnit) {
		this.enemyUnit = enemyUnit;
	}

	public Float getDamage() {
		return damage;
	}

	public void setDamage(Float damage) {
		this.damage = damage;
	}

	public EffectivenessMessage getEffectiveness() {
		return effectiveness;
	}

	public void setEffectiveness(EffectivenessMessage effectiveness) {
		this.effectiveness = effectiveness;
	}

	public EventStatus getStatus() {
		return status;
	}

	public void setStatus(EventStatus status) {
		this.status = status;
	}

}
