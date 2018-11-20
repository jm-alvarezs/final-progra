import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivos implements Serializable {

    public static User getUser(String username) {
        User user = new User();
        try {
            FileInputStream fis = new FileInputStream("./files/users.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            HashMap<String, User> mapa = (HashMap<String, User>) in.readObject();
            user = mapa.get(username);
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return user;
    }

    public static Oferta getOferta(int oferta) {
        Oferta offer = new Oferta();
        try {
            FileInputStream fis = new FileInputStream("./files/ofertas.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            HashMap<Integer, Oferta> mapa = (HashMap<Integer, Oferta>) in.readObject();
            offer = mapa.get(oferta);
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }
        return offer;
    }

    public static double getVentasMensuales(String filename, int mes) {
        ArrayList<Factura> facturasMes = getFacturasMes(filename, mes);
        double total = 0;
        for(int i = 0; i  < facturasMes.size(); i++){
            total += facturasMes.get(i).calcularTotalFactura();
        }
        return total;

    }

    public static ArrayList<Factura> getFacturasMes(String filename, int mes) {
        ArrayList<Factura> facturas = Archivos.readFacturas(filename);
        ArrayList<Factura> facturasMes = new ArrayList<Factura>();
        for(int i = 0; i < facturas.size(); i++){
            if(facturas.get(i).getFecha().getMes() == mes) {
                facturasMes.add(facturas.get(i));
            }
        }
        return facturasMes;
    }

    public static ArrayList<DetalleFactura> getDetalles(int id) {
        ArrayList<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
        try {
            FileInputStream fis = new FileInputStream("./files/detalles.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            HashMap<Integer, ArrayList<DetalleFactura>> mapa = (HashMap<Integer, ArrayList<DetalleFactura>>) in.readObject();
            detalles = mapa.get(id);
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return detalles;
    }

    public static HashMap<Integer, ArrayList<DetalleFactura>> getDetalles() {
        HashMap<Integer, ArrayList<DetalleFactura>> mapa = new HashMap<Integer, ArrayList<DetalleFactura>>();
        try {
            FileInputStream fis = new FileInputStream("./files/detalles.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            mapa = (HashMap<Integer, ArrayList<DetalleFactura>>) in.readObject();            
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return mapa;
    }

    public static Cliente getCliente(int id){
        Cliente c = new Cliente();
        try {
            FileInputStream fis = new FileInputStream("./files/clientes.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            HashMap<Integer, Cliente> clientes = (HashMap<Integer, Cliente>) in.readObject();
            c = clientes.get(id);
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return c;
    }

    public static Vehiculo getVehiculo(int id){
        Vehiculo v = new Vehiculo();
        try {
            FileInputStream fis = new FileInputStream("./files/vehiculos.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            HashMap<Integer, Vehiculo> vehiculos = (HashMap<Integer, Vehiculo>) in.readObject();
            v = vehiculos.get(id);
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }
        return v;
    }

    public static Vendedor getVendedor(int id) {
        Vendedor v = new Vendedor();
        try {
            FileInputStream fis = new FileInputStream("./files/vendedores.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            HashMap<Integer, Vendedor> vendedores = (HashMap<Integer, Vendedor>) in.readObject();
            v = vendedores.get(id);
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }
        return v;
    }

    public static void writeOfertas(String filename, HashMap<Integer, Oferta> ofertas) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(ofertas);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeClientes(String filename, HashMap<Integer, Cliente> clientes) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(clientes);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFacturas(String filename, ArrayList<Factura> facturas) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(facturas);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeVendedores(String filename, HashMap<Integer, Vendedor> vendedores) {
        try {
            FileOutputStream fo = new FileOutputStream(filename, true);
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(vendedores);
            o.close();
            fo.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeUsers(String filename, HashMap<String, User> users) {
        try {
            FileOutputStream fo = new FileOutputStream(filename, true);
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(users);
            o.close();
            fo.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeVehiculos(String filename, HashMap<Integer, Vehiculo> vehiculo) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(vehiculo);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDetalles(String filename, HashMap<Integer, ArrayList<DetalleFactura>> detalles) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(detalles);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, Oferta> readOfertas(String filename) {
        HashMap<Integer, Oferta> ofertas = new HashMap<Integer, Oferta>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            ofertas = (HashMap<Integer, Oferta>) in.readObject();
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return ofertas;
    }


    public static HashMap<Integer, Cliente> readClientes(String filename) {
        HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            clientes = (HashMap<Integer, Cliente>) in.readObject();
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return clientes;
    }

    public static ArrayList<Factura> readFacturas(String filename) {
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            facturas = (ArrayList<Factura>) in.readObject();
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

        return facturas;
    }
    
    public static HashMap<Integer, Vehiculo> readVehiculos(String filename) {
        HashMap<Integer, Vehiculo> vehiculos = new HashMap<Integer, Vehiculo>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            vehiculos = (HashMap<Integer, Vehiculo>) in.readObject();
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return vehiculos;
    }

    
    public static HashMap<Integer, Vendedor> readVendedores(String filename) {
        HashMap<Integer, Vendedor> vendedores = new HashMap<Integer, Vendedor>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            vendedores = (HashMap<Integer, Vendedor>) in.readObject();
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

        return vendedores;
    }

}