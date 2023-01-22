package clase5;

public class Main {
	static Human human = new Human(100, 25, 25, 75, "Nico");
	static Orc orc = new Orc(100, 75, 75, 25, "Grunt");
	static Elf elf = new Elf(100, 50, 25, 50, "Landrei");

	public static void main(String[] args) {
		printStatus();
		human.fight(orc);
		printStatus();
		human.fight(elf);
		printStatus();
		elf.fight(orc);
		printStatus();
		elf.elfSpecial();
		human.humanSpecial();
	}

	static void printStatus() {
		System.out.println("ESTADO DE LOS PERSONAJES:\n");
		System.out.println(human + "\n" + orc + "\n" + elf + "\n");
		System.out.println("-------------------------------------------\n");
	}

}
