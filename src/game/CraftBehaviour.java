package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class CraftBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		List <Item> item = actor.getInventory();
		boolean crafted = false;
		
		if (actor.getDisplayChar() == '@'){
			for(Item e: item) {
				if (e.hasCapability(WeaponCapability.WEAPON) == true && e.toString() == "leg") {
					crafted = true;
					actor.getInventory().remove(e);
					actor.addItemToInventory(new zombieClub());
					System.out.println(actor.toString() + " has crafted a zombie leg into a zombie club !");
				}
				else if(e.hasCapability(WeaponCapability.WEAPON) == true && e.toString() == "arm") {
					crafted = true;
					actor.getInventory().remove(e);
					actor.addItemToInventory(new zombieMace());
					System.out.println(actor.toString() + " has crafted a zombie leg into a zombie mace !");
				}
			}
				
		}
		if (crafted == false) {
			System.out.println("No crafting action done by player this turn");
		}
		return null;
	}

}
