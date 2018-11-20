import java.util.StringTokenizer;
import java.text.*;

public class Texto {
	private String texto;
	
	public Texto(String texto) {
		setTexto(texto);
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	//Obtener el texto guardado
	public String getTexto() {
		return texto;
	}
	
	public static String ajustarCaracteres(String texto, int size) {
		String nuevo = texto;
		while(nuevo.length() < size) {
			nuevo += " ";
		}
		return nuevo;
	}

	public static String ajustarCaracteres(String texto, int size, String caracter) {
		String nuevo = texto;
		while(nuevo.length() < size) {
			nuevo += caracter;
		}
		return nuevo;
	}
	
	public void convertirMayusculas() {
		this.texto = texto.toUpperCase();
	}

	public static DecimalFormat decimalFormat(){
		return new DecimalFormat("0.00");
	}
	
	//Imprime el objeto
	public String toString() {
		return this.texto;
	}
	
}
