import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

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
    
        System.out.println(getInventarioTotal(facturasFile, vehiculosFile, true));
    }

    public static String getInventarioTotal(String facturasFile, String vehiculosFile, boolean ascendente) {
        HashMap<Integer, Vehiculo> vehiculos = Archivos.readVehiculos(vehiculosFile);
        ArrayList<Factura> facturas = Archivos.readFacturas(facturasFile);
        String total = "Inventario Total\n" + Texto.ajustarCaracteres("Nombre", 15) + Texto.ajustarCaracteres("VIN", 25) + Texto.ajustarCaracteres("Precio", 18) + "\n";
        for(int i = 0; i < facturas.size(); i++) {
            ArrayList<DetalleFactura> detalles = Archivos.getDetalles(facturas.get(i).getDetalles());
            for(int j = 0; j < detalles.size(); j++) {
                if(vehiculos.containsKey(detalles.get(j).getProducto())) vehiculos.remove(detalles.get(j).getProducto());
            }
        }

        ArrayList<Vehiculo> inventario = new ArrayList<Vehiculo>();
        for (HashMap.Entry<Integer, Vehiculo> entry : vehiculos.entrySet()) {
            inventario.add(entry.getValue());
        }
        if(ascendente) Collections.sort(inventario, Vehiculo.precioAsc);
        else Collections.sort(inventario, Vehiculo.precioDesc);

        for(int i = 0; i < inventario.size(); i++) total += inventario.get(i).toRow()+"\n";

        return total;
    }
    
    public static String getAutosModelo(int modelo, String filename) {
        HashMap<Integer, Vehiculo> vehiculos = Archivos.readVehiculos(filename);
        ArrayList<Vehiculo> vehiculosModelo = new ArrayList<Vehiculo>();
        String titulos = "Autos Modelo "+modelo+"\n";
        for (HashMap.Entry<Integer, Vehiculo> entry : vehiculos.entrySet()) {
            if(entry.getValue().getModelo() == modelo) vehiculosModelo.add(entry.getValue());
        }
        return titulos + listToString(vehiculosModelo);
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

    public static String listToString(ArrayList<Vehiculo> vehiculos) {
	    String result = "";
	    for (int i = 0; i < vehiculos.size(); i++) {
	        result += vehiculos.get(i).toString() + "\n\n";
	    }
	    return result;
	}

}