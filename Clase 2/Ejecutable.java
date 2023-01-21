package clase2;

import java.util.Scanner;

/*
Ahora, crea una clase clase ejecutable:

Crea un array de Passwords con el tamaño que tu le indiques por teclado.

Crea un bucle que cree un objeto para cada posición del array.

Indica también por teclado la longitud de los Passwords (antes de bucle).

Crea un segundo array con objetos copia del array anterior.

Ordena alfabéticamente el array de copias.

Muestra el array de copias.

Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte (se trata de las contraseñas del array
original, no de las copias).

Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior).

Ejemplo salida:

Contraseñas ordenadas:

Todas las contraseñas

contraseña1 valor_booleano1

contraseña2 valor_bololeano2

...*/

public class Ejecutable {

	public static void main(String[] args) {
		System.out.println("Ingrese la cantidad de contraseñas que desea guardar:");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		System.out.println("Ingrese la longitud deseada para las contraseñas:");
		int length = sc.nextInt();
		sc.close();

		Password[] passwords = new Password[amount];
		boolean[] areStrong = new boolean[amount];
		Password[] copies = new Password[amount];
		for (int i = 0; i < amount; i++) {
			passwords[i] = new Password(length);
			areStrong[i] = passwords[i].isStrong();
			copies[i] = new Password(passwords[i]);
		}
		boolean[] copiesAreStrong = areStrong.clone();

		bubbleSort(copies, copiesAreStrong);
		System.out.println("\nContraseñas ordenadas:\n");
		for (int i = 0; i < amount; i++)
			System.out.println(copies[i].getPassword() + " " + copiesAreStrong[i] + "\n");
	}

	private static void bubbleSort(Password[] passwords, boolean[] areStrong) {
		for (int j = 0; j < passwords.length; j++)
			for (int i = j + 1; i < passwords.length; i++)
				if (passwords[i].getPassword().toLowerCase().compareTo(passwords[j].getPassword().toLowerCase()) < 0) {
					Password aux1 = passwords[j];
					passwords[j] = passwords[i];
					passwords[i] = aux1;
					boolean aux2 = areStrong[j];
					areStrong[j] = areStrong[i];
					areStrong[i] = aux2;
				}
	}

}
