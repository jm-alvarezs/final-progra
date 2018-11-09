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

    public String getVentasMensuales(int mes) {
        ArrayList<Factura> facturasMes = Archivos.getFacturasMes(mes);
        double total = 0;
        for(int i = 0; i < facturasMes.length; i++){
            total += facturasMes.get(i).calcularTotalFactura();
        }
        return "Facturas del Mes "+mes+"\n"+facturasMes.toString()+"\nTotal: "+total;
    }

    public String toString() {
        return getFecha().toString() + "\n" + getContenido();
    }

}