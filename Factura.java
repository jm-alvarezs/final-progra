import java.util.*;
import java.text.*;

public class Factura {
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
				"\n"+listToString(Archivos.getDetalles(detalles))+
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
		return Texto.ajustarCaracteres("Clave", size)+"| "+
				Texto.ajustarCaracteres("Cantidad", size)+"| "+
				Texto.ajustarCaracteres("Unidad", size)+" | "+
				Texto.ajustarCaracteres("Descripción", 30)+" | "+
				Texto.ajustarCaracteres("Precio", size)+"| "+
				Texto.ajustarCaracteres("Importe", size)+"| "+
				Texto.ajustarCaracteres("Descuento", size)+"| "+
				Texto.ajustarCaracteres("Base", size)+"| "+
				Texto.ajustarCaracteres("IVA", size-1)+"";
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
	
}
