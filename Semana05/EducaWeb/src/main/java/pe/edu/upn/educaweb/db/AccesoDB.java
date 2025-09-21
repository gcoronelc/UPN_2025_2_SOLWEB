package pe.edu.upn.educaweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

	private AccesoDB() {
	}

	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		try {
			// Paso 1: Cargar el driver a memoria 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Paso 2: Obtener el objeto Connection 
			String url = "jdbc:sqlserver://localhost:1433;databaseName=EDUCA2;trustServerCertificate=true;";
			cn = DriverManager.getConnection(url, "sa", "database");
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new SQLException("No se encontró el driver de la base de datos.");
		} catch (Exception e) {
			throw new SQLException("No se puede establecer la conexión con la BD.");
		}
		return cn;
	}

}
