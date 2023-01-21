package clase1;

import java.util.Scanner;

//Solicita al usuario una frase y una letra y muestra la cantidad de veces que aparece la letra en la frase.

public class Ejercicio2 {

	public static void main(String[] args) {
		System.out.println("Ingrese una frase:");
		Scanner sc = new Scanner(System.in);
		String phrase = sc.nextLine().toLowerCase();
		System.out.println("Ingrese una letra:");
		char letter = sc.next().toLowerCase().charAt(0);
		sc.close();

		int ocurrences = 0;
		for (int i = 0; i < phrase.length(); i++)
			if (phrase.charAt(i) == letter)
				ocurrences++;

		System.out.println("La letra " + letter + " aparece " + ocurrences + " veces en su frase.");
	}

}
