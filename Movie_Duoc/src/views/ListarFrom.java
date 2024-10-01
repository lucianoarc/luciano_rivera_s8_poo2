
package views;


import Controllers.MovieController;
import java.util.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.*;


public class ListarFrom extends javax.swing.JFrame {
       private MovieController movieController;
    private JTable table;
    private JScrollPane scrollPane;

    public ListarFrom(MovieController movieController) {
        initComponents();
        this.movieController = movieController;

           // Obtener la lista de películas
           List<Movies> movies = movieController.getMoviesFromDB();
           populateTable(movies);
    }

    private void populateTable(List<Movies> movies) {
        String[] columnNames = {"ID", "Titulo", "Director", "Ano", "Duracion", "Genero"};
        Object[][] data = new Object[movies.size()][columnNames.length];

        for (int i = 0; i < movies.size(); i++) {
            Movies movie = movies.get(i);
            data[i][0] = movie.getId();
            data[i][1] = movie.getTitulo();
            data[i][2] = movie.getDirector();
            data[i][3] = movie.getAno();
            data[i][4] = movie.getDuracion();
            data[i][5] = movie.getGenero();
        }

        // Configurar el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
