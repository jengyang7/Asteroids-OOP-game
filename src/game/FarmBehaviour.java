package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

public class FarmBehaviour implements Behaviour {
	

	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		List <Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		
		if (actor.getDisplayChar() == 'F') {
			for (Exit e: exits) {
				
				//Sow a crop onto the ground if it is a Dirt, 33% chance of sowing a crop. Show failed to sow if farmer fail to sow a crop
				if (e.getDestination().getGround() instanceof Dirt) {
					double probability = Math.random();		
					if (probability < 0.33) {
						e.getDestination().setGround(new Crop());
						System.out.println(actor.toString() +" sowed a crop");
						return null;
					}else {
						System.out.println(actor.toString() + " failed to sow a crop");
						return null;
					}
				}
				
				//If it is already a crop, the farmer will choose to fertilise or harvest depend on the status of the crop.
				if (e.getDestination().getGround() instanceof Crop) {
					return new FarmAction((Crop) e.getDestination().getGround());
					}
				
				continue;
				
				}
		
			
		//If it is a player or human that encounter a crop, they can only collect and store harvested crop by the farmer in their inventory. Else, do nothing
		}else if (actor.getDisplayChar() == 'H' || actor.getDisplayChar() == '@') {
			for (Exit e: exits) {
				if (e.getDestination().getGround() instanceof Crop) {
					return new FarmAction((Crop) e.getDestination().getGround());
					}
				continue;
				}
			}
		return null;
		}
	}
