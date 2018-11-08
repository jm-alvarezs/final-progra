import java.text.*;

class DetalleFactura {
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
		int size = 10;
		return Texto.ajustarCaracteres(Integer.toString(getCant()), size)+" | "+
			Texto.ajustarCaracteres(Archivos.getVehiculo(producto).getNombre(), size)+" | "+
			Texto.ajustarCaracteres(Double.toString(Archivos.getVehiculo(producto).getPrecio()), size)+" | "+
			Texto.ajustarCaracteres(Double.toString(this.getImporte()), size)+" | "+
			Texto.ajustarCaracteres(Double.toString(this.getDescuento()), size)+" | "+
			Texto.ajustarCaracteres(Double.toString(this.calcularSubtotal()), size)+" | "+
			Texto.ajustarCaracteres(dos.format(this.calcularIVA()), size);
	}
	
	public void setProducto(int producto) {
		this.producto = producto;
	}
	
	public Producto getProducto() {
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
		return getCant() * getProducto().getPrecio();
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
