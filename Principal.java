import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Principal {
    public static void main(String args[]) {
    
        String clientesFile = "./files/clientes.dat";
        Archivos.writeClientes(clientesFile, Datos.generarClientes());
        //HashMap<Integer, Cliente> clientes = Archivos.readClientes(clientesFile);
        
        String facturasFile = "./files/facturas.dat";
        Archivos.writeFacturas(facturasFile, Datos.generarFacturas());
        //HashMap<Integer, Factura> facturas = Archivos.readFacturas(facturasFile);

        String vehiculosFile = "./files/vehiculos.dat";
        //Archivos.writeVehiculos(vehiculosFile, Datos.generarVehiculos());

        String vendedoresFile = "./files/vendedores.dat";
        Archivos.writeVendedores(vendedoresFile, Datos.generarVendedores());
        //HashMap<Integer, Vendedor> vendedores = Archivos.readVendedores(vendedoresFile);
        
        String detallesFile = "./files/detalles.dat";
        //Archivos.writeDetalles(detallesFile, Datos.generarDetalles());
        //HashMap<Integer, ArrayList<DetalleFactura>> detalles = Archivos.readDetalles(detallesFile);
    
    }

    public static String getInventarioTotal(String facturasFile, String vehiculosFile, char sort, boolean ascendente) {
        HashMap<Integer, Vehiculo> vehiculos = Archivos.readVehiculos(vehiculosFile);
        ArrayList<Factura> facturas = Archivos.readFacturas(facturasFile);
        for(int i = 0; i < facturas.size(); i++) {
            ArrayList<DetalleFactura> detalles = Archivos.getDetalles(facturas.get(i).getDetalles());
            for(int j = 0; j < detalles.size(); j++) {
                if(vehiculos.containsKey(detalles.get(j).getProducto())) vehiculos.remove(detalles.get(j).getProducto());
            }
        }
        ArrayList<Vehiculo> inventario = mapaToArrayList(vehiculos);
        inventario = ordenarVehiculos(inventario, sort, ascendente);
        return inventarioToRow(inventario);
    }

    public static String inventarioToRow(ArrayList<Vehiculo> inventario) {
        String total = "Inventario Total\n" + Texto.ajustarCaracteres("Nombre", 15) + Texto.ajustarCaracteres("VIN", 25) + Texto.ajustarCaracteres("Precio", 18) + "\n";
        for(int i = 0; i < inventario.size(); i++) total += inventario.get(i).toRow()+"\n";
        return total;
    }

    public static ArrayList<Vehiculo> ordenarVehiculos(ArrayList<Vehiculo> arreglo, char sort, boolean ascendente) {
        if(ascendente) {
            if(Character.toLowerCase(sort) == 'p') arreglo = ordenarVehiculosPrecioAsc(arreglo);
            else arreglo = ordenarVehiculosNombreAsc(arreglo);
        } else {
            if(Character.toLowerCase(sort) == 'p') arreglo = ordenarVehiculosPrecioDesc(arreglo);
            else arreglo = ordenarVehiculosNombreDesc(arreglo);
        }
        return arreglo;
    }

    public static ArrayList<Factura> ordenarFacturas(ArrayList<Factura> arreglo, char sort, boolean ascendente) {
        if(ascendente) {
            if(Character.toLowerCase(sort) == 'd') arreglo = ordenarFacturasFechaAsc(arreglo);
            else arreglo = ordenarFacturasFolioAsc(arreglo);
        } else {
            if(Character.toLowerCase(sort) == 'd') arreglo = ordenarFacturasFechaDesc(arreglo);
            else arreglo = ordenarFacturasFolioDesc(arreglo);
        }
        return arreglo;
    }

    public static ArrayList<Vehiculo> mapaToArrayList(HashMap<Integer, Vehiculo> vehiculos) {
        ArrayList<Vehiculo> arreglo = new ArrayList<Vehiculo>();
        for (HashMap.Entry<Integer, Vehiculo> entry : vehiculos.entrySet()) {
            arreglo.add(entry.getValue());
        }
        return arreglo;
    }

    public static ArrayList<Factura> ordenarFacturasFechaAsc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.fechaAsc);
        return facturas;
    }

    public static ArrayList<Factura> ordenarFacturasFechaDesc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.fechaDesc);
        return facturas;
    }
    
    public static ArrayList<Factura> ordenarFacturasFolioAsc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.folioAsc);
        return facturas;
    }
    
    public static ArrayList<Factura> ordenarFacturasFolioDesc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.folioDesc);
        return facturas;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosPrecioAsc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.precioAsc);
        return vehiculos;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosPrecioDesc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.precioDesc);
        return vehiculos;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosNombreAsc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.nombreAsc);
        return vehiculos;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosNombreDesc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.nombreDesc);
        return vehiculos;
    }
    
    public static String getAutosModelo(int modelo, String filename) {
        HashMap<Integer, Vehiculo> vehiculos = Archivos.readVehiculos(filename);
        ArrayList<Vehiculo> vehiculosModelo = new ArrayList<Vehiculo>();
        for (HashMap.Entry<Integer, Vehiculo> entry : vehiculos.entrySet()) {
            if(entry.getValue().getModelo() == modelo) vehiculosModelo.add(entry.getValue());
        }
        return "Autos Modelo "+modelo+"\n" + vehiculosToString(vehiculosModelo);
    }

    public static String getVendedores(String filename) {
        String total = Texto.ajustarCaracteres("Nombre", 30) + "Comision\n";
        HashMap<Integer, Vendedor> mapa = Archivos.readVendedores(filename);
        for (HashMap.Entry<Integer, Vendedor> entry : mapa.entrySet()) {
            total += entry.getValue().toRow() + "\n";
        }
        return total;
    }

    public static String getVentasMensuales(String filename, int mes) {
        double total = Archivos.getVentasMensuales(filename, mes);
        DecimalFormat dos = new DecimalFormat("0.00");
        return "Ventas del Mes de"+Fecha.mesToString(mes)+" = "+dos.format(total);
    }

    public static String vehiculosToString(ArrayList<Vehiculo> vehiculos) {
	    String result = "";
	    for (int i = 0; i < vehiculos.size(); i++) {
	        result += vehiculos.get(i).toString() + "\n\n";
	    }
	    return result;
    }
    
    public static String facturasToString(ArrayList<Factura> facturas) {
	    String result = "";
	    for (int i = 0; i < facturas.size(); i++) {
	        result += facturas.get(i).toString() + "\n\n";
	    }
	    return result;
    }

}