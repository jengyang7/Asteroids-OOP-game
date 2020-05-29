package game;

public class Food extends PortableItem {

	public Food() {
		super("Food", 'f');
		this.addCapability(FoodCapability.Food);
		
	}

}
