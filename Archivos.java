import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivos implements Serializable {

    public static ArrayList<Factura> getFacturasMes(int mes) {
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        try {
            FileInputStream fis = new FileInputStream("./files/facturas.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            Factura f = (Factura) in.readObject();
            while(f != null){
                if(f.getFecha().getMes() == mes) facturas.add(f);
                f = (Factura) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return facturas;
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

    public static void writeClientes(String filename, HashMap<String, Cliente> clientes) {
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

    public static void writeFacturas(String filename, ArrayList<Factura> clientes) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            for(int i = 0; i < clientes.size(); i++){
                o.writeObject(clientes.get(i));
                o.close();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeVendedores(String filename, ArrayList<Vendedor> clientes) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            for(int i = 0; i < clientes.size(); i++){
                o.writeObject(clientes.get(i));
                o.close();
            }
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

    public static ArrayList<Cliente> readClientes(String filename) {
        ArrayList<Cliente> arreglo = new ArrayList<Cliente>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            Cliente a = (Cliente) in.readObject();
            while(a != null){
                arreglo.add(a);
                a = (Cliente) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return arreglo;
    }

    public static ArrayList<Factura> readFacturas(String filename) {
        ArrayList<Factura> arreglo = new ArrayList<Factura>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            Factura a = (Factura) in.readObject();
            while(a != null){
                arreglo.add(a);
                a = (Factura) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return arreglo;
    }
    
    public static ArrayList<Vehiculo> readVehiculos(String filename) {
        ArrayList<Vehiculo> arreglo = new ArrayList<Vehiculo>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            Vehiculo a = (Vehiculo) in.readObject();
            while(a != null){
                arreglo.add(a);
                a = (Vehiculo) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return arreglo;
    }

    
    public static ArrayList<Vendedor> readVendedores(String filename) {
        ArrayList<Vendedor> arreglo = new ArrayList<Vendedor>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            Vendedor a = (Vendedor) in.readObject();
            while(a != null){
                arreglo.add(a);
                a = (Vendedor) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return arreglo;
    }

}