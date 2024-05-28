package actividad;

import java.util.ArrayList;
import java.util.Random;

/**
 * En la clase domador, el domador tendrá un equipo de Digimones y
 * puede capturar nuevos Digimones
 * 
 * @version 1.0
 * @author Alvaro
 */

public class Domador {
	String Nombre;
	ArrayList<DigimonesIconicos>Equipo;
	Random Aleatorio = new Random();

	 /**
     * En el constructor de la clase Domador se declara el nombre del domador y se 
     * añade un digimon aleatorio al equipo del domador
     * 
     * @param nombre Nombre del domador
     */
	
	public Domador(String nombre) {
		this.Nombre = nombre;
		this.Equipo = new ArrayList<>();
		this.Equipo.add(DigimonAleatorio());
	}

	
	 /**
     * El método DigimonAleatorio genera un digimon aleatorio y lo añade al equipo.
     * 
     * @return Devuelve un objeto 
     */
	
	public DigimonesIconicos DigimonAleatorio() {
		String[] nombreDigimon = {"Agumon", "Gabumon", "Patamon"};
		String[] especieDigimon = {"Reptil", "Reptil", "Mammal"};
		int index = Aleatorio.nextInt(nombreDigimon.length);
		return new DigimonesIconicos(nombreDigimon[index], especieDigimon[index]);
	}

	 /**
     * Este método captura un digimon en el caso de que su salud sea
     * menor o igual a 20 y lo añade al equipo
     * 
     * @param digimon El Digimon capturado
     */
	
	public void captura(DigimonesIconicos digimon) {
		if (digimon.Salud <= 20) {
			Equipo.add(digimon);
			System.out.println(digimon.Nombre + " se ha unido a su equipo");
		} else {
			System.out.println("No se puede unir");
		}
	}

	
	 /**
     * Este método comprueba si uno de los 3 digimones ha sido capturado 
     * 
     * @param nombre Nombre del digimon que va a ser comprobado
     * @return Devuelve true si el digimon ha sido capturado o false sino lo ha sido
     */
	
	public boolean DigimonCapturado(String nombre) {
		for (DigimonesIconicos digimon : Equipo) {
			if (digimon.Nombre.equals(nombre)) {
				return true;
			}
		}
		return false;
	}
}