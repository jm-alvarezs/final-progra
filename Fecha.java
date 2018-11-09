import java.io.Serializable;

public class Fecha implements Serializable {
	private int dia;
	private int mes;
	private int year;
	
	public Fecha(int dia, int mes, int year) {
		setDia(dia);
		setMes(mes);
		setYear(year);
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getDia() {
		return dia;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return dia+"-"+mes+"-"+year;
	}
	
}
