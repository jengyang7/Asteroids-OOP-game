package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

public class Farmer extends ZombieActor {
	
	private Behaviour[] behaviour = {new FarmBehaviour()};
	
	public Farmer(String name) {
		super(name, 'F', 50, ZombieCapability.ALIVE);
	}

	public Farmer(String name, char displayChar, int hitPoints, ZombieCapability team) {
		super(name, displayChar, hitPoints, team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour behaviour: behaviour) {
			Action action = behaviour.getAction(this, map);
			if (action != null){
				return action;
			}
			
		}
		return new DoNothingAction();
	}

}
