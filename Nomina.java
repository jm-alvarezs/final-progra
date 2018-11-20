import java.util.Comparator;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Nomina {
    private int vendedor;
    private String nombre;
    private double monto;

    public Nomina(int vendedor, String nombre, double monto) {
        setVendedor(vendedor);
        setNombre(nombre);
        setMonto(monto);
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getVendedor() {
        return vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }

    public String toString() {
        return "Vendedor: " + getVendedor() + "\n" + "Monto: "+getMonto();   
    }

    public static String nominaToString(ArrayList<Nomina> nomina) {
        String total = Texto.ajustarCaracteres("Nombre", 20)+Texto.ajustarCaracteres("Nomina", 20) + "\n";
        DecimalFormat dos = new DecimalFormat("00,000.00");
        for(int i = 0; i < nomina.size(); i++){
            total += Texto.ajustarCaracteres(nomina.get(i).getNombre(), 20) + Texto.ajustarCaracteres(dos.format(nomina.get(i).getMonto()), 20) + "\n";
        }
        return total;
    }

    public static Comparator<Nomina> montoAsc = new Comparator<Nomina>() {
		public int compare(Nomina n1, Nomina n2) {
			return (int) n1.getMonto() - (int) n2.getMonto();
		}
    };
    
    public static Comparator<Nomina> montoDesc = new Comparator<Nomina>() {
		public int compare(Nomina n1, Nomina n2) {
			return (int) n2.getMonto() - (int) n1.getMonto();
		}
    };
    
	public static Comparator<Nomina> nombreAsc = new Comparator<Nomina>() {
		public int compare(Nomina v1, Nomina v2) {
			return v1.getNombre().compareTo(v2.getNombre());
		}
    };

    public static Comparator<Nomina> nombreDesc = new Comparator<Nomina>() {
		public int compare(Nomina v1, Nomina v2) {
			return v2.getNombre().compareTo(v1.getNombre());
		}
	};
}