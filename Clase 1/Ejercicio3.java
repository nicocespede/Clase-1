package clase1;

import java.util.Scanner;

//Suma o resta (según elija el usuario) dos números reales

public class Ejercicio3 {

	public static void main(String[] args) {
		System.out.println("Ingrese un numero real:");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		System.out.println("Ingrese el simbolo de la operación deseado:");
		char symbol = sc.next().charAt(0);

		if (symbol != '+' && symbol != '-')
			System.out.println("Simbolo inválido");
		else {
			System.out.println("Ingrese el segundo numero real:");
			double b = sc.nextDouble();
			System.out.println(a + " " + symbol + " " + b + " = " + (symbol == '+' ? a + b : a - b));
		}
		sc.close();
	}

}
