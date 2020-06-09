package game;


import java.util.Objects;
import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

public class GameWorld extends World{
	
	protected Actor mambo; // We only draw the particular map this actor is on.

	
	/**
	 * Constructor.
	 * 
	 * @param display the Display that will display this World.
	 */
	public GameWorld(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}
	
	public void addMambo(Actor mambo) {
		this.mambo = mambo;
	}
	
	@ Override
	public void addGameMap(GameMap gameMap) {
		super.addGameMap(gameMap);
		
	}
	
	@ Override
	public void run() {
		if (player == null)
			throw new IllegalStateException();

		// initialize the last action map to nothing actions;
		for (Actor actor : actorLocations) {
			lastActionMap.put(actor, new DoNothingAction());
		}

		// This loop is basically the whole game
		while (stillRunning()) {
			GameMap playersMap = actorLocations.locationOf(player).map();
			playersMap.draw(display);
			
			if (!gameMaps.get(0).contains(mambo)) {
				if (Math.random() <= 0.5) {
					int x, y;
					int width = gameMaps.get(0).getXRange().max();
					int height = gameMaps.get(0).getYRange().max();
					do {
						//new Random().nextInt(list.size())
						// Math.floor(Math.random() * 6) + 1  
						
						if (Math.random() <= 0.5) {
							if (Math.random()<= 0.5) {
								x = 0;
								y = (int) Math.floor(Math.random() * height) + 0; 
							}else {
								x = (int) Math.floor(Math.random() * width) + 0;  
								y = 0;
							}
						}else {
							if (Math.random()<= 0.5) {
								x = width;
								y = (int) Math.floor(Math.random() * height) + 0; 
							}else {
								x = (int) Math.floor(Math.random() * width) + 0;  
								y = height;
							}
						}
					} 
					while (gameMaps.get(0).at(x, y).containsAnActor());
					gameMaps.get(0).at(x,  y).addActor(mambo);	
					
				}				
			}
			

			// Process all the actors.
			for (Actor actor : actorLocations) {
				if (stillRunning())
					processActorTurn(actor);
			}

			// Tick over all the maps. For the map stuff.
			for (GameMap gameMap : gameMaps) {
				gameMap.tick();
			}

		}
		display.println(endGameMessage());
	}
}
