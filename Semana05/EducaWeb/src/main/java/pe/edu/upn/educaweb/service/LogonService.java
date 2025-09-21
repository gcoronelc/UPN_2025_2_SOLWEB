package pe.edu.upn.educaweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.edu.upn.educaweb.db.AccesoDB;
import pe.edu.upn.educaweb.dto.EmpleadoDto;

public class LogonService {
	
	public EmpleadoDto validarUsuario(String usuario, String clave){
		String sql_select = """
                      select 
                      	emp_id, emp_apellido, emp_nombre, emp_direccion,
                        emp_email, emp_usuario,'******' emp_clave
                      from empleado
                      where emp_usuario=? and emp_clave=?
                      """;
		EmpleadoDto dto = null;
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql_select);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			if(rs.next()){
				dto = new EmpleadoDto();
				dto.setId(rs.getInt("emp_id"));
				dto.setApellido(rs.getString("emp_apellido"));
				dto.setNombre(rs.getString("emp_nombre"));
				dto.setDireccion(rs.getString("emp_direccion"));
				dto.setEmail(rs.getString("emp_email"));
				dto.setUsuario(rs.getString("emp_usuario"));
				dto.setClave(rs.getString("emp_clave"));
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			dto = null;
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	
	
	
}
