drop table t_account;
create TABLE t_account(id number(4) primary key, money number(8,2));
insert into t_account values(1001,20000);
insert into t_account values(1002,20000);
select id,money from t_account;
select *from emp_zyl;
create sequence deptseq start with 60;----Ĭ��������Ϊ1

----�޸ı��ֶε�����
alter 