import java.io.Serializable;
import java.util.Comparator;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
   String rfc;
   
    public Cliente(int id, Nombre nombre, Direccion direccion, Fecha miembroDesde, String rfc) {
        super(id, nombre, direccion, miembroDesde);
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

    public String getNombre() {
       return super.getNombrePersona().toString();
    }

    public String toString() {
        return "Datos de Cliente: \n" + super.toString();
    }

    public static String clientesToString(ArrayList<Cliente> clientes) {
      String total = Texto.ajustarCaracteres("Nombre", 25) + Texto.ajustarCaracteres("Miembro Desde (yy/mm/dd)", 10) + "\n";
      for(int i = 0; i < clientes.size(); i++) {
          total += Texto.ajustarCaracteres(clientes.get(i).getNombre(), 25) + Texto.ajustarCaracteres(clientes.get(i).getMiembroDesde().toString(), 10) + "\n";
      }
      return total;
    }

    public static Comparator<Cliente> nombreAsc = new Comparator<Cliente>() {
		public int compare(Cliente c1, Cliente c2) {
			return c1.getNombre().compareTo(c2.getNombre());
		}
    };

    public static Comparator<Cliente> nombreDesc = new Comparator<Cliente>() {
		public int compare(Cliente c1, Cliente c2) {
			return c2.getNombre().compareTo(c1.getNombre());
		}
    };
    
    public static Comparator<Cliente> fechaAsc = new Comparator<Cliente>() {
		public int compare(Cliente c1, Cliente c2) {
			return c1.getMiembroDesde().toString().compareTo(c2.getMiembroDesde().toString());
		}
	};

	public static Comparator<Cliente> fechaDesc = new Comparator<Cliente>() {
		public int compare(Cliente c1, Cliente c2) {
			return c2.getMiembroDesde().toString().compareTo(c1.getMiembroDesde().toString());
		}
	};
}