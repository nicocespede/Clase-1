package clase10;

public class Elf extends Character {

	public Elf(String name, int health, int attack, int defense, int speed) {
		super(name, health, attack, defense, speed);
	}

	public void elfSpecial() {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out
					.println("ERROR: " + this.getName() + " está muerto y no puede realizar su movimiento especial\n");
			return;
		}
		System.out.println("*" + this.getName() + " realiza un movimiento especial de elfo*\n");
	}

	public void meditate() {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.getName() + " está muerto y no puede meditar\n");
			return;
		}
		this.setHealth(this.INITIAL_HEALTH);
		System.out.println("*" + this.getName() + " medita y recupera todos sus puntos de vida*\n");
	}

}
