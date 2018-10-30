public class Vehiculo extends Producto {
	private String vin;
	private String color;
	private Motor motor;
	private int modelo;
	private int pasajeros;
		
	public Vehiculo(int idProd, double precio, String nombre, String vin, String color, Motor motor, int modelo, int pasajeros){
		super(idProd, precio, nombre);
		setVin(vin);
		setColor(color);
		setMotor(motor);
		setModelo(modelo);
		setPasajeros(pasajeros);
	}
	
	public void setVin(String vin){
		this.vin = vin;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setMotor(Motor motor){
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
	
	public Motor getMotor(){
		return motor;
	}
	
	public int getModelo(){
		return modelo;
	}
	
	public int getPasajeros(){
		return pasajeros;
	}
	
	public String toString(){
		return super.toString()+"\nVIN: "+getVIn()+"\nColor "+getColor()+"\nMotor: "+getMotor()+"\nModelo: "+getModelo()+"\nPasajeros: "+getPasajeros();
	}
}
