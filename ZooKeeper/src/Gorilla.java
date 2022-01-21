
public class Gorilla extends Mammal {
	// constructor
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	public void throwSomething() {
		System.out.println("Throwing object");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla is full");
		energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Climbing tree");
		energyLevel -= 10;
	}

}
