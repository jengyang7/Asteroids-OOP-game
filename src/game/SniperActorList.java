package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class SniperActorList extends Action {
	ArrayList <Actor> allTargets = new ArrayList<Actor>();
	private Display display;
	private Action lastLoc;
	
	
	public SniperActorList(ArrayList<Actor> actor, Display display, Action action) {
		this.allTargets = actor;
		this.display = display;
		this.lastLoc = action;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		System.out.println("Choose actor by number");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String choice = "";
		try {
			choice = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		if (Integer.parseInt(choice) >= 0 && Integer.parseInt(choice) < allTargets.size()){
			Actions actions = new Actions();
			actions.add(new SniperAimType(allTargets.get(Integer.parseInt(choice))));
			Action action = actor.playTurn(actions, this.lastLoc, map, this.display);
			return action.execute(actor, map);
		}
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		String result = "Type in c to choose an actor target:" + "\n";
		for (int i = 0; i < allTargets.size(); i ++) {
			result +=  i + " " + allTargets.get(i).toString() + " \n";
		}
		
		return result;
	}
	
	@Override
	public String hotkey(){
		return "c";
	}

}
