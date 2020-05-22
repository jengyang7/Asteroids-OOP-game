package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class PickUpBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
//		List <Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
//		Collections.shuffle(exits);
//		
//		for (Exit e: exits) {
//			if  ((e.getDestination().getDisplayChar() == '(') ){
//				if (e.getDestination().getGround().hasCapability(WeaponCapability.WEAPON)) {
//					return e.getDestination().getItems().;
//					
//				}
//			}			 
//				
//		return null;
//	}
//		map.locationOf(actor).getItems();
		
		for (Item item : map.locationOf(actor).getItems()) {
			if(item.hasCapability(WeaponCapability.WEAPON)) {
				return item.getPickUpAction();
			}
			
		}
		
		return null;}
}
