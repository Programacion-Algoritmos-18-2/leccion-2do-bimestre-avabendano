package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author reroes
 */
public class OperacionData {

    // Atributo de clase
    ArrayList<Profesor> informacion = new ArrayList<>();

    // MEtodo que establece la informacion
    public void agregarInformacion(ArrayList<Profesor> info) {
//        informacion = new ArrayList<Profesor>(info.subList(1, 500));
        informacion = info;
    }

    // Metodo que retorna la informacion
    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }

    // Proceso de ordenar, a través del uso de Collections
    public void ordenarPorCanton() {
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones,
                (o1, o2) -> o1.getCanton().compareTo(o2.getCanton()));
        // Imprime el resultado ordenado
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));
        }
    }

    // Proceso de ordenar, a través del uso de Collections
    public ArrayList<Profesor> ordenarPorNombres() {
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres,
                (o1, o2) -> o1.getNombres().compareTo(o2.getNombres()));
        // Retrona la lista ordenada
        return dataPorNombres;

    }

    // Metodo que unicamente imprime la informacion
    public void lecturaData() {
        for (int i = 0; i < obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));
        }
    }

    // Metodo de redireccionamietno a cada operacion segun la opcion como parametro
    public void menuOperaciones(int op) {
        switch (op) {
            case 1:
                ordenarPorCanton();
                break;
            case 2:
                generarArchivo();
                break;
            case 3:
                obtenerPersonalidad();
                break;
            case 4:
                obtenerDictamenIdoneidad();
                break;
            default:
                throw new AssertionError();
        }
    }

    // Genera un nuevo archivo ordenado por NOMBRES
    public void generarArchivo() {
        // Creamos un nuevo objeto MiArchivoNuevo
        MiArchivoNuevo nuevoArchivo = new MiArchivoNuevo("data/data3.csv");
        // Abrimos el archivo
        nuevoArchivo.abrirArchivo();

        // Escribimos la cabecera de los datos en el archvo
        nuevoArchivo.agregar_linea("NROCEDULA,NOMBRES Y APELLIDOS,ZONA,PROVINCIA,CANTON,PERSONALIDAD,RAZONAMIENTO,DICTAMENDEIDONEIDAD");

        // Recorremos la lista orndenada por nombres
        for (Profesor participante : ordenarPorNombres()) {
            // Escribimos cada linea en el nuevo archivo
            nuevoArchivo.agregar_informacion(participante);
        }

        // Cerramos el archivo
        nuevoArchivo.cerrarArchivo();
        System.out.println("Nuevo archivo generado en data/data3.csv");
    }

    // Metodo que muestra el numero de participantes por personalidad
    public void obtenerPersonalidad() {
        int num_adecuado = 0;
        int num_por_convocar = 0;

        // Recorremos la lista buscando coincidencias
        for (Profesor participante : informacion) {
            if (participante.getPersonalidad().equalsIgnoreCase("ADECUADO")) {
                // Invrementamos los contadores en 1
                num_adecuado++;
            } else if (participante.getPersonalidad().equalsIgnoreCase("POR CONVOCAR")) {
                num_por_convocar++;
            }
        }

        // Mostramos los resultados
        System.out.printf("Numero de Participantes por PERSONALIDAD:\n\tADECUADO - %d\n\tPOR CONVOCAR - %d\n", num_adecuado, num_por_convocar);
    }

    public void obtenerDictamenIdoneidad() {
        int num_idoneo = 0;
        int num_no_idoneo = 0;

        // Recorremos la lista buscando coincidencias
        for (Profesor participante : informacion) {
            if (participante.getDictamenIdoniedad().equalsIgnoreCase("IDONEO")) {
                // Incrementamos los contadores en 1
                num_idoneo++;
            } else if (participante.getDictamenIdoniedad().equalsIgnoreCase("NO IDONEO")) {
                num_no_idoneo++;
            }
        }

        // Mostramos los resultados
        System.out.printf("Numero de Participantes por PERSONALIDAD:\n\tIDONEO - %d\n\tNO IDONEO - %d\n", num_idoneo, num_no_idoneo);
    }

}
