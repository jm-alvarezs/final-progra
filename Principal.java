import java.io.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String args[]) {
        Nombre n = new Nombre("Orlando", "Torrres");
        Direccion d = new Direccion("Morones Prieto", 4500, "Jesus M Garza", "San Pedro", 60570);
        Fecha f = new Fecha(31, 10, 2018);
        String rfc = "TGOR011199POS";
        Cliente c = new Cliente(1, n, d, f, rfc);



        String clientesFile = "./files/clientes.dat";
        //Archivos.writeCliente(clientesFile, c);
        ArrayList<Cliente> clientes = Archivos.readClientes(clientesFile);
    }

    public static 
}