package examenlion;

import javax.swing.JFrame;

import examenlion.view.InterfazJugos;

public class Main {

    public static void main(String[] args) {
        InterfazJugos interfaz = new InterfazJugos();
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
    }

}
