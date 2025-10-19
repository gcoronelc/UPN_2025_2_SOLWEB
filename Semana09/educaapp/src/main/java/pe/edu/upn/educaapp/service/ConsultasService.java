package pe.edu.upn.educaapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	public double precioCurso(int idCurso) {
		String sql = "select cur_precio precio from CURSO where cur_id=?";
		Double precio = jdbcTemplate.queryForObject(sql, Double.class,idCurso);
		return precio;
	}
	
	
	public List<Map<String,Object>> matriculados(int idCurso){
		String sql = """
				select A.alu_id id, A.alu_nombre nombre, 
				M.cur_id curso, M.mat_precio precio, M.mat_nota nota
				from MATRICULA M
				join ALUMNO A on M.alu_id=A.alu_id
				where M.cur_id=?
				""";
		List<Map<String,Object>> lista = jdbcTemplate.queryForList(sql, idCurso);
		return lista;
	}
	
}
