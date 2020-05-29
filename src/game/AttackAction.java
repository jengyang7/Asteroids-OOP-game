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
		
//		if (actor.hasCapability(ZombieCapability.UNDEAD)) {
//			for (Item item : actor.getInventory()) {
//				if (item.hasCapability(LegCounter.TWO)) {
//					System.out.println("drop leg!"); 
//					item.getDropAction().execute(actor, map);
//					}
//				}
//		}
		
//		if (weapon.verb().equals("bites")){
//			if( Math.random() <= 0.75 ) {
//				return missAttack(actor, target);
//				
//			}else {
//				if (actor.hasCapability(ZombieCapability.UNDEAD)){
//					actor.heal(5);
//				}
//			}
//		}
//		else {
//			if (rand.nextBoolean()) {
//				return missAttack(actor, target);
//			}
//		}
//		
		 //Zombie has 25% probability to loose one limb if get attacked
		

		if( Math.random() <= 0.99 && target.hasCapability(ZombieCapability.UNDEAD)){
			
			ArrayList<Integer> limbs = new ArrayList<Integer>();
			System.out.println("limbs size");

			System.out.println(limbs.size());
			
			for (int i=0; i <target.getInventory().size(); i++) {
					if (target.getInventory().get(i).hasCapability(LegCounter.TWO) || target.getInventory().get(i).hasCapability(LegCounter.ONE) 
							||target.getInventory().get(i).hasCapability(ArmCounter.TWO) || target.getInventory().get(i).hasCapability(ArmCounter.ONE)) {
							if (target.getInventory().get(i).hasCapability(WeaponCapability.ITEM)) {
								limbs.add(i);
								System.out.println("limbs size");
								System.out.println(limbs.size());
							}
						}
					else {
						System.out.println("limbs size");
						break;}
					}
					
			
		if(limbs.size() > 1) {
			int limb = 0;

		if (limbs.size() == 1) {
			
			limb = limbs.get(0);
			System.out.println("limbs size 1");
			
		}
			
		else if(limbs.size() == 2) {
			
			System.out.println("limbs size 2");
			System.out.println(limbs.size());
		
			for (int j=0; j <limbs.size(); j++)	{
				System.out.println(target.getInventory().get(j));

			}
		
			if (Math.random() >= 0.5) {
				limb = limbs.get(0);
				}
			else {
				limb = limbs.get(1);
			}
			}
		
//			changeCapability(target.getInventory().get(limb));
			Item LimbToDrop = target.getInventory().get(limb);
			target.getInventory().get(limb).getDropAction().execute(target, map);
			addLimb(LimbToDrop);
//		target.getInventory().get(limb).getDropAction().execute(target, map);

			System.out.println("drop limb!");
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
	
	public void dropItem(Actor actor, GameMap map, Item item) {
		item.getDropAction().execute(actor, map);
		
	}
		
	public void addLimb(Item item) {
		if (item.hasCapability(LegCounter.TWO)) {
			target.addItemToInventory(new Leg("leg", 'L', 5, "attack (with leg)", WeaponCapability.ITEM, LegCounter.ONE));
			System.out.println("aaa");

		}
		else if (item.hasCapability(LegCounter.ONE)) {
			target.addItemToInventory(new Leg("leg", 'L', 5, "attack (with leg)", WeaponCapability.ITEM, LegCounter.ZERO));
			System.out.println("bbb");

		}
		else if (item.hasCapability(ArmCounter.TWO)) {
			target.addItemToInventory(new Arm("leg", 'L', 5, "attack (with arm)", WeaponCapability.ITEM, ArmCounter.ONE));
			System.out.println("ccc");

			
		}
		else if (item.hasCapability(ArmCounter.ONE)) {
			target.addItemToInventory(new Arm("leg", 'L', 5, "attack (with arm)", WeaponCapability.ITEM, ArmCounter.ZERO));
			System.out.println("ddd");

		}
	}
	
	public void changeCapability(Item item) {
		item.removeCapability(WeaponCapability.ITEM);
		item.addCapability(WeaponCapability.WEAPON);
	}
}
