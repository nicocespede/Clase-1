import java.util.Scanner;

//Programa que lea por teclado un número correspondiente a un mes e indique si es un mes de 28, 30 o 31 días y qué mes es en un String.

public class Ejercicio8 {

	public static void main(String[] args) {
		String[] months = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el numero de mes:");
		int n = sc.nextInt() - 1;
		sc.close();

		if (n < 0 || n > 11)
			System.out.println("Numero de mes invalido.");
		else {
			String month = months[n];
			if (n == 1)
				System.out.println(month + " - " + "28 dias");
			else if (n == 3 || n == 5 || n == 8 || n == 10)
				System.out.println(month + " - " + "30 dias");
			else
				System.out.println(month + " - " + "31 dias");
		}
	}

}
