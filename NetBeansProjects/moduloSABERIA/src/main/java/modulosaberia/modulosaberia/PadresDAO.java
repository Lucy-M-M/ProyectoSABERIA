/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulosaberia.modulosaberia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PadresDAO {

    // 1. FUNCIONALIDAD DE INSERCIÓN (CREAR)
    public boolean insertar(String nombre, String correo, String telefono) {
        String sql = "INSERT INTO padres (nombre, correo, telefono) VALUES (?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, telefono);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar padre: " + e.getMessage());
            return false;
        }
    }

    // 2. FUNCIONALIDAD DE CONSULTA (LEER)
    public void consultarTodos() {
        String sql = "SELECT * FROM padres";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE PADRES DE FAMILIA ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_padre") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Correo: " + rs.getString("correo") + 
                                   " | Teléfono: " + rs.getString("telefono"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar padres: " + e.getMessage());
        }
    }

    // 3. FUNCIONALIDAD DE ACTUALIZACIÓN (EDITAR)
    public boolean actualizar(int idPadre, String nuevoNombre, String nuevoCorreo, String nuevoTelefono) {
        String sql = "UPDATE padres SET nombre = ?, correo = ?, telefono = ? WHERE id_padre = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoCorreo);
            ps.setString(3, nuevoTelefono);
            ps.setInt(4, idPadre);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar padre: " + e.getMessage());
            return false;
        }
    }

    // 4. FUNCIONALIDAD DE ELIMINACIÓN (BORRAR)
    public boolean eliminar(int idPadre) {
        String sql = "DELETE FROM padres WHERE id_padre = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idPadre);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar padre: " + e.getMessage());
            return false;
        }
    }
}