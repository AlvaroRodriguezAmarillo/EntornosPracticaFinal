package actividad;

import java.util.Scanner;

/**
 * La clase Principal es el comienzo del programa, desde el que el usuario tendrá que elegir las diferentes opciones
 *
 * @version 1.0
 * @author Álvaro
 */

public class Principal {

	/**
	 * Este método permite al usuario ingresar su nombre de domador y elegir si quiere
	 * iniciar una batalla o salir.
	 */
	
	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);
		System.out.println("Bienvenido al mundo Digimon, por favor ingrese su nombre de Domador: ");

		String NombreDomador = leer.nextLine();
		Domador domador = new Domador(NombreDomador);
		while (domador.Equipo.size() < 3) {
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println();
			System.out.println("Elige una de las opciones posibles:");
			System.out.println();
			System.out.println("1. Iniciar batalla");
			System.out.println("2. Salir");
			int opcion = leer.nextInt();
			switch (opcion) {

			case 1:
				BatallaDigital batalla = new BatallaDigital(domador);
				batalla.pelea();
				break;

			case 2:
				break;

			default:
				System.out.println("Esta opción no es válida, elige una opción válida de entre las posibles.");
				break;
			}
			if (opcion == 2) {
				break;
			}
		}
		if (domador.Equipo.size() == 3) {
			System.out.println("Enhorabuena " + domador.Nombre + ". Has capturado los 3 Digimones.");
		}
		leer.close();
	}
}
