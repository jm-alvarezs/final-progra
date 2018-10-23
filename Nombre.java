
public class Nombre {
	String nombres;
	String apellidos;
	String prefijo;
	String sufijo;
	
	public Nombre(String nombres, String apellidos, String prefijo, String sufijo) {
		setNombres(nombres);
		setApellidos(apellidos);
		setPrefijo(prefijo);
		setSufijo(sufijo);
	}
	
	public Nombre(String nombres, String apellidos) {
		setNombres(nombres);
		setApellidos(apellidos);
		setPrefijo("");
		setSufijo("");
	}
	
	public String toString() {
		String sufijo = getSufijo();
		if(!sufijo.equals("")) sufijo = ", "+sufijo;
		return getPrefijo()+""+getNombres()+" "+getApellidos()+sufijo;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	
	public String getPrefijo() {
		return prefijo;
	}
	
	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}
	
	public String getSufijo() {
		return sufijo;
	}
	
}
