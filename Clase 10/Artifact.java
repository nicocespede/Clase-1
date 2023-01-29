package clase10;

import java.util.ArrayList;
import java.util.List;

public class Artifact {

	private String name;
	private int health, attack, defense, speed;
	public static List<Artifact> availableArtifacts = new ArrayList<>();

	public Artifact(String name, int health, int attack, int defense, int speed) {
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.name = name;
		Artifact.availableArtifacts.add(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artifact other = (Artifact) obj;
		return this.health == other.health && this.attack == other.attack && this.defense == other.defense
				&& this.speed == other.speed && this.name.equals(other.name);
	}

	@Override
	public String toString() {
		return "'" + this.name + "': " + this.getAttributesString();
	}

	private String getAttributesString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getVisualValue(this.health) + " ♥♥♥");
		sb.append(" | " + this.getVisualValue(this.attack) + " ATQ");
		sb.append(" | " + this.getVisualValue(this.defense) + " DEF");
		sb.append(" | " + this.getVisualValue(this.speed) + " VEL");
		return sb.toString();
	}

	private String getVisualValue(int value) {
		if (value == 0)
			return "0";
		String ret = value > 0 ? "↑" : "↓";
		return ret + Math.abs(value);
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpeed() {
		return speed;
	}
}
