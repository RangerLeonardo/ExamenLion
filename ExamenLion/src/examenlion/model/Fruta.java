package examenlion.model;

import java.util.ArrayList;
import java.util.List;

import examenlion.interfaces.TieneJugo;

public class Fruta implements TieneJugo {
    public static List<Fruta> listaFrutas = new ArrayList<Fruta>();
    static {
        listaFrutas.add(0, new Fruta("Naranja", 3000));
        listaFrutas.add(1, new Fruta("Manzana", 1500));
        listaFrutas.add(2, new Fruta("Nopal", 1000));
        listaFrutas.add(3, new Fruta("Remolacha", 1000));
        listaFrutas.add(4, new Fruta("Zanahoria", 5000));
    }

    private String nombre;
    private int cantidadTotalJugo; // Capacidad total de jugo en mililitros
    private int cantidadActualJugo; // Cantidad actual de jugo disponible en mililitros

    public Fruta(String nombre, int cantidadTotalJugo) {
        this.nombre = nombre;
        this.cantidadTotalJugo = cantidadTotalJugo;
        this.cantidadActualJugo = 0; // Al inicio, la cantidad actual es igual a la capacidad total
    }

    @Override
    public int getCantidadJugo() {
        return cantidadActualJugo;
    }

    @Override
    public void extraerJugo(int cantidad) {
        if (cantidad <= cantidadTotalJugo) {
            cantidadTotalJugo -= cantidad;
            cantidadActualJugo += cantidad;
        } else {
            // Si no hay suficiente jugo, se muestra un mensaje o se toma alguna acción
            System.out.println("No hay suficiente jugo de " + nombre + " para servir.");
        }
    }

    public String getTotal() {
        int total = cantidadActualJugo / 500;
        total = total * 50;
        return total + "";
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadTotalJugo() {
        return this.cantidadTotalJugo;
    }

    public void setCantidadTotalJugo(int cantidadTotalJugo) {
        this.cantidadTotalJugo = cantidadTotalJugo;
    }

    public int getCantidadActualJugo() {
        return this.cantidadActualJugo;
    }

    public void setCantidadActualJugo(int cantidadActualJugo) {
        this.cantidadActualJugo = cantidadActualJugo;
    }

}
