import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Oferta implements Serializable {
    private int idOferta;
    private String titulo;
    private double descuento;
    private Fecha vigencia;

    public Oferta(int idOferta, double descuento, String titulo, Fecha vigencia) {
        setIdOferta(idOferta);
        setDescuento(descuento);
        setTitulo(titulo);
        setVigencia(vigencia);
    }

    public Oferta() {

    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setVigencia(Fecha vigencia) {
        this.vigencia = vigencia;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getTitulo() {
        return titulo;
    }

    public Fecha getVigencia() {
        return vigencia;
    }

    public String getVigenciaStr() {
        return vigencia.toString();
    }

    public String toString() {
        return getTitulo() + "\n" + getDescuento() + "\n";
    }

    public String toRow() {
        DecimalFormat dos = new DecimalFormat("0.00");
        return Texto.ajustarCaracteres(getTitulo(), 25) + Texto.ajustarCaracteres(dos.format(getDescuento()*100)+"%", 10) + Texto.ajustarCaracteres(getVigencia().toString(), 10);
    }

    public static String ofertasToString(ArrayList<Oferta>  ofertas) {
        String total = Texto.ajustarCaracteres("Titulo", 25) + Texto.ajustarCaracteres("Descuento", 10) + Texto.ajustarCaracteres("Vigencia", 10) + "\n";
        for(int i = 0; i < ofertas.size(); i++){
            total += ofertas.get(i).toRow() + "\n";
        }
        return total;
    }
}