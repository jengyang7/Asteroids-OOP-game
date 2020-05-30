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
		
		if (actor.hasCapability(ZombieCapability.ALIVE)) {
		turn++;
		System.out.println(actorName + " corpse turn: " + turn);
		if (turn == 5) {
			location.removeItem(this);
			location.addActor(new Zombie(actorName));		
			}
		}
	}
}