package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class HealBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		boolean healed = false;
		
		if (actor.getDisplayChar() == '@' || actor.getDisplayChar() == 'H') {
			List <Item> item = actor.getInventory();
			
			for (Item e: item){
				if (e.toString() == "Food") {
					healed = true;
					actor.heal(10);
					actor.getInventory().remove(e);
					System.out.println(actor.toString() + " successfully healed 10hp by consuming food in the his/her inventory");
				}
			}
			
		}
		if (healed == false) {
			System.out.println("No healing made in this turn");
		}
		return null;
	}

}
