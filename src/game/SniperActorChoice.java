package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Menu;

public class SniperActorChoice extends Action {
	
	private static boolean waiting;
	private Menu menu = new Menu();
	
	@Override
	public String execute(Actor actor, GameMap map) {
		List <Item> item = actor.getInventory();
		Actions actions = new Actions();
		actions.add(new SniperActorList());
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
