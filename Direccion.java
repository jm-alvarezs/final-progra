public class Direccion {
	String calle;
	int numero;
	String colonia;
	String ciudad;
	int cp;
	
	public Direccion(String calle, int numero, String colonia, String ciudad, int cp) {
		setCalle(calle);
		setNumero(numero);
		setColonia(colonia);
		setCiudad(ciudad);
		setCp(cp);
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public String getCalle() {
		return calle;
	} 
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	public String getColonia() {
		return colonia;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public int getCp() {
		return cp;
	}
	
	public String toString() {
		return calle+" #"+numero+", "+colonia+".\n"+ciudad+". C.P.:"+cp;
	}
	
}
