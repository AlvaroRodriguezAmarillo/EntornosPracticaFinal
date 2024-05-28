package actividad;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * En la clase DigimonesIconicos se representa un digimon 
 * con sus atributos 
 * 
 * @version 1.0
 * @author Alvaro
 */

class DigimonesIconicos {
	String Nombre;
	String Especie;
	int Nivel;
	int PuntosAtaque;
	int Salud;
	int DP1;
	int DP2;
	Random rand = new Random();

	
	/**
     * Este constructor inicializa un digimon con su nombre y especie 
     * aniadiendoles unos valores aleatorios especificados.
     * 
     * @param nombre Nombre del digimon.
     * @param especie Especie del digimon.
     * @param nivel Nivel del digimon
     * @param ataque Puntos de ataque del digimon
     * @param salud Salud del digimon
     * @param intentos Intentos de ataques del digimon
     */
	
	public DigimonesIconicos(String nombre, String especie) {
		this.Nombre = nombre;
		this.Especie = especie;
		this.Nivel = rand.nextInt(5) + 1;
		this.PuntosAtaque = 5 * this.Nivel;
		this.Salud = 10 * this.Nivel;
		this.DP1 = 10;
		this.DP2 = 10;
	}

	
	 /**
     * Este constructor es el primer ataque del digimon, donde se resta su DP1
     * 
     * @return Devuelve los puntos de ataque en el caso de que el digimon tenga
     * suficientes DP1 o sino devuelve 0
     */
	
	public int ataque1() {
		if (DP1 > 0) {
			DP1 = DP1 - 1;
			return PuntosAtaque;
		}
		return 0;
	}

	
	 /**
     * Este constructor es el segundo ataque del digimon, donde se resta su DP2
     * 
     * @return Devuelve el doble de los puntos de ataque en el caso de que el digimon tenga
     * suficientes DP2 o sino devuelve 0
     */
	
	public int ataque2() {
		if (DP2 > 1) {
			DP2 = DP2 - 2;
			return PuntosAtaque * 2;
		}
		return 0;
	}
}