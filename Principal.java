import java.io.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]) {
        Nombre n = new Nombre("Orlando", "Torres");
        Direccion d = new Direccion("Morones Prieto", 4500, "Jesus M Garza", "San Pedro", 60570);
        Fecha f = new Fecha(31, 10, 2018);
        String rfc = "TGOR011199POS";
        Cliente c = new Cliente(1, n, d, f, rfc);
        Vehiculo v=new Vehiculo(1,500,"C100","AB","rojo","V10",2005,4);
        //ArrayList <DetalleFactura> detalles;
        //Factura f=new Factura(001,c,
        DetalleFactura det=new DetalleFactura(v,1,.5);
        


        String clientesFile = "./files/clientes.dat";
        //Archivos.writeCliente(clientesFile, c);
        ArrayList<Cliente> clientes = Archivos.readClientes(clientesFile);
        
        //String facturasFile=".files/facturas.dat";
        //Archivos.writeFacturas(
        
        String vehiculosFile=".files/vehiculos.dat";
        //Archivos.writeFactura(vehiculosFile,v);
        ArrayList<Vehiculo> vehiculos=Archivos.readVehiculos(vehiculosFile);
        
        
        
        //Clientes, Facturas, Autos, Vendedores
        
    }
}