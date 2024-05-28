package actividad;

import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase representa la pelea entre el digimon del domador y el enemigo
 * 
 * @version 1.0
 * @author Alvaro
 */

public class BatallaDigital {
	Domador Domador;
	DigimonesIconicos enemigo;
	Random rand = new Random();
	Scanner scanner = new Scanner(System.in);

	
	 /**
     * Este constructor inicializa la batalla
     * 
     * @param domador Domador que va a participar en la pelea.
     */
	
	public BatallaDigital(Domador domador) {
		this.Domador = domador;
	}

	 /**
     * Se genera un digimon aleatorio que aun no ha sido capturado
     * 
     * @return Devuelve un objeto
     */
	
	public DigimonesIconicos DigimonAleatorio() {
		String[] nombreDigimon = {"Agumon", "Gabumon", "Patamon"};
		String[] especieDigimon = {"Reptil", "Reptil", "Mammal"};
		DigimonesIconicos digimon;
		do {
			int index = rand.nextInt(nombreDigimon.length);
			digimon = new DigimonesIconicos(nombreDigimon[index], especieDigimon[index]);
		} while (Domador.DigimonCapturado(digimon.Nombre));
		return digimon;
	}

	 /**
     * Este constructor permite al usuario escoger el digimon con el que pelear
     * 
     * @return El digimon escogido
     */
	public DigimonesIconicos elige() {
		System.out.println("Escoge el Digimon con el que desee luchar:");
		for (int i = 0; i < Domador.Equipo.size(); i++) {
			DigimonesIconicos digimon = Domador.Equipo.get(i);
			System.out.println((i + 1) + ". " + digimon.Nombre + " (Nivel: " + digimon.Nivel + ", Salud: " + digimon.Salud + ", Ataque: " + digimon.PuntosAtaque + ")");
			System.out.println();
		}
		int eleccion = scanner.nextInt() - 1;
		return Domador.Equipo.get(eleccion);
	}

	
	/**
     * Se inicia la pelea entre los digimones
     */
	public void pelea() {
		DigimonesIconicos MiDigimon = elige();
		enemigo = DigimonAleatorio();
		while (MiDigimon.Salud > 0 && enemigo.Salud > 0) {
			System.out.println("La batalla va a comenzar");
			System.out.println("");
			System.out.println("---------------------------------------------------------------");
			System.out.println("");
			System.out.println("Mi " + MiDigimon.Nombre + " (Nivel: " + MiDigimon.Nivel + ", Salud: " + MiDigimon.Salud + ", Ataque: " + MiDigimon.PuntosAtaque + ") vs " + enemigo.Nombre + " Enemigo (Nivel: " + enemigo.Nivel + ", Salud: " + enemigo.Salud + ", Ataque: " + enemigo.PuntosAtaque + ")");
			System.out.println("1. Ataque1 (DP1: " + MiDigimon.DP1 + ")");
			System.out.println("2. Ataque2 (DP2: " + MiDigimon.DP2 + ")");
			System.out.println("3. Capturar enemigo");
			int eleccion = scanner.nextInt();
			int danio = 0;

			switch (eleccion) {
			case 1:
				danio = MiDigimon.ataque1();
				break;
			case 2:
				danio = MiDigimon.ataque2();
				break;
			case 3:
				Domador.captura(enemigo);
				return;
			default:
				System.out.println("Esta opción no existe, escoge una de entre las posibles");
				continue;
			}

			enemigo.Salud -= danio;
			System.out.println("El " + enemigo.Nombre + " enemigo ha recibido " + danio + " de daño. Salud restante: " + enemigo.Salud);

			if (enemigo.Salud > 0) {
				int danioEnemigo = enemigo.ataque1();
				MiDigimon.Salud -= danioEnemigo;
				System.out.println("Mi " + MiDigimon.Nombre + " ha recibido " + danioEnemigo + " de daño. Salud restante: " + MiDigimon.Salud);
			}
		}
		if (MiDigimon.Salud <= 0) {
			System.out.println("Mi " + MiDigimon.Nombre + " ha sido derrotado.");
		}
		if (enemigo.Salud <= 0) {
			System.out.println("El enemigo " + enemigo.Nombre + " ha sido derrotado.");
		}
	}
}
