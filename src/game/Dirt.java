package game;

import edu.monash.fit2099.engine.Ground;
import java.lang.Math;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	
	
	private int turn = 20;
	private boolean isACrop;
	private boolean riped;
	private boolean fertilised;
	

	public Dirt() {
		super('.');
		this.isACrop = false;
		this.riped = false;
		this.fertilised = false;
		
	}
	
	
	public boolean sow(){
		
		//Generate probability for sowing crop from 0 - 1 (exclusive 1)
		double probability = Math.random();
		
		if (this.isACrop && !this.riped) {
			System.out.println("This is already a crop!");
			return false;
		}
		else if (!this.isACrop && probability < 0.33 && !this.riped) {
			super.displayChar = 'C';
			System.out.println("Successfully sowed a crop!");
			return true;
			
		}
		return false;
		
	}
	
	public void reduceTurn() {
		if (this.isACrop && this.turn <= 0 && !this.riped) {
			this.isACrop = false;
			this.fertilised = false;
			this.riped = true;
			super.displayChar = 'F';
			
		}else {
			this.turn -= 1;
		}
	}
	
	public void fertilised() {
		if (this.isACrop && !this.fertilised && !this.riped && this.turn > 0){
			this.turn -= 10;
			this.fertilised = true;
		}
		
	}
	
	public boolean isFood() {
		if (this.riped) {
			return true;
		}
		return false;
	}
	
	
}
