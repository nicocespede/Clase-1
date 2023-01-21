package clase2;

//1. Indica la utilidad y pon un ejemplo del método equals en la clase Rectangulo.

//El método equals retorna true o false dependiendo de si el objeto en cuestión es equivalente al objeto pasado por parámetro.

//public boolean equals(Rectangulo r) {
//	return this.alto == r.getAlto() && this.ancho == r.getAncho();
//}

//2. Indica la utilidad y pon un ejemplo del método compareTo en la clase Rectangulo.

//El método compareTo se utiliza para comparar el objeto en cuestión con el objeto pasado por parámetro, suele devolver -1, 0 o 1 dependiendo 
//del criterio de comparación elegido.

//4. Realiza con POO un programa que permita pintar lo siguiente:

//Dimensión 1: 4
//Dimensión 2: 10

//    ++++
//   ++++++
//  ++++++++
// ++++++++++
//  ++++++++
//   ++++++
//    ++++

public class EjerciciosClase {

	public static void main(String[] args) {
		final class Hexagon {
			private int dim1;
			private int dim2;

			public Hexagon() {
				this.dim1 = 4;
				this.dim2 = 10;
			}

			public Hexagon(int dim1, int dim2) {
				if (dim1 < dim2) {
					this.dim1 = dim1;
					this.dim2 = dim2;
				} else {
					this.dim1 = dim2;
					this.dim2 = dim1;
				}
			}

			public String toString() {
				int symbols = this.dim1;
				int blanks = this.dim2 - this.dim1;
				String draw = "Dimension 1: " + this.dim1 + "\nDimension 2: " + this.dim2 + "\n\n";

				while (symbols < this.dim2) {
					int blanksHalf = blanks / 2;
					for (int i = 0; i < blanksHalf; i++) {
						draw += " ";
					}
					for (int i = 0; i < symbols; i++) {
						draw += "+";
					}
					for (int i = 0; i < blanksHalf; i++) {
						draw += " ";
					}
					draw += "\n";
					symbols += 2;
					blanks -= 2;
				}

				while (symbols >= this.dim1) {
					int blanksHalf = blanks / 2;
					for (int i = 0; i < blanksHalf; i++) {
						draw += " ";
					}
					for (int i = 0; i < symbols; i++) {
						draw += "+";
					}
					for (int i = 0; i < blanksHalf; i++) {
						draw += " ";
					}
					draw += "\n";
					symbols -= 2;
					blanks += 2;
				}

				return draw;

			}
		}

		System.out.println(new Hexagon());
		System.out.println(new Hexagon(15, 5));
	}

}
