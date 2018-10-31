import java.io.Serializable;

public class Vendedor extends Persona implements Serializable{
    private double salario;
    private double comision;

    public Vendedor(final int ID, Nombre nombre, Direccion direccion, Fecha miembroDesde, double salario, double comision) {
        super(ID, nombre, direccion, miembroDesde);
        setSalario(salario);
        setComision(comision);
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
}