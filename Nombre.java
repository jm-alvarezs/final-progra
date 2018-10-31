import java.io.Serializable;

public class Nombre implements Serializable{
	String nombres;
	String apellidos;
	
	public Nombre(String nombres, String apellidos) {
		setNombres(nombres);
		setApellidos(apellidos);

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
	
   public String toString() {
   
      return getNombres()+" "+getApellidos();
   }
	

}
