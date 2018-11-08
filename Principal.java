import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal {
    public static void main(String args[]) {
        Nombre n = new Nombre("Orlando", "Torres");
        Direccion d = new Direccion("Morones Prieto", 4500, "Jesus M Garza", "San Pedro", 60570);
        Fecha f = new Fecha(31, 10, 2018);
        String rfc = "TGOR011199POS";
        Cliente c = new Cliente(1, n, d, f, rfc);

        HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

        //ArrayList <DetalleFactura> detalles;
        //Factura f=new Factura(001,c,)
        
        //DetalleFactura d1 = new DetalleFactura(v, 1, 0);
        
        String clientesFile = "./files/clientes.dat";
        //Archivos.writeClientes(clientesFile, clientes);
        //ArrayList<Cliente> clientes = Archivos.readClientes(clientesFile);
        
        String facturasFile = "./files/facturas.dat";

        ArrayList<Factura> facturas = new ArrayList<Factura>();

        //ESTA LINEA VA SIN COMENTARIO   facturas.add(new Factura("0001", c, detalles, f));
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

    public static ArrayList<Factura> generarFacturas(ArrayList<Cliente> clientes) {
      ArrayList<Factura> facturas = new ArrayList<Factura>();
      facturas.add(new Factura("FAC001", new Fecha(10,11,18), 1234, 1234));
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
        return new ArrayList<Factura>();
    }

    public static ArrayList<Cliente> generarClientes() {
        /*
            TODO:
            Cambiar los nombres de los clientes
        */
        ArrayList<Cliente> clientes=new ArrayList<Cliente>();
        clientes.add(new Cliente(1234,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"BAFJ701213SB10"));
        clientes.add(new Cliente(4343,new Nombre("Luis","Doriz"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"OIPF790205PT26"));
        clientes.add(new Cliente(5454,new Nombre("Cesar","García"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"MAHM670102NJ19"));
        clientes.add(new Cliente(4344,new Nombre("Roberto","Montemayor"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"CAGM640618JY29"));
        clientes.add(new Cliente(6462,new Nombre("Fernando","Zablah"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"OLAL701201RK94"));
        clientes.add(new Cliente(2321,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"ERER671120ET10"));
        clientes.add(new Cliente(6742,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"SADD780812FH92"));
        clientes.add(new Cliente(5454,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"CAHA811231YH89"));
        clientes.add(new Cliente(5612,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"JIPA771012JN20"));
        clientes.add(new Cliente(1012,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"FEJL800808LK99"));
        clientes.add(new Cliente(0014,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"CAHA992310HA19"));
        clientes.add(new Cliente(1494,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"DAFR563241JH10"));
        clientes.add(new Cliente(8786,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"MAJU746372IL84"));
        clientes.add(new Cliente(5123,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"ZAGE857273KG90"));
        clientes.add(new Cliente(2432,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"JDUH656362IO12"));
        clientes.add(new Cliente(5657,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"JFAA954889OL10"));
        clientes.add(new Cliente(0101,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"ROGO847728IA23"));
        clientes.add(new Cliente(2134,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"YFHD101023UH25"));
        clientes.add(new Cliente(4533,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"OACR710101JA00"));
        clientes.add(new Cliente(6162,new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"DAFT893821DD10"));
        return clientes;
    }

    public static ArrayList<Vendedor> generarVendedores() {
        /*TODO:
            Usa instrucciones de factura
            OJO: comisión máxima = 0.2 solo para 5 vendedores, los demas con 0.1 o 0.15
        */
        return new ArrayList<Vendedor>();
    }
}