import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal {
    public static void main(String args[]) {
    
        String clientesFile = "./files/clientes.dat";
        //Archivos.writeClientes(clientesFile, Datos.generarClientes());
        //HashMap<Integer, Cliente> clientes = Archivos.readClientes(clientesFile);
        
        String facturasFile = "./files/facturas.dat";
        Archivos.writeFacturas(facturasFile, Datos.generarFacturas());
        //HashMap<Integer, Factura> facturas = Archivos.readFacturas(facturasFile);

        String vehiculosFile = "./files/vehiculos.dat";
        //Archivos.writeVehiculos(vehiculosFile, Datos.generarVehiculos());

        String vendedoresFile = "./files/vendedores.dat";
        //Archivos.writeVendedores(vendedoresFile, Datos.generarVendedores());
        //HashMap<Integer, Vendedor> vendedores = Archivos.readVendedores(vendedoresFile);
        
        String detallesFile = "./files/detalles.dat";
        //Archivos.writeDetalles(detallesFile, Datos.generarDetalles());
        //HashMap<Integer, ArrayList<DetalleFactura>> detalles = Archivos.readDetalles(detallesFile);

        System.out.println(getVendedores(vendedoresFile));
    }
    
    public static String getVendedores(String filename) {
        String total = Texto.ajustarCaracteres("Nombre", 30) + "Comision\n";
        HashMap<Integer, Vendedor> mapa = Archivos.readVendedores(filename);
        for (HashMap.Entry<Integer, Vendedor> entry : mapa.entrySet()) {
            total += entry.getValue().toRow() + "\n";
        }
        return total;
    }

    public static String getVentasMensuales(int mes) {
        double total = Archivos.getVentasMensuales(mes);
        DecimalFormat dos = new DecimalFormat("0.00");
        return "Ventas del Mes de"+Fecha.mesToString(mes)+" = "+dos.format(total);
    }

}