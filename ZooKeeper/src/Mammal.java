
public class Mammal {
	protected int energyLevel;
	
	// constructor
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println("Energy Level: " + this.energyLevel);
		return this.energyLevel;
	}
	
	
}
