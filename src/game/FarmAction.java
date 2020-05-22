package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

public class FarmAction extends Action {
	
	protected Dirt target;
	
	
	public FarmAction(Dirt dirt) {
		this.target = dirt;
	}

	
	
	@Override
	public String execute(Actor actor, GameMap map) {
		String result;
		
		
		if (actor.getDisplayChar() == 'F') {
			
			//Sow a crop on a dirt
			if (target.retIsACrop() == false && target.retRiped() == false) {
				result = target.sow();
				return result;
			}
			
			//Fertilize a non fertilized crop 
			if (target.retIsACrop() == true && target.retFertilised() == false) {
				result = target.fertilised();
				return result;
			}
			
			//Change the crop to a food
			if (target.retRiped() == true){
				target.changeFood();
				result = "This crop is a food now!";
				return result;
			}
			
		}else if (actor.getDisplayChar() == 'H') {
			if(target.retRiped() == true) {
				target = new Dirt();
				actor.addItemToInventory(new Food("Food", 'f', FoodCapability.Food));
			}
		}
		return null;
	}

	
	
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
