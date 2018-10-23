
public class Cliente extends Persona {

    public Cliente(final int ID, Nombre nombre, Direccion direccion, Fecha miembroDesde) {
        super(ID, nombre, direccion, miembroDesde);
    }

    public void setMiembroDesde(Fecha miembroDesde) {
        this.miembroDesde = miembroDesde;
    }

    public Fecha getMiembroDesde() {
        return miembroDesde;
    }

    public String toString() {
        return "Datos de Cliente: \n" + super.toString();
    }
}