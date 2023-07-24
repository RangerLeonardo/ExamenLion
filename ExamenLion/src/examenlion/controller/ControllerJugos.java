package examenlion.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import examenlion.exceptions.ExceptionCapacidadExcedida;
import examenlion.exceptions.ExceptionNoHayJugo;
import examenlion.interfaces.TieneCapacidad;
import examenlion.model.Contenedor;
import examenlion.model.Fruta;
import examenlion.view.InterfazJugos;
import examenlion.view.Total;

public class ControllerJugos implements TieneCapacidad {

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

        if (fruta.getCantidadActualJugo() == 2000) {
            int opcion = JOptionPane.showOptionDialog(null,
                    "Este es el máximo contenedor ¿Desea tirar el jugo o pagar?",
                    "Capacidad Excedida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "Tirar", "Pagar" }, null);

            if (opcion == JOptionPane.YES_OPTION) {
                throw new ExceptionCapacidadExcedida("El contenido del contenedor se ha excedido.");
            } else {
                Total totalPanel = new Total(fruta, contenedor); // Suponiendo que Total es una subclase de JFrame
                totalPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                totalPanel.setVisible(true);
                totalPanel.setLocationRelativeTo(null);
            }
        } else if (fruta.getCantidadActualJugo() > contenedor.getCantidadMaxima()
                && fruta.getCantidadActualJugo() != 2000) {
            int opcion = JOptionPane.showOptionDialog(null,
                    "El contenido del contenedor ha alcanzado la capacidad máxima. ¿Desea tirar el jugo o servirlo en otro contenedor?",
                    "Capacidad Excedida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "Tirar", "Servir en otro contenedor" }, null);

            if (opcion == JOptionPane.YES_OPTION) {
                InterfazJugos interfazJugos = new InterfazJugos();
                interfazJugos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                interfazJugos.setVisible(true);
                interfazJugos.setLocationRelativeTo(null);
                throw new ExceptionCapacidadExcedida("El contenido del contenedor se ha excedido.");

            } else {
                contenedor.setCantidad(fruta.getCantidadActualJugo());
            }
        }

        if (cantidad <= fruta.getCantidadTotalJugo()) {
            fruta.setCantidadTotalJugo(fruta.getCantidadTotalJugo() - cantidad);
            fruta.setCantidadActualJugo(fruta.getCantidadActualJugo() + cantidad);

            System.out.println(contenedor.getCantidadMaxima() + "Soy la capacidad maxima");
        } else if (fruta.getCantidadTotalJugo() <= 0) {
            throw new ExceptionNoHayJugo("Se ha agotado el jugo, pero aún puede probar con otras opciones");
        }

    }

    public void verificarContenedor(int cantidad) {
        if (cantidad == 500) {
            contenedor.setCantidadMaxima(1000);
        } else {
            contenedor.setCantidadMaxima(2000);
        }

    }

    public String obtenerTotalMLYContenedor() {
        return "Fueron: " + fruta.getCantidadActualJugo() + "ml" + "\n Servido en: " + contenedor.getName();

    }

}
