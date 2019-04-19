select * from t_emp;

create table t_emp(
	id number(4) primary key,
	name varchar2(20),
	salary number(7,2),
	age number(3)
);

create sequence emp_seq start with 1;

insert into t_emp values(emp_seq.nextval,'Lisa',3000.00,20);
insert into t_emp values(emp_seq.nextval,'»¨¶ù',3000.00,20);
insert into t_emp values(emp_seq.nextval,'ÉÙÄê',3000.00,20);
commit;


