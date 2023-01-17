package clase1;

import java.util.Scanner;

//Almacena en dos variables datos de validación (usuario y contraseña) correctos y permite que el usuario valide (dispone de 3 intentos)

public class Ejercicio4 {

	public static void main(String[] args) {
		String USERNAME = "nicolascespede";
		String PASSWORD = "Qaracter123";

		int fails = 0;
		String username;
		String password;

		Scanner sc = new Scanner(System.in);
		do {
			fails++;
			System.out.println("Ingrese nombre de usuario (intento " + fails + "/3):");
			username = sc.next();
			System.out.println("Ingrese contraseña (intento " + fails + "/3):");
			password = sc.next();
		} while (fails < 3 && !username.equals(USERNAME) && !password.equals(PASSWORD));

		sc.close();
		if (username.equals(USERNAME) && password.equals(PASSWORD))
			System.out.println("¡Bienvenido " + USERNAME + "!");
		else
			System.out.println("Máxima cantidad de intentos alcanzada, hemos bloqueado el acceso.");
	}

}
