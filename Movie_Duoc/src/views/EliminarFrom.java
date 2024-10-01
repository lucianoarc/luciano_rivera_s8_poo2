
package views;

import Controllers.MovieController;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.*;


public class EliminarFrom extends javax.swing.JFrame {
    private MovieController movieController;

    /**
     * Creates new form EliminarFrom
     */
    public EliminarFrom(MovieController movieController) {
        initComponents();
        this.movieController = movieController;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("TITULO:");

        jButton1.setText("ELIMINAR PELICULA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(68, 68, 68)
                .addComponent(jButton1)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String titulo = txttitulo.getText().trim();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un título válido");
            return;
        }

        // Elimina la película y verifica el resultado
        boolean peliculaEliminada = movieController.eliminarMovies(titulo); // Suponiendo que el método maneja la conexión y transacción
        if (peliculaEliminada) {
            JOptionPane.showMessageDialog(null, "Película eliminada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la película con ese título");
        }
        // Limpia el campo de texto
        txttitulo.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}
