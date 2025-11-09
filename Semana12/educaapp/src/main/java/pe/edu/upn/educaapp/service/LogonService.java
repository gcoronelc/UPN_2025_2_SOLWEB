package pe.edu.upn.educaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pe.edu.upn.educaapp.dto.EmpleadoDto;

@Service
public class LogonService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmpleadoDto validar(String usuario, String clave) {
		String sql = """
				select emp_id id, emp_apellido apellido, emp_nombre nombre,
				emp_direccion direccion, emp_email email, emp_usuario usuario, '*****' clave
				from empleado
				where emp_usuario=? and emp_clave=?
				""";
		EmpleadoDto bean = jdbcTemplate.queryForObject(sql, 
				BeanPropertyRowMapper.newInstance(EmpleadoDto.class), usuario, clave); 
		return bean;		
	}
	
	
}
