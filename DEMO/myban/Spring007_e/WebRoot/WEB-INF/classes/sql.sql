select * from emp;
select emp_seq.nextval from dual;
select empseq.nextval from dual;		-- invalid 	无效的	denied 拒绝，拒签 
select * from emp where deptno = 10;
select * from dept order by deptno;
delete from dept where loc is null;
delete from dept where loc = '无锡';
--select t_dept_seq.nextval from dual;	不存在
drop sequence deptseq;
create sequence dept_seq start with 40 increment by 10;
select dept_seq.nextval from dual;	--50	
select dept_seq.currval from dual;
select * from t_emp order by id; 
select t_emp_seq.nextval from dual;
create sequence t_emp_seq start with 25 increment;