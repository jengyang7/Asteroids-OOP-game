package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class SniperActorChoice extends Action {
	
	private static boolean waiting;

	@Override
	public String execute(Actor actor, GameMap map) {
		List <Item> item = actor.getInventory();
		SniperActorList showList = new SniperActorList();
		showList.execute(actor, map);
		
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Choose an Actor to kill with sniper";
	}
	
	@Override
	public String hotkey() {
		return "v";
	}

}
