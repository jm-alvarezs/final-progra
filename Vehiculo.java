import java.io.Serializable;
import java.util.Comparator;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Vehiculo extends Producto implements Serializable {
	private String vin;
	private String color;
	private String motor;
	private int modelo;
	private int pasajeros;
		
	public Vehiculo(int idProd, double precio, String nombre, String vin, String color, String motor, int modelo, int pasajeros){
		super(idProd, precio, nombre+" "+motor);
		setVin(vin);
		setColor(color);
		setMotor(motor);
		setModelo(modelo);
		setPasajeros(pasajeros);
	}
	
	public Vehiculo() {

	}

	public void setVin(String vin){
		this.vin = vin;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setMotor(String motor){
		this.motor = motor;
	}
	
	public void setModelo(int modelo){
		this.modelo = modelo;
	}
	
	public void setPasajeros(int pasajeros){
		this.pasajeros = pasajeros;
	}
	
	public String getVin(){
		return vin;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getMotor(){
		return motor;
	}
	
	public int getModelo(){
		return modelo;
	}
	
	public int getPasajeros(){
		return pasajeros;
	}
	
	public String toRow() {
		DecimalFormat dos = new DecimalFormat("0,000,000.00");
		return Texto.ajustarCaracteres(this.getNombre(), 15)+
				Texto.ajustarCaracteres(this.getVin(), 25) + 
				Texto.ajustarCaracteres(dos.format(this.getPrecio()), 18);
	}

	public String toString(){
		return super.toString()+"\nVIN: "+getVin()+"\nColor "+getColor()+"\nMotor: "+getMotor()+"\nModelo: "+getModelo()+"\nPasajeros: "+getPasajeros();
	}

	public static String vehiculosToString(ArrayList<Vehiculo> vehiculos) {
	    String result = "";
	    for (int i = 0; i < vehiculos.size(); i++) {
	        result += vehiculos.get(i).toString() + "\n\n";
	    }
	    return result;
    }

	public static Comparator<Vehiculo> precioAsc = new Comparator<Vehiculo>() {
		public int compare(Vehiculo v1, Vehiculo v2) {
			return (int) v1.getPrecio() - (int) v2.getPrecio();
		}
	};
	
	public static Comparator<Vehiculo> precioDesc = new Comparator<Vehiculo>() {
		public int compare(Vehiculo v1, Vehiculo v2) {
			return (int) v2.getPrecio() - (int) v1.getPrecio();
		}
	};

	public static Comparator<Vehiculo> nombreAsc = new Comparator<Vehiculo>() {
		public int compare(Vehiculo v1, Vehiculo v2) {
			return v1.getNombre().compareTo(v2.getNombre());
		}
	};

	
	public static Comparator<Vehiculo> nombreDesc = new Comparator<Vehiculo>() {
		public int compare(Vehiculo v1, Vehiculo v2) {
			return v2.getNombre().compareTo(v1.getNombre());
		}
	};
}
