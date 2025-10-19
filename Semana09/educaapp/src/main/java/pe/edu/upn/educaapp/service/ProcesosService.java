package pe.edu.upn.educaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.educaapp.dto.MatriculaDto;

@Service
public class ProcesosService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public MatriculaDto matricular(MatriculaDto bean) {
		String sql;
		int rowCount;
		int cont;
		bean.setEstado("Error en el proceso, intentelo nuevamente.");
		// Validaciones
		// Verificar Matricula
		sql = """
				select count(1) cont from matricula
				where cur_id = ? and alu_id=?
			""";
		cont = jdbcTemplate.queryForObject(sql, Integer.class, bean.getIdCurso(), bean.getIdAlumno());
		if (cont == 1) {
			throw new RuntimeException("Matricula ya existe");
		}
		// Varificar vacantes
		sql = """
			select (cur_vacantes - cur_matriculados) vacantes 
			from CURSO where cur_id=?
			""";
		cont = jdbcTemplate.queryForObject(sql, Integer.class, bean.getIdCurso());
		if (cont <= 0) {
			throw new RuntimeException("No hay vacantes.");
		}
		// Verificar tipo de matricula
		bean.setTipo(bean.getTipo().toUpperCase());
		String textoCompleto = "REGULAR,BECA,MEDIABECA";
		if (textoCompleto.indexOf(bean.getTipo()) == -1) {
			throw new RuntimeException("Tipo de matricula incorrecta.");
		}
		// Verificar cuotas
		
		// Operaciones
		// Leer precio
		
		// Establecer precio
		bean.setPrecio(777777);
		// Registrar matricula
		sql = """
			insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,
			mat_fecha,mat_precio,mat_cuotas)
			values(?,?,?,?,GETDATE(),?,?)	
			""";
		Object[] parms = {bean.getIdCurso(), bean.getIdAlumno(),bean.getIdEmpleado(),
				bean.getTipo(),bean.getPrecio(), bean.getCuotas()};
		jdbcTemplate.update(sql, parms);
		// Actualizar la tabla curso
		sql = """
				update curso
				set cur_matriculados = cur_matriculados + 1
				where cur_id = ?	
				""";
		rowCount = jdbcTemplate.update(sql, bean.getIdCurso());
		if(rowCount!=1) {
			throw new RuntimeException("Error al actualizar el curso.");
		}
		bean.setEstado("Matricula conforme.");
		return bean;
	}

}
