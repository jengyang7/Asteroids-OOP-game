package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ChantingAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		int x, y;
		
		String[] zombies = {"Retcher", "Flamer", "Scraper", "Nibbler", "Pygmy"};
		
		// spawn 5 zombie at random location on map
		for (String name: zombies) {
			do {
				x = (int) Math.floor(Math.random() * map.getXRange().max() + 0);
				y = (int) Math.floor(Math.random() * map.getYRange().max() + 0);
			}
			while (map.at(x, y).containsAnActor());
			map.at(x, y).addActor(new Zombie(name));
		}
		return menuDescription(actor);
	}
	

	@Override
	public String menuDescription(Actor actor) {
		return actor + " chanting and spawn 5 zombies!";
	}
	
}

