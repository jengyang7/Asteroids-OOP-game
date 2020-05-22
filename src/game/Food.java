package game;

public class Food extends PortableItem {

	public Food(String name, char displayChar, Enum<?> capability) {
		super(name, displayChar);
		this.addCapability(capability);
		
	}

}
