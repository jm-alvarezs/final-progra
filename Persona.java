import java.io.Serializable;

public class Persona implements Serializable {
    protected int idPersona;
    protected Nombre nombre;
    protected Direccion direccion;
    protected Fecha miembroDesde;

    public Persona(int idPersona, Nombre nombre, Direccion direccion, Fecha miembroDesde) {
        setIdPersona(idPersona);
        setNombrePersona(nombre);
        setDireccion(direccion);
        setMiembroDesde(miembroDesde);
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setNombrePersona(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nombre getNombrePersona() {
        return nombre;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setMiembroDesde(Fecha miembroDesde) {
        this.miembroDesde = miembroDesde;
    }

    public Fecha getMiembroDesde() {
        return miembroDesde;
    }

    public String toString() {
        return "ID: "+getIdPersona()+"\nNombre: "+getNombrePersona()+"\nDirección: "+getDireccion()+"\nMiembro Desde: "+getMiembroDesde();
    }
}