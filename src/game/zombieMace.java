package game;

import edu.monash.fit2099.engine.WeaponItem;

public class zombieMace extends WeaponItem {

	public zombieMace() {
		super("Zombie Mace", '^', 50, "Whishss");
		this.addCapability(WeaponCapability.WEAPON);
	}

}
