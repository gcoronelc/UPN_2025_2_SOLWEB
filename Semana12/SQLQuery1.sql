select * from empleado;
go

sp_help empleado
go

select emp_id id, emp_apellido apellido, emp_nombre nombre,
emp_direccion direccion, emp_email email, emp_usuario usuario, '*****' clave
from empleado
where emp_usuario='ecastillo' and emp_clave='hastalavista';
go

select * from curso where cur_id=6;
select * from MATRICULA where cur_id=6;
go



