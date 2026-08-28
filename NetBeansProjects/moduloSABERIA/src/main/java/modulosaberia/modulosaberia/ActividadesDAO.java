package modulosaberia.modulosaberia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActividadesDAO {

    // 1. FUNCIONALIDAD DE INSERCIÓN (CREAR)
    public boolean insertar(String titulo, int idDocente) {
        String sql = "INSERT INTO actividades (titulo, id_docente) VALUES (?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, titulo);
            ps.setInt(2, idDocente);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar actividad: " + e.getMessage());
            return false;
        }
    }

    // 2. FUNCIONALIDAD DE CONSULTA (LEER)
    public void consultarTodas() {
        String sql = "SELECT * FROM actividades";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE ACTIVIDADES ACADÉMICAS ---");
            while (rs.next()) {
                System.out.println("ID Actividad: " + rs.getInt("id_actividad") + 
                                   " | Título: " + rs.getString("titulo") + 
                                   " | ID Docente Asignado: " + rs.getInt("id_docente"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar actividades: " + e.getMessage());
        }
    }

    // 3. FUNCIONALIDAD DE ACTUALIZACIÓN (EDITAR)
    public boolean actualizar(int idActividad, String nuevoTitulo, int nuevoIdDocente) {
        String sql = "UPDATE actividades SET titulo = ?, id_docente = ? WHERE id_actividad = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nuevoTitulo);
            ps.setInt(2, nuevoIdDocente);
            ps.setInt(3, idActividad);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar actividad: " + e.getMessage());
            return false;
        }
    }

    // 4. FUNCIONALIDAD DE ELIMINACIÓN (BORRAR)
    public boolean eliminar(int idActividad) {
        String sql = "DELETE FROM actividades WHERE id_actividad = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idActividad);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar actividad: " + e.getMessage());
            return false;
        }
    }
}