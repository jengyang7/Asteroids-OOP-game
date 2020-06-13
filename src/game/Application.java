package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.World;

/**
 * The main class for the zombie apocalypse game.
 *
 */
public class Application {

	public static void main(String[] args) {
		GameWorld world = new GameWorld(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Fence(), new Tree(), new Wall());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"....................................##########..................................",
		"..........................###########........#####..............................",
		"............++...........##......................########.......................",
		"..............++++.......#..............................##......................",
		".............+++...+++...#...............................#......................",
		".........................##..............................##.....................",
		"..........................#...............................#.....................",
		".........................##...............................##....................",
		".........................#...............................##.....................",
		".........................###..............................##....................",
		"...........................####......................######.....................",
		"..............................#########.........####............................",
		"............+++.......................#.........#...............................",
		".............+++++....................#.........#...............................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);
		
		List<String> townMap = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"................................................................................",
		".........................................$$$$$$$$$$$$$$$$$$$$$$$$...............",
		".........................................$$....................$$...............",
		".........................................$$....................$$...............",
		".........................................$$....................$$...............",
		".........................................$$....................$$...............",
		".........................................$$....................$$...............",
		".........................................$$....................$$...............",
		".........................................$$....................$$...............",
		".............+++.........................$$....................$$...............",
		"...........+.++..........................$$....................$$...............",
		"............+++..........................$$$$$$$$........$$$$$$$$...............",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"..........................+.....................................................",
		".........................+++....................................................",
		"........................+.++....................................................",
		"..........................+.....................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................");
        GameMap town = new GameMap(groundFactory, townMap);
        world.addGameMap(town);
		
        TownItem horse = new TownItem("Horse", 'h', false);
        horse.addAction(new MoveActorAction(town.at(2, 2), "to Town!"));
        gameMap.at(40, 17).addItem(horse);
        
        TownItem cat = new TownItem("C", 'c', false);
        cat.addAction(new MoveActorAction(gameMap.at(4, 4), "to GameMap!"));
        town.at(10, 17).addItem(cat);
        
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(42, 15));
		
		Actor mambo = new MamboMarie("Mambo Marie", 'M', 100);
		world.addMambo(mambo);
		
	    // Place some random humans
		String[] humans = {"Carlton", "May", "Vicente", "Andrea", "Wendy",
				"Elina", "Winter", "Clem", "Jacob", "Jaquelyn"};
		int x, y;
		for (String name : humans) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			} 
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x,  y).addActor(new Human(name));	
		}
		
		String[] farmers = {"Yusof", "Johnny", "Matt", "Harry"};
		for (String name: farmers) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			}
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x, y).addActor(new Farmer(name));
		}
		
		
		// place a simple weapon
		gameMap.at(74, 20).addItem(new Plank());
		town.at(50, 10).addItem(new Shotgun());
		town.at(55, 20).addItem(new Shotgun());
		
		
		// FIXME: Add more zombies!
		gameMap.at(30, 20).addActor(new Zombie("Groan"));
		gameMap.at(30,  18).addActor(new Zombie("Boo"));
		gameMap.at(10,  4).addActor(new Zombie("Uuuurgh"));
		gameMap.at(50, 18).addActor(new Zombie("Mortalis"));
		gameMap.at(1, 10).addActor(new Zombie("Gaaaah"));
		gameMap.at(62, 12).addActor(new Zombie("Aaargh"));	
		world.run();
	}
}
