package clase1;

import java.util.Scanner;

/*Programa para invertir el orden de las cifras de un número. Se introduce un número entero positivo por teclado y el programa modifica el número invirtiendo el orden de sus cifras.

Si por ejemplo se introduce el número N = 1234

El programa lo transformará invirtiendo el orden de sus cifras. El nuevo valor de N será 4321*/

public class Ejercicio10 {
	public static void main(String[] args) {
		System.out.println("Ingrese un numero entero positivo:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n <= 0)
			System.out.println("Número inválido");
		else {
			String original = Integer.toString(n);
			String reversed = "";
			for (int i = original.length() - 1; i >= 0; i--)
				reversed += original.charAt(i);
			System.out.println(reversed);
		}
	}
}
