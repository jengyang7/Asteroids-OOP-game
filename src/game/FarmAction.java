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

			
		}else if (actor.getDisplayChar() == 'H') {
			if (target.retFood() == true) {
				actor.addItemToInventory(new Food());
				map.locationOf(actor).setGround(new Dirt());
				result = actor.toString() + " had harvested the food and placed into their inventory";
				return result;
			}
		}
		return actor.toString() + " did not made any farming/harvest action in tis turn";
	}

	
	
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
