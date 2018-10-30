public class DetalleCompra {
    private Producto producto;
    private double cantidad;
    private Fecha fechaCompra;

    public DetalleCompra(Producto producto, double cantidad, Fecha fechaCompra) {
        setProducto(producto);
        setCantidad(cantidad);
        setFechaCompra(fechaCompra);
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setFechaCompra(Fecha fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Fecha getFechaCompra() {
        return fechaCompra;
    }

    public double getIva(){
        return producto.getPrecio() * cantidad * 0.16;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public double getTotal() {
        return getSubtotal() + getIva();
    }

    public String toString() {
        return Texto.ajustarCaracteres(producto.getNombreProd(), 30)
                + Texto.ajustarCaracteres(Texto.decimalFormat().format(producto.getPrecio()), 10)
                + Texto.ajustarCaracteres(Texto.decimalFormat().format(this.getCantidad()), 4)
                + Texto.ajustarCaracteres(Texto.decimalFormat().format(this.getSubtotal()), 8)
                + Texto.ajustarCaracteres(Texto.decimalFormat().format(this.getIva()), 8)
                + Texto.ajustarCaracteres(Texto.decimalFormat().format(this.getTotal()), 8);
    }

}