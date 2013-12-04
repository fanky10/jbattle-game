package com.doinfinite.battlegame.model;

public class Game {
	public static enum GameMode {
		IA, PVP
	};

	public static enum GameType {
		THREE_VS_THREE, FIVE_VS_FIVE
	};

	private GameMode gameMode;
	private GameType gameType;

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
}
