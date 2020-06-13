package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;


public class Shotgun extends WeaponItem {

	public Shotgun() {
		super("Shotgun", '>', 60, "Baam");
		this.addCapability(WeaponCapability.WEAPON);
		}
	}
