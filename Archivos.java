import java.io.*;
import java.util.ArrayList;

public class Archivos implements Serializable {

    public static Cliente getCliente(int id){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            Cliente cliente = (Cliente) in.readObject();
            while(cliente != null){
                if(cliente.getIdPersona() == id) return cliente;
                cliente = (Cliente) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return null;
    }

    public static Vehiculo getVehiculo(int id){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            Vehiculo vehiculo = (Vehiculo) in.readObject();
            while(cliente != null){
                if(vehiculo.getIdPersona() == id) return vehiculo;
                vehiculo = (Vehiculo) in.readObject();
            }
            fis.close();
            in.close();
        }catch(ClassNotFoundException e){
        }catch(FileNotFoundException e) {
        }catch(IOException e) {
        }

        return null;
    }

    public static void writeClientes(String filename, ArrayList<Cliente> clientes) {
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


    public static void writeVehiculos(String filename, ArrayList<Vehiculo> clientes) {
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