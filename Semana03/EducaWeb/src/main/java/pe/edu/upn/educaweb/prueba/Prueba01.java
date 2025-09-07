package pe.edu.upn.educaweb.prueba;

import java.sql.Connection;
import pe.edu.upn.educaweb.db.AccesoDB;


public class Prueba01 {
	
	
	public static void main(String[] args) {
		
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexion OK!!!");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
