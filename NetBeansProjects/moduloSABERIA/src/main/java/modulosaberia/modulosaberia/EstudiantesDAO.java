/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modulosaberia.modulosaberia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudiantesDAO {

    // 1. FUNCIONALIDAD DE INSERCIÓN (CREAR ESTUDIANTE)
    // Nota: idPadre debe existir previamente en la tabla padres
    public boolean insertar(String nombre, String nivelEducativo, int idPadre) {
        String sql = "INSERT INTO estudiantes (nombre, nivel_educativo, id_padre) VALUES (?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, nivelEducativo);
            ps.setInt(3, idPadre);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar estudiante: " + e.getMessage());
            return false;
        }
    }

    // 2. FUNCIONALIDAD DE CONSULTA (LEER)
    public void consultarTodos() {
        String sql = "SELECT * FROM estudiantes";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE ESTUDIANTES ---");
            while (rs.next()) {
                System.out.println("ID Estudiante: " + rs.getInt("id_estudiante") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Nivel Educativo: " + rs.getString("nivel_educativo") + 
                                   " | ID Padre: " + rs.getInt("id_padre"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar estudiantes: " + e.getMessage());
        }
    }

    // 3. FUNCIONALIDAD DE ACTUALIZACIÓN (EDITAR)
    public boolean actualizar(int idEstudiante, String nuevoNombre, String nuevoNivel, int nuevoIdPadre) {
        String sql = "UPDATE estudiantes SET nombre = ?, nivel_educativo = ?, id_padre = ? WHERE id_estudiante = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoNivel);
            ps.setInt(3, nuevoIdPadre);
            ps.setInt(4, idEstudiante);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }

    // 4. FUNCIONALIDAD DE ELIMINACIÓN (BORRAR)
    public boolean eliminar(int idEstudiante) {
        String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idEstudiante);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }
}