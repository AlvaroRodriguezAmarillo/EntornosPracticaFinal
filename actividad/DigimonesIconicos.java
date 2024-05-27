package actividad;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Clase Digimon
class DigimonesIconicos {
    String Nombre;
    String Especie;
    int Nivel;
    int PuntosAtaque;
    int Salud;
    int DP1;
    int DP2;
    Random rand = new Random();

    public DigimonesIconicos(String nombre, String especie) {
        this.Nombre = nombre;
        this.Especie = especie;
        this.Nivel = rand.nextInt(5) + 1;
        this.PuntosAtaque = 5 * this.Nivel;
        this.Salud = 10 * this.Nivel;
        this.DP1 = 10;
        this.DP2 = 10;
    }

    public int ataque1() {
        if (DP1 > 0) {
            DP1 = DP1 - 1;
            return PuntosAtaque;
        }
        return 0;
    }

    public int ataque2() {
        if (DP2 > 1) {
            DP2 = DP2 - 2;
            return PuntosAtaque * 2;
        }
        return 0;
    }
}