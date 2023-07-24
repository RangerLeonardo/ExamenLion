package examenlion.model;

import java.util.ArrayList;
import java.util.List;

public class Fruta {
    public static List<Fruta> listaFrutas = new ArrayList<Fruta>();
    static {
        listaFrutas.add(0, new Fruta("Naranja", 3000));
        listaFrutas.add(1, new Fruta("Manzana", 1500));
        listaFrutas.add(2, new Fruta("Nopal", 1000));
        listaFrutas.add(3, new Fruta("Remolacha", 500));
        listaFrutas.add(4, new Fruta("Zanahoria", 5000));
    }

    private String nombre;
    private int cantidadTotalJugo; // Capacidad total de jugo en mililitros que tenemos exprimido
    private int cantidadActualJugo; // Cantidad actual de jugo que está en el contenedor

    public Fruta(String nombre, int cantidadTotalJugo) {
        this.nombre = nombre;
        this.cantidadTotalJugo = cantidadTotalJugo;
        this.cantidadActualJugo = 0;
    }

    public Fruta() {
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

    public String getNombre() {
        return this.nombre;
    }

}
