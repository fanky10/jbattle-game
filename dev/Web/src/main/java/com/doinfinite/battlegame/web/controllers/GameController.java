package com.doinfinite.battlegame.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doinfinite.battlegame.datafields.GameModePropertyEditor;
import com.doinfinite.battlegame.datafields.GameTypePropertyEditor;
import com.doinfinite.battlegame.model.Battlefield;
import com.doinfinite.battlegame.model.Game;
import com.doinfinite.battlegame.model.Game.GameMode;
import com.doinfinite.battlegame.model.Game.GameType;
import com.doinfinite.battlegame.model.Unit;
import com.doinfinite.battlegame.web.constants.WebAppConstants;

@Controller
public class GameController extends BaseController {

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(GameMode.class,
				new GameModePropertyEditor());
		binder.registerCustomEditor(GameType.class,
				new GameTypePropertyEditor());
	}

	@RequestMapping(value = "/game/{gameMode}/{gameType}", method = RequestMethod.GET)
	public String showGame(HttpServletRequest httpRequest,
			@PathVariable(value = "gameMode") GameMode gameMode,
			@PathVariable(value = "gameType") GameType gameType, ModelMap map) {
		List<Unit> userTeam = getSelectedUnits(httpRequest, gameType);
		List<Unit> foeTeam = getFoeSelectedUnits(gameMode, gameType);
		Game game = new Game(gameMode, gameType);
		game.setBattlefield(new Battlefield(userTeam, foeTeam));
		setGameSettings(httpRequest, game);

		map.put("selectedGame", game);
		map.put("selectedUnits", userTeam);
		map.put("foeSelectedUnits", foeTeam);
		map.put("gameType", gameType);
		return WebAppConstants.GAME_NEW;
	}

	@RequestMapping(value = "/game/new", method = RequestMethod.GET)
	public String showDefaultGame(HttpServletRequest httpRequest, ModelMap map) {
		return showGame(httpRequest, GameMode.IA, GameType.THREE_VS_THREE, map);
	}
}
