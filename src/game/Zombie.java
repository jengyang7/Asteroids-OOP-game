package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * A Zombie.
 * 
 * This Zombie is pretty boring.  It needs to be made more interesting.
 * 
 * @author ram
 *
 */
public class Zombie extends ZombieActor {
	private Behaviour[] behaviours = {
			new PickUpBehaviour(),
			new ScreamBehaviour("braaaains"),
			new AttackBehaviour(ZombieCapability.ALIVE),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};

	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);
		this.addItemToInventory(new Leg("leg", 'L', 5, "", WeaponCapability.ITEM, LegCounter.TWO));
		this.addItemToInventory(new Arm("arm", 'A', 5, "", WeaponCapability.ITEM, ArmCounter.TWO));
	}
	

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		
		double probability = Math.random();
		
		for (Item item : this.getInventory()) {
				if (item.hasCapability(ArmCounter.ONE)) {
						  //probability of punching is halved
						probability = probability/2;
				}
					}
				
		if( probability >= 0.5 ) {
			  //we hit the 1/2 ( 50% ) case.
			return new IntrinsicWeapon(5, "punches");
			}
		else {
			return new IntrinsicWeapon(10, "bites");
		}
	}
	
	@Override
	public Weapon getWeapon() {
		for (Item item : inventory) {
			if (item.asWeapon() != null && item.hasCapability(WeaponCapability.WEAPON))
				return item.asWeapon();
		}
		return getIntrinsicWeapon();
	}
	
	/**
	 * If a Zombie can attack, it will.  If not, it will chase any human within 10 spaces.  
	 * If no humans are close enough it will wander randomly.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);

			
				if (action != null) {
					String[] currentActionWord = action.menuDescription(this).split(" ") ;
					if (currentActionWord[1].equals("moves")) {
						for (Item item : this.getInventory()) {
							if (item.hasCapability(LegCounter.ZERO)) {
								break;
								
								}
							else if (item.hasCapability(LegCounter.ONE)) {
								String[] lastActionWord = lastAction.menuDescription(this).split(" ") ;
								if (lastActionWord[1].equals("moves")) {
									break;
									}
								}
							}
					}else {
					return action;
					}
				}
			}
	
	return new DoNothingAction();	
	}
}