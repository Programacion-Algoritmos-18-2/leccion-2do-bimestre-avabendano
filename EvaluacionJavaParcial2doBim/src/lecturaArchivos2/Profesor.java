package lecturaArchivos2;

/**
 *
 * @author reroes
 */
/*
{"cedula":"1803742806","nombres":"MULLO ROMERO ESTHER DEL CARMEN", 
"zona":"ZONA 3","provincia":"TUNGURAHUA", 
"canton":"AMBATO", "personalidad": "POR CONVOCAR", 
"razonamiento":"POR CONVOCAR", 
"dictamenIdoniedad":"NO IDONEO"}
 */
public class Profesor {

    // Atributos de clase
    private String cedula;
    private String nombres;
    private String zona;
    private String provincia;
    private String canton;
    private String personalidad;
    private String razonamiento;
    private String dictamenIdoniedad;

    // Constructor de clase
    public Profesor(String cedula, String nombres, String zona, String provincia, String canton, String personalidad, String razonamiento, String dictamenIdoniedad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.zona = zona;
        this.provincia = provincia;
        this.canton = canton;
        this.personalidad = personalidad;
        this.razonamiento = razonamiento;
        this.dictamenIdoniedad = dictamenIdoniedad;
    }

    // Metodos Establecer
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public void setRazonamiento(String razonamiento) {
        this.razonamiento = razonamiento;
    }

    public void setDictamenIdoniedad(String dictamenIdoniedad) {
        this.dictamenIdoniedad = dictamenIdoniedad;
    }

    // Metodos Obtener
    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getZona() {
        return zona;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCanton() {
        return canton;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public String getRazonamiento() {
        return razonamiento;
    }

    public String getDictamenIdoniedad() {
        return dictamenIdoniedad;
    }

    // Metodo toString sobreescrito
    @Override
    public String toString() {
        // Formateamos los valores con espacios, para una correcta visualizacion
        return String.format("%-10s %-40s %-8s %-12s %-15s %-13s %-13s %s", cedula, nombres, zona, provincia, canton, personalidad, razonamiento, dictamenIdoniedad);
    }

    // Metodo que devuelve el objeto formateado en CSV (separado por comas)
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", cedula, nombres, zona, provincia, canton, personalidad, razonamiento, dictamenIdoniedad);
    }
}
