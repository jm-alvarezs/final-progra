import java.io.Serializable;

public class Vehiculo extends Producto implements Serializable{
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
		return Texto.ajustarCaracteres(this.getNombre(), 15)+
				Texto.ajustarCaracteres(this.getVin(), 25) + 
				Texto.ajustarCaracteres(Double.toString(this.getPrecio()), 18);
	}

	public String toString(){
		return super.toString()+"\nVIN: "+getVin()+"\nColor "+getColor()+"\nMotor: "+getMotor()+"\nModelo: "+getModelo()+"\nPasajeros: "+getPasajeros();
	}
}
