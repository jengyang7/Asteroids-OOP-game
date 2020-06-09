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
		super(name, displayChar, hitPoints, ZombieCapability.ALIVE);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		
		turn += 1;
		
		System.out.println("mamboo turn: " + turn);
		
		if (turn % 10 == 0) {
			int x, y;
			
			String[] zombies = {"Retcher", "Flamer", "Scraper", "Nibbler", "Pygmy"};
			
			for (String name: zombies) {
				do {
					x = (int) Math.floor(Math.random() * map.getXRange().max() + 0);
					y = (int) Math.floor(Math.random() * map.getYRange().max() + 0);
				}
				while (map.at(x, y).containsAnActor());
				map.at(x, y).addActor(new Zombie(name));
			}
			
			if (turn == 20) {
				turn = 0;
				map.removeActor(this);
			}
			return new DoNothingAction();
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
