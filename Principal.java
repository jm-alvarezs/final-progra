import java.io.*;

public class Principal {
    public static void main(String args[]) {
        Nombre n = new Nombre("Orlando", "Torrres");
        Direccion d = new Direccion("Morones Prieto", 4500, "Jesus M Garza", "San Pedro", 60570);
        Fecha f = new Fecha(31, 10, 2018);
        String rfc = "TGOR011199POS";
        Cliente c = new Cliente(1, n, d, f, rfc);
        String filename = "C:\\Users/saube/Desktop/Projects/progra-final/files/clientes-txt";
        /*try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));
            o.writeObject(c);
            o.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Cliente c2 = (Cliente) in.readObject();
            System.out.print(c2);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}