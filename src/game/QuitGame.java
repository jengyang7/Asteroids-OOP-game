package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.GameMap;

public class QuitGame extends Action{
	
	private ActorLocations actorLocations;

	public QuitGame(ActorLocations actorLocations) {
		this.actorLocations = actorLocations;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		for (Actor eachActor: actorLocations) {
			map.removeActor(eachActor);
		}
		return "All Actors are removed from the map!";
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Quit game";
	}
	
	@Override
	public String hotkey() {
		return "q";
	}
}
