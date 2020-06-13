package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

public class MamboMarie extends ZombieActor{

	private Behaviour[] behaviour = {
			new WanderBehaviour()
	};
	
	int turn = 0;

	public MamboMarie(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints, ZombieCapability.UNDEAD);
		this.addCapability(ActorType.MAMBO);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		
		// increment turn for every turn
		turn += 1;
		System.out.println("mambo turn: " + turn);
		
		// if this is turn 30, remove Mambo from the map
		if (turn == 30) {
			turn = 0;
			map.removeActor(this);
			return new DoNothingAction();
		}
		
		// Every 10 turn, born 5 Zombies at random location on compound map
		if (turn % 10 == 0) {
			return new ChantingAction();
		}

		for (Behaviour behaviour: behaviour) {
			Action action = behaviour.getAction(this, map);
			if (action != null){
				return action;
			}
		}
		return new DoNothingAction();
	}
}
