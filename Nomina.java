import java.util.Comparator;

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