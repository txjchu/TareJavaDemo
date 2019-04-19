--t_user

--t_user

CREATE TABLE t_dept
	(deptno number(2) primary key,
	 dname varchar2(10),
	 loc varchar2(20)
	 );
	 
CREATE SEQUENCE seq
increment by 5
start with 10;

SELECT *FROM t_dept;