import java.io.Serializable;
import java.util.*;

public class Compra implements Serializable{
    private int idCompra;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<DetalleCompra> detalles;

    public Compra(int idCompra, Cliente cliente, Vendedor vendedor, ArrayList<DetalleCompra> detalles) {
        setIdCompra(idCompra);
        setCliente(cliente);
        setVendedor(vendedor);
        setDetalles(detalles);        
    }     

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setDetalles(ArrayList<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ArrayList<DetalleCompra> getDetalles() {
        return detalles;
    }

    public String toString() {
        return "";
    }

}