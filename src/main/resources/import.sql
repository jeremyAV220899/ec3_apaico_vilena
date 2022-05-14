insert into cliente (id_cliente,celular,nombre) values (1,'999999999','jeremy');
insert into cliente (id_cliente,celular,nombre) values (2,'999999999','juan');
insert into cliente (id_cliente,celular,nombre) values (3,'999999999','estefano');

insert into usuariocliente(`id_usuario`,`password`,`rol`,`usuario`,`id_cliente`) values(1,'123','ROLE_ADMIN','jeremy',1);

insert into  usuariocliente(`id_usuario`,`password`,`rol`,`usuario`,`id_cliente`) values(2,'123','ROLE_USER','juan',2);

insert into usuariocliente(`id_usuario`,`password`,`rol`,`usuario`,`id_cliente`) values(3,'123','ROLE_USER','estefano',3);
