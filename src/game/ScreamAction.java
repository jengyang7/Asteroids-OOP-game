package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ScreamAction extends Action{
	
	protected String word;
	
	public ScreamAction(String word) {
		this.word = word;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub		
		return actor + " scream " + word;

	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " scream " + word;
	}
	
	
}
