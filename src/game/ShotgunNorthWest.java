package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class ShotgunNorthWest extends Action {

	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		int x = map.locationOf(actor).x();
		int y = map.locationOf(actor).y();
		boolean shot = false;
		List <Item> item = actor.getInventory();
		
		if (actor.getDisplayChar() == '@'){
			for(Item e: item) {
				if (e.hasCapability(WeaponCapability.WEAPON) && e.toString() == "Shotgun") {
					ShotgunShooting shoot = new ShotgunShooting();
					shoot.shoot(x, y, map, "nw");
					shot = true;
					break;
				}
			}
			
			if (shot == false) {
				result = "No shotgun found in player's inventory";
			}else {
				result = "Player took his/her shot !";
			}
			
		}else {
			result = "Only a player can shoot !";
		}
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Shotgun shoot north west";
	}
	
	@Override
	public String hotkey() {
		return "g";
	}

}
