package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		
		
		Weapon weapon = actor.getWeapon();
		
		
		if (weapon.verb().equals("bites")){
			if( Math.random() <= 0.75 ) {
				return missAttack(actor, target);
				
			}else {
				if (actor.hasCapability(ZombieCapability.UNDEAD)){
					actor.heal(5);
				}
			}
		}
		else {
			if (rand.nextBoolean()) {
				return missAttack(actor, target);
			}
		}
		
		 //Zombie has 25% probability to loose one limb if get attacked
		if( Math.random() <= 0.25 && actor.hasCapability(ZombieCapability.UNDEAD)){
			
			for (Item item : actor.getInventory()) {
				if(item.hasCapability(WeaponCapability.WEAPON)) {
					if (item.hasCapability(LegCounter.ONE) ||item.hasCapability(LegCounter.TWO) 
							|| item.hasCapability(ArmCounter.ONE) || item.hasCapability(ArmCounter.TWO))
					item.getDropAction().execute(actor, map);
					
					if (item.hasCapability(ArmCounter.ONE) && (Math.random() <= 0.5)) {
						for (Item item1 : actor.getInventory()) {
							if(item1.hasCapability(WeaponCapability.WEAPON)) {
								item1.getDropAction().execute(actor, map);}
							break;
						}
					}
					
					break;	//after lose one limb, break
				}
			}				
		}
		

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

		target.hurt(damage);
		if (!target.isConscious()) {
			Item corpse = new PortableItem("dead " + target, '%');
			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		 
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator() + target + " is killed.";
		}

		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
	
	public String missAttack(Actor actor, Actor target) {
		return actor + " misses " + target + ".";
	}
		
}
