package game;

import edu.monash.fit2099.engine.Ground;

public class Crop extends Ground {
	private boolean fertilised;
	private boolean riped;
	private int turn;
	private boolean food;

	public Crop() {
		super('C');
		this.fertilised = false;
		this.riped = false;
		this.food = false;
		this.turn = 20;
	}
	
		
	public void reduceTurn() {
		if (!this.riped) {
			this.turn -= 1;
			if (this.turn <= 0) {
				this.fertilised = false;
				this.riped = true;
			}
		}
	}
	
	public void fertilised() {
	
		this.turn -= 10;
		this.fertilised = true;
		}
		
	public void changeFood() {
		this.fertilised = false;
		this.riped = false;
		this.food = true;
		super.displayChar = 'f';
	}
	
	public boolean retFertilised() {
		return this.fertilised;
	}
	
	public boolean retRiped() {
		return this.riped;
	}
	
	public boolean retFood() {
		return this.food;
	}

}
