import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Formato {

    public static String ofertasToString(ArrayList<Oferta>  ofertas) {
        String total = Texto.ajustarCaracteres("Titulo", 25) + Texto.ajustarCaracteres("Descuento", 10) + Texto.ajustarCaracteres("Vigencia", 10) + "\n";
        for(int i = 0; i < ofertas.size(); i++){
            total += ofertas.get(i).toRow() + "\n";
        }
        return total;
    }

    public static String nominaToString(ArrayList<Nomina> nomina) {
        String total = Texto.ajustarCaracteres("Nombre", 20)+Texto.ajustarCaracteres("Nomina", 20) + "\n";
        DecimalFormat dos = new DecimalFormat("00,000.00");
        for(int i = 0; i < nomina.size(); i++){
            total += Texto.ajustarCaracteres(nomina.get(i).getNombre(), 20) + Texto.ajustarCaracteres(dos.format(nomina.get(i).getMonto()), 20) + "\n";
        }
        return total;
    }

    public static String clientesToString(ArrayList<Cliente> clientes) {
        String total = Texto.ajustarCaracteres("Nombre", 25) + Texto.ajustarCaracteres("Miembro Desde (yy/mm/dd)", 10) + "\n";
        for(int i = 0; i < clientes.size(); i++) {
            total += Texto.ajustarCaracteres(clientes.get(i).getNombre(), 25) + Texto.ajustarCaracteres(clientes.get(i).getMiembroDesde().toString(), 10) + "\n";
        }
        return total;
    }

    public static String vehiculosToString(ArrayList<Vehiculo> vehiculos) {
	    String result = "";
	    for (int i = 0; i < vehiculos.size(); i++) {
	        result += vehiculos.get(i).toString() + "\n\n";
	    }
	    return result;
    }

    public static String vendedoresClientesToString(HashMap<Integer, Vendedor> vendedores, HashMap<Integer, Cliente> clientes, HashMap<Integer, ArrayList<Integer>> vendedoresClientes) {        
        String total = "";
        for(HashMap.Entry<Integer, ArrayList<Integer>> entry: vendedoresClientes.entrySet()) {
            total += "Vendedor: "+vendedores.get(entry.getKey()).getNombrePersona() + "\n";
            for(int i = 0; i < entry.getValue().size(); i++) {
                total += "Cliente: "+clientes.get(entry.getValue().get(i)).getNombre()+"\n";
            }
            total += "\n";
        }
        return total;
    }

    public static String inventarioToString(ArrayList<Vehiculo> inventario) {
        String total = "Inventario Total\n" + Texto.ajustarCaracteres("Nombre", 15) + Texto.ajustarCaracteres("VIN", 25) + Texto.ajustarCaracteres("Precio", 18) + "\n";
        for(int i = 0; i < inventario.size(); i++) total += inventario.get(i).toRow()+"\n";
        return total;
    }

    public static String valoresToString(String clientesFile, HashMap<Integer, Double> valores) {
        HashMap<Integer, Cliente> clientesMapa = Archivos.readClientes(clientesFile);
        String total = Texto.ajustarCaracteres("Nombre", 25) + Texto.ajustarCaracteres("Monto Comprado", 30) + "\n";
        DecimalFormat dos = new DecimalFormat("0,000,000.00");
        for(HashMap.Entry<Integer, Double> entry: valores.entrySet()) {
            total += Texto.ajustarCaracteres(Archivos.getCliente(entry.getKey()).getNombre(), 25) + Texto.ajustarCaracteres("$"+dos.format(entry.getValue()), 30) + "\n";
        }
        return total;
    }
}