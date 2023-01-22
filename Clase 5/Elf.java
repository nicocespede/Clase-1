package clase5;

public class Elf extends Character {

	public Elf(int health, int attack, int defense, int speed, String name) {
		super(health, attack, defense, speed, name);
	}

	public void elfSpecial() {
		System.out.println("*Movimiento especial de elfo*");
	}

}
