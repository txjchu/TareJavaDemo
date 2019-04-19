select * from emp;
select * from t_emp;
create table t_emp(
	id number(4) primary key,
	ename varchar2(20),
	age number(2),
	salary number(10,2)
);
create sequence emp_id_seq increment by 1 start with 1;
select emp_id_seq.nextval from dual;
select * from t_emp order by id;
select * from t_emp where id = 7;