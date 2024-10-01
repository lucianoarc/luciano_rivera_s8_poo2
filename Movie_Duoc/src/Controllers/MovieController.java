
package Controllers;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.*;
import models.Movies;
import java.sql.SQLException;

public class MovieController {
    private List<Movies> movies;
    private DatabaseConnection databaseconnection;

    public MovieController() {
        movies = new ArrayList<>();
        databaseconnection = new DatabaseConnection();
    }

    // Consulta movies
    public List<Movies> getMoviesFromDB() {
        List<Movies> movies = new ArrayList<>();
        String query = "SELECT * FROM movies";
        
        try (Connection connection = databaseconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String director = resultSet.getString("director");
                int ano = resultSet.getInt("ano");
                int duracion = resultSet.getInt("duracion");
                String genero = resultSet.getString("genero");
                Movies movie = new Movies(id, titulo, director, ano, duracion, genero);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las peliculas de la base de datos: " + e.getMessage());
        }
        return movies;
    }

    public void addMovies(Movies movie) throws SQLException {
        String sql = "INSERT INTO movies (id, titulo, director, ano, duracion, genero) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = databaseconnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false); // Iniciar transacción
            
            pstmt.setInt(1, movie.getId());
            pstmt.setString(2, movie.getTitulo());
            pstmt.setString(3, movie.getDirector());
            pstmt.setInt(4, movie.getAno());
            pstmt.setInt(5, movie.getDuracion());
            pstmt.setString(6, movie.getGenero());
            pstmt.executeUpdate();
            
            databaseconnection.commit(); // Confirmar transacción       
            System.out.println("Pelicula ingresada con exito.");
        } catch (SQLException e) {
            databaseconnection.rollback(); // Revertir transacción en caso de error
            e.printStackTrace();
            System.out.println("Error al insertar la pelicula en la base de datos: " + e.getMessage());
        }
    }

    public boolean eliminarMovies(String titulo) {
    String sql = "DELETE FROM movies WHERE titulo = ?";
    Connection connection = null; // Declaramos la conexión aquí para el manejo en finally
    try {
        connection = databaseconnection.getConnection();
        connection.setAutoCommit(false); // Iniciar transacción

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, titulo);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit(); // Confirmar transacción solo si hubo éxito
                System.out.println("Pelicula eliminada con exito.");
                return true;
            } else {
                connection.rollback(); // Revierte la transacción si no se encontró la película
                System.out.println("No se encontro la pelicula con ese titulo.");
                return false;
            }
        }
    } catch (SQLException e) {
        if (connection != null) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transaccion: " + rollbackEx.getMessage());
            }
        }
        System.err.println("Error al eliminar la pelicula de la base de datos: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Asegúrate de cerrar la conexión
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexion: " + closeEx.getMessage());
            }
        }
    }
    return false; // Retorna false si hubo un error o si no se eliminó la película
}

    // Método para actualizar una película
    public boolean actualizarPelicula(int id, String titulo, String director, int ano, int duracion, String genero) {
        String sql = "UPDATE movies SET TITULO = ?, DIRECTOR = ?, ANO = ?, DURACION = ?, GENERO = ? WHERE ID = ?";
        boolean updated = false;

        try (Connection connection = databaseconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, titulo);
            statement.setString(2, director);
            statement.setInt(3, ano);
            statement.setInt(4, duracion);
            statement.setString(5, genero);
            statement.setInt(6, id);

            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0); // Retorna true si se actualizó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    public Movies buscarPeliculaPorId(int id) {
    String sql = "SELECT * FROM movies WHERE id = ?";
    
    try (Connection connection = databaseconnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
         
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            // Crear y retornar un objeto Movies con los datos
            Movies movie = new Movies(id, sql, sql, id, id, sql);
            movie.setId(resultSet.getInt("id"));
            movie.setTitulo(resultSet.getString("titulo"));
            movie.setDirector(resultSet.getString("director"));
            movie.setAno(resultSet.getInt("ano"));
            movie.setDuracion(resultSet.getInt("duracion"));
            movie.setGenero(resultSet.getString("genero"));
            return movie;
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar pelicula: " + e.getMessage());
    }
    
    return null; // Retorna null si no se encuentra la película
}
}