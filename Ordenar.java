import java.util.*;

public class Ordenar {

    //Facturas
    public static ArrayList<Factura> ordenarFacturas(ArrayList<Factura> arreglo, char sort, boolean ascendente) {
        if(ascendente) {
            if(Character.toLowerCase(sort) == 'd') arreglo = ordenarFacturasFechaAsc(arreglo);
            else arreglo = ordenarFacturasFolioAsc(arreglo);
        } else {
            if(Character.toLowerCase(sort) == 'd') arreglo = ordenarFacturasFechaDesc(arreglo);
            else arreglo = ordenarFacturasFolioDesc(arreglo);
        }
        return arreglo;
    }

    public static ArrayList<Factura> ordenarFacturasFechaAsc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.fechaAsc);
        return facturas;
    }

    public static ArrayList<Factura> ordenarFacturasFechaDesc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.fechaDesc);
        return facturas;
    }
    
    public static ArrayList<Factura> ordenarFacturasFolioAsc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.folioAsc);
        return facturas;
    }
    
    public static ArrayList<Factura> ordenarFacturasFolioDesc(ArrayList<Factura> facturas) {
        Collections.sort(facturas, Factura.folioDesc);
        return facturas;
    }

    //Nomina
    public static ArrayList<Nomina> ordenarNomina(ArrayList<Nomina> nomina, char sort, boolean ascendente) {
        if(ascendente) {
            if(sort == 'n') nomina = ordenarNominaNombreAsc(nomina);
            else nomina = ordenarNominaMontoAsc(nomina);
        } else {
            if(sort == 'n') nomina = ordenarNominaNombreDesc(nomina);
            else nomina = ordenarNominaMontoDesc(nomina);
        }
        return nomina;
    }

    public static ArrayList<Nomina> ordenarNominaNombreAsc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.nombreAsc);
        return nomina;
    }

    public static ArrayList<Nomina> ordenarNominaNombreDesc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.nombreDesc);
        return nomina;
    }
    
    public static ArrayList<Nomina> ordenarNominaMontoAsc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.montoAsc);
        return nomina;
    }
    
    public static ArrayList<Nomina> ordenarNominaMontoDesc(ArrayList<Nomina> nomina) {
        Collections.sort(nomina, Nomina.montoDesc);
        return nomina;
    }

    //Vehiculos
    public static ArrayList<Vehiculo> ordenarVehiculos(ArrayList<Vehiculo> arreglo, char sort, boolean ascendente) {
        if(ascendente) {
            if(Character.toLowerCase(sort) == 'p') arreglo = ordenarVehiculosPrecioAsc(arreglo);
            else arreglo = ordenarVehiculosNombreAsc(arreglo);
        } else {
            if(Character.toLowerCase(sort) == 'p') arreglo = ordenarVehiculosPrecioDesc(arreglo);
            else arreglo = ordenarVehiculosNombreDesc(arreglo);
        }
        return arreglo;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosPrecioAsc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.precioAsc);
        return vehiculos;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosPrecioDesc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.precioDesc);
        return vehiculos;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosNombreAsc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.nombreAsc);
        return vehiculos;
    }

    public static ArrayList<Vehiculo> ordenarVehiculosNombreDesc(ArrayList<Vehiculo> vehiculos) {
        Collections.sort(vehiculos, Vehiculo.nombreDesc);
        return vehiculos;
    }

    //Clientes
    public static ArrayList<Cliente> ordenarClientes(ArrayList<Cliente> clientes, char sort, boolean ascendente) {
        if(ascendente) {
            if(sort == 'f') clientes = ordenarClientesFechaAsc(clientes);
            else clientes = ordenarClientesNombreAsc(clientes);
        } else {
            if(sort == 'f') clientes = ordenarClientesFechaDesc(clientes);
            else clientes = ordenarClientesNombreDesc(clientes);
        }
        return clientes;
    }

    public static ArrayList<Cliente> ordenarClientesNombreAsc(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, Cliente.nombreAsc);
        return clientes;
    }
    
    public static ArrayList<Cliente> ordenarClientesNombreDesc(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, Cliente.nombreDesc);
        return clientes;
    }

    public static ArrayList<Cliente> ordenarClientesFechaAsc(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, Cliente.fechaAsc);
        return clientes;
    }
    
    public static ArrayList<Cliente> ordenarClientesFechaDesc(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, Cliente.fechaDesc);
        return clientes;
    }
}