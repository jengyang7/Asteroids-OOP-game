package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;


public class Shotgun extends WeaponItem {

	public Shotgun() {
		super("Sniper Rifle", '>', 66, "Baam");
		// TODO Auto-generated constructor stub
	}
	
	public void shoot(Actor actor, GameMap map, String direction) {
		Location initialLoc = map.locationOf(actor);
		int x = initialLoc.x();
		int y = initialLoc.y();
		
		ArrayList <ShotgunBullet> all = new ArrayList <ShotgunBullet>();
		ArrayList <ShotgunBullet> all2 = new ArrayList <ShotgunBullet>();
		
		ArrayList <ShotgunBullet> highDamage = new ArrayList <ShotgunBullet>();
		ArrayList <ShotgunBullet> mediumDamage = new ArrayList <ShotgunBullet>();
		ArrayList <ShotgunBullet> lowDamage = new ArrayList <ShotgunBullet>();
		
		Integer[] northx = {x, x-1, x, x+1, x-2, x-1, x, x+1, x+2};
		Integer[] northy = {y+1, y+2, y+2, y+2, y+3, y+3, y+3, y+3, y+3};
		Integer[] southx = {x, x-1, x, x+1, x-2, x-1, x, x+1, x+2};
		Integer[] southy = {y-1, y-2, y-2, y-2, y-3, y-3, y-3, y-3, y-3};
		Integer[] eastx = {x+1, x+2, x+2 , x+2, x+3, x+3, x+3, x+3, x+3};
		Integer[] easty = {y, y+1, y, y-1, y+2, y+1, y, y-1, y-2};
		Integer[] westx = {x-1, x-2 , x-2, x-2, x-3, x-3, x-3, x-3, x-3};
		Integer [] westy = {y, y+1, y, y-1, y+2, y+1, y, y-1, y-2};
		
		Integer[] swx = {x-1, x, x, x-1, x, x, x-1, x-2, x-3, x-3, x-2, x-1, x-3, x-2, x-3};
		Integer[] swy = {y, y-1, y, y-1, y-2, y-3, y-2, y-1, y, y-1, y-2, y-3, y-2, y-3, y-3};
		Integer[] nwx = {x-1, x, x-2, x-1, x, x, x-1, x-2, x-3, x-3, x-2, x-1, x-3, x-2, x-3};
		Integer[] nwy = {y, y+1, y, y+1, y+2, y+3, y+2, y+1, y, y+1, y+2, y+3, y+2, y+3, y+3};
		Integer[] sex = {x+1, x, x+2, x+1, x, x, x+1, x+2, x+3, x+3, x+2, x+1, x+3, x+2, x+3};
		Integer[] sey = {y, y-1, y, y-1, y-2, y-3, y-2, y-1, y, y-1, y-2, y-3, y-2, y-3, y-3};
		Integer[] nex = {x+1, x, x+2, x+1, x, x, x+1, x+2, x+3, x+3, x+2, x+1, x+3, x+2, x+3};
		Integer[] ney = {y, y+1, y, y+1, y+2, y+3, y+2, y+1, y, y+1, y+2, y+3, y+2, y+3, y+3};
		
		
		if (direction == "n" || direction == "s" || direction == "e" || direction == "w") {
			if (direction == "n") {
				for (int i = 0; i < northx.length; i ++) {
					all.add(new ShotgunBullet(northx[i], northy[i]));
				}
				
			}else if (direction == "s") {
				for (int i = 0; i < southx.length; i ++) {
					all.add(new ShotgunBullet(southx[i], southy[i]));
				}
				
				
			}else if (direction == "e") {
				for (int i = 0; i < eastx.length; i ++) {
					all.add(new ShotgunBullet(eastx[i], easty[i]));
				}
			
			}else if (direction == "w") {
				for (int i = 0; i < westx.length; i ++) {
					all.add(new ShotgunBullet(westx[i], westy[i]));
				}
			}
			
		
		}else if (direction == "ne" || direction == "nw" || direction == "se" || direction == "sw") {
			if (direction == "sw") {
				for (int i = 0; i < swx.length; i ++) {
					all.add(new ShotgunBullet(swx[i], swy[i]));
				}
				
			}else if (direction == "nw") {
				for (int i = 0; i < nwx.length; i ++) {
					all.add(new ShotgunBullet(nwx[i], nwy[i]));
				}
			
			
			}else if (direction == "se") {
				for (int i = 0; i < sex.length; i ++) {
					all.add(new ShotgunBullet(sex[i], sey[i]));
				}
			
			}else if (direction == "ne") {
				for (int i = 0; i < nex.length; i ++) {
					all.add(new ShotgunBullet(nex[i], ney[i]));
				}
				
			}
			
		}
		
		if (all.size() > 0) {
			for (int i = 0; i < 1; i ++) {
				highDamage.add(all.get(i));
			}
			
			for (int i = 1; i < 4; i ++ ) {
				mediumDamage.add(all.get(i));
			}
			
			for (int i = 4; i < 9; i ++) {
				lowDamage.add(all.get(i));
			}
			
			
		
		}else if (all2.size() > 0) {
			for (int i = 0; i < 2; i ++) {
				highDamage.add(all.get(i));
			}
			
			for (int i = 2; i < 9; i ++ ) {
				mediumDamage.add(all.get(i));
			}
			
			for (int i = 9; i < 15; i ++) {
				lowDamage.add(all.get(i));
				}
			}
		
		
		for (int i = 0; i < highDamage.size(); i ++) {
			double random1 = Math.random();
			
			if (map.at(highDamage.get(i).x(), highDamage.get(i).y()).containsAnActor() == true) {
				if (random1 <= 0.75) {
				Actor target = map.at(highDamage.get(i).x(), highDamage.get(i).y()).getActor();
				target.hurt(70);
				}
			}
		}
		
		for (int i = 0; i < mediumDamage.size(); i ++){
			double random2 = Math.random();
			
			if (map.at(mediumDamage.get(i).x(), mediumDamage.get(i).y()).containsAnActor() == true) {
				if (random2 <= 0.75) {
					Actor target = map.at(mediumDamage.get(i).x(), mediumDamage.get(i).y()).getActor();
					target.hurt(40);
				}
			}
			
		}
		
		for (int i = 0; i < lowDamage.size(); i ++) {
			double random3 = Math.random();
			if (map.at(lowDamage.get(i).x(), lowDamage.get(i).y()).containsAnActor() == true) {
				if (random3 <= 0.75) {
					Actor target = map.at(lowDamage.get(i).x(), lowDamage.get(i).y()).getActor();
					target.hurt(20);
					}
				}
			}
		}
	}
