package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class SniperActorList extends Action {
	ArrayList <Actor> allTargets = new ArrayList<Actor>();

	@Override
	public String execute(Actor actor, GameMap map) {
		
		
		for (int x = 0; x < 70; x ++) {
			for (int y = 0; y < 20; y ++) {
				if (map.at(x, y).containsAnActor() == true) {
					allTargets.add(map.at(x, y).getActor());
				}
			}
		}
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		String result = null;
		for (int i = 0; i < allTargets.size(); i ++) {
			result += allTargets.get(i).toString() + "/n";
		}
		return result;
	}

}
