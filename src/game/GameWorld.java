package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
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
			
			// check player on map
			
			if (!gameMaps.get(0).contains(mambo) && Math.random() <= 0.5) {
					this.createMambo();
			}

			// Process all the actors.
			for (Actor actor : actorLocations) {
				if (stillRunning()) {
					processActorTurn(actor);
					if(!stillRunning()) {
						break;
					}
				}
			}	
			
			// Tick over all the maps. For the map stuff.
			
			for (GameMap gameMap : gameMaps) {
				gameMap.tick();
			}
		

		}
		display.println(endGameMessage());
	}
	
	
	protected void processActorTurn(Actor actor) {
		Location here = actorLocations.locationOf(actor);
		GameMap map = here.map();
		

		Actions actions = new Actions();
		for (Item item : actor.getInventory()) {
			actions.add(item.getAllowableActions());
			// Game rule. If you're carrying it, you can drop it.
			actions.add(item.getDropAction());
		}
		
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();

			// Game rule. You don't get to interact with the ground if someone is standing
			// on it.
			if (actorLocations.isAnActorAt(destination)) {
				actions.add(actorLocations.getActorAt(destination).getAllowableActions(actor, exit.getName(), map));
			} else {
				actions.add(destination.getGround().allowableActions(actor, destination, exit.getName()));
			}
			actions.add(destination.getMoveAction(actor, exit.getName(), exit.getHotKey()));
		}

		for (Item item : here.getItems()) {
			actions.add(item.getAllowableActions());
			// Game rule. If it's on the ground you can pick it up.
			actions.add(item.getPickUpAction());
		}
		
		actions.add(new ShotgunNorth());
		actions.add(new ShotgunSouth());
		actions.add(new ShotgunEast());
		actions.add(new ShotgunWest());
		actions.add(new ShotgunNorthEast());
		actions.add(new ShotgunNorthWest());
		actions.add(new ShotgunSouthEast());
		actions.add(new ShotgunSouthWest());
		actions.add(new SniperActorChoice());
		actions.add(new DoNothingAction());
		actions.add(new QuitGame(actorLocations));

		Action action = actor.playTurn(actions, lastActionMap.get(actor), map, display);
		
		lastActionMap.put(actor, action);
		
		String result = action.execute(actor, map);
		display.println(result);
	}
	
	private void createMambo() {
		
		int x, y;
		int width = gameMaps.get(0).getXRange().max();
		int height = gameMaps.get(0).getYRange().max();
		
		// calculate the random location of map map 
		do { 	
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
	
	@ Override
	protected boolean stillRunning() {
		
		// Check Count of Zombie and Human on both map
		int humanCount = 0, zombieCount= 0;
		
		for (Actor eachActor : actorLocations) {
			if (eachActor.hasCapability(ActorType.HUMAN) && (gameMaps.get(0).contains(eachActor) || gameMaps.get(1).contains(eachActor))) {
				humanCount++;
			}else if (eachActor.hasCapability(ActorType.ZOMBIE) && (gameMaps.get(0).contains(eachActor) || gameMaps.get(1).contains(eachActor))) {
				zombieCount++;
			}
		}
		
		// Check if all human are killed on both compound and town map then player lose
		if (humanCount == 0) {
			display.println("Player loses");
			return false;
			}  
		
		// Check if all Zombie and Mambo are killed on both compound and town map then player lose
		else if (zombieCount == 0 && !gameMaps.get(0).contains(mambo) ) {
			display.println("Player wins");
			return false;
			}
		
		// Check if Player is killed and not on both compound and toown map then player lose
		else if (!gameMaps.get(0).contains(player) && !gameMaps.get(1).contains(player)) {
			display.println("Player loses");
			return false;
		}
		
		return actorLocations.contains(player);
	}
	
	protected String endGameMessage() {
		return "Game Over";
	}
}
