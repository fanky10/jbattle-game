package com.doinfinite.battlegame.model;

public class Game {
	public static enum GameMode {
		IA, PVP
	};

	public static enum GameType {
		THREE_VS_THREE(3), FIVE_VS_FIVE(5);

		private int maxUnits;
		
		private GameType(int maxUnits) {
			this.maxUnits = maxUnits;
		}

		public int getMaxUnits() {
			return maxUnits;
		}

		public void setMaxUnits(int maxUnits) {
			this.maxUnits = maxUnits;
		}
	};

	private GameMode gameMode;
	private GameType gameType;
	private Battlefield battlefield;

	public Game() {
		this(GameMode.IA, GameType.THREE_VS_THREE);
	}

	public Game(String gameMode, String gameType) {
		this(GameMode.valueOf(gameMode), GameType.valueOf(gameType));
	}

	public Game(GameMode gameMode, GameType gameType) {
		this.gameMode = gameMode;
		this.gameType = gameType;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public Battlefield getBattlefield() {
		return battlefield;
	}

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}
}
