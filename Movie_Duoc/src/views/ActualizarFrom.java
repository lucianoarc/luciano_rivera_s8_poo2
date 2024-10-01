
package views;


import javax.swing.JOptionPane;
import Controllers.MovieController;
import models.Movies;
import java.sql.Connection;
import java.sql.SQLException;

public class ActualizarFrom extends javax.swing.JFrame {
    private MovieController movieController;

    public ActualizarFrom(MovieController movieController) {
        initComponents();
        this.movieController = movieController;
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdirector = new javax.swing.JTextField();
        txtano = new javax.swing.JTextField();
        txtduracion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtgenero = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID:");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("TITULO: ");

        txttitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttituloActionPerformed(evt);
            }
        });

        jLabel3.setText("DIRECTOR: ");

        jLabel4.setText("AÑO:");

        jLabel5.setText("DURACION:");

        txtdirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdirectorActionPerformed(evt);
            }
        });

        jLabel6.setText("GENERO:");

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(btnbuscar)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(230, 230, 230))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(6, 6, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttitulo)
                                    .addComponent(txtdirector)
                                    .addComponent(txtano)
                                    .addComponent(txtduracion)
                                    .addComponent(txtgenero)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtduracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
     // Obtener el ID desde el campo de texto
    String idStr = txttitulo.getText().trim();
    
    // Verificar que el ID no esté vacío
    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID");
        return;
    }

    try {
        // Convertir el ID a entero
        int id = Integer.parseInt(idStr);
        
        // Buscar la película por ID
        Movies movie = movieController.buscarPeliculaPorId(id); // Cambia el método de búsqueda

        if (movie != null) {
            // Mostrar todos los detalles de la película
            txtid.setText(movie.getTitulo()); // Asegúrate de tener un método getTitulo() en tu modelo
            txtdirector.setText(movie.getDirector());
            txtano.setText(String.valueOf(movie.getAno()));
            txtduracion.setText(String.valueOf(movie.getDuracion()));
            txtgenero.setText(movie.getGenero());
        } else {
            JOptionPane.showMessageDialog(null, "Pelicula no encontrada");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: El ID debe ser un numero valido.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnbuscarActionPerformed
   
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
        // Obtener los datos desde los campos de texto
        int id = Integer.parseInt(txttitulo.getText().trim());
        String titulo = txtid.getText().trim();
        String director = txtdirector.getText().trim();
        int ano = Integer.parseInt(txtano.getText().trim());
        int duracion = Integer.parseInt(txtduracion.getText().trim());
        String genero = txtgenero.getText().trim();

        // Llamar al método para actualizar la película
        boolean actualizado = movieController.actualizarPelicula(id, titulo, director, ano, duracion, genero);

        // Mostrar un mensaje dependiendo del resultado
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Pelicula actualizada con exito");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la pelicula. Verifique que el ID sea correcto.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Asegurate de que los campos numericos son validos.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txttituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttituloActionPerformed

    private void txtdirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdirectorActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtano;
    private javax.swing.JTextField txtdirector;
    private javax.swing.JTextField txtduracion;
    private javax.swing.JTextField txtgenero;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}
