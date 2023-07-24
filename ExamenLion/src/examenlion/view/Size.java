
package examenlion.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import examenlion.controller.ControllerJugos;
import examenlion.model.Contenedor;
import examenlion.model.Fruta;

public class Size extends javax.swing.JFrame {

    private String nombreJugo;
    public ControllerJugos controllerJugos;

    public Size(String nombreJugo) {
        initComponents();
        this.nombreJugo = nombreJugo;
    }

    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("¿De que tamaño y precio será el jugo?");

        jLabel2.setText("$50");

        jLabel3.setText("$100");

        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Bolsa 500ml (max:1000ml)");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Vaso 1000ml (max:2000ml)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(159, 159, 159))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(121, 121, 121))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(182, 182, 182)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(jRadioButton3)
                                                .addGap(82, 82, 82)
                                                .addComponent(jRadioButton4)))
                                .addContainerGap(114, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(jLabel2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46,
                                        Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(69, 69, 69)));

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String tipoContenedor = "";
        int capacidadContenedor;

        if (jRadioButton3.isSelected()) {
            tipoContenedor = "Bolsa";
            capacidadContenedor = 500;
        } else if (jRadioButton4.isSelected()) {
            tipoContenedor = "Vaso";
            capacidadContenedor = 1000;
        } else {
            JOptionPane.showMessageDialog(null,
                    "No has seleccionado un tamaño, selecciona uno para poder continuar");
            return;
        }

        // Agregar el ingrediente
        // ----------------------------------------------------------------
        Fruta fruta = new Fruta();
        Contenedor contenedor = new Contenedor(tipoContenedor, capacidadContenedor);

        controllerJugos = new ControllerJugos(fruta, contenedor);

        Fruta frutaEncontrada = controllerJugos.buscarNombreFruta(nombreJugo);
        int frutaCantidadTotal = controllerJugos.buscarCapacidadTotalFruta(nombreJugo);
        fruta.setCantidadTotalJugo(frutaCantidadTotal);
        fruta.setNombre(nombreJugo);

        controllerJugos.verificarContenedor(capacidadContenedor);

        if (frutaEncontrada != null) {
            controllerJugos.extraerJugo(capacidadContenedor);
            // Imprimir la capacidad restante
            System.out.println(
                    "Capacidad restante de " + fruta.getNombre() + ": "
                            + fruta.getCantidadTotalJugo() + " ml" + fruta.getCantidadActualJugo());

            Pagar pagar = new Pagar(fruta, contenedor);
            pagar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pagar.setVisible(true);
            pagar.setLocationRelativeTo(null);
            dispose();
        } else {
            System.out.println("La fruta " + nombreJugo + " no está en la lista.");
        }

    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Size(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
