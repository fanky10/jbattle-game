package com.doinfinite.battlegame.services.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doinfinite.battlegame.model.BattleEvent;
import com.doinfinite.battlegame.model.Battlefield;
import com.doinfinite.battlegame.model.Game;
import com.doinfinite.battlegame.web.controllers.BaseController;

@Controller
public class GameServiceController extends BaseController {
	
	@RequestMapping(value = "/game/events.json", method = RequestMethod.POST)
	public @ResponseBody
	ResponseMessage getEventsJSON(HttpServletRequest httpRequest) {
		Game gameSettings = getGameSettings(httpRequest);
		String code = "-1";
		String message = "null battlefield!";
		Battlefield bf = gameSettings.getBattlefield();
		List<BattleEvent> battleEvents = new ArrayList<BattleEvent>();
		if (bf != null) {
			code = "0";
			message = "Battlefield: " + bf.toString();
			battleEvents = bf.battle();
		}
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage(message);
		responseMessage.setCode(code);
		responseMessage.setContent(battleEvents);
		return responseMessage;
	}
}
