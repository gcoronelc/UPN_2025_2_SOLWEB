select * from empleado;
go

sp_help empleado
go

select emp_id id, emp_apellido apellido, emp_nombre nombre,
emp_email email, emp_usuario usuario, '*****' clave
from empleado
where emp_usuario='ecastillo' and emp_clave='hastalavista';
go



