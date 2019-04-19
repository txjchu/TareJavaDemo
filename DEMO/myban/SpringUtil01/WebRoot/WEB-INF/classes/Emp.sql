select * from emp order by empno;
select emp_seq.nextval from dual;
select * from emp where ename = '张三';
CREATE TABLE t_car (
  id NUMBER(11) NOT NULL,
  type VARCHAR2(1) default NULL,
  doorSize NUMBER(11) default NULL,
  boxSize NUMBER(11) default NULL,
  color VARCHAR2(20) default NULL,
  PRIMARY KEY  (id)
  );
insert into t_car values (1,'C',2,null,'红色');
insert into t_car values (2,'C',4,null,'黑色');
insert into t_car values (3,'T',null,1,'蓝色');
insert into t_car values (4,'T',null,2,'蓝色');
commit;
select * from t_car ;