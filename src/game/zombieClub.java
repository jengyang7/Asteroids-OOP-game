package game;

import edu.monash.fit2099.engine.WeaponItem;

public class zombieClub extends WeaponItem {

	public zombieClub() {
		super("Zombie Club", '*', 40, "Whoop");
		this.addCapability(WeaponCapability.WEAPON);
	}

}
