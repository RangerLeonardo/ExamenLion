package examenlion.interfaces;

public interface TieneCapacidad {
    int getCapacidadTotal();

    int getCantidadActual();

    void agregarJugo();

    void quitarJugo();

    void contenedor(int contenedor);
}
