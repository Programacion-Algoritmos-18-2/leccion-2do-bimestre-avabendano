package lecturaArchivos2;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author Victoria
 */
public class MiArchivoNuevo {
    
    // Atributos globales
    private String path;
    private Formatter archivo;
    
    // Constructor d clase, recibe una ruta de archivo como unico parametro
    public MiArchivoNuevo(String path) {
        this.path = path;
        this.archivo = null;
    }
    
    // Metodo que abre el archivo
    public void abrirArchivo() {
        try {
            // Objeto Formatter que nos permite escribir sobre archivos
            archivo = new Formatter(path);
        } catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        }
    }
    
    // Metodo encargado de escrbir el objeto Profesor en el nuevo archivo
    public void agregar_informacion(Profesor participante) {
        // Usamos el metodo format para escribir un texto en el archivo
        // Le pasamos el objeto con su metodo toCSV que nos devuelve
        // el objeto en un formato de tipo CSV (separado por comas)
        archivo.format("%s\n", participante.toCSV());
    }
    
    // Metodo que nos permite escribir lineas de texto individuales
    public void agregar_linea(String texto) {
        archivo.format("%s\n", texto);
    }
    
    // Metodo que cierra el archivo
    public void cerrarArchivo() {
        if (archivo != null) {
            archivo.close(); // cierra el archivo
        }
    }

}
