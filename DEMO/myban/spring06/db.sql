create table student_zyl(
	id number(8) primary key,
	name varchar2(50),
	age number(3)
);

create sequence stu_seq;

select * from student_zyl;
select * from t_emp;
delete emp where job is null;
select emp_seq.nextval from dual;--102
select empseq.nextval from dual;--3721
select emp_id_seq.nextval from dual;--22
select emp_seq_forexer.nextval from dual;--41
commit; 
rollback;
select * from emp;
delete emp where mgr = 3;
insert into emp values (1,'SMITH','CLERK',3,null,800,null,2);
insert into emp values (2,'ALLEN','SALESMAN',3,null,1600,300,3);
insert into emp values (3,'WARD','SALESMAN',4,null,1250,500,3);
insert into emp values (4,'JONES','MANAGER',5,null,2975,null,2);
insert into emp values (5,'MARTIN','SALESMAN',7,null,1250,1400,3);
insert into emp values (6,'BLAKE','MANAGER',9,null,2850,null,3);
insert into emp values (7,'CLARK','MANAGER',9,null,2450,null,1);
insert into emp values (8,'SCOTT','ANALYST',9,null,3000,null,2);
insert into emp values (9,'KING','PRESIDENT',null,null,5000,null,1);
insert into emp values (10,'TURNER','SALESMAN',5,null,1500,0,3);
insert into emp values (11,'ADAMS','CLERK',5,null,1100,null,2);
insert into emp values (12,'JAMES','CLERK',1,null,950,null,3);
insert into emp values (13,'FORD','ANALYST',1,null,3000,null,2);
insert into emp values (14,'MILLER','CLERK',3,null,1300,null,1);