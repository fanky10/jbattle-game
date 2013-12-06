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

	private String atackerName;
	private String defenderName;
	private Integer defenderHealth;
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
		sb.append(atackerName).append(" attacks ").append(defenderName).append(" DEALING: ").append(damage).append("dmg");
		sb.append(" health left: ").append(defenderHealth);
		if(defenderHealth<=0){
			if(status == EventStatus.ATTACKING){
				sb.append(" One less and counting...!");
			}
			if(status == EventStatus.UNDER_ATTACK){
				sb.append(" Your unit has fallen in combat...");
			}
		}
		return sb.toString();
	}
	
	@Override
	public String toString(){
		return getMessage();
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

	public String getAtackerName() {
		return atackerName;
	}

	public void setAtackerName(String atackerName) {
		this.atackerName = atackerName;
	}

	public String getDefenderName() {
		return defenderName;
	}

	public void setDefenderName(String defenderName) {
		this.defenderName = defenderName;
	}

	public Integer getDefenderHealth() {
		return defenderHealth;
	}

	public void setDefenderHealth(Integer defenderHealth) {
		this.defenderHealth = defenderHealth;
	}

}
