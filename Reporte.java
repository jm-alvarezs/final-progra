import java.io.*;
import java.util.ArrayList;

public class Reporte implements Serializable {
    private Fecha fecha;
    private String contenido;

    public Reporte(Fecha fecha, String contenido) {
        setFecha(fecha);
        setContenido(contenido);
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public String toString() {
        return getFecha().toString() + "\n" + getContenido();
    }

}