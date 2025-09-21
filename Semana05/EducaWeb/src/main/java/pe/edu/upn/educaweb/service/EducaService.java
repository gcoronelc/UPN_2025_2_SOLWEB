package pe.edu.upn.educaweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import pe.edu.upn.educaweb.db.AccesoDB;
import pe.edu.upn.educaweb.util.JdbcUtil;

public class EducaService {

	public double consultarPrecio(int idCurso) {
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		double precio = 0.0;
		try {
			cn = AccesoDB.getConnection();
			String sql = """
                select cur_precio from curso 
                where cur_id = ?
                """;
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idCurso);
			rs = pstm.executeQuery();
			if (rs.next()) {
				precio = rs.getDouble("cur_precio");
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return precio;
	}

	public List<Map<String, ?>> consultarMatriculados(int idCurso) {
		List<Map<String, ?>> lista = null;
		String sql = """
				select * from MATRICULA
				where cur_id = ?;
               """;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idCurso);
			rs = pstm.executeQuery();
			lista = JdbcUtil.rsToList(rs);
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.");
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}
}
