package vallegrade.edu.pe.model;

import vallegrade.edu.pe.database.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    private static final String SQL_SELECT = "SELECT * FROM estudiante";
    private static final String SQL_INSERT = "INSERT INTO estudiante (nombre, apellidos, documento, numero_documento, institucion, grado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE estudiante SET nombre=?, apellidos=?, documento=?, numero_documento=?, institucion=?, grado=? WHERE id_estudiante=?";
    private static final String SQL_DELETE = "DELETE FROM estudiante WHERE id_estudiante=?";

    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Estudiante e = new Estudiante(
                        rs.getInt("id_estudiante"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("documento"),
                        rs.getString("numero_documento"),
                        rs.getString("institucion"),
                        rs.getString("grado")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("Error en listar(): " + ex.getMessage());
        }
        return lista;
    }

    public boolean insertar(Estudiante e) {
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getDocumento());
            ps.setString(4, e.getNumeroDocumento());
            ps.setString(5, e.getInstitucion());
            ps.setString(6, e.getGrado());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error en insertar(): " + ex.getMessage());
            return false;
        }
    }

    public boolean actualizar(Estudiante e) {
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getDocumento());
            ps.setString(4, e.getNumeroDocumento());
            ps.setString(5, e.getInstitucion());
            ps.setString(6, e.getGrado());
            ps.setInt(7, e.getIdEstudiante());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error en actualizar(): " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error en eliminar(): " + ex.getMessage());
            return false;
        }
    }
}
