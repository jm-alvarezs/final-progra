import java.io.Serializable;

abstract class Producto implements Serializable{
	protected double precio;
	protected String nombre;	
	
	public Producto(double precio, String nombreProd) {
		setPrecio(precio);
		setNombre(nombre);
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;	
	}
	
	public String getNombre(){
		return nombre;
	}

	public String toString() {
		return "\nNombre: "+getNombre()+"\nPrecio: "+getPrecio();
	}

}
