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

	public Fecha() {
		
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

	public String mesToString() {
		String strmes = "";
		switch(this.getMes()) {
			case 1: strmes = "Enero"; break;
			case 2: strmes = "Febrero"; break;
			case 3: strmes = "Marzo"; break;
			case 4: strmes = "Abril"; break;
			case 5: strmes = "Mayo"; break;
			case 6: strmes = "Junio"; break;
			case 7: strmes = "Julio"; break;
			case 8: strmes = "Agosto"; break;
			case 9: strmes = "Septiembre"; break;
			case 10: strmes = "Octubre"; break;
			case 11: strmes = "Noviembre"; break;
			case 12: strmes = "Diciembre";
		}
		return strmes;
	}

	public static String mesToString(int mes) {
		String strmes = "";
		switch(mes) {
			case 1: strmes = "Enero"; break;
			case 2: strmes = "Febrero"; break;
			case 3: strmes = "Marzo"; break;
			case 4: strmes = "Abril"; break;
			case 5: strmes = "Mayo"; break;
			case 6: strmes = "Junio"; break;
			case 7: strmes = "Julio"; break;
			case 8: strmes = "Agosto"; break;
			case 9: strmes = "Septiembre"; break;
			case 10: strmes = "Octubre"; break;
			case 11: strmes = "Noviembre"; break;
			case 12: strmes = "Diciembre";
		}
		return strmes;
	}
	
	public String toString() {
		return dia+"-"+mes+"-"+year;
	}
	
}
