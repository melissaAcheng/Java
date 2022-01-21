
public class Bat extends Mammal {
	// constructor
	public Bat() {
		super(300);
	}

	public void fly() {
		System.out.println("I'm flying!!!!");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Fire!! Help! Fire!!");
		energyLevel -= 100;
	}
}
