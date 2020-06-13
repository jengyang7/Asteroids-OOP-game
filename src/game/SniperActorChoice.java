package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;

public class SniperActorChoice extends Action {
	
	private Display display;
	private Action lastLoc;
	private ArrayList<Actor> allTarget = new ArrayList<Actor>();
	private static Integer tick;
	private static boolean aiming;
	
	public SniperActorChoice(Display display, Action action) {
		this.display = display;
		this.lastLoc = action;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		
		if (this.aiming == true) {
			return "Player is still aiming !";
		}
		Actions actions = new Actions();
		
		for (int x = 0; x < 70; x ++) {
			for (int y = 0; y < 20; y ++) {
				if (map.at(x, y).containsAnActor() == true) {
					allTarget.add(map.at(x, y).getActor());
					}
				}
			}
		actions.add(new SniperActorList(this.allTarget, this.display, this.lastLoc));
		Action action = actor.playTurn(actions, this.lastLoc, map, this.display);
		String result = action.execute(actor, map);
		
		if (result == "two") {
			this.aiming = true;
			this.tick = 2;
			
		}else if(result == "three") {
			this.aiming = true;
			this.tick = 3;
			
		}
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Choose an Actor to kill with sniper";
	}
	
	@Override
	public String hotkey() {
		return "v";
	}
	
	public void setDisplay(Display display) {
		this.display = display;
	}
	
	public void setLastLocation(Action action) {
		this.lastLoc = action;
	}

}
