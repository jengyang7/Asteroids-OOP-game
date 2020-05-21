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
		
		for (Exit e: exits) {
			if (!(e.getDestination().getDisplayChar() == '.' || !(e.getDestination().getDisplayChar() == 'C'))){
				continue;
			}
			if ((e.getDestination().getDisplayChar() == '.') || (e.getDestination().getDisplayChar() == 'C')){
				if (e.getDestination().getGround() instanceof Dirt) {
					return new FarmAction((Dirt) e.getDestination().getGround());
					
				}else {
					e.getDestination().setGround(new Dirt());
					return new FarmAction((Dirt) e.getDestination().getGround());
					}
				}
			}
		
		return null;
		}
	}
