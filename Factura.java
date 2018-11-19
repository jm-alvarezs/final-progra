import java.util.*;
import java.io.Serializable;
import java.text.*;

public class Factura implements Serializable {
	private String folio;
	private int cliente;
	private int vendedor;
	private int detalles;
	private Fecha fecha;
	
	public Factura(String folio, Fecha fecha, int cliente, int vendedor, int detalles) {
		setFolio(folio);
		setCliente(cliente);
		setVendedor(vendedor);
		setDetalles(detalles);
		setFecha(fecha);
	}
	
	public Factura() {
		
	}
	
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	public String getFolio() {
		return folio;
	}
		
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	public int getCliente() {
		return cliente;
	}

	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}

	public int getVendedor() {
		return vendedor;
	}
	
	public void setDetalles(int detalles) {
		this.detalles = detalles;
	}
	
	public int getDetalles() {
		return detalles;
	}
	
	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
	public Fecha getFecha() {
		return fecha;
	}
	
	public String toString() {
		DecimalFormat dos = new DecimalFormat("0.00");
		return "\n"+Texto.ajustarCaracteres("Mercedes-Benz", 90)+"Fecha: "+fecha.toString()+
				"\n"+Texto.ajustarCaracteres(" ", 90)+"Folio: "+this.getFolio()+
				"\n"+Archivos.getCliente(cliente).toString()+
				"\n"+this.getEncabezado(11)+
				"\n"+Archivos.getDetalles(detalles).toString()+
				"\n\n"+Texto.ajustarCaracteres("", 115)+"Subtotal: "+dos.format(calcularSubtotalFactura())+
				"\n"+Texto.ajustarCaracteres("", 115)+"IVA:      "+dos.format(calcularIVA())+
				"\n"+Texto.ajustarCaracteres("", 115)+"Total:    "+dos.format(calcularTotalFactura());
	}

	public static String listToString(ArrayList<DetalleFactura> detalles) {
	    String result = "";
	    for (int i = 0; i < detalles.size(); i++) {
	        result += detalles.get(i).toString() + "\n";
	    }
	    return result;
	}
	
	public String getEncabezado(int size) {
		return Texto.ajustarCaracteres("[Clave", size)+"| "+
				Texto.ajustarCaracteres("Vehiculo", size)+"| "+
				Texto.ajustarCaracteres("Modelo", size)+" | "+
				Texto.ajustarCaracteres("Motor", size)+" | "+
				Texto.ajustarCaracteres("Precio", size)+"| "+
				Texto.ajustarCaracteres("Descuento", size)+"| "+
				Texto.ajustarCaracteres("IVA", size-1)+"]";
	}
	
	public double calcularSubtotalFactura() {
		double total = 0;
		ArrayList<DetalleFactura> details = Archivos.getDetalles(detalles);
		for(int i = 0; i < details.size(); i++) {
			total += details.get(i).calcularTotal();
		}
		return total;
	}
	
	public double calcularIVA() {
		return calcularSubtotalFactura() * 0.16;
	}
	
	public double calcularTotalFactura() {
		return calcularSubtotalFactura() + calcularIVA();
	}

	public static Comparator<Factura> folioAsc = new Comparator<Factura>() {
		public int compare(Factura f1, Factura f2) {
			return f1.getFolio().compareTo(f2.getFolio());
		}
	};

	public static Comparator<Factura> folioDesc = new Comparator<Factura>() {
		public int compare(Factura f1, Factura f2) {
			return f2.getFolio().compareTo(f1.getFolio());
		}
	};

	public static Comparator<Factura> fechaAsc = new Comparator<Factura>() {
		public int compare(Factura f1, Factura f2) {
			return f1.getFecha().toString().compareTo(f2.getFecha().toString());
		}
	};

	public static Comparator<Factura> fechaDesc = new Comparator<Factura>() {
		public int compare(Factura f1, Factura f2) {
			return f2.getFecha().toString().compareTo(f1.getFecha().toString());
		}
	};
	
}
