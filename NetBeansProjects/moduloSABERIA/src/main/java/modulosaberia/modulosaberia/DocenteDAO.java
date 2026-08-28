/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulosaberia.modulosaberia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocenteDAO {

    // 1. FUNCIONALIDAD DE INSERCIÓN (CREAR)
    public boolean insertar(String nombre, String especialidad) {
        String sql = "INSERT INTO docentes (nombre, especialidad) VALUES (?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, especialidad);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar docente: " + e.getMessage());
            return false;
        }
    }

    // 2. FUNCIONALIDAD DE CONSULTA (LEER)
    public void consultarTodos() {
        String sql = "SELECT * FROM docentes";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE DOCENTES ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_docente") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Especialidad: " + rs.getString("especialidad"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar docentes: " + e.getMessage());
        }
    }

    // 3. FUNCIONALIDAD DE ACTUALIZACIÓN (EDITAR)
    public boolean actualizar(int idDocente, String nuevoNombre, String nuevaEspecialidad) {
        String sql = "UPDATE docentes SET nombre = ?, especialidad = ? WHERE id_docente = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevaEspecialidad);
            ps.setInt(3, idDocente);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar docente: " + e.getMessage());
            return false;
        }
    }

    // 4. FUNCIONALIDAD DE ELIMINACIÓN (BORRAR)
    public boolean eliminar(int idDocente) {
        String sql = "DELETE FROM docentes WHERE id_docente = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idDocente);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar docente: " + e.getMessage());
            return false;
        }
    }
}