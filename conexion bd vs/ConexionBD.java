import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // URL de conexión a tu base de datos 'alumno'
            String url = "jdbc:mysql://localhost:3306/Alumno?useSSL=false&serverTimezone=UTC";
            String usuario = "root";
            
            String password = "123456"; 

            conexion = DriverManager.getConnection(url, usuario, password);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL en el classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos (Verifica tu usuario/contraseña o si el servicio de MySQL está encendido):");
            e.printStackTrace();
        }
        return conexion;
    }
}