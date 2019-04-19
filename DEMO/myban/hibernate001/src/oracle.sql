select * from emp order by empno;
select * from t_emp;
select * from emp_h;
create table emp_h(
  ID            NUMBER(4) CONSTRAINT EMP_ID_PK PRIMARY KEY,
  NAME        VARCHAR(50)  NOT NULL,
  AGE        NUMBER(11),
  SALARY        NUMBER(7,2),
  MARRY         CHAR(1),
  BIRTHDAY     DATE,
  LAST_LOGIN_TIME    DATE
);
select emp_seq.nextval from dual;
select empseq.nextval from dual;
select t_emp_seq.nextval from dual;
select * from cost;
select * from admin_info;
--desc cost;ÎªÉ¶ÎÞÐ§
select admin_seq.nextval from dual;
select cost_seq.nextval from dual;
create sequence admin_seq start with 2000 increment by 10;
drop sequence admin_seq; 
select user_id_seq.nextval from dual;









