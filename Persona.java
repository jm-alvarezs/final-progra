import java.io.Serializable;

public class Persona implements Serializable {
    protected int id;
    protected Nombre nombre;
    protected Direccion direccion;
    protected Fecha miembroDesde;

    public Persona(int id, Nombre nombre, Direccion direccion, Fecha miembroDesde) {
        setId(id);
        setNombrePersona(nombre);
        setDireccion(direccion);
        setMiembroDesde(miembroDesde);
    }

    public Persona() {
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
        return "Nombre: "+getNombrePersona()+"\nDireccion: "+getDireccion()+"\nMiembro Desde: "+getMiembroDesde();
    }
}