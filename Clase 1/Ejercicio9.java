package clase1;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		int negatives = 0;
		int zeros = 0;
		int last;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Ingrese un numero entero:");
			last = sc.nextInt();
			if (last < 0)
				negatives++;
			if (last == 0)
				zeros++;
		} while (last != -25);

		sc.close();
		System.out.println("Números negativos ingresados: " + negatives);
		System.out.println("Ceros ingresados: " + zeros);
	}

}
