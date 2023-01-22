package clase5;

public class Orc extends Character {

	public Orc(int health, int attack, int defense, int speed, String name) {
		super(health, attack, defense, speed, name);
	}

	public void orcSpecial() {
		System.out.println("*" + this.getName() + " realiza un movimiento especial de orco*");
	}
}
