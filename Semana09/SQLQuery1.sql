select cur_precio precio from CURSO where cur_id=?
go


select * from curso where cur_id=8;
select A.alu_id id, A.alu_nombre nombre, 
M.cur_id curso, M.mat_precio precio, M.mat_nota nota
from MATRICULA M
join ALUMNO A on M.alu_id=A.alu_id
where M.cur_id=8;
go

select count(1) cont
from matricula 
where cur_id = 1 and alu_id=1
go

update curso
set cur_matriculados = 30
where cur_id=7;
go

select (cur_vacantes - cur_matriculados) vacantes 
from CURSO where cur_id=7;
go

select  * from MATRICULA;
go

insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,
mat_fecha,mat_precio,mat_cuotas)
values(?,?,?,?,GETDATE(),?,?)
go

update curso
set cur_matriculados = cur_matriculados + 1
where cur_id = ?
go










