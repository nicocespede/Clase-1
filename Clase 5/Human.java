package clase5;

public class Human extends Character {

	public Human(int health, int attack, int defense, int speed, String name) {
		super(health, attack, defense, speed, name);
	}

	public void humanSpecial() {
		System.out.println("*Movimiento especial de humano*");
	}
}
