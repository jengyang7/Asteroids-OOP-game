package game;

import edu.monash.fit2099.engine.WeaponItem;

public class SniperRifle extends WeaponItem {

	public SniperRifle() {
		super("Sniper Rifle", '^', 80, "Baaaaammm");
		this.addCapability(WeaponCapability.WEAPON);
	}

}
