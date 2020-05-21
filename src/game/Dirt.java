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
	private boolean food;

	public Dirt() {
		super('.');
		this.isACrop = false;
		this.riped = false;
		this.fertilised = false;
		this.food = false;
	}
	
	public String sow(){
		
		//Generate probability for sowing crop from 0 - 1 (exclusive 1)
		double probability = Math.random();
		
		if (probability < 0.33) {
			this.isACrop = true;
			this.riped = false;
			this.fertilised = false;
			super.displayChar = 'C';
			return ("Successfully sowed a crop!");
			
		}
		this.isACrop = false;
		this.riped = false;
		this.fertilised = false;
		return ("Sow unsuccessful!");
		
	}
	
	public void reduceTurn() {
		if (!this.riped) {
			this.turn -= 1;
			if (this.turn <= 0) {
				this.isACrop = false;
				this.fertilised = false;
				this.riped = true;
			}
		}
	}
	
	public String fertilised() {
	
		this.turn -= 10;
		this.fertilised = true;
		return ("Successfully fertilise a crop!");
		}
		

	
	public void changeFood() {
		this.isACrop = false;
		this.fertilised = false;
		this.riped = false;
		this.food = true;
		super.displayChar = 'f';
	}
	

	public boolean retIsACrop() {
		return this.isACrop;
	}
	
	public boolean retFertilised() {
		return this.fertilised;
	}
	
	public boolean retRiped() {
		return this.riped;
	}

	
	
}
