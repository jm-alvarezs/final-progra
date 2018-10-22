
public class Cliente {
    private int idCliente;
    private Nombre nombreCliente;
    private Direccion dirCliente;
    private Fecha miembroDesde;

    public Cliente(int idCliente, Nombre nombreCliente, Direccion dirCliente, Fecha miembroDesde) {
        setIdCliente(idCliente);
        setNombreCliente(nombreCliente);
        setDirCliente(dirCliente);
        setMiembroDesde(miembroDesde);
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setNombreCliente(Nombre nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Nombre getNombreCliente() {
        return nombreCliente;
    }

    public void setDirCliente(Direccion dirCliente) {
        this.dirCliente = dirCliente;
    }

    public Direccion getDirCliente() {
        return dirCliente;
    }

    public void setMiembroDesde(Fecha miembroDesde) {
        this.miembroDesde = miembroDesde;
    }

    public Fecha getMiembroDesde() {
        return miembroDesde;
    }

    public String toString() {
        return "ID Cliente: "+getIdCliente()+"\nNombre: "+getNombreCliente()+"\nDirección: "+getDirCliente()+"\nMiembro Desde: "+getMiembroDesde();
    }
}