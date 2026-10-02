/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modulosaberia.modulosaberia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ProgresoAcademicoDAO {

    // 1. FUNCIONALIDAD DE INSERCIÓN (CREAR REGISTRO)
    // Nota: id_estudiante e id_actividad deben existir previamente
    public boolean insertar(int idEstudiante, int idActividad, double puntaje, String fechaCompletado, String observaciones) {
        String sql = "INSERT INTO progreso_academico (id_estudiante, id_actividad, puntaje, fecha_completado, observaciones) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idEstudiante);
            ps.setInt(2, idActividad);
            ps.setDouble(3, puntaje);
            ps.setDate(4, Date.valueOf(fechaCompletado)); // Formato "AAAA-MM-DD"
            ps.setString(5, observaciones);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar progreso: " + e.getMessage());
            return false;
        }
    }

    // 2. FUNCIONALIDAD DE CONSULTA (LEER)
    public void consultarTodos() {
        String sql = "SELECT * FROM progreso_academico";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE PROGRESO ACADÉMICO ---");
            while (rs.next()) {
                System.out.println("ID Progreso: " + rs.getInt("id_progreso") + 
                                   " | ID Estudiante: " + rs.getInt("id_estudiante") + 
                                   " | ID Actividad: " + rs.getInt("id_actividad") + 
                                   " | Puntuación: " + rs.getDouble("puntaje") + 
                                   " | Fecha: " + rs.getDate("fecha_completado") + 
                                   " | Observaciones: " + rs.getString("observaciones"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar progreso: " + e.getMessage());
        }
    }

    // 3. FUNCIONALIDAD DE ACTUALIZACIÓN (EDITAR)
    public boolean actualizar(int idProgreso, int nuevoIdEstudiante, int nuevoIdActividad, double nuevoPuntaje, String nuevaFecha, String nuevasObservaciones) {
        String sql = "UPDATE progreso_academico SET id_estudiante = ?, id_actividad = ?, puntoje = ?, fecha_completado = ?, observaciones = ? WHERE id_progreso = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, nuevoIdEstudiante);
            ps.setInt(2, nuevoIdActividad);
            ps.setDouble(3, nuevoPuntaje);
            ps.setDate(4, Date.valueOf(nuevaFecha));
            ps.setString(5, nuevasObservaciones);
            ps.setInt(6, idProgreso);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar progreso: " + e.getMessage());
            return false;
        }
    }

    // 4. FUNCIONALIDAD DE ELIMINACIÓN (BORRAR)
    public boolean eliminar(int idProgreso) {
        String sql = "DELETE FROM progreso_academico WHERE id_progreso = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idProgreso);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar progreso: " + e.getMessage());
            return false;
        }
    }
}