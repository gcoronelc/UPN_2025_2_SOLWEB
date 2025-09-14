select 
	emp_id, emp_apellido, emp_nombre,
	emp_direccion, emp_email,
	emp_usuario,'******' emp_clave
from empleado
where emp_usuario = 'kdelgado' and emp_clave='noimporta';
go


