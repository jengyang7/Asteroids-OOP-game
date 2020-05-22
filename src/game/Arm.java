package game;

import edu.monash.fit2099.engine.WeaponItem;

public class Arm extends WeaponItem{
	

	public Arm(String name, char displayChar, int damage, String verb, Enum<?> capability) {
		super(name, displayChar, damage, verb);
		this.addCapability(capability);
		// TODO Auto-generated constructor stub
	}

}