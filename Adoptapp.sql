use adoptapp;
select * from datospersonales;

insert into datospersonales (nombre_completo,dni,direccion,telefono,ciudad,idusuario,idtipodocumentos)
values ("Julian Giraldo", "1423423423","avasdasda","3123124312","medellín",3,3);

select * from usuario;
insert into usuario (email, pass_user,estado_user)
values ("jsaoasdasdassdfdjas","sasdasdfs",2);

select * from tipodocumentos;
insert into tipodocumentos (nombre_tipo_documento)
value ("Cedula");
insert into tipodocumentos (nombre_tipo_documento)
value ("Tarjeta de Identidad");
insert into tipodocumentos (nombre_tipo_documento)
value ("NIT");
