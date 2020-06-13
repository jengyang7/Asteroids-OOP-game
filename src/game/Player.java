package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.Weapon;

/**
 * Class representing the Player.
 */
public class Player extends Human {

	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}
	
//	public Weapon getWeapon() {
//		for (Item item : inventory) {
//			if (item.asWeapon() != null && item.hasCapability(WeaponCapability.WEAPON))
//				return item.asWeapon();
//		}
//		return getIntrinsicWeapon();
//	}
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		List <Item> item = this.getInventory();
		for(Item e: item) {
			if (e.hasCapability(WeaponCapability.WEAPON) && e.toString() == "Shotgun"){
				actions.add(new ShotgunNorth());
				actions.add(new ShotgunSouth());
				actions.add(new ShotgunEast());
				actions.add(new ShotgunWest());
				actions.add(new ShotgunNorthEast());
				actions.add(new ShotgunNorthWest());
				actions.add(new ShotgunSouthEast());
				actions.add(new ShotgunSouthWest());
				actions.add(new SniperActorChoice());
				break;
			}
		}
		if (lastAction.getNextAction() != null) {
			return lastAction.getNextAction();
		}
		return menu.showMenu(this, actions, display);
	}
}
