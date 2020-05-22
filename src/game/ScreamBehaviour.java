package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ScreamBehaviour implements Behaviour {
	
	private String word;

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		if( Math.random() <= 0.1 ) {
			return new ScreamAction(word);
		}
			return null;
		
	}
	
	public ScreamBehaviour(String word) {
		this.word = word;
		
	}
}
