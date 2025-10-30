package pe.edu.upn.educaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDto {
	
	private int idCurso;
	private int idAlumno;
	private String tipo;
	private double precio;
	private int cuotas;
	private int idEmpleado;
	private String estado;
	
}
