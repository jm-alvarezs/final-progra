
public class Producto {
	protected int idProd;
	protected double precio;
	protected String nombreProd;
	protected String descripcionProd;
	protected int stock;
	
	public Producto(int idProd, double precio, String nombre, String descripcionProd, int stock) {
		setIdProd(idProd);
		setPrecio(precio);
		setNombreProd(nombre);
		setDescripcionProd(descripcionProd);
		setStock(stock);
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

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}

	public String getDescripcionProd() {
		return descripcionProd;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public String toString() {
		return "Datos de Producto: "+"\nID: "+getIdProd()+"\nNombre: "+getNombreProd()+"\nDescripcion: "+getDescripcionProd()+"\nPrecio: "+getPrecio()+"\nStock: "+getStock();
	}

}