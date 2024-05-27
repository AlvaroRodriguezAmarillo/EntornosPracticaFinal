package actividad;

import java.util.ArrayList;
import java.util.Random;

public class Domador {
	String Nombre;
	ArrayList<DigimonesIconicos>Equipo;
	Random Aleatorio = new Random();

	public Domador(String nombre) {
		this.Nombre = nombre;
		this.Equipo = new ArrayList<>();
		this.Equipo.add(DigimonAleatorio());
	}

	public DigimonesIconicos DigimonAleatorio() {
		String[] nombreDigimon = {"Agumon", "Gabumon", "Patamon"};
		String[] especieDigimon = {"Reptil", "Reptil", "Mammal"};
		int index = Aleatorio.nextInt(nombreDigimon.length);
		return new DigimonesIconicos(nombreDigimon[index], especieDigimon[index]);
	}

	public void captura(DigimonesIconicos digimon) {
		if (digimon.Salud <= 20) {
			Equipo.add(digimon);
			System.out.println(digimon.Nombre + " se ha unido a su equipo");
		} else {
			System.out.println("No se puede unir");
		}
	}

	public boolean DigimonCapturado(String nombre) {
		for (DigimonesIconicos digimon : Equipo) {
			if (digimon.Nombre.equals(nombre)) {
				return true;
			}
		}
		return false;
	}
}