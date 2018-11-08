import java.io.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]) {
        Nombre n = new Nombre("Orlando", "Torres");
        Direccion d = new Direccion("Morones Prieto", 4500, "Jesus M Garza", "San Pedro", 60570);
        Fecha f = new Fecha(31, 10, 2018);
        String rfc = "TGOR011199POS";
        Cliente c = new Cliente(1, n, d, f, rfc);

        //ArrayList <DetalleFactura> detalles;
        //Factura f=new Factura(001,c,
        DetalleFactura d1 = new DetalleFactura(v, 1, 0);
        DetalleFactura d2 = new DetalleFactura(v, 1, 0);
        DetalleFactura d3 = new DetalleFactura(v, 1, 0);
        DetalleFactura d4 = new DetalleFactura(v, 1, 0);
        DetalleFactura d5 = new DetalleFactura(v, 1, 0);
        DetalleFactura d6 = new DetalleFactura(v, 1, 0);
        DetalleFactura d7 = new DetalleFactura(v, 1, 0);
        
        String clientesFile = "./files/clientes.dat";
        //Archivos.writeClientes(clientesFile, clientes);
        //ArrayList<Cliente> clientes = Archivos.readClientes(clientesFile);
        
        String facturasFile = "./files/facturas.dat";

        ArrayList<Factura> facturas = new ArrayList<Factura>();

        facturas.add(new Factura("0001", c, detalles, f));
        //Archivos.writeFacturas(facturasFile, generarFacturas());
        //ArrayList<Factura> facturas = Archivos.readFacturas(facturasFile);


        String vehiculosFile = "./files/vehiculos.dat";
        //Archivos.writeFactura(vehiculosFile, generarVehiculos());
        //ArrayList<Vehiculo> vehiculos = Archivos.readVehiculos(vehiculosFile);

        String vendedoresFile = "./files/vendedores.dat";
        //Archivos.writeVendedores(vendedoresFile, generarVendedores());
        //ArrayList<Vendedor> vendedores = Archivos.readVendedores(vendedoresFile);
        
    }

    public static ArrayList<Vehiculo> generarVehiculos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        
        vehiculos.add(new Vehiculo(3, 560699, "C", "WDB1260251A336981", "rojo", "200", 2017, 5));
        vehiculos.add(new Vehiculo(3, 525600, "C", "WDB1260251A336981", "negro", "180", 2018, 5));
        vehiculos.add(new Vehiculo(5, 735230, "E", "WDB1260251A336981", "azul", "300", 2018, 5));
        vehiculos.add(new Vehiculo(10, 2100800, "S", "WDB1260251A336981", "blanco", "550", 2017, 4));
        vehiculos.add(new Vehiculo(13, 1350650, "GLE", "WDB1260251A336981", "negro", "350", 2016, 7));
        vehiculos.add(new Vehiculo(11, 2230500, "G", "WDB1260251A336981", "gris", "500", 2015, 5));
        vehiculos.add(new Vehiculo(5, 1850690, "E", "WDB1260251A336981", "gris", "63 AMG", 2018, 5));
        vehiculos.add(new Vehiculo(1, 1130260, "A", "WDB1260251A336981", "blanco", "45 AMG", 2019, 4));
        vehiculos.add(new Vehiculo(20, 1650380, "SLC", "WDB1260251A336981", "gris", "43 AMG", 2018, 2));
        vehiculos.add(new Vehiculo(5, 780650, "E", "WDB1260251A336981", "azul", "350", 2017, 5));
        vehiculos.add(new Vehiculo(12, 860530, "GLC", "WDB1260251A336981", "negro", "250", 2017, 5));
        vehiculos.add(new Vehiculo(19, 2130620, "SL", "WDB1260251A336981", "rojo", "500", 2018, 2));
        vehiculos.add(new Vehiculo(3, 1652390, "C", "WDB1260251A336981", "rojo", "63 AMG", 2019, 5));
        vehiculos.add(new Vehiculo(4, 790630, "CLS", "WDB1260251A336981", "pantera", "500", 2017, 4));
        vehiculos.add(new Vehiculo(5, 780650, "E", "WDB1260251A336981", "negro", "350", 2019, 5));
        vehiculos.add(new Vehiculo(1, 430250, "A", "WDB1260251A336981", "gris", "180", 2018, 4));
        vehiculos.add(new Vehiculo(15, 460250, "GLA", "WDB1260251A336981", "blanco", "250", 2018, 4));
        vehiculos.add(new Vehiculo(14, 1960380, "GLS", "WDB1260251A336981", "plata", "350", 2018, 8));
        vehiculos.add(new Vehiculo(10, 2225600, "S", "WDB1260251A336981", "negro", "550", 2019, 4));
        vehiculos.add(new Vehiculo(6, 480560, "CLA", "WDB1260251A336981", "gris", "250", 2019, 4));
        
        return vehiculos;
    }

    public static ArrayList<Factura> generarFacturas() {
        /*TODO:
            Toma sintaxis de generar Autos
            20 objetos a generar
            TIP: generalos vainilla como:
            Factura f1 = new Factura(......);
            y luego agregas la sintaxis de ArrayList
            facturas.add(new Factura(...));
            OJO: Descuento maximo = 0.30
            No pongas mas de 5 autos con descuento y que sean los modelos mas viejos
        */
        return new ArrayList<Vendedor>();
    }

    public static ArrayList<Cliente> generarClientes() {
        /*TODO:
            Usa instrucciones de factura
            OJO: Busca RFCs en linea o algo asi o saca el de tu mama y modificalo
            pero que tenga la misma cantidad de caracteres
        */
        return new ArrayList<Vendedor>();
    }

    public static ArrayList<Vendedor> generarVendedores() {
        /*TODO:
            Usa instrucciones de factura
            OJO: comisión máxima = 0.2 solo para 5 vendedores, los demas con 0.1 o 0.15
        */
        return new ArrayList<Vendedor>();
    }
}