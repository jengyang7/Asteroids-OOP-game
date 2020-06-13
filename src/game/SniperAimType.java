package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperAimType extends Action {
	private Actor target;
	
	public SniperAimType(Actor target){
		this.target = target;
		
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "No target hit with sniper rifle";
		System.out.println("Choose aim type by number");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String choice = "";
		try {
			choice = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		double probability = Math.random();
		if (Integer.parseInt(choice) == 1) {
			if (probability < 0.75) {
				target.hurt(80);
				result = target.toString() + " hit by sniper rilfe for 80 damage";
			}
			
		}else if (Integer.parseInt(choice) == 2) {
			return "two";
			
		}else if (Integer.parseInt(choice) == 3) {
			return "three";
		}
		
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		String result  = "Type in a to choose aim type" + "\n";
		result += "0 No aim" + "\n" + "1 One round aim" + "\n" + "2 Two round aim" + "\n"; 
		return result;
	}
	
	@Override
	public String hotkey() {
		return "a";
	}
	

}
