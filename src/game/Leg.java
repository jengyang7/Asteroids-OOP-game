package game;

import edu.monash.fit2099.engine.WeaponItem;

public class Leg extends WeaponItem{
	

	public Leg(String name, char displayChar, int damage, String verb, Enum<?> weaponCapability, Enum<?> legCounter) {
		super(name, displayChar, damage, verb);
		this.addCapability(weaponCapability);
		this.addCapability(legCounter);
		
		// TODO Auto-generated constructor stub
	}

}
