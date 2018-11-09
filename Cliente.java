import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
   String rfc;
   
    public Cliente(int ID, Nombre nombre, Direccion direccion, Fecha miembroDesde, String RFC) {
        super(ID, nombre, direccion, miembroDesde);
        setRfc(rfc);
    }

    public Cliente() {
        
    }

   public void setRfc(String rfc){
      this.rfc = rfc;
   }
   
   public String getRfc(){
      return rfc;
   }
    public String toString() {
        return "Datos de Cliente: \n" + super.toString();
    }
}