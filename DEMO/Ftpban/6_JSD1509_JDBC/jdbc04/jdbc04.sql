drop table t_account;
create table t_account
(id number(4) primary key,
 money number(8,2)); 
insert into t_account values(1001,20000);
insert into t_account values(1002,20000);
commit;
select * from emp;

create sequence deptseq
start with 60;
--查询序列的值
select empseq.nextval from dual;

--修改表字段类型
alter table emp modify empno number(5);

delete from emp;

commit;





