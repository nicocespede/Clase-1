package clase10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Character {
	private String name;
	public final int INITIAL_HEALTH, INITIAL_ATTACK, INITIAL_DEFENSE, INITIAL_SPEED;
	private int health, attack, defense, speed;
	private List<Artifact> inventory;
	private Artifact actualArtifact;

	public Character(String name, int health, int attack, int defense, int speed) {
		this.setName(name);
		INITIAL_HEALTH = health;
		this.setHealth(INITIAL_HEALTH);
		INITIAL_ATTACK = attack;
		this.setAttack(INITIAL_ATTACK);
		INITIAL_DEFENSE = defense;
		this.setDefense(INITIAL_DEFENSE);
		INITIAL_SPEED = speed;
		this.setSpeed(INITIAL_SPEED);
		this.inventory = new ArrayList<>();
	}

	public void fight(Character c) {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " está muerto y no puede atacar\n");
			return;
		}

		System.out.println("*" + this.name + " ataca a " + c.name + "*\n");
		int hitRate = this.speed / c.speed;
		int attackerHits = (hitRate > 0 ? hitRate : 1) + 1;
		hitRate = c.speed / this.speed;
		int defenderHits = hitRate > 0 ? hitRate : 1;

		int max = attackerHits > defenderHits ? attackerHits : defenderHits;
		int i = 0;
		while (i < max && this.isAlive() && c.isAlive()) {
			if (i < attackerHits)
				this.attack(this, c);
			if (c.isAlive() && i < defenderHits)
				this.attack(c, this);
			System.out.println("");
			i++;
		}
	}

	public void grab(Artifact a) {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " está muerto y no puede agarrar un artefacto\n");
			return;
		}

		if (this.inventory.contains(a)) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " ya tiene " + a.getName() + " en su inventario\n");
			return;
		}

		if (!Artifact.availableArtifacts.contains(a)) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: '" + a.getName() + "' ya fue agarrado por otro personaje\n");
			return;
		}

		this.inventory.add(a);
		Artifact.availableArtifacts.remove(a);
		System.out.println("+ " + this.name + " agarró '" + a.getName() + "'\n");
	}

	public void drop(Artifact a) {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " está muerto y no puede soltar un artefacto\n");
			return;
		}

		if (!this.inventory.contains(a)) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " no tiene " + a.getName() + " en su inventario\n");
			return;
		}

		if (this.actualArtifact.equals(a))
			this.stopUsing(a);
		this.inventory.remove(a);
		Artifact.availableArtifacts.add(a);
		System.out.println("+ " + this.name + " soltó '" + a.getName() + "'\n");
	}

	public void use(Artifact a) {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " está muerto y no puede usar un artefacto\n");
			return;
		}

		if (!this.inventory.contains(a) || this.actualArtifact != null) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " no tiene " + a.getName()
					+ " en su inventario o ya está usando otro artefacto\n");
			return;
		}

		this.actualArtifact = a;
		this.applyModifiers(a.getHealth(), a.getAttack(), a.getDefense(), a.getSpeed());
		System.out.println("+ " + this.name + " está usando '" + a.getName() + "'\n");
	}

	public void stopUsing(Artifact a) {
		if (!this.isAlive()) {
			// seria mejor arrojar excepcion
			System.out.println("ERROR: " + this.name + " está muerto y no puede dejar de usar un artefacto\n");
			return;
		}

		if (!this.inventory.contains(a) || !this.actualArtifact.equals(a)) {
			// seria mejor arrojar excepcion
			System.out.println(
					"ERROR: " + this.name + " no tiene " + a.getName() + " en su inventario o no lo está usando\n");
			return;
		}

		this.actualArtifact = null;
		this.applyModifiers(-a.getHealth(), -a.getAttack(), -a.getDefense(), -a.getSpeed());
		System.out.println("+ " + this.name + " deja de usar '" + a.getName() + "'\n");
	}

	public void showInventory() {
		System.out.println(this.getInventoryString());
	}

	private String getInventoryString() {
		if (this.inventory.size() == 0)
			return "Inventario de " + this.name + ":\n\tVACÍO\n";
		else {
			StringBuilder sb = new StringBuilder("Inventario de " + this.name + ":\n");
			for (Artifact a : this.inventory)
				sb.append("\t→ " + a.toString() + "\n");
			return sb.toString();
		}
	}

	public void save(String filename) {
		try (FileWriter fw = new FileWriter(filename)) {
			fw.write(this.toString() + "\n\n" + this.getInventoryString());
		} catch (IOException e) {
			System.out.println("Ocurrió un error al guardar el personaje:\n" + e.getStackTrace());
		}
	}

	protected boolean isAlive() {
		return this.health > 0;
	}

	private void applyModifiers(int health, int attack, int defense, int speed) {
		this.setHealth(this.health + health);
		this.setAttack(this.attack + attack);
		this.setDefense(this.defense + defense);
		this.setSpeed(this.speed + speed);
	}

	private void attack(Character attacker, Character defender) {
		int damage = this.calculateDamage(attacker.attack, defender.defense);
		defender.setHealth(defender.health - damage);
		System.out.println("> " + attacker.name + " inflinge " + damage + " puntos de daño a " + defender.name);
	}

	private int calculateDamage(int attack, int defense) {
		int damage = attack - defense + this.generateRandomInt();
		if (damage < 0)
			damage = 0;
		return damage;
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
