package game;

import edu.monash.fit2099.engine.WeaponItem;

public class Leg extends WeaponItem{
	

	public Leg(String name, char displayChar, int damage, String verb, Enum<?> weaponCapability, Enum<?> limbCapability) {
		super(name, displayChar, damage, verb);
		this.addCapability(weaponCapability);
		this.addCapability(limbCapability);

		
		// TODO Auto-generated constructor stub
	}

}
