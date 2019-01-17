package lecturaArchivos2;

import java.util.ArrayList;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        // Creamos los objetos operacion e interfaz
        OperacionData operacion = new OperacionData();
        Interfaz interfaz = new Interfaz();

        // Creamos el objeto aplicacion pasandole la ruta como unico argumento
        LeerArchivoTexto aplicacion = new LeerArchivoTexto("data/data1.csv");
        // Arbimos el archivo
        aplicacion.abrirArchivo();
        // Obtenemos la informacion del archivo
        // Definimos que la forma de obtencion sera desde un archivo csv
        ArrayList<Profesor> lista = aplicacion.leerRegistros("CSV");
        // Cerramos el archivo
        aplicacion.cerrarArchivo();

        // Sobreescribimos el objeto aplicacion pasandole otra ruta como unico argumento
        aplicacion = new LeerArchivoTexto("data/data2.txt");
        // Abrimos el archivo
        aplicacion.abrirArchivo();
        // Añadimos la informacion del archivo nuevo a la informacion ya existente en lista
        // Definimos que la forma de obtencion sera desde un archivo txt/JSON
        lista.addAll(aplicacion.leerRegistros("JSON"));
        // Cerramos el archivo
        aplicacion.cerrarArchivo();

        // Pasamos la lista completa de participantes al obejto operacion
        operacion.agregarInformacion(lista);

        // Bandera para dar por terminada la ejecucion del programa
        boolean salir = false;

        // Ciclo principal
        while (!salir) {
            // Presentamos el menu y guardamos la opcion del usuario en op
            int op = interfaz.menu();

            // Si op es igual a 5, salir cambia de valor y salimos del programa
            if (op == 5) {
                salir = true;
            } else {
                // Pasamos la opcion ingresada por el usuario a las operaciones 
                operacion.menuOperaciones(op);
            }
        }

    }
}
