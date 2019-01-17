package lecturaArchivos2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;

import com.google.gson.Gson;

public class LeerArchivoTexto {

    // Atributos globales
    private Scanner entrada;
    private String path;

    // Constructor de clase
    // Recibe una ruta de archivo como unico parametro
    public LeerArchivoTexto(String path) {
        this.entrada = null;
        this.path = path;
    }

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File(path));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // lee registro del archivo
    public ArrayList<Profesor> leerRegistros(String op) {

        OperacionData operacion = new OperacionData();
        ArrayList<Profesor> lista = new ArrayList<>();

        try // lee registros del archivo, usando el objeto Scanner
        {
            // Segun op los datos se leeran de una forma u otra
            if (op.equalsIgnoreCase("JSON")) {
                entrada.nextLine();
                while (entrada.hasNext()) {
                    // se crea el objeto para leer Json
                    Gson g = new Gson();
                    String linea = entrada.nextLine();
                    // se hace el proceso de transformación
                    Profesor p = g.fromJson(linea, Profesor.class);
                    lista.add(p);
                } // fin de while
            } else if (op.equalsIgnoreCase("CSV")) {
                entrada.nextLine();
                while (entrada.hasNext()) {
                    // Obtenemos cada linea de texto individual y la dividimos en una lista de valores unicos
                    String data[] = entrada.nextLine().split(",");
                    // Comprueba que no sea la primera linea del archivo CSV
                    // Esta contiene las cabeceras y la ignora
                    if (!data[0].equalsIgnoreCase("NROCEDULA")) {
                        // Creamos un nuevo profesor le pasamos los valores de data a su constructor
                        // y añadimos el nuevo profesor a la lista
                        lista.add(new Profesor(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]));
                    }
                }
            } else {
                System.out.printf("ERROR: No existe la opcion %s en el metodo leerRegistros\n", op);
            }

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch

        // Retornamos la lista con todos los participantes
        return lista;

    }

    // Metodo que cierra el archivo
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

/**
 * ************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y * Pearson Education,
 * Inc. Todos los derechos reservados. * * RENUNCIA: Los autores y el editor de
 * este libro han realizado su mejor * esfuerzo para preparar este libro. Esto
 * incluye el desarrollo, la * investigaci�n y prueba de las teor�as y programas
 * para determinar su * efectividad. Los autores y el editor no hacen ninguna
 * garant�a de * ning�n tipo, expresa o impl�cita, en relaci�n con estos
 * programas o * con la documentaci�n contenida en estos libros. Los autores y
 * el * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de * estos
 * programas. *
 * ***********************************************************************
 */
