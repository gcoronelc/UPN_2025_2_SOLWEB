package pe.edu.upn.educaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pe.edu.upn.educaapp.dto.ComboDto;
import pe.edu.upn.educaapp.dto.EmpleadoDto;

@Service
public class ComboService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ComboDto> getCursos() {
		List<ComboDto> lista = null;
		String sql = """
				select cur_id id, cur_nombre nombre
				from CURSO
				where cur_vacantes > 0 and cur_vacantes > cur_matriculados
				order by 2
				""";
		lista = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ComboDto.class));
		return lista;
	}
}
