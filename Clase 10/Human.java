package clase10;

public class Human extends Character {

	public Human(String name, int health, int attack, int defense, int speed) {
		super(name, health, attack, defense, speed);
	}

	public void humanSpecial() {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out
					.println("ERROR: " + this.getName() + " está muerto y no puede realizar su movimiento especial\n");
			return;
		}
		System.out.println("*" + this.getName() + " realiza un movimiento especial de humano*\n");
	}
}
