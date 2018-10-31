import java.io.Serializable;

public class Fecha implements Serializable {
	private int dia;
	private int mes;
	private String strmes;
	private int year;
	
	public Fecha(int dia, int mes, int year) {
		setDia(dia);
		setMes(mes);
		setYear(year);
		setStrmes(mes);
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
	
	public void setStrmes(int mes) {
		String[] meses = new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		this.strmes = meses[mes];
	}
	
	public String getStrmes() {
		return strmes;
	}
	
	public String toString() {
		return year+"-"+mes+"-"+dia;
	}
	
}
