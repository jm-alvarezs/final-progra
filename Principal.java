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
    
        System.out.println(getNominaMensual(11, 'n', true));
    }

    public static String getNominaMensual(int mes, char sort, boolean ascendente) {
        HashMap<Integer, Vendedor> vendedores = Archivos.readVendedores("./files/vendedores.dat");
        ArrayList<Factura> facturas = Archivos.getFacturasMes("./files/facturas.dat", mes);
        HashMap<Integer, Double> comisiones = getComisiones(mes, facturas);
        ArrayList<Nomina> nomina = new ArrayList<Nomina>();
        for (HashMap.Entry<Integer, Vendedor> entry : vendedores.entrySet()) {
            Vendedor v = (Vendedor) entry.getValue();
            nomina.add(new Nomina(v.getId(), v.getNombrePersona().toString(), v.getSalario() + getComision(v.getId(), comisiones)));
        }
        nomina = ordenarNomina(nomina, sort, ascendente);
        return nominaToString(nomina);
    }

    public static ArrayList<Nomina> ordenarNomina(ArrayList<Nomina> nomina, char sort, boolean ascendente) {
        if(ascendente) {
            if(sort == 'n') nomina = ordenarNominaNombreAsc(nomina);
            else nomina = ordenarNominaMontoAsc(nomina);
        } else {
            if(sort == 'n') nomina = ordenarNominaNombreDesc(nomina);
            else nomina = ordenarNominaMontoDesc(nomina);
        }
        return nomina;
    }

    public static ArrayList<Nomina> ordenarNominaNombreAsc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.nombreAsc);
        return nomina;
    }

    public static ArrayList<Nomina> ordenarNominaNombreDesc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.nombreDesc);
        return nomina;
    }
    
    public static ArrayList<Nomina> ordenarNominaMontoAsc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.montoAsc);
        return nomina;
    }
    
    public static ArrayList<Nomina> ordenarNominaMontoDesc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.montoDesc);
        return nomina;
    }

    public static String nominaToString(ArrayList<Nomina> nomina) {
        String total = Texto.ajustarCaracteres("Nombre", 20)+Texto.ajustarCaracteres("Nomina", 20) + "\n";
        DecimalFormat dos = new DecimalFormat("0.00");
        for(int i = 0; i < nomina.size(); i++){
            total += Texto.ajustarCaracteres(nomina.get(i).getNombre(), 20) + Texto.ajustarCaracteres(dos.format(nomina.get(i).getMonto()), 20) + "\n";
        }
        return total;
    }

    public static double getComision(int id, HashMap<Integer, Double> comisiones) {
        if(comisiones.containsKey(id)) return comisiones.get(id);
        return 0;
    }

    public static HashMap<Integer, Double> getComisiones(int mes, ArrayList<Factura> facturas) {
        HashMap<Integer, Double> comisiones = new HashMap<Integer, Double>();
        for(int i = 0; i < facturas.size(); i++) {
            double comision = facturas.get(i).calcularTotalFactura() * Archivos.getVendedor(facturas.get(i).getVendedor()).getComision();
            comisiones.put(facturas.get(i).getVendedor(), comision);
        }
        return comisiones;
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