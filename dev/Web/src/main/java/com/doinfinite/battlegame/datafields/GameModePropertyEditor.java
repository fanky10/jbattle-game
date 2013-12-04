package com.doinfinite.battlegame.datafields;

import java.beans.PropertyEditorSupport;

import com.doinfinite.battlegame.model.Game.GameMode;

public class GameModePropertyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		GameMode gType = GameMode.valueOf(text.toUpperCase());
		super.setValue(gType);
	}
}
