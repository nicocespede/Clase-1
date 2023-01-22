package clase5;

public class Character {
	private int health;
	private int attack;
	private int defense;
	private int speed;
	private String name;

	public Character(int health, int attack, int defense, int speed, String name) {
		this.setHealth(health);
		this.setAttack(attack);
		this.setDefense(defense);
		this.setSpeed(speed);
		this.setName(name);
	}

	public void fight(Character c) {
		System.out.println("*" + this.name + " ataca a " + c.name + "*\n");
		int hitRate = this.speed / c.speed;
		int attackerHits = (hitRate > 0 ? hitRate : 1) + 1;
		hitRate = c.speed / this.speed;
		int defenderHits = hitRate > 0 ? hitRate : 1;

		int max = attackerHits > defenderHits ? attackerHits : defenderHits;
		int i = 0;
		while (i < max && this.health > 0 && c.health > 0) {
			if (i < attackerHits) {
				int damage = this.attack - c.defense + generateRandomInt();
				if (damage < 0)
					damage = 0;
				c.setHealth(c.health - damage);
				System.out.println("> " + this.name + " inflinge " + damage + " puntos de daño a " + c.name);
			}

			if (c.health > 0 && i < defenderHits) {
				int damage = c.attack - this.defense + generateRandomInt();
				if (damage < 0)
					damage = 0;
				this.setHealth(this.health - damage);
				System.out.println("> " + this.name + " recibe " + damage + " puntos de daño de " + c.name);
			}
			System.out.println("");
			i++;
		}
	}

	private int generateRandomInt() {
		return (int) Math.floor(Math.random() * 101 - 50);
	}

	public String toString() {
		return this.name + ": " + this.health + " ♥♥♥ | " + this.attack + " ATQ | " + this.defense + " DEF | "
				+ this.speed + " VEL";
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health >= 0 ? health : 0;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack >= 0 ? attack : 0;
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense >= 0 ? defense : 0;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed >= 0 ? speed : 0;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
