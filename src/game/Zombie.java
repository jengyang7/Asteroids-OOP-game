package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;

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
		this.addItemToInventory(new Leg("leg1", 'L', 5, "", WeaponCapability.ITEM, LimbCapability.LEG));
		this.addItemToInventory(new Leg("leg2", 'L', 5, "", WeaponCapability.ITEM, LimbCapability.LEG));
		this.addItemToInventory(new Arm("arm1", 'A', 5, "", WeaponCapability.ITEM, LimbCapability.ARM));
		this.addItemToInventory(new Arm("arm2", 'A', 5, "", WeaponCapability.ITEM, LimbCapability.ARM));
	}
	

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		if( Math.random() <= 0.5 ) {
			  //we hit the 1/2 ( 50% ) case.
			return new IntrinsicWeapon(5, "punches");
			}
		else {
			return new IntrinsicWeapon(10, "bites");
		}
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
			if (action != null)
				return action;
		}
		return new DoNothingAction();	
	}
}
