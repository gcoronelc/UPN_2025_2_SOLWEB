package pe.edu.upn.educaapp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upn.educaapp.dto.MatriculaDto;
import pe.edu.upn.educaapp.service.ConsultasService;
import pe.edu.upn.educaapp.service.ProcesosService;

@RestController
@RequestMapping("/educa/api")
public class EducaRest {
	
	@Autowired
	private ConsultasService consultasService;
	
	@Autowired
	private ProcesosService procesosService;
	
	/*
	@GetMapping("/preciocurso/{idCurso}")
	public double precioCurso(@PathVariable int idCurso) {
		return consultasService.precioCurso(idCurso);
	}
	*/
	
	@GetMapping("/preciocurso/{idCurso}")
	public ResponseEntity<Double> precioCurso(@PathVariable int idCurso) {
	    try {
	        double precio = consultasService.precioCurso(idCurso);
	        return ResponseEntity.ok(precio);
	    } catch (EmptyResultDataAccessException e) {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/matriculados/{idCurso}")
	public List<Map<String,Object>> matriculados(@PathVariable int idCurso){
		return consultasService.matriculados(idCurso);
	}
	
	/*
	@PostMapping("/matricular")
	public MatriculaDto matricular(@RequestBody MatriculaDto bean) {
		return procesosService.matricular(bean);
	}
	*/
	
	@PostMapping("/matricular")
	public ResponseEntity<?> matricular(@RequestBody MatriculaDto bean) {
	    try {
	        MatriculaDto resultado = procesosService.matricular(bean);
	        return ResponseEntity.ok(resultado);
	    } catch (RuntimeException e) {
	        Map<String, String> error = new HashMap<>();
	        error.put("error", "Error al matricular");
	        error.put("mensaje", e.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	    }
	}

}
