package pe.edu.upn.educaapp.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upn.educaapp.dto.ComboDto;
import pe.edu.upn.educaapp.service.ComboService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/educa/api/combo")
public class ComboRest {
	
	@Autowired
	private ComboService comboService;
	
	@GetMapping("/cursos")
	public ResponseEntity<List<ComboDto>> matriculados() {
	    try {
	        List<ComboDto> lista = comboService.getCursos();
	        return ResponseEntity.ok(lista);
	    } catch (Exception e) {
	        return ResponseEntity.notFound().build();
	    }
	}
	

}
