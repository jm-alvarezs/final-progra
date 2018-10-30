
public class Cliente extends Persona {
   String RFC;
   
    public Cliente(int ID, Nombre nombre, Direccion direccion, Fecha miembroDesde, String RFC) {
        super(ID, nombre, direccion, miembroDesde);
    }

   public void setRFC(String RFC){
      this.RFC=RFC;
   }
   
   public String getRFC(){
      return RFC;
   }
    public String toString() {
        return "Datos de Cliente: \n" + super.toString();
    }
}