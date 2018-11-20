import java.io.*;
import java.text.*;
import java.util.*;

public class Principal {
    final static String clientesFile = "./files/clientes.dat";
    final static String facturasFile = "./files/facturas.dat";
    final static String vehiculosFile = "./files/vehiculos.dat";
    final static String vendedoresFile = "./files/vendedores.dat";
    final static String ofertasFile = "./files/ofertas.dat";
    final static String detallesFile = "./files/detalles.dat";
    final static String usersFile = "./files/users.dat";
    public static void main(String args[])  {
        Datos.generarDatos(clientesFile, facturasFile, vehiculosFile, vendedoresFile, ofertasFile, detallesFile, usersFile);
        if(!login(getUser(), getPass())) {
            System.out.println("Autenticación Fallida. Intente de Nuevo. ");
            return;
        }

        boolean answer = true;

        do {
            consultar(getReporte());
            answer = getSiNo();
        }while(answer);
    }

    public static boolean getSiNo() {
        System.out.println("¿Consultar de Nuevo? (s/n)");
        char answer = Character.toLowerCase(Lectura.readChar());
        while(answer != 's' && answer != 'n'){
            System.out.println("Error. Intente de Nuevo. ");
            answer = Character.toLowerCase(Lectura.readChar());
        }
        return answer == 's';
    }

    public static void imprimirOpciones() {
        System.out.println("¿Que reporte desea consultar?");
        System.out.println("1 = Ventas Mensuales\n2 = Inventario Total\n3 = Autos Modelo 2018\n4 = Vendedores\n5 = Facturas Mensuales");
        System.out.println("6 = Ofertas Vigentes\n7 = Monto Comprado por Cliente\n8 = Clientes\n9 = Nomina Mensual\n10 = Clientes por Vendedor");
    }

    public static int getReporte() {
        imprimirOpciones();
        int opcion = Lectura.readInt();
        while(opcion < 1 && opcion > 10){
            System.out.println("Error. Intente de Nuevo. ");
            imprimirOpciones();
            opcion = Lectura.readInt();
        }
        return opcion;
    }

    public static void consultar(int opcion) {
        String reporte = "";
        switch(opcion) {
            case 1: reporte = getVentasMensuales(facturasFile, getMes()); break;
            case 2: reporte = getInventarioTotal(facturasFile, vehiculosFile, getSortInventario(), getOrden()); break;
            case 3: reporte = getAutosModelo(2018, vehiculosFile); break;
            case 4: reporte = getVendedores(vendedoresFile); break;
            case 5: reporte = getFacturasMensuales(facturasFile, getMes()); break;
            case 6: reporte = getOfertas(ofertasFile); break;
            case 7: reporte = getValoresClientes(clientesFile, facturasFile); break;
            case 8: reporte = getClientes(clientesFile, getSortCliente(), getOrden()); break;
            case 9: reporte = getNominaMensual(getMes(), getSortNomina(), getOrden()); break;
            case 10: reporte = getClientesPorVendedor(clientesFile, vendedoresFile, facturasFile);
        }
        System.out.println(reporte);
    }

    public static int getMes() {
        System.out.println("¿Que mes desea consultar?");
        int mes = Lectura.readInt();
        while(mes < 1 && mes > 12) {
            System.out.println("Error. Intente de Nuevo. ");
            mes = Lectura.readInt();
        }
        return mes;
    }

    public static char getSortInventario() {
        System.out.println("Introduce el orden del reporte: \nP = Precio\nN = Nombre");
        char orden = Character.toLowerCase(Lectura.readChar());
        while(orden != 'p' && orden != 'n'){
            System.out.println("Error. Intente de Nuevo.");
            orden = Character.toLowerCase(Lectura.readChar());
        }
        return orden;
    }

    public static char getSortNomina() {
        System.out.println("Introduce el orden del reporte: \nN = Nombre\nM = Monto");
        char orden = Character.toLowerCase(Lectura.readChar());
        while(orden != 'm' && orden != 'n'){
            System.out.println("Error. Intente de Nuevo.");
            orden = Character.toLowerCase(Lectura.readChar());
        }
        return orden;
    }

    public static char getSortCliente() {
        System.out.println("Introduce el orden del reporte: \nN = Nombre\nF = Fecha");
        char orden = Character.toLowerCase(Lectura.readChar());
        while(orden != 'f' && orden != 'n'){
            System.out.println("Error. Intente de Nuevo.");
            orden = Character.toLowerCase(Lectura.readChar());
        }
        return orden;
    }

    public static boolean getOrden() {
        System.out.println("Introduce el orden del reporte: \nA = Ascendente\nD = descendente");
        char orden = Character.toLowerCase(Lectura.readChar());
        while(orden != 'a' && orden != 'd'){
            System.out.println("Error. Intente de Nuevo.");
            orden = Character.toLowerCase(Lectura.readChar());
        }
        return orden == 'a';
    }

    public static String getUser() {
        System.out.print("Introduce tu nombre de usuario: ");
        return Lectura.readString();
    }

    public static String getPass() {
            Console c = null;
            String pass = "";
            try {
               c = System.console();
               if (c != null) {
                  pass = String.valueOf(c.readPassword("Introduce tu contraseña: "));
               } 
            } catch(Exception e) {
            }
            return pass;
    }

    public static boolean login(String user, String pass) {
        return Archivos.getUser(user).getPass().equals(pass);
    }

    public static String getFacturasMensuales(String facturasFile, int mes) {
        return Archivos.getFacturasMes(facturasFile, mes).toString();
    }

    public static String getValoresClientes(String clientesFile, String facturasFile) {
        ArrayList<Factura> facturas = Archivos.readFacturas(facturasFile);
        HashMap<Integer, Double> valores = new HashMap<Integer, Double>();
        for(int i = 0; i < facturas.size(); i++) {
            int idcliente = Archivos.getCliente(facturas.get(i).getCliente()).getId();
            double compra = facturas.get(i).calcularTotalFactura();
            if(valores.containsKey(idcliente)) valores.put(idcliente, valores.get(idcliente) + compra);
            else valores.put(idcliente, compra);
        }
        return Formato.valoresToString(clientesFile, valores);
    }

    public static String getClientesPorVendedor(String clientesFile, String vendedoresFile, String facturasFile) {
        ArrayList<Factura> facturas = Archivos.readFacturas(facturasFile);
        HashMap<Integer, ArrayList<Integer>> vendedoresClientes = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < facturas.size(); i++) {
            int cliente = facturas.get(i).getCliente();
            int vendedor = facturas.get(i).getVendedor();
            if(vendedoresClientes.containsKey(vendedor)) vendedoresClientes.get(vendedor).add(cliente);
            else {
                ArrayList<Integer> clientes = new ArrayList<Integer>();
                clientes.add(cliente);
                vendedoresClientes.put(vendedor, clientes);
            }
        }
        return Formato.vendedoresClientesToString(Archivos.readVendedores(vendedoresFile), Archivos.readClientes(clientesFile), vendedoresClientes);
    }

    public static String getOfertas(String filename) {
        HashMap<Integer, Oferta> ofertasMapa = Archivos.readOfertas(filename);
        ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
        Date hoy = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        for(HashMap.Entry<Integer, Oferta> entry: ofertasMapa.entrySet()) {
            int vigente = entry.getValue().getVigenciaStr().compareTo(dateFormat.format(hoy));
            if(vigente == 0 || vigente == 1) ofertas.add(entry.getValue());
        }
        return Formato.ofertasToString(ofertas);
    }

    public static String getClientes(String filename, char sort, boolean ascendente) {
        HashMap<Integer, Cliente> clientesMapa = Archivos.readClientes(filename);
        ArrayList<Cliente> clientes = Estructuras.clientesToArrayList(clientesMapa);
        clientes = Ordenar.ordenarClientes(clientes, sort, ascendente);
        return Formato.clientesToString(clientes);
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
        nomina = Ordenar.ordenarNomina(nomina, sort, ascendente);
        return Formato.nominaToString(nomina);
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
        ArrayList<Vehiculo> inventario = Estructuras.vehiculosToArrayList(vehiculos);
        inventario = Ordenar.ordenarVehiculos(inventario, sort, ascendente);
        return Formato.inventarioToString(inventario);
    }
    
    public static String getAutosModelo(int modelo, String filename) {
        HashMap<Integer, Vehiculo> vehiculos = Archivos.readVehiculos(filename);
        ArrayList<Vehiculo> vehiculosModelo = new ArrayList<Vehiculo>();
        for (HashMap.Entry<Integer, Vehiculo> entry : vehiculos.entrySet()) {
            if(entry.getValue().getModelo() == modelo) vehiculosModelo.add(entry.getValue());
        }
        return "Autos Modelo "+modelo+"\n" + Formato.vehiculosToString(vehiculosModelo);
    }

    public static String getVendedores(String filename) {
        String total = Texto.ajustarCaracteres("Nombre", 30) + "Comision\n";
        HashMap<Integer, Vendedor> mapa = Archivos.readVendedores(filename);
        for (HashMap.Entry<Integer, Vendedor> entry : mapa.entrySet()) {
            total += entry.getValue().toRow() + "\n";
        }
        return total;
    }

    public static String getVentasMensuales(String facturasFile, int mes) {
        double total = Archivos.getVentasMensuales(facturasFile, mes);
        DecimalFormat dos = new DecimalFormat("0,000,000.00");
        return "Ventas del Mes de "+Fecha.mesToString(mes)+" = $"+dos.format(total);
    }

}