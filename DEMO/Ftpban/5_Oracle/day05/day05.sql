作业1
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

5：
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


作业3:
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT id,title,content,occurtime
          FROM news
          ORDER BY occurtime DESC) t)
WHERE rn BETWEEN 6 AND 10

作业6:
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

    
视图:
CREATE VIEW v_emp_10
AS
SELECT empno, ename, sal, deptno 
FROM emp 
WHERE deptno = 10;

查询视图内容:
数据库会先将该视图对应的SELECT
语句执行，然后得到结果集，再将
该结果集当做一张表，然后执行我们的
查询工作。
SELECT * FROM v_emp_10

查看视图的结构：
DESC v_emp_10
视图本身没有结构，而是将其子查询
查询的基表对应字段的类型长度列出来

修改视图:
由于视图本身没有结构，只是对应了一条
子查询，所以修改视图就是替换原有的子
查询。可以使用语句CREATE OR REPLACE
创建修改都可以，没有则创建，有则替换。
视图对应的子查询可以为字段添加别名，
这样视图中该字段的名字则变为别名，若
查询的字段含有表达式，函数，则该字段必
须指定别名。

CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id  , ename name , sal salary, deptno 
FROM emp 
WHERE deptno = 10;

对视图进行DML操作:
只能对简单视图进行，对视图进行DML
就是对该视图数据来源的基表进行的操作。
              
简单视图:
数据从单一的一张表中获取，并且没有对
表中的数据做过任何加工(字段中不含有
表达式，函数，不含有分组等操作。)。
    
INSERT INTO v_emp_10
VALUES
(1001,'JACK',3000,10)    
    
SELECT * FROM v_emp_10    
SELECT * FROM emp    

向视图插入一条数据，就是将数据插入
到基表中，并且，该条记录只有视图看
的到得字段会有值，其他都是插入默认
值NULL(单独指定默认值的除外)。
所以，若基表中视图看不到的字段含有
NOT NULL约束的话，那么插入会失败!
              
有时，我们通过视图插入的数据，视图
本身看不到，但是却又插入到基表中了，
那么这样的数据会对基表产生污染。
INSERT INTO v_emp_10
VALUES
(1002,'ROSE',4000,20)
              
SELECT * FROM v_emp_10    
SELECT * FROM emp  


更新同样存在这个问题:
正常情况:
UPDATE v_emp_10
SET salary=salary+500

SELECT * FROM v_emp_10
SELECT * FROM emp

污染效果:
UPDATE v_emp_10
SET deptno=20

SELECT * FROM v_emp_10
SELECT * FROM emp

删除数据没有问题
因为删除只能删除视图看的到得
记录。
DELETE FROM v_emp_10 
WHERE deptno=20
  
SELECT * FROM v_emp_10  
SELECT * FROM emp  
  
             
为视图添加CHECK OPTION选项
当一个视图添加了检查选项后，
那么对视图进行增，改操作后，
若视图对数据不可见了，则不允许
这样的操作。
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
    
    
将视图设置为只读的，那么该视图则不允许
执行DML操作。
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
                                                                                                                                                                              
复杂视图:
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

查看哪些员工比所在部门平均薪水高?
SELECT e.ename,e.sal,s.dname
FROM emp e,v_emp_salary s
WHERE e.deptno=s.deptno
AND e.sal>s.avg_sal
    
    
v_emp_sal    
员工工号，名字，职位，年薪，部门名称，所在地    
    
CREATE VIEW v_emp_sal_fancq
AS
SELECT e.empno,e.ename,e.job,
       e.sal*12 year_sal,d.dname,
       d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
              

SELECT * FROM v_emp_sal_fancq              
              
    
序列
用于生成一组数字的数据库对象，通常
为某张表的主键字段提供值。

CREATE SEQUENCE seq_emp_empno
START WITH 100
INCREMENT BY 10

序列提供了两个伪列:
NEXTVAL:获取序列下一个值
CURRVAL:获取序列最后一次生成的值

NEXTVAL在新创建的序列中使用会首先
获取START WITH指定的值，以后则是
用最后一次生成的数字加上步长得到，
序列不可以后退，所以当调用了NEXTVAL
后就无法再得到之前生成的数字了。
CURRVAL可以获取最后生成的数字，无论
调用多少次值都是一样的，除非调用过
NEXTVAL生成下一个数字。需要注意，刚
创建的序列必须先执行一次NEXTVAL后才
可以使用CURRVAL
    
SELECT seq_emp_empno.NEXTVAL 
FROM dual    
    
SELECT seq_emp_empno.CURRVAL 
FROM dual  

使用序列作为emp表主键提供值
INSERT INTO emp
(empno,ename,job,sal,deptno)
VALUES
(seq_emp_empno.NEXTVAL,'POP','CLERK',5000,10)


SELECT * FROM emp    
 
删除序列 
DROP SEQUENCE seq_emp_empno 
 
索引，用于提高查询效率，排序效率等操作。
索引可以建立在一张表的单列也可以建立
在多列上。
索引的算法是数据库自行维护，我们无需关注。
当我们进行查询或排序时，数据库会自动使用
可用的索引。
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
       
主键可以使用序列作为值的提供方式。
还有一种常见的是UUID，是一个32位不重复
字符串。所以若使用UUID，主键字段应当是
字符串类型。ORACLE提供了一个函数可以生
成UUID
SELECT SYS_GUID() FROM dual
  
  
  
  
  
       
       
              