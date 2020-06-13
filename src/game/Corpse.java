package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

public class Corpse extends PortableItem {
	private int turn = 0;
	private String actorName;
	private Actor actor;


	public Corpse(String name, char displayChar, String actorName, Actor actor) {
		super(name, displayChar);
		this.actorName = actorName;
		this.actor = actor;
		
	}
	
	
	// override tick method from PortableItem class, tick method will called each turn, 
	// so that after 5 turn Human will rising from the death and become Zombie
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		if (actor.hasCapability(ActorType.HUMAN)) {
			turn++;
		
			if (turn == 5) {
				location.removeItem(this);
				if(!location.containsAnActor()) {
					location.addActor(new Zombie(actorName));		
	
				}else {
					int x, y;
						do {
							x = (int) Math.floor(Math.random() * 20.0 + 30.0);
							y = (int) Math.floor(Math.random() * 7.0 + 5.0);
						} 
						while (location.map().at(x, y).containsAnActor());
						location.map().at(x,  y).addActor(new Zombie(name));	
					
	
					}
				}
		}
	}
}
