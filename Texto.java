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
	
	//Regresar 1 si es vocal o 0 si no
	public int esVocal(String letra) {
		if(letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u"))
			return 1;
		return 0;
	}
	
	//Contar vocales
	public int contarVocales() {
		int cantVocal = 0;
		for(int i = 0; i < this.getTexto().length() - 1; i++) {
			cantVocal += this.esVocal(this.getTexto().substring(i, i + 1));
		}
		cantVocal += this.esVocal(this.getTexto().substring(this.getTexto().length() - 1));
		return cantVocal;
	}
	
	//Regresa cantidad de tokens separados por espacios
	public int contarPalabras() {
		StringTokenizer tokens = new StringTokenizer(this.getTexto(), " ");
		return tokens.countTokens();
	}
	
	//Reemplazar todas las palabras del texto
	public void reemplazarPalabras(String palabra) {
		StringTokenizer tokens = new StringTokenizer(this.getTexto(), " ");
		while(tokens.hasMoreTokens()) {
			this.texto = this.texto.replaceAll(tokens.nextToken(), palabra);
		}
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
