package game;

import java.util.ArrayList;
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
		

		// if Zombie use bites attack, have 75% of missing attack
		if (weapon.verb().equals("bites") && actor.hasCapability(ZombieCapability.UNDEAD)){
			if( Math.random() <= 0.75 ) {
				return missAttack(actor, target);
				
			}else {
				// if zombie successfully use bite attack, restore 5 health points 
				if (actor.hasCapability(ZombieCapability.UNDEAD)){
					actor.heal(5);
				}
			}
		}
		else {
			// general missing attack with 50% probability
			if (rand.nextBoolean()) {
				return missAttack(actor, target);
			}
		}
		
		// Zombie has 25% probability to loose one limb if get attacked
		// add zombie's limbs (leg and arm) into limbs arraylist, 
		// then random drop any one limb choosing from the list

		if( Math.random() <= 0.99 && target.hasCapability(ZombieCapability.UNDEAD)){
			lostLimb(map);
		}
		

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

		target.hurt(damage);
		if (!target.isConscious()) {
			
			Corpse corpse = new Corpse("dead " + target, '%', target.toString(), target);
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
	
	public void dropItem(Actor actor, GameMap map, Item item) {
		item.getDropAction().execute(actor, map);
		
	}
	
	// method to dropping limb
	private void lostLimb(GameMap map) {
		ArrayList<Integer> limbs = new ArrayList<Integer>();
		
		for (int i=0; i <target.getInventory().size(); i++) {
				if (target.getInventory().get(i).hasCapability(LegCounter.TWO) || target.getInventory().get(i).hasCapability(LegCounter.ONE) 
						||target.getInventory().get(i).hasCapability(ArmCounter.TWO) || target.getInventory().get(i).hasCapability(ArmCounter.ONE)) {
						if (target.getInventory().get(i).hasCapability(WeaponCapability.ITEM)) {
							limbs.add(i);
						}
					}
				else {
					break;}
				}
				
	//if Zombie only have at least one limb
	if(limbs.size() > 1) {
		
		int limb = 0;

		//if Zombie only have either leg or arm, just get the index of it
		if (limbs.size() == 1) {	
			limb = limbs.get(0);	
			}	
		
		//if Zombie have both leg and arm, drop either one with 50% probability
		else if(limbs.size() == 2) {
		
			if (Math.random() >= 0.5) {
				limb = limbs.get(0);
				}
			else {
				limb = limbs.get(1);
				}
			}
			
			// Drop the limb!
			Item LimbToDrop = target.getInventory().get(limb);
			changeCapability(target.getInventory().get(limb));
			target.getInventory().get(limb).getDropAction().execute(target, map);
			addLimb(LimbToDrop);
	
			System.out.println(target.toString() + " drop a " + LimbToDrop.toString());
		}	
	}
	
	
	// method to add limb back to zombie after droping as I implement zombie leg and arm as each of one object with counter.
	public void addLimb(Item item) {
		if (item.hasCapability(LegCounter.TWO)) {
			target.addItemToInventory(new Leg("leg", 'L', 20, "attack (with leg)", WeaponCapability.ITEM, LegCounter.ONE));
			System.out.println("aaa");

		}
		else if (item.hasCapability(LegCounter.ONE)) {
			target.addItemToInventory(new Leg("leg", 'L', 20, "attack (with leg)", WeaponCapability.ITEM, LegCounter.ZERO));
			System.out.println("bbb");

		}
		else if (item.hasCapability(ArmCounter.TWO)) {
			target.addItemToInventory(new Arm("arm", 'A', 30, "attack (with arm)", WeaponCapability.ITEM, ArmCounter.ONE));
			System.out.println("ccc");

			
		}
		else if (item.hasCapability(ArmCounter.ONE)) {
			target.addItemToInventory(new Arm("arm", 'A', 30, "attack (with arm)", WeaponCapability.ITEM, ArmCounter.ZERO));
			System.out.println("ddd");

		}
	}
	
	// method to change dropping limb from ITEM and WEAPON so that Zombie will not pick the dropping limb up 
	public void changeCapability(Item item) {
		item.removeCapability(WeaponCapability.ITEM);
		item.addCapability(WeaponCapability.WEAPON);
	}
}
