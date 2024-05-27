package actividad;

import java.util.Scanner;

public class Principal {
	
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
                    System.out.println("Este digimon no existe, elige un digimon de entre los posibles");
                    break;
            }

            if (opcion == 2) {
                break;
            }
        }

        if (domador.Equipo.size() == 3) {
            System.out.println("Enhorabuena " + domador.Nombre + ". Has capturado  los 3 Digimones.");
        }

        leer.close();
    }
}
