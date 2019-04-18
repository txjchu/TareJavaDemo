select * from emp;
--²âÊÔsql×¢Èë
create table t_account
(id number(4) primary key,
 username varchar2(10),
 password varchar2(10)
);
insert into t_account values(1,'aaa','aaa');
insert into t_account values(2,'ccc','ccc');
insert into t_account values(3,'user1','user1');
insert into t_account values(4,'admin','admin');
commit;