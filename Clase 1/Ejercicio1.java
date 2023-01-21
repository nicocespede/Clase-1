package clase1;

import java.util.Scanner;

//Solicita al usuario tres números enteros e indícale cuál es el menor.

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("Ingrese un número:");
		Scanner sc = new Scanner(System.in);
		int minor = sc.nextInt();
		for (int i = 0; i < 2; i++) {
			System.out.println("Ingrese otro número:");
			int aux = sc.nextInt();
			if (aux < minor)
				minor = aux;
		}
		sc.close();
		System.out.println("El número menor es " + minor);
	}

}
