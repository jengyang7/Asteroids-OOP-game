package game;

import edu.monash.fit2099.engine.WeaponItem;

public class Arm extends WeaponItem{
	

	public Arm(String name, char displayChar, int damage, String verb, Enum<?> weaponCapability, Enum<?> ArmCounter) {
		super(name, displayChar, damage, verb);
		this.addCapability(weaponCapability);
		this.addCapability(ArmCounter);
		// TODO Auto-generated constructor stub
	}

}