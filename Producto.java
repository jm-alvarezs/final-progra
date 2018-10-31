import java.io.Serializable;

abstract class Producto implements Serializable{
	protected double precio;
	protected String nombreProd;	
	
	public Producto(double precio, String nombreProd) {
		setPrecio(precio);
		setNombreProd(nombreProd);
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setNombreProd(String nombreProd){
		this.nombreProd = nombreProd;	
	}
	
	public String getNombreProd(){
		return nombreProd;
	}

	public String toString() {
		return "\nNombre: "+getNombreProd()+"\nPrecio: "+getPrecio();
	}

}
