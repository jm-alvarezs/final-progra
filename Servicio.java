public class Servicio extends Producto {
	private String descripcion;
	
	public Servicio(int idProd, double precio, String nombre){
		super(idProd, precio, nombre);
		setNombre(nombre);
	}
	
	public String toString(){
		return "";
	}
}
