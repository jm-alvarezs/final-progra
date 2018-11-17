import java.io.Serializable;
import java.text.*;

class DetalleFactura implements Serializable {
	int producto;
	int cant;
	double descuento;
	
	public DetalleFactura(int producto, int cant) {
		setProducto(producto);
		setCant(cant);
		setDescuento(0);
	}
	
	public DetalleFactura(int producto, int cant, double descuento) {
		setProducto(producto);
		setCant(cant);
		setDescuento(descuento);
	}
	
	public String toString() {
		DecimalFormat dos = new DecimalFormat("0.00");
		int size = 9;
		Vehiculo vehiculo = Archivos.getVehiculo(producto);
		return Texto.ajustarCaracteres(Integer.toString(getCant()), size)+" | "+
			Texto.ajustarCaracteres(vehiculo.getNombre(), size+1)+" | "+
			Texto.ajustarCaracteres(Integer.toString(vehiculo.getModelo()), size+2)+" | "+
			Texto.ajustarCaracteres(vehiculo.getMotor(), size+2)+" | "+
			Texto.ajustarCaracteres(Double.toString(vehiculo.getPrecio()), size+1)+" | "+
			Texto.ajustarCaracteres(Double.toString(this.getDescuento()), size+1)+" | "+
			Texto.ajustarCaracteres(dos.format(this.calcularIVA()), size+1);
	}
	
	public void setProducto(int producto) {
		this.producto = producto;
	}
	
	public int getProducto() {
		return producto;
	}
	
	public void setCant(int cant) {
		this.cant = cant;
	}
	
	public int getCant() {
		return cant;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public double getImporte() {
		return getCant() * Archivos.getVehiculo(producto).getPrecio();
	}
	
	public double calcularSubtotal() {
		return getImporte() - getImporte() * getDescuento();
	}
	
	public double calcularIVA() {
		return calcularSubtotal() * 0.16;
	}
	
	public double calcularTotal() {
		return calcularSubtotal() + calcularIVA();
	}
		
}
