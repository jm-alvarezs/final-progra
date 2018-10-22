
public class Categoria {
	private int idCategoria;
	private String nombreCategoria;
	private String descripcionCat;
	
	public Categoria(int idCategoria, String nombreCategoria, String descripcionCat) {
		setIdCategorida(idCategoria);
		setNombreCategoria(nombreCategoria);
		setDescripcionCategoria(descripcionCat);
	}

	public void setIdCategorida(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setDescripcionCategoria(String descripcionCat) {
		this.descripcionCat = descripcionCat;
	}
	
	public String getDescripcionCat() {
		return descripcionCat;
	}

	public String toString() {
		return "ID: "+getIdCategoria() + "\nNombre: "+getNombreCategoria()+"\nDescripción: "+getDescripcionCat();
	}

}