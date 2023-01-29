package clase10;

public class Main {
	private static Human human = new Human("Nico", 100, 25, 25, 75);
	private static Orc orc = new Orc("Grunt", 100, 75, 75, 25);
	private static Elf elf = new Elf("Landrei", 100, 50, 25, 50);

	public static void main(String[] args) {
		Artifact sword = new Artifact("Espada guay", 0, 20, 5, -1);
		Artifact shield = new Artifact("Escudo pesado", 0, 0, 50, -20);
		Artifact hammer = new Artifact("Mjolnir", 0, 40, 0, -5);

		printStatus();
		// pelea 1
		human.grab(sword);
		human.grab(shield);
		human.use(shield);
		human.showInventory();
		orc.grab(sword);
		printStatus();
		human.fight(orc);
		printStatus();

		// pelea 2
		human.stopUsing(shield);
		human.use(sword);
		human.fight(elf);
		printStatus();
		elf.meditate();
		printStatus();

		// pelea 3
		elf.grab(hammer);
		elf.use(hammer);
		elf.showInventory();
		printStatus();
		elf.fight(orc);
		printStatus();
		elf.elfSpecial();
		human.humanSpecial();

		human.save("Nico.txt");
	}

	private static void printStatus() {
		System.out.println("ESTADO DE LOS PERSONAJES:\n");
		System.out.println(human + "\n" + orc + "\n" + elf + "\n");
		System.out.println("------------------------------------------------\n");
	}

}
