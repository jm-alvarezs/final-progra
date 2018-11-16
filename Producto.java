import java.io.Serializable;

public class Producto implements Serializable{
	protected int idProd;
	protected double precio;
	protected String nombre;	
	
	public Producto(int idProd, double precio, String nombre) {
		setIdProd(idProd);
		setPrecio(precio);
		setNombre(nombre);
	}

	public Producto() {

	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getIdProd() {
		return idProd;
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
		return this.nombre;
	}

	public String toString() {
		return "Nombre: "+getNombre()+"\nPrecio: "+getPrecio();
	}

}
