package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class DropBehaviour implements Behaviour{
	

	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		for (Item item : actor.getInventory()) {
			if (item.hasCapability(WeaponCapability.WEAPON)) {
				return item.getDropAction();
			}
	}
		return null;
	}

}