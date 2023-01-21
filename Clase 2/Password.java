package clase2;

import java.util.Random;

/*
Desarrolla una clase llamada Password que siga las siguientes condiciones:

Que tenga los atributos longitud y contraseña . Por defecto, la longitud sera de 8.

Los constructores serán los siguiente:

Un constructor por defecto.
Un constructor sobrecargado con la longitud que nosotros le pasemos. Generara una contraseña aleatoria con esa longitud.
Un constructor de copia, ya que vamos a tener que hacer copias de seguridad en un array.
Los métodos que implementa serán:

esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
generarPassword(): genera la contraseña del objeto con la longitud que tenga de manera aleatoria.
Método get para contraseña y longitud.
Método set para longitud.
*/

public class Password {
	private int length;
	private String password;

	public Password() {
		this.length = 8;
		this.password = generatePassword();
	}

	public Password(int length) {
		this.length = length;
		this.password = generatePassword();
	}

	public Password(Password p) {
		this.length = p.length;
		this.password = p.password;
	}

	public boolean isStrong() {
		String UPPER_CASES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String LOWER_CASES = "abcdefghijklmnopqrstuvwxyz";
		String NUMBERS = "0123456789";
		int upperCases = 0;
		int lowerCases = 0;
		int numbers = 0;
		for (int i = 0; i < this.length; i++) {
			char actual = this.password.charAt(i);
			if (UPPER_CASES.indexOf(actual) != -1)
				upperCases++;
			else if (LOWER_CASES.indexOf(actual) != -1)
				lowerCases++;
			else if (NUMBERS.indexOf(actual) != -1)
				numbers++;
		}
		return upperCases > 2 && lowerCases > 1 && numbers > 5;
	}

	private String generatePassword() {
		return generateRandomString(this.length);
	}

	public void setLength(int length) {
		if (length < this.length)
			this.password = this.password.substring(0, length);
		else
			this.password += generateRandomString(length - this.length);
		this.length = length;
	}

	private String generateRandomString(int length) {
		String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random rand = new Random();

		String ret = "";
		for (int i = 0; i < length; i++) {
			int random = rand.nextInt(CHARACTERS.length());
			char character = CHARACTERS.charAt(random);
			random = rand.nextInt(2);
			ret += random == 0 ? character : Character.toUpperCase(character);
		}
		return ret;
	}

	public int getLength() {
		return length;
	}

	public String getPassword() {
		return password;
	}
}
