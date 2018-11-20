import java.io.Serializable;
import java.text.DecimalFormat;

public class Vendedor extends Persona implements Serializable{
    private double salario;
    private double comision;

    public Vendedor(int id, Nombre nombre, Direccion direccion, Fecha miembroDesde, double salario, double comision) {
        super(id, nombre, direccion, miembroDesde);
        setSalario(salario);
        setComision(comision);
    }

    public Vendedor() {
        
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public String toString() {
        return "Datos de Vendedor: "+super.toString() + "\nSalario: "+getSalario()+"\nComision: "+getComision();
    }

    public String toRow() {
        int size = 30;
        DecimalFormat dos = new DecimalFormat("0.00");
        return Texto.ajustarCaracteres(this.getNombrePersona().toString(), size) + 
                Texto.ajustarCaracteres(dos.format(this.getComision()*100)+"%", 10);
    }
}