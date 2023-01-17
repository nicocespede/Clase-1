package clase1;

public class Ejercicio6 {

	public static void main(String[] args) {
		String[] WORDS = { "Madre", "Padre", "Hermano", "Hermana", "Abuelo", "Primo", "Nieto" };
		String aux;

		System.out.print("{ ");
		for (int j = 0; j < WORDS.length; j++) {
			for (int i = j + 1; i < WORDS.length; i++)
				if (WORDS[i].compareTo(WORDS[j]) < 0) {
					aux = WORDS[j];
					WORDS[j] = WORDS[i];
					WORDS[i] = aux;
				}
			System.out.print("'" + WORDS[j] + "'" + (j < WORDS.length - 1 ? ", " : ""));
		}
		System.out.print(" }");

	}

}
