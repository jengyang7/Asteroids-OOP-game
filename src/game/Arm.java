package game;

import edu.monash.fit2099.engine.WeaponItem;

public class Arm extends WeaponItem{
	

	public Arm(String name, char displayChar, int damage, String verb, Enum<?> weaponCapability, Enum<?> limbCapability) {
		super(name, displayChar, damage, verb);
		this.addCapability(weaponCapability);
		this.addCapability(limbCapability);
		// TODO Auto-generated constructor stub
	}

}