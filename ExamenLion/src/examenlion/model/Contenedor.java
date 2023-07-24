package examenlion.model;

public class Contenedor {
    private String name;
    private int cantidad;
    private int cantidadMaxima;

    public Contenedor(String name, int cantidad) {
        this.name = name;
        this.cantidad = cantidad;
        this.cantidadMaxima = 0;
    }

    public Contenedor() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadMaxima() {
        return this.cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

}
