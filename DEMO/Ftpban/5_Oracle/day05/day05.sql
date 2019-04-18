��ҵ1
1:
SELECT DISTINCT e.job
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.dname='SALES'

SELECT DISTINCT job
FROM emp
WHERE deptno=(SELECT deptno
              FROM dept
              WHERE dname='SALES')
              
2:
SELECT e.ename
FROM emp e
WHERE NOT EXISTS(
  SELECT * FROM emp
  WHERE mgr = e.empno
)
    
3:
SELECT ename,sal
FROM emp
WHERE sal>ANY(SELECT sal
              FROM emp
              WHERE ename='FORD')

4:
SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='FORD')
AND ename<>'FORD'              

5��
SELECT COUNT(*),deptno
FROM emp
GROUP BY deptno
HAVING COUNT(*)>(SELECT COUNT(*)
                 FROM emp
                 WHERE deptno=20)

6:
SELECT ename,job
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 GROUP BY deptno
                 HAVING AVG(sal)>2000)


��ҵ3:
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT id,title,content,occurtime
          FROM news
          ORDER BY occurtime DESC) t)
WHERE rn BETWEEN 6 AND 10

��ҵ6:
1:
SELECT sid,sname,score,class_id,
       ROW_NUMBER() OVER(
        PARTITION BY class_id
        ORDER BY score DESC
       ) rank
FROM student
 
2:
SELECT sid,sname,score,class_id,
       ROW_NUMBER() OVER(
        PARTITION BY class_id
        ORDER BY score DESC,sid
       ) rank
FROM student

3:
SELECT c.cname,s.sname,s.score,
       ROW_NUMBER() OVER(
        PARTITION BY s.class_id
        ORDER BY s.score DESC,s.sid
       ) rank
FROM student s,class c
WHERE s.class_id=c.cid

4:
SELECT SUM(salary),group_id
FROM mygroup
GROUP BY ROLLUP(group_id)

5:
SELECT SUM(salary),group_id,job
FROM mygroup
GROUP BY CUBE(group_id,job)

6:
SELECT SUM(salary),group_id,job
FROM mygroup
GROUP BY GROUPING SETS(group_id,job)

    
��ͼ:
CREATE VIEW v_emp_10
AS
SELECT empno, ename, sal, deptno 
FROM emp 
WHERE deptno = 10;

��ѯ��ͼ����:
���ݿ���Ƚ�����ͼ��Ӧ��SELECT
���ִ�У�Ȼ��õ���������ٽ�
�ý��������һ�ű�Ȼ��ִ�����ǵ�
��ѯ������
SELECT * FROM v_emp_10

�鿴��ͼ�Ľṹ��
DESC v_emp_10
��ͼ����û�нṹ�����ǽ����Ӳ�ѯ
��ѯ�Ļ����Ӧ�ֶε����ͳ����г���

�޸���ͼ:
������ͼ����û�нṹ��ֻ�Ƕ�Ӧ��һ��
�Ӳ�ѯ�������޸���ͼ�����滻ԭ�е���
��ѯ������ʹ�����CREATE OR REPLACE
�����޸Ķ����ԣ�û���򴴽��������滻��
��ͼ��Ӧ���Ӳ�ѯ����Ϊ�ֶ���ӱ�����
������ͼ�и��ֶε��������Ϊ��������
��ѯ���ֶκ��б��ʽ������������ֶα�
��ָ��������

CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id  , ename name , sal salary, deptno 
FROM emp 
WHERE deptno = 10;

����ͼ����DML����:
ֻ�ܶԼ���ͼ���У�����ͼ����DML
���ǶԸ���ͼ������Դ�Ļ�����еĲ�����
              
����ͼ:
���ݴӵ�һ��һ�ű��л�ȡ������û�ж�
���е����������κμӹ�(�ֶ��в�����
���ʽ�������������з���Ȳ�����)��
    
INSERT INTO v_emp_10
VALUES
(1001,'JACK',3000,10)    
    
SELECT * FROM v_emp_10    
SELECT * FROM emp    

����ͼ����һ�����ݣ����ǽ����ݲ���
�������У����ң�������¼ֻ����ͼ��
�ĵ����ֶλ���ֵ���������ǲ���Ĭ��
ֵNULL(����ָ��Ĭ��ֵ�ĳ���)��
���ԣ�����������ͼ���������ֶκ���
NOT NULLԼ���Ļ�����ô�����ʧ��!
              
��ʱ������ͨ����ͼ��������ݣ���ͼ
��������������ȴ�ֲ��뵽�������ˣ�
��ô���������ݻ�Ի��������Ⱦ��
INSERT INTO v_emp_10
VALUES
(1002,'ROSE',4000,20)
              
SELECT * FROM v_emp_10    
SELECT * FROM emp  


����ͬ�������������:
�������:
UPDATE v_emp_10
SET salary=salary+500

SELECT * FROM v_emp_10
SELECT * FROM emp

��ȾЧ��:
UPDATE v_emp_10
SET deptno=20

SELECT * FROM v_emp_10
SELECT * FROM emp

ɾ������û������
��Ϊɾ��ֻ��ɾ����ͼ���ĵ���
��¼��
DELETE FROM v_emp_10 
WHERE deptno=20
  
SELECT * FROM v_emp_10  
SELECT * FROM emp  
  
             
Ϊ��ͼ���CHECK OPTIONѡ��
��һ����ͼ����˼��ѡ���
��ô����ͼ���������Ĳ�����
����ͼ�����ݲ��ɼ��ˣ�������
�����Ĳ�����
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id  , ename name , sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH CHECK OPTION
             
INSERT INTO v_emp_10
VALUES
(1003,'MIKE',5000,20)
    
UPDATE v_emp_10
SET deptno=20
    
    
����ͼ����Ϊֻ���ģ���ô����ͼ������
ִ��DML������
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id  , ename name , sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH READ ONLY
             
             

SELECT object_name 
FROM user_objects 
WHERE object_type='TABLE'

SELECT text,view_name
FROM user_views

SELECT table_name
FROM user_tables
                                                                                                                                                                              
������ͼ:
CREATE VIEW v_emp_salary
AS
SELECT d.dname,d.deptno, 
       avg(e.sal) avg_sal, 
       sum(e.sal) sum_sal, 
       max(e.sal) max_sal, 
       min(e.sal) min_sal 
FROM emp e join dept d
ON e.deptno = d.deptno
GROUP BY d.dname,d.deptno;

SELECT * FROM v_emp_salary

�鿴��ЩԱ�������ڲ���ƽ��нˮ��?
SELECT e.ename,e.sal,s.dname
FROM emp e,v_emp_salary s
WHERE e.deptno=s.deptno
AND e.sal>s.avg_sal
    
    
v_emp_sal    
Ա�����ţ����֣�ְλ����н���������ƣ����ڵ�    
    
CREATE VIEW v_emp_sal_fancq
AS
SELECT e.empno,e.ename,e.job,
       e.sal*12 year_sal,d.dname,
       d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
              

SELECT * FROM v_emp_sal_fancq              
              
    
����
��������һ�����ֵ����ݿ����ͨ��
Ϊĳ�ű�������ֶ��ṩֵ��

CREATE SEQUENCE seq_emp_empno
START WITH 100
INCREMENT BY 10

�����ṩ������α��:
NEXTVAL:��ȡ������һ��ֵ
CURRVAL:��ȡ�������һ�����ɵ�ֵ

NEXTVAL���´�����������ʹ�û�����
��ȡSTART WITHָ����ֵ���Ժ�����
�����һ�����ɵ����ּ��ϲ����õ���
���в����Ժ��ˣ����Ե�������NEXTVAL
����޷��ٵõ�֮ǰ���ɵ������ˡ�
CURRVAL���Ի�ȡ������ɵ����֣�����
���ö��ٴ�ֵ����һ���ģ����ǵ��ù�
NEXTVAL������һ�����֡���Ҫע�⣬��
���������б�����ִ��һ��NEXTVAL���
����ʹ��CURRVAL
    
SELECT seq_emp_empno.NEXTVAL 
FROM dual    
    
SELECT seq_emp_empno.CURRVAL 
FROM dual  

ʹ��������Ϊemp�������ṩֵ
INSERT INTO emp
(empno,ename,job,sal,deptno)
VALUES
(seq_emp_empno.NEXTVAL,'POP','CLERK',5000,10)


SELECT * FROM emp    
 
ɾ������ 
DROP SEQUENCE seq_emp_empno 
 
������������߲�ѯЧ�ʣ�����Ч�ʵȲ�����
�������Խ�����һ�ű�ĵ���Ҳ���Խ���
�ڶ����ϡ�
�������㷨�����ݿ�����ά�������������ע��
�����ǽ��в�ѯ������ʱ�����ݿ���Զ�ʹ��
���õ�������
CREATE INDEX idx_emp_ename 
ON emp(ename);             
              
              
DROP INDEX idx_emp_ename;
      
      
CREATE TABLE employees (
eid NUMBER(6),
name VARCHAR2(30) NOT NULL,
salary NUMBER(7, 2),
hiredate DATE 
      CONSTRAINT employees_hiredate_nn_fancq NOT NULL
);  
DESC employees      
    
CREATE TABLE employees1 (
  eid NUMBER(6) UNIQUE,
  name VARCHAR2(30),
  email VARCHAR2(50),
  salary NUMBER(7, 2),
  hiredate DATE,
  CONSTRAINT employees_email_uk_fancq UNIQUE(email)
);
INSERT INTO employees1
(eid,name,email)
VALUES
(NULL,'POP','POP@QQ.COM')
    
SELECT * FROM employees1    
    
CREATE TABLE employees2 (
  eid NUMBER(6) PRIMARY KEY,
  name VARCHAR2(30),
  email VARCHAR2(50),
  salary NUMBER(7, 2),
  hiredate DATE
);
    
INSERT INTO employees2
(eid,name,salary)
VALUES
(NULL,'JACK',5000)
      
CREATE TABLE employees3 (
  eid NUMBER(6),
  name VARCHAR2(30),
  email VARCHAR2(50),
  salary NUMBER(7, 2),
  hiredate DATE
);
ALTER TABLE employees3 
ADD CONSTRAINT employees3_eid_pk 
    PRIMARY KEY (eid);
       
��������ʹ��������Ϊֵ���ṩ��ʽ��
����һ�ֳ�������UUID����һ��32λ���ظ�
�ַ�����������ʹ��UUID�������ֶ�Ӧ����
�ַ������͡�ORACLE�ṩ��һ������������
��UUID
SELECT SYS_GUID() FROM dual
  
  
  
  
  
       
       
              