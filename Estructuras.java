import java.util.*;

public class Estructuras {
    
    public static ArrayList<Vehiculo> vehiculosToArrayList(HashMap<Integer, Vehiculo> vehiculos) {
        ArrayList<Vehiculo> arreglo = new ArrayList<Vehiculo>();
        for (HashMap.Entry<Integer, Vehiculo> entry : vehiculos.entrySet()) {
            arreglo.add(entry.getValue());
        }
        return arreglo;
    }

    public static ArrayList<Cliente> clientesToArrayList(HashMap<Integer, Cliente> mapa) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        for(HashMap.Entry<Integer, Cliente> entry: mapa.entrySet()) {
            clientes.add(entry.getValue());
        }
        return clientes;
    }
}