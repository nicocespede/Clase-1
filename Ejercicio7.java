import java.util.Scanner;

/*Crea un programa que lea por teclado tres números enteros H, M, S correspondientes a hora, minutos y segundos respectivamente, 
y comprueba si la hora que indican es una hora válida.

Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor válido para las horas será mayor o igual que cero y menor 
que 24.

El valor válido para los minutos y segundos estará comprendido entre 0 y 59 ambos incluidos*/

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese las horas: ");
		int H = sc.nextInt();
		System.out.println("Ingrese los minutos: ");
		int M = sc.nextInt();
		System.out.println("Ingrese los segundos: ");
		int S = sc.nextInt();
		sc.close();
		boolean isValid = H >= 0 && H <= 23 && M >= 0 && M <= 59 && S >= 0 && S <= 59;

		System.out.println(isValid ? "Hora valida." : "Hora no valida.");
	}

}
