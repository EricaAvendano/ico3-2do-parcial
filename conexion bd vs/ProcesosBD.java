import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcesosBD {

    public boolean insertarRegistro(Alumno alumno) {
        String sql = "INSERT INTO Alumno (Cuenta, Paterno, Materno, Nombre, Direccion, Telefono, Licenciatura, Semestre) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar()) {

            if (con == null) {
                System.out.println("Error: La conexión a la base de datos no se pudo establecer.");
                return false;
            }

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, alumno.getCuenta());
                pst.setString(2, alumno.getPaterno());
                pst.setString(3, alumno.getMaterno());
                pst.setString(4, alumno.getNombre());
                pst.setString(5, alumno.getDireccion());
                pst.setString(6, alumno.getTelefono());
                pst.setString(7, alumno.getLicenciatura());
                pst.setInt(8, alumno.getSemestre());

                pst.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("\nError al ejecutar el INSERT en MySQL:");
            System.out.println("Mensaje de error: " + e.getMessage());
            return false;
        }
    }
}