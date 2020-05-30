package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

public class FarmAction extends Action {
	
	protected Crop target;
	
	
	public FarmAction(Crop crop) {
		this.target = crop;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		
		//A farmer will fertilise a crop if the crop haven't been fertilized beforehand. Farmer will harvest the crop if the crop is ripped.
		if (actor.getDisplayChar() == 'F') {
			if (target.retFertilised() == false) {
				target.fertilised();
				result = actor.toString() + " fertilised a crop";
				return result;
			}
			
			if (target.retRiped() == true) {
				target.changeFood();
				result =  actor.toString() + " harvested a ripe crop, it became food and dropped on ground";
				return result;
			}

		//If the current actor is a human or a player, they can place a harvested food into their inventory.
		}else if (actor.getDisplayChar() == 'H' || actor.getDisplayChar() == '@') {
			if (target.retFood() == true) {
				actor.addItemToInventory(new Food());
				map.locationOf(actor).setGround(new Dirt());
				result = actor.toString() + " had harvested the food and placed into their inventory";
				return result;
			}
		}
		return actor.toString() + " did not made any farming/harvest action in this turn";
	}

	
	
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
