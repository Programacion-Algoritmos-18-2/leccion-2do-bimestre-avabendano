package lecturaArchivos2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Victoria
 */
public class Interfaz {

    // Metodo que muestra un menu y retorna una opcion numerica ingresada por el usuario
    public int menu() {
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        // Bandera para verificar el valor correcto
        boolean correcto = false;
        while (!correcto) {
            System.out.println("\n\t=== MENU ===");
            System.out.println("1 - Imprimir participantes ordenados por CANTON");
            System.out.println("2 - Generar un archivo de participantes ordenados por NOMBRES y APELLIDOS");
            System.out.println("3 - Reporte de Participantes por PERSONALIDAD");
            System.out.println("4 - Reporte de Participantes por DICTAMENIDONEIDAD");
            System.out.println("5 - SALIR");

            System.out.printf("Opcion: ");

            // Intentanmos obtener un valor numerico
            try {
                op = teclado.nextInt();
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: Ingresa un numero...");
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: Ingresa un numero...");
            }

            // Comprobamos que el nuemro este dentro del rango de opciones
            if (op > 0 && op < 6) {
                correcto = true;
            } else {
                System.out.println("ERROR: Un numero entre 1 - 5");
            }
        }

        // Retornamos la opcion
        return op;
    }
}
