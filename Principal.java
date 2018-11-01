import java.io.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]) {
        Nombre n = new Nombre("Orlando", "Torrres");
        Direccion d = new Direccion("Morones Prieto", 4500, "Jesus M Garza", "San Pedro", 60570);
        Fecha f = new Fecha(31, 10, 2018);
        String rfc = "TGOR011199POS";
        Cliente c = new Cliente(1, n, d, f, rfc);
        String clientesFile = "./files/clientes.txt";
        //writeCliente(clientesFile, c);
        String facturasFile = "./files/facturas.txt";
        ArrayList<Cliente> clientes = readClientes(clientesFile);
        System.out.print(clientes);
    }

    public static void writeCliente(String filename, Cliente c){
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename, true));
            o.writeObject(c);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
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

    public static ArrayList<Cliente> readClientes(String filename) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Cliente c = (Cliente) in.readObject();
            //TODO: while
            /*Arroja error: Invalid type code AC*/
            clientes.add(c);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return clientes;
    }
}