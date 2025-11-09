package pe.edu.upn.educaapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upn.educaapp.dto.EmpleadoDto;
import pe.edu.upn.educaapp.dto.LogonDto;
import pe.edu.upn.educaapp.service.LogonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/educa/api")
public class LogonRest {

	@Autowired
	private LogonService logonService;
	
	@PostMapping("/logon")
	public ResponseEntity<EmpleadoDto> validar(@RequestBody LogonDto bean) {
	    try {
	        EmpleadoDto empleado = logonService.validar(bean.getUsuario(), bean.getClave());
	        return ResponseEntity.ok(empleado);
	    } catch (EmptyResultDataAccessException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}
	
	
}
