package clase1;

import java.util.Scanner;

//Solicita al usuario una letra, si inserta una a muestra el número 7, si es una b, el 9, si es una c el 101 y si no es ninguno de los tres, indícale que se ha equivocado de letra

public class Ejercicio5 {
	public static void main(String[] args) {
		System.out.println("Ingrese una letra:");
		Scanner sc = new Scanner(System.in);
		char letter = sc.next().toLowerCase().charAt(0);
		sc.close();
		
		String ret;
		switch (letter) {
		case 'a':
			ret = "7";
			break;
		case 'b':
			ret = "9";
			break;
		case 'c':
			ret = "101";
			break;
		default:
			ret = "¡Te equivocaste de letra!";
		}
		
		System.out.println(ret);
	}
}
