package com.doinfinite.battlegame.datafields;

import java.beans.PropertyEditorSupport;

import com.doinfinite.battlegame.model.Game.GameType;

public class GameTypePropertyEditor extends PropertyEditorSupport {

	private static final String THREE_VS_THREE_NAME = "3v3";
	private static final String FIVE_VS_FIVE_NAME = "5v5";

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		GameType gameType = null;
		if (text.equalsIgnoreCase(THREE_VS_THREE_NAME)) {
			gameType = GameType.THREE_VS_THREE;
		} else if (text.equalsIgnoreCase(FIVE_VS_FIVE_NAME)) {
			gameType = GameType.FIVE_VS_FIVE;
		} else {
			gameType = GameType.valueOf(text.toUpperCase());
		}
		if (gameType == null) {
			throw new IllegalArgumentException("not supported game type");
		}
		super.setValue(gameType);
	}
}
