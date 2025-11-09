package pe.edu.upn.educaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogonDto {

	private String usuario;
	private String clave;
}
