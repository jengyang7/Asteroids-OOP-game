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
		
		ArrayList <ShotgunBullet> highDamage = new ArrayList <ShotgunBullet>();
		ArrayList <ShotgunBullet> mediumDamage = new ArrayList <ShotgunBullet>();
		ArrayList <ShotgunBullet> lowDamage = new ArrayList <ShotgunBullet>();
		
		
		
		if (direction == "n" || direction == "s" || direction == "e" || direction == "w") {
			
			if (direction == "n") {
				ShotgunBullet first = new ShotgunBullet(x, y + 1);
				ShotgunBullet second = new ShotgunBullet(x - 1, y + 2);
				ShotgunBullet third = new ShotgunBullet(x, y + 2);
				ShotgunBullet fourth = new ShotgunBullet(x + 1, y + 2);
				ShotgunBullet fifth = new ShotgunBullet(x - 2, y + 3);
				ShotgunBullet sixth = new ShotgunBullet(x - 1, y + 3);
				ShotgunBullet seventh = new ShotgunBullet(x, y + 3);
				ShotgunBullet eighth = new ShotgunBullet(x + 1, y + 3);
				ShotgunBullet nineth = new ShotgunBullet(x + 2, y + 3);
				
				highDamage.add(first);
				mediumDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				lowDamage.add(fifth);
				lowDamage.add(sixth);
				lowDamage.add(seventh);	
				lowDamage.add(eighth);
				lowDamage.add(nineth);
				
			}else if (direction == "s") {
				ShotgunBullet first = new ShotgunBullet(x, y - 1);
				ShotgunBullet second = new ShotgunBullet(x - 1, y - 2);
				ShotgunBullet third = new ShotgunBullet(x, y - 2);
				ShotgunBullet fourth = new ShotgunBullet(x + 1, y - 2);
				ShotgunBullet fifth = new ShotgunBullet(x - 2, y - 3);
				ShotgunBullet sixth = new ShotgunBullet(x - 1, y - 3);
				ShotgunBullet seventh = new ShotgunBullet(x, y - 3);
				ShotgunBullet eighth = new ShotgunBullet(x + 1, y - 3);
				ShotgunBullet nineth = new ShotgunBullet(x + 2, y - 3);
				
				highDamage.add(first);
				mediumDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				lowDamage.add(fifth);
				lowDamage.add(sixth);
				lowDamage.add(seventh);	
				lowDamage.add(eighth);
				lowDamage.add(nineth);
				
			}else if (direction == "e") {
				ShotgunBullet first = new ShotgunBullet(x + 1, y);
				ShotgunBullet second = new ShotgunBullet(x + 2, y + 1);
				ShotgunBullet third = new ShotgunBullet(x + 2, y);
				ShotgunBullet fourth = new ShotgunBullet(x + 2, y - 1);
				ShotgunBullet fifth = new ShotgunBullet(x + 3, y + 2);
				ShotgunBullet sixth = new ShotgunBullet(x + 3, y + 1);
				ShotgunBullet seventh = new ShotgunBullet(x + 3, y);
				ShotgunBullet eighth = new ShotgunBullet(x + 3, y - 1);
				ShotgunBullet nineth = new ShotgunBullet(x + 3, y - 2);
				
				highDamage.add(first);
				mediumDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				lowDamage.add(fifth);
				lowDamage.add(sixth);
				lowDamage.add(seventh);	
				lowDamage.add(eighth);
				lowDamage.add(nineth);
				
			}else if (direction == "w") {
				ShotgunBullet first = new ShotgunBullet(x - 1, y);
				ShotgunBullet second = new ShotgunBullet(x - 2, y + 1);
				ShotgunBullet third = new ShotgunBullet(x - 2, y);
				ShotgunBullet fourth = new ShotgunBullet(x - 2, y - 1);
				ShotgunBullet fifth = new ShotgunBullet(x - 3, y + 2);
				ShotgunBullet sixth = new ShotgunBullet(x - 3, y + 1);
				ShotgunBullet seventh = new ShotgunBullet(x - 3, y);
				ShotgunBullet eighth = new ShotgunBullet(x - 3, y - 1);
				ShotgunBullet nineth = new ShotgunBullet(x - 3, y - 2);
				
				highDamage.add(first);
				mediumDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				lowDamage.add(fifth);
				lowDamage.add(sixth);
				lowDamage.add(seventh);	
				lowDamage.add(eighth);
				lowDamage.add(nineth);
			}
			
		}else if (direction == "ne" || direction == "nw" || direction == "se" || direction == "sw") {
			if (direction == "sw") {
				ShotgunBullet first = new ShotgunBullet(x - 1, y);
				ShotgunBullet second = new ShotgunBullet(x, y - 1);
				ShotgunBullet third = new ShotgunBullet(x - 2, y);
				ShotgunBullet fourth = new ShotgunBullet(x - 1, y - 1);
				ShotgunBullet fifth = new ShotgunBullet(x, y - 2);
				ShotgunBullet sixth = new ShotgunBullet(x , y - 3);
				ShotgunBullet seventh = new ShotgunBullet(x - 1, y - 2);
				ShotgunBullet eighth = new ShotgunBullet(x - 2, y - 1);
				ShotgunBullet nineth = new ShotgunBullet(x - 3, y);
				ShotgunBullet ten = new ShotgunBullet(x - 3, y - 1);
				ShotgunBullet eleven = new ShotgunBullet(x - 2, y - 2);
				ShotgunBullet twelve = new ShotgunBullet(x - 1, y - 3);
				ShotgunBullet thirteen = new ShotgunBullet(x - 3, y - 2);
				ShotgunBullet fourteen = new ShotgunBullet(x - 2, y - 3);
				ShotgunBullet fifteen = new ShotgunBullet(x - 3, y - 3);
				
				highDamage.add(first);
				highDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				mediumDamage.add(fifth);
				mediumDamage.add(sixth);
				mediumDamage.add(seventh);
				mediumDamage.add(eighth);
				mediumDamage.add(nineth);
				lowDamage.add(ten);
				lowDamage.add(eleven);
				lowDamage.add(twelve);
				lowDamage.add(thirteen);
				lowDamage.add(fourteen);
				lowDamage.add(fifteen);
				
			}else if (direction == "nw") {
				ShotgunBullet first = new ShotgunBullet(x - 1, y);
				ShotgunBullet second = new ShotgunBullet(x, y + 1);
				ShotgunBullet third = new ShotgunBullet(x - 2, y);
				ShotgunBullet fourth = new ShotgunBullet(x - 1, y + 1);
				ShotgunBullet fifth = new ShotgunBullet(x, y + 2);
				ShotgunBullet sixth = new ShotgunBullet(x , y + 3);
				ShotgunBullet seventh = new ShotgunBullet(x - 1, y + 2);
				ShotgunBullet eighth = new ShotgunBullet(x - 2, y + 1);
				ShotgunBullet nineth = new ShotgunBullet(x - 3, y);
				ShotgunBullet ten = new ShotgunBullet(x - 3, y + 1);
				ShotgunBullet eleven = new ShotgunBullet(x - 2, y + 2);
				ShotgunBullet twelve = new ShotgunBullet(x - 1, y + 3);
				ShotgunBullet thirteen = new ShotgunBullet(x - 3, y + 2);
				ShotgunBullet fourteen = new ShotgunBullet(x - 2, y + 3);
				ShotgunBullet fifteen = new ShotgunBullet(x - 3, y + 3);
				
				highDamage.add(first);
				highDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				mediumDamage.add(fifth);
				mediumDamage.add(sixth);
				mediumDamage.add(seventh);
				mediumDamage.add(eighth);
				mediumDamage.add(nineth);
				lowDamage.add(ten);
				lowDamage.add(eleven);
				lowDamage.add(twelve);
				lowDamage.add(thirteen);
				lowDamage.add(fourteen);
				lowDamage.add(fifteen);
				
			}else if (direction == "se") {
				ShotgunBullet first = new ShotgunBullet(x + 1, y);
				ShotgunBullet second = new ShotgunBullet(x, y - 1);
				ShotgunBullet third = new ShotgunBullet(x + 2, y);
				ShotgunBullet fourth = new ShotgunBullet(x + 1, y - 1);
				ShotgunBullet fifth = new ShotgunBullet(x, y - 2);
				ShotgunBullet sixth = new ShotgunBullet(x , y - 3);
				ShotgunBullet seventh = new ShotgunBullet(x + 1, y - 2);
				ShotgunBullet eighth = new ShotgunBullet(x + 2, y - 1);
				ShotgunBullet nineth = new ShotgunBullet(x + 3, y);
				ShotgunBullet ten = new ShotgunBullet(x + 3, y - 1);
				ShotgunBullet eleven = new ShotgunBullet(x + 2, y - 2);
				ShotgunBullet twelve = new ShotgunBullet(x + 1, y - 3);
				ShotgunBullet thirteen = new ShotgunBullet(x + 3, y - 2);
				ShotgunBullet fourteen = new ShotgunBullet(x + 2, y - 3);
				ShotgunBullet fifteen = new ShotgunBullet(x + 3, y - 3);
				
				highDamage.add(first);
				highDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				mediumDamage.add(fifth);
				mediumDamage.add(sixth);
				mediumDamage.add(seventh);
				mediumDamage.add(eighth);
				mediumDamage.add(nineth);
				lowDamage.add(ten);
				lowDamage.add(eleven);
				lowDamage.add(twelve);
				lowDamage.add(thirteen);
				lowDamage.add(fourteen);
				lowDamage.add(fifteen);
				
			}else if (direction == "ne") {
				ShotgunBullet first = new ShotgunBullet(x + 1, y);
				ShotgunBullet second = new ShotgunBullet(x, y + 1);
				ShotgunBullet third = new ShotgunBullet(x + 2, y);
				ShotgunBullet fourth = new ShotgunBullet(x + 1, y + 1);
				ShotgunBullet fifth = new ShotgunBullet(x, y + 2);
				ShotgunBullet sixth = new ShotgunBullet(x , y + 3);
				ShotgunBullet seventh = new ShotgunBullet(x + 1, y + 2);
				ShotgunBullet eighth = new ShotgunBullet(x + 2, y + 1);
				ShotgunBullet nineth = new ShotgunBullet(x + 3, y);
				ShotgunBullet ten = new ShotgunBullet(x + 3, y + 1);
				ShotgunBullet eleven = new ShotgunBullet(x + 2, y + 2);
				ShotgunBullet twelve = new ShotgunBullet(x + 1, y + 3);
				ShotgunBullet thirteen = new ShotgunBullet(x + 3, y + 2);
				ShotgunBullet fourteen = new ShotgunBullet(x + 2, y + 3);
				ShotgunBullet fifteen = new ShotgunBullet(x + 3, y + 3);
				
				highDamage.add(first);
				highDamage.add(second);
				mediumDamage.add(third);
				mediumDamage.add(fourth);
				mediumDamage.add(fifth);
				mediumDamage.add(sixth);
				mediumDamage.add(seventh);
				mediumDamage.add(eighth);
				mediumDamage.add(nineth);
				lowDamage.add(ten);
				lowDamage.add(eleven);
				lowDamage.add(twelve);
				lowDamage.add(thirteen);
				lowDamage.add(fourteen);
				lowDamage.add(fifteen);
				
			}
			
		}
		for (int i = 0; i < highDamage.size(); i ++) {
			if (map.at(highDamage.get(i).x(), highDamage.get(i).y()).containsAnActor() == true) {
				Actor target = map.at(highDamage.get(i).x(), highDamage.get(i).y()).getActor();
				target.hurt(70);
				}
		}
		
		for (int i = 0; i < mediumDamage.size(); i ++){
			if (map.at(highDamage.get(i).x(), highDamage.get(i).y()).containsAnActor() == true) {
				Actor target = map.at(highDamage.get(i).x(), highDamage.get(i).y()).getActor();
				target.hurt(40);
				}
			
		}
		
		for (int i = 0; i < mediumDamage.size(); i ++) {
			if (map.at(highDamage.get(i).x(), highDamage.get(i).y()).containsAnActor() == true) {
				Actor target = map.at(highDamage.get(i).x(), highDamage.get(i).y()).getActor();
				target.hurt(20);
				}
			
		}
	}

}
