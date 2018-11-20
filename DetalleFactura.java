import java.io.Serializable;
import java.text.*;

class DetalleFactura implements Serializable {
	int producto;
	int cant;
	int oferta;

	public DetalleFactura(int producto, int cant) {
		setProducto(producto);
		setCant(cant);
		setOferta(0);
	}
	
	public DetalleFactura(int producto, int cant, int oferta) {
		setProducto(producto);
		setCant(cant);
		setOferta(oferta);
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
	
	public void setOferta(int oferta) {
		this.oferta = oferta;
	}
	
	public int getOferta() {
		return oferta;
	}

	public double getDescuento() {
		if(getOferta() == 0) return 0;
		return Archivos.getOferta(getOferta()).getDescuento();
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
