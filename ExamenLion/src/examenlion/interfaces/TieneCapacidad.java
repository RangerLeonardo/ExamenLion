package examenlion.interfaces;

import examenlion.model.Fruta;

public interface TieneCapacidad {
    String getTotal();

    String getIngredienteJugo();

    Fruta buscarNombreFruta(String nombre);

    void verificarContenedor(int cantidad);

    String obtenerTotalMLYContenedor();
}
