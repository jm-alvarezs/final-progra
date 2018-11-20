import java.util.ArrayList;
import java.util.HashMap;

public class Datos {

    public static void generarDatos() {
        Archivos.writeClientes(clientesFile, Datos.generarClientes());
        Archivos.writeFacturas(facturasFile, Datos.generarFacturas());
        Archivos.writeVehiculos(vehiculosFile, Datos.generarVehiculos());
        Archivos.writeVendedores(vendedoresFile, Datos.generarVendedores());
        Archivos.writeOfertas(ofertasFile, Datos.generarOfertas());
        Archivos.writeDetalles(detallesFile, Datos.generarDetalles());
        Archivos.writeUsers(usersFile, Datos.generarUsuarios());
    }

    public static HashMap<Integer, Vehiculo> generarVehiculos() {
        HashMap<Integer, Vehiculo> vehiculos = new HashMap<Integer, Vehiculo>();
        vehiculos.put(1, new Vehiculo(1, 560699, "C", "WDB1260251A336981", "rojo", "200", 2017, 5));
        vehiculos.put(2, new Vehiculo(2, 525600, "C", "WDB1260251A336961", "negro", "180", 2018, 5));
        vehiculos.put(3, new Vehiculo(3, 735230, "E", "WDB1260251A336951", "azul", "300", 2018, 5));
        vehiculos.put(4, new Vehiculo(4, 2100800, "S", "WDB1260251A336941", "blanco", "550", 2017, 4));
        vehiculos.put(5, new Vehiculo(5, 1350650, "GLE", "WDB1260251A336931", "negro", "350", 2016, 7));
        vehiculos.put(6, new Vehiculo(6, 2230500, "G", "WDB1260251A336921", "gris", "500", 2015, 5));
        vehiculos.put(7, new Vehiculo(7, 1850690, "E", "WDB1260251A336911", "gris", "63 AMG", 2018, 5));
        vehiculos.put(8, new Vehiculo(8, 1130260, "A", "WDB1260251A336912", "blanco", "45 AMG", 2019, 4));
        vehiculos.put(9, new Vehiculo(9, 1650380, "SLC", "WDB1260251A336922", "gris", "43 AMG", 2018, 2));
        vehiculos.put(10, new Vehiculo(10, 780650, "E", "WDB1260251A336932", "azul", "350", 2017, 5));
        vehiculos.put(11, new Vehiculo(11, 860530, "GLC", "WDB1260251A336942", "negro", "250", 2017, 5));
        vehiculos.put(12, new Vehiculo(12, 2130620, "SL", "WDB1260251A336952", "rojo", "500", 2018, 2));
        vehiculos.put(13, new Vehiculo(13, 1652390, "C", "WDB1260251A336962", "rojo", "63 AMG", 2019, 5));
        vehiculos.put(14, new Vehiculo(14, 790630, "CLS", "WDB1260251A336972", "pantera", "500", 2017, 4));
        vehiculos.put(15, new Vehiculo(15, 780650, "E", "WDB1260251A336982", "negro", "350", 2019, 5));
        vehiculos.put(16, new Vehiculo(16, 430250, "A", "WDB1260251A336992", "gris", "180", 2018, 4));
        vehiculos.put(17, new Vehiculo(17, 460250, "GLA", "WDB1260251A336993", "blanco", "250", 2018, 4));
        vehiculos.put(18, new Vehiculo(18, 1960380, "GLS", "WDB1260251A336983", "plata", "350", 2018, 8));
        vehiculos.put(19, new Vehiculo(19, 2225600, "S", "WDB1260251A336973", "negro", "550", 2019, 4));
        vehiculos.put(20, new Vehiculo(20, 480560, "CLA", "WDB1260251A336963", "gris", "250", 2019, 4));
        return vehiculos;
    }

    public static HashMap<Integer, Oferta> generarOfertas() {
        HashMap<Integer, Oferta> ofertas = new HashMap<Integer, Oferta>();
        ofertas.put(1, new Oferta(1, 0.10, "10% de descuento", new Fecha(15, 10, 2018)));
        ofertas.put(2, new Oferta(2, 0.15, "BUENFIN15", new Fecha(19, 11, 2018)));
        ofertas.put(3, new Oferta(3, 0.10, "BUENFIN10", new Fecha(19, 11, 2018)));
        ofertas.put(4, new Oferta(4, 0.05, "Bono de 5%", new Fecha(31, 12, 2018)));
        ofertas.put(5, new Oferta(5, 0.10, "NAVIDAD10", new Fecha(25,12,2018)));
        return ofertas;
    }

    public static HashMap<Integer, ArrayList<DetalleFactura>> generarDetalles() {
        ArrayList<DetalleFactura> d1 = new ArrayList<DetalleFactura>();
        d1.add(new DetalleFactura(15, 1, 2));
        ArrayList<DetalleFactura> d2 = new ArrayList<DetalleFactura>();
        d2.add(new DetalleFactura(3, 1));
        ArrayList<DetalleFactura> d3 = new ArrayList<DetalleFactura>();
        d3.add(new DetalleFactura(8, 1));
        ArrayList<DetalleFactura> d4 = new ArrayList<DetalleFactura>();
        d4.add(new DetalleFactura(5, 1, 1));
        ArrayList<DetalleFactura> d5 = new ArrayList<DetalleFactura>();
        d5.add(new DetalleFactura(12, 1));
        ArrayList<DetalleFactura> d6 = new ArrayList<DetalleFactura>();
        d6.add(new DetalleFactura(19, 1));
        ArrayList<DetalleFactura> d7 = new ArrayList<DetalleFactura>();
        d7.add(new DetalleFactura(6, 1, 3));
        ArrayList<DetalleFactura> d8 = new ArrayList<DetalleFactura>();
        d8.add(new DetalleFactura(1, 1));
        
        HashMap<Integer, ArrayList<DetalleFactura>> detalles = new HashMap<Integer, ArrayList<DetalleFactura>>();
        detalles.put(1, d1);
        detalles.put(2, d2);
        detalles.put(3, d3);
        detalles.put(4, d4);
        detalles.put(5, d5);
        detalles.put(6, d6);
        detalles.put(7, d7);
        detalles.put(8, d8);
        return detalles;
    }

    public static ArrayList<Factura> generarFacturas() {
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        facturas.add(new Factura("FAC001", new Fecha(10,11,18), 4343, 1202, 1));
        facturas.add(new Factura("FAC002", new Fecha(9,10,18), 5123, 1203, 2));
        facturas.add(new Factura("FAC003", new Fecha(17,11,18), 4344, 1202, 3));
        facturas.add(new Factura("FAC004", new Fecha(7,11,18), 6462, 1201, 4));
        facturas.add(new Factura("FAC005", new Fecha(15,9,18), 1234, 1206, 5));
        facturas.add(new Factura("FAC006", new Fecha(10,5,18), 5454, 1205, 6));
        facturas.add(new Factura("FAC007", new Fecha(27,10,18), 1494, 1202, 7));
        facturas.add(new Factura("FAC008", new Fecha(2,11,18), 1012, 1204, 8));
        return facturas;
    }

    public static HashMap<Integer, Cliente> generarClientes() {
        HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
        clientes.put(1234, new Cliente(1234, new Nombre("Orlando","Torres"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"BAFJ701213SB10"));
        clientes.put(4343, new Cliente(4343, new Nombre("Luis","Doriz"),new Direccion("Miguel Hidalgo",501,"Colonia Centro","Monterrey",65454),new Fecha(10,11,18),"OIPF790205PT26"));
        clientes.put(5464, new Cliente(5464, new Nombre("Cesar","Garcia"),new Direccion("Jose Maria Morelos",652,"Col. Reforma","Monterrey",67574),new Fecha(13,10,17),"MAHM670102NJ19"));
        clientes.put(4344, new Cliente(4344, new Nombre("Roberto","Montemayor"),new Direccion("Agustin Iturbide",112,"Col. Centro","Santa Catarina",66368),new Fecha(7,11,18),"CAGM640618JY29"));
        clientes.put(6462, new Cliente(6462, new Nombre("Fernando","Zablah"),new Direccion("Padre Mier",154,"Heroes","Monterrey",66375),new Fecha(30,7,18),"OLAL701201RK94"));
        clientes.put(2321, new Cliente(2321, new Nombre("Jonathan","Nunez"),new Direccion("Benito Juarez",112,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,11,18),"ERER671120ET10"));
        clientes.put(6742, new Cliente(6742, new Nombre("Lisa","Gonzalez"),new Direccion("Porfirio Diaz",162,"Col. Reforma","Monterrey",32321),new Fecha(4,11,17),"SADD780812FH92"));
        clientes.put(5454, new Cliente(5454, new Nombre("Kenia","Castro"),new Direccion("Paseo de la Huasteca",292,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(20,8,18),"CAHA811231YH89"));
        clientes.put(5612, new Cliente(5612, new Nombre("Andres","Aldape"),new Direccion("Ninos Heroes",153,"Col. Ninos Heroes","Monterrey",66322),new Fecha(12,11,15),"JIPA771012JN20"));
        clientes.put(1012, new Cliente(1012, new Nombre("Juan","Alvarez"),new Direccion("Morones Prieto",542,"Col. San Pedro","San Pedro Garza Garcia",66232),new Fecha(10,6,18),"FEJL800808LK99"));
        clientes.put(0014, new Cliente(0014, new Nombre("Bernardo","Cardenas"),new Direccion("Santa Catarina",512,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(11,11,11),"CAHA992310HA19"));
        clientes.put(1494, new Cliente(1494, new Nombre("Daniel","Ramirez"),new Direccion("Paseo de la M",765,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,9,16),"DAFR563241JH10"));
        clientes.put(8786, new Cliente(8786, new Nombre("Francisco","Bermudez"),new Direccion("Leyes de Reforma",232,"Col. Reforma","Monterrey",62321),new Fecha(2,11,18),"MAJU746372IL84"));
        clientes.put(5123, new Cliente(5123, new Nombre("Leobardo","Lozano"),new Direccion("Paseo de la M",132,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(12,4,16),"ZAGE857273KG90"));
        clientes.put(2432, new Cliente(2432, new Nombre("Alexia","Garcia"),new Direccion("Paseo de la M",112,"Vision de la Huasteca","Santa Catarina",66369),new Fecha(15,11,18),"JDUH656362IO12"));
        return clientes;
    }

    public static HashMap<Integer, Vendedor> generarVendedores() {
        HashMap<Integer, Vendedor> vendedores = new HashMap<Integer, Vendedor>();
        vendedores.put(1201, new Vendedor(1201,new Nombre("Juan","Mejia"),new Direccion("Calle 2 Oriente",102,"Adolfo Lopez Mateos","Santa Catarina",66366),new Fecha(10,10,10),12344,0.03));
        vendedores.put(1202, new Vendedor(1202,new Nombre("Carlos","Ramos"),new Direccion("Calle 5 Oriente",212,"Adolfo Lopez Mateos","Santa Catarina",66366),new Fecha(15,6,12),11444,0.02));
        vendedores.put(1203, new Vendedor(1203,new Nombre("Esteban","Madrid"),new Direccion("Adolfo Rios",122,"Nuevo Repueblo","Monterrey",61213),new Fecha(1,10,13),13564,0.03));
        vendedores.put(1204, new Vendedor(1204,new Nombre("Luis","Gonzalez"),new Direccion("Noche buena",142,"Mision de las Villas","Santiago",66366),new Fecha(20,14,12),12514,0.04));
        vendedores.put(1205, new Vendedor(1205,new Nombre("Miguel","Juarez"),new Direccion("Rangel Frias",422,"Centro","Monterrey",66343),new Fecha(12,11,14),11244,0.04));
        vendedores.put(1206, new Vendedor(1206,new Nombre("Daniel","Vazquez"),new Direccion("Revolucion",522,"Col. Revolucion","Monterrey",65443),new Fecha(12,11,14),12744,0.03));
        vendedores.put(1207, new Vendedor(1207,new Nombre("Jairo","Velazquez"),new Direccion("Vasconcelos",122,"Col. Vasconcelos","San Pedro Garza Garcia",61212),new Fecha(6,4,12),12844,0.02));
        vendedores.put(1208, new Vendedor(1208,new Nombre("Sofia","Rodriguez"),new Direccion("Emiliano Zapata",422,"Col. Vasconcelos","San Pedro Garza Garcia",66343),new Fecha(5,2,12),12344,0.04));
        vendedores.put(1209, new Vendedor(1209,new Nombre("Martha","Sanchez"),new Direccion("Rangel Frias",122,"Centro","Monterrey",66343),new Fecha(12,4,12),15344,0.02));
        vendedores.put(1210, new Vendedor(1210,new Nombre("Fidel","Rueda"),new Direccion("Paseo Arbolado",214,"Paseo de la Huasteca","Santa Catarina",62133),new Fecha(12,6,15),12364,0.03));
        return vendedores;
    }

    public static HashMap<String, User> generarUsuarios() {
        HashMap<String, User> users = new HashMap<String, User>();
        users.put("Admin", new User(1, "Admin", "jkl10", 1));
        users.put("v1202", new User(2, "v1202", "hjk90", 2));
        return users;
    }

}