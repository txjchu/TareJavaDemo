create table t_emp_test(eno number primary key,ename varchar2(20));
 emp_seq_test;
select * from t_emp_test;
select emp_seq.nextval from dual;
select emp_seq.currval from dual;
select * from emp;
select * from admin_info;