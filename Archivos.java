import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivos implements Serializable {

    public static ArrayList<Factura> getFacturasMes(int mes) {
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        ArrayList<Factura> facturasMes = new ArrayList<Factura>();
        try {
            FileInputStream fis = new FileInputStream("./files/facturas.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            facturas = (ArrayList<Factura>) in.readObject();
            fis.close();
            in.close();
            for(int i = 0; i < facturas.size(); i++){
                if(facturas.get(i).getFecha().getMes() == mes) {
                    facturasMes.add(facturas.get(i));
                }
            }
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
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
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(vendedores);
            o.close();
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

    public static HashMap<Integer, Factura> readFacturas(String filename) {
        HashMap<Integer, Factura> facturas = new HashMap<Integer, Factura>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            facturas = (HashMap<Integer, Factura>) in.readObject();
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
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
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return vendedores;
    }

}