package examenlion.controller;

import javax.swing.JOptionPane;

import examenlion.exceptions.ExceptionCapacidadExcedida;
import examenlion.exceptions.ExceptionNoHayJugo;
import examenlion.model.Contenedor;
import examenlion.model.Fruta;

public class ControllerJugos {

    private final Fruta fruta;
    private final Contenedor contenedor;

    public ControllerJugos(Fruta fruta, Contenedor contenedor) {
        this.fruta = fruta;
        this.contenedor = contenedor;
    }

    // Metodo para agregar jugo al contenedor
    public Contenedor agregarContenedor(String contenedor) {
        return null;
    }

    public String getTotal() {
        int total = fruta.getCantidadActualJugo() / 500;
        total = total * 50;
        return total + "";
    }

    public String getIngredienteJugo() {
        return fruta.getNombre();
    }

    public Fruta buscarNombreFruta(String nombre) {
        for (Fruta fruta : Fruta.listaFrutas) {
            if (fruta.getNombre().equals(nombre)) {
                return fruta;

            }

        }
        return null;
    }

    public int buscarCapacidadTotalFruta(String nombre) {
        for (Fruta fruta : Fruta.listaFrutas) {
            if (fruta.getNombre().equals(nombre)) {
                return fruta.getCantidadTotalJugo();

            }

        }
        return -1;
    }

    public void extraerJugo(int cantidad) throws ExceptionCapacidadExcedida, ExceptionNoHayJugo {

        if (cantidad <= fruta.getCantidadTotalJugo()) {
            fruta.setCantidadTotalJugo(fruta.getCantidadTotalJugo() - cantidad);
            fruta.setCantidadActualJugo(fruta.getCantidadActualJugo() + cantidad);

            System.out.println(contenedor.getCantidadMaxima() + "SOy la capacidad maxima");
        } else if (fruta.getCantidadTotalJugo() <= 0) {
            throw new ExceptionNoHayJugo("Se ha agotado el jugo, pero aún puede probar con otras opciones");
        }

        if (fruta.getCantidadActualJugo() > contenedor.getCantidadMaxima()) {
            int opcion = JOptionPane.showOptionDialog(null,
                    "El contenido del contenedor ha alcanzado la capacidad máxima. ¿Desea tirar el jugo o servirlo en otro contenedor?",
                    "Capacidad Excedida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "Tirar", "Servir en otro contenedor" }, null);

            if (opcion == JOptionPane.YES_OPTION) {
                throw new ExceptionCapacidadExcedida("El contenido del vaso se ha excedido.");
            } else {
                contenedor.setCantidad(fruta.getCantidadActualJugo());
            }
        }
    }

    public void verificarContenedor(int cantidad) {
        if (cantidad == 500) {
            contenedor.setCantidadMaxima(1000);
        } else {
            contenedor.setCantidadMaxima(2000);
        }

    }

}
