import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal {
    public static void main(String args[]) {
    
        String clientesFile = "./files/clientes.dat";
        //Archivos.writeClientes(clientesFile, Datos.generarClientes());
        //HashMap<Integer, Cliente> clientes = Archivos.readClientes(clientesFile);
        
        String facturasFile = "./files/facturas.dat";
        //Archivos.writeFacturas(facturasFile, Datos.generarFacturas());
        //HashMap<Integer, Factura> facturas = Archivos.readFacturas(facturasFile);

        String vehiculosFile = "./files/vehiculos.dat";
        //Archivos.writeVehiculos(vehiculosFile, Datos.generarVehiculos());

        String vendedoresFile = "./files/vendedores.dat";
        //Archivos.writeVendedores(vendedoresFile, Datos.generarVendedores());
        //HashMap<Integer, Vendedor> vendedores = Archivos.readVendedores(vendedoresFile);
        
        String detallesFile = "./files/detalles.dat";
        //Archivos.writeDetalles(detallesFile, Datos.generarDetalles());
        //HashMap<Integer, ArrayList<DetalleFactura>> detalles = Archivos.readDetalles(detallesFile);

        System.out.println(Archivos.getFacturasMes(11));
    }

}