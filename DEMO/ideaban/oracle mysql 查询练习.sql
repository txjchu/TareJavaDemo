CREATE TABLE student(
    id NUMERIC(4),
    name VARCHAR(20),
    gender CHAR(1),
    fee NUMERIC(7,2)
    
    
);
DESC student;
ALTER TABLE student ADD c1(CHAR(1)); -- 错误语法
ALTER TABLE student ADD c1; -- 错误语法
ALTER TABLE student ADD COLUMN c1; -- 语法错误
ALTER TABLE student ADD COLUMN c1 VARCHAR(2);
ALTER TABLE student ADD COLUMNS (c2 VARCHAR(2), c3 VARCHAR(1)); -- 错误语法
ALTER TABLE student ADD COLUMNS c2 VARCHAR(2), c3 VARCHAR(1); -- 错误语法

-- 删除列
ALTER TABLE student DROP c1; -- ok
DESC student;
ALTER TABLE STUDENT ADD COLUMN C1; -- 错误语法，表名大小写敏感
ALTER TABLE student ADD COLUMN c2 VARCHAR(2);
DESC student;
ALTER TABLE student DROP COLUMN c2; -- OK
-- 修改列
-- 可以改变列的数据类型，长度，默认值（1.只针对之后插入的数据有效，(已有数据不会改变？)2.对已有数据的列将长度改小可能失败）
ALTER TABLE student MODIFY name VARCHAR(10);
DESC student;
ALTER TABLE student CHANGE name VARCHAR(15); -- 错误语法
ALTER TABLE student CHANGE name name VARCHAR(15);
DESC student;
ALTER TABLE student CHANGE name name1 VARCHAR(15);
DESC student;
ALTER TABLE student CHANGE name1 name VARCHAR(12);
DESC student;


CREATE TABLE employee(
    id NUMERIC(4),
    name VARCHAR(20) NOT NULL,
    gender CHAR(1) DEFAULT 'M',
    birth DATE,
    salary NUMERIC(6, 2),
    comm NUMERIC(6, 2),
    job VARCHAR(30),
    manager NUMERIC(4),
    deptno NUMERIC(2)
);
DESC employee;
SELECT * FROM employee;

RENAME employee TO myemp; -- Oracle 中语法，MySQL中错误
RENAME TABLE employee TO myemp;     -- OK

ALTER TABLE myemp ADD COLUMN (hiredate DATE DEFAULT CURRENT_DATE); -- 错误语法
DESC myemp;
ALTER TABLE myemp ADD COLUMN hiredate DATE;
ALTER TABLE myemp MODIFY hiredate TIMESTAMP(6);
ALTER TABLE myemp CHANGE hiredate hiredate TIMESTAMP(14); -- 同下
ALTER TABLE myemp ADD COLUMN hiredate1 TIMESTAMP(14); -- 1426 - Too-big precision 14 specified for 'hiredate1'. Maximum is 6.
ALTER TABLE myemp MODIFY hiredate TIMESTAMP DEFAULT CURRENT_DATE;-- 错误语法
ALTER TABLE myemp MODIFY hiredate TIMESTAMP DEFAULT CURRENT_TIMESTAMP; -- OK
ALTER TABLE myemp MODIFY joy VARCHAR(40) DEFAULT 'CLERK'; -- Unknown column 'joy' in 'myemp'
ALTER TABLE myemp MODIFY job VARCHAR(40) DEFAULT 'CLERK';
ALTER TABLE myemp DROP hiredate;
DESC myemp;

--插入数据
INSERT INTO myemp(id, name, job, salary) VALUES('1001', 'rose', 'PROGRAMMER', 5500);
INSERT INTO myemp(id, name, job, birth) VALUES('1002', 'MARTHA', 'ANALYST', '01-SEP-89'); -- Incorrect date value: '01-SEP-89' for column 'birth' at row 1
INSERT INTO myemp(id, name, job, birth) VALUES('1002', 'MARTHA', 'ANALYST', '89-01-13'); --ok
SELECT * FROM myemp;
UPDATE myemp SET name = 'martha' WHERE id = '1002';
INSERT INTO myemp(id, name, job, birth) VALUES('1003', 'donna', 'MANAGER', DATE_FORMAT('89-09-01','%d-%M-%y')); -- Incorrect date value: '5 September 89' for column 'birth' at row 1
INSERT INTO myemp(id, name, job, birth) VALUES('1003', 'donna', 'MANAGER', DATE_FORMAT('89-09-01','%y-%m-%d')); -- ok 
INSERT INTO myemp(id, name, job, birth) VALUES('1003', 'donna', 'MANAGER', DATE_FORMAT('09-01-89','%m-%d-%y')); -- Incorrect datetime value: '09-01-89'

INSERT INTO myemp(id, name, job, birth) VALUES(1003, 'donna', 'MANAGER', TO_DATE('1978-09-01', 'YYYY-MM-DD')); -- Oracle 中可用
INSERT INTO myemp(id, name, job, birth) VALUES(1003, 'donna', 'MANAGER','89-01-01');

UPDATE myemp set salary = 8500 WHERE name = 'rose';
SELECT * FROM myemp;
UPDATE myemp SET salary = 6500 , job = 'ANALYST' WHERE id = '1003';
DELETE FROM myemp WHERE job is NULL;
DELETE FROM myemp WHERE name = 'rose';
SELECT * FROM myemp;

create table ACCOUNT
(
  ID              NUMERIC(9) not null,
  RECOMMENDER_ID  NUMERIC(9),
  LOGIN_NAME      VARCHAR(30) not null,
  LOGIN_PASSWD    VARCHAR(8) not null,
  STATUS          CHAR(1),
  CREATE_DATE     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PAUSE_DATE      DATE,
  CLOSE_DATE      DATE,
  REAL_NAME       VARCHAR(20) not null,
  IDCARD_NO       CHAR(18) not null,
  BIRTHDATE       DATE,
  GENDER          CHAR(1),
  OCCUPATION      VARCHAR(50),
  TELEPHONE       VARCHAR(15) not null,
  EMAIL           VARCHAR(50),
  MAILADDRESS     VARCHAR(50),
  ZIPCODE         CHAR(6),
  QQ              VARCHAR(15),
  LAST_LOGIN_TIME DATE,
  LAST_LOGIN_IP   VARCHAR(15)
);
DESC account;

RENAME TABLE account TO t_account;
ALTER TABLE t_account ADD bak VARCHAR(50);
ALTER TABLE t_account MODIFY bak VARCHAR(40) DEFAULT 'login';
DESC t_account;

ALTER TABLE t_account DROP bak;
DESC t_account;
INSERT INTO T_ACCOUNT(ID,LOGIN_NAME,LOGIN_PASSWD,CREATE_DATE,     REAL_NAME,IDCARD_NO,TELEPHONE) VALUES(1,'shiyl','256528','08-01-28','shiyuanli','410381194302256523',13669351234);
SELECT * FROM t_account;
UPDATE t_account SET login_passwd = '801206' WHERE id = 1;
DELETE FROM t_account WHERE id = 1;
SELECT * FROM t_account;

CREATE TABLE dept (
    deptno NUMERIC(2),
    dname VARCHAR(14),
    loc VARCHAR(13)
);
CREATE TABLE emp(empno NUMERIC(4), ename VARCHAR(10), job VARCHAR(9), mgr NUMERIC(4), hiredate DATE, sal NUMERIC(7, 2), comm NUMERIC(7, 2));
DESC emp;
DESC dept;

INSERT INTO dept VALUES    (10,'ACCOUNTING','NEW YORK');
INSERT INTO dept VALUES   (20,'RESEARCH','DALLAS');
INSERT INTO dept VALUES    (30,'SALES','CHICAGO');
INSERT INTO dept VALUES    (40,'OPERATIONS','BOSTON');
SELECT * FROM dept;

ALTER TABLE emp ADD deptno VARCHAR(2);

INSERT INTO emp VALUES(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp VALUES(7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30);
INSERT INTO emp VALUES(7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30);
INSERT INTO emp VALUES(7566,'JONES','MANAGER',7839,'1981-4-2',2975,NULL,20);
INSERT INTO emp VALUES(7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30);
INSERT INTO emp VALUES(7698,'BLAKE','MANAGER',7839,'1981-5-1',2850,NULL,30);
INSERT INTO emp VALUES(7782,'CLARK','MANAGER',7839,'1981-9-6',2450,NULL,10);
INSERT INTO emp VALUES(7788,'SCOTT','ANALYST',7566,'87-4-19',3000,NULL,20);
INSERT INTO emp VALUES(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp VALUES(7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30);
INSERT INTO emp VALUES(7876,'ADAMS','CLERK',7788,'87-5-23',1100,NULL,20);
INSERT INTO emp VALUES(7900,'JAMES','CLERK',7698,'1981-12-3',950,NULL,30);
INSERT INTO emp VALUES(7902,'FORD','ANALYST',7566,'1981-3-12',3000,NULL,20);
INSERT INTO emp VALUES(7934,'MILLER','CLERK',7782,'1982-1-23',1300,NULL,10);
SELECT * FROM emp;
TRUNCATE TABLE emp; -- 整体清空表中数据，速度快，与 delete * from table_name 区别是 delete 是逐条删除。

SELECT hiredate FROM emp order by hiredate;
SELECT ename, sal FROM emp WHERE sal > 1600;
SELECT ename, deptno FROM emp WHERE empno = 7369;
SELECT ename, sal FROM emp WHERE sal NOT BETWEEN 4000 AND 5000;
SELECT ename FROM emp WHERE deptno IS NULL;
SELECT * FROM emp;

SELECT ename, sal + nvl(comm, 0) * 0.8 money FROM emp ORDER BY money; -- nvl(comm, 0) oracle中的聚合函数，如果第一个参数为null，则会返回第二个参数
SELECT ename, sal+IFNULL(comm, 0)*0.8 money FROM emp ORDER BY money;
SELECT job, MAX(sal), MIN(sal), AVG(sal), SUM(sal) FROM emp GROUP BY job;
SELECT job, COUNT(*) FROM emp GROUP BY job;
SELECT MAX(sal)-MIN(sal) "DIFFERENCE" FROM emp;
-- 查询各个管理者属下员工的最低工资，其中最低工资不能低于800，且没有管理者的员工不计算在内

SELECT mgr, MIN(sal) FROM emp WHERE mgr IS NOT NULL GROUP BY mgr;
SELECT mgr, MIN(sal) FROM emp WHERE mgr IS NOT NULL GROUP BY mgr HAVING min(sal) >= 900;
SELECT mgr, MIN(sal) FROM emp WHERE mgr IS NOT NULL AND MIN(sal)>= 900 GROUP BY mgr ;

SELECT deptno, count(*) FROM emp WHERE sal>1500 GROUP BY deptno;
SELECT deptno, AVG(IFNULL(comm, 0)) avg_comm FROM emp GROUP BY deptno;
SELECT ename, dname, loc FROM emp e JOIN dept d ON e.deptno = d.deptno;
SELECT e1.ename, e2.ename mgr_name FROM emp e1 JOIN emp e2 ON e1.mgr = e2.empno;
SELECT e.empno, e.ename, d.deptno, d.dname, d.loc FROM emp e LEFT JOIN dept d ON e.deptno = d.deptno;

SELECT e.empno, e.ename, d.deptno, d.dname, d.loc FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno;
SELECT e.empno, e.ename, d.deptno, d.dname, d.loc FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno WHERE e.empno IS NULL;
SELECT DISTINCT e.job FROM emp e,dept d WHERE e.deptno = d.deptno AND d.dname = 'SALES';

-- 查询所有部门的名称、所在地、员工数量以及平均工资
SELECT d.dname, d.loc, COUNT(e.empno) AS "EMP_COUNT", AVG(e.sal) AS "SAL_AVG" FROM emp e, dept d WHERE e.deptno = d.deptno GROUP BY d.deptno;

SELECT deptno, COUNT(*) AS "EMP_COUNT", AVG(sal) AS "SAL_AVG" FROM emp GROUP BY deptno ;

SELECT
    d.dname,
    d.loc,
    e.EMP_COUNT,
    e.SAL_AVG 
FROM
    dept d
    JOIN ( SELECT deptno, COUNT(*) AS "EMP_COUNT", AVG(sal) AS "SAL_AVG" FROM emp GROUP BY deptno) e 
WHERE
    d.deptno = e.deptno;
    
    
SELECT e1.ename, e2.ename FROM emp e1, emp e2 WHERE e1.mgr = e2.empno;  -- 查询每个员工的上级管理者
SELECT e1.ename, e2.ename FROM emp e1, emp e2 WHERE e1.empno = e2.mgr;  -- 查询每个管理者的下级员工

SELECT e.ename, e.deptno, d.dname FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno WHERE d.deptno = 20 OR d.deptno = 30;
SELECT ename, deptno FROM emp WHERE deptno IN (20,30);
SELECT * FROM emp;

SELECT ename, job FROM emp WHERE sal > AVG(sal); -- Invalid use of group function WHERE 子句中不可用使用聚合函数，因为聚合函数是基于结果的，WHERE 子句是正在确定结果集。
SELECT ename, job FROM emp WHERE sal > (SELECT AVG(sal) FROM emp);

SELECT ename, job FROM emp WHERE mgr IS NULL ORDER BY job;

SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL ORDER BY sal DESC;

SELECT ename FROM emp WHERE ename LIKE '__A%';  -- 查询名字中第三个字母是A 的员工

SELECT ename ||','|| job ||','|| sal OUT_PUT FROM emp ; -- ORACLE 中可用
SELECT CONCAT(ename, ',', job, ',', sal) AS OUT_PUT FROM emp;
SELECT empno, ename, sal, sal * 1.2 FROM emp;
SELECT ename, sal FROM emp WHERE sal >= 1200 ORDER BY hiredate;
DESC emp;
SELECT deptno, dname, loc FROM dept WHERE NOT dname = "ACCOUNT";
SELECT deptno, dname, loc FROM dept WHERE dname<> "ACCOUNTING";

SELECT ename, MAX(sal) FROM emp GROUP BY deptno;
SELECT a.ename, a.sal, a.deptno, b.maxsal FROM emp a ,(SELECT deptno, MAX(sal) maxsal FROM emp GROUP BY deptno) b WHERE a.deptno = b.deptno AND a.sal < b.maxsal ORDER BY deptno;

-- 每个部门的平均工资
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
-- 每个部门中比平均工资高的员工
SELECT a.ename, a.deptno, a.sal, b.avgsal FROM emp a, (SELECT deptno, AVG(sal) avgsal FROM emp GROUP BY deptno) b WHERE a.deptno = b.deptno AND a.sal > b.avgsal ORDER BY a.deptno;

-- 找出工资比所在部门管理者工资高的员工（同一个管理者的员工属于同一个部门）
SELECT a.ename, a.sal, a.mgr FROM emp a, (SELECT empno, sal FROM emp ) b WHERE a.mgr = b.empno AND a.sal > b. sal ;
SELECT * FROM emp e1, emp e2 WHERE e1.mgr = e2.empno AND e1.sal > e2.sal;

RENAME TABLE student TO student1;
CREATE TABLE student(
    id NUMERIC(4),
    name VARCHAR(30),
    subject VARCHAR(30),
    score NUMERIC(8, 2),
    classid NUMERIC(2)
);

-- 查询每班中每个科目最高成绩
SELECT classid, subject, MAX(score) FROM student GROUP BY classid, subject;

-- 查找所有薪水高于平均薪水值的员工信息
SELECT a.empno, a.ename, a.sal, a.deptno, b.avgsal FROM emp a, (SELECT AVG(sal) avgsal FROM emp ) b WHERE a.sal > b.avgsal;
SELECT * FROM emp WHERE sal > (SELECT AVG(sal) FROM emp );

-- 查询每门课程成绩都大于80分的学生信息
SELECT name, subject, score FROM student WHERE (SELECT MIN(score) FROM student GROUP BY name ) > 80 GROUP BY name;
SELECT * FROM student WHERE name NOT IN (SELECT DISTINCT name FROM student WHERE score < 80);

CREATE TABLE userlist(
    telephone VARCHAR(10) COMMENT '主键，电话号',
    account VARCHAR(10) COMMENT '账号',
    rent NUMERIC(10, 2) COMMENT '费用'
);
CREATE TABLE charge(
    telephone VARCHAR(10) COMMENT '电话号',
    fee01 NUMERIC(10, 2) ,
    fee02 NUMERIC(10, 2),
    fee03 NUMERIC(10, 2),
    fee04 NUMERIC(10, 2)
) COMMENT="费用表";
INSERT INTO userlist VALUES('4210001', 'AAAA', 19.50);
INSERT INTO userlist VALUES('4210002', 'AAAA', 20.50);
INSERT INTO userlist VALUES('4210003', 'BBBB', 100.00);
INSERT INTO userlist VALUES('4210004', 'CCCC', 250.00);
SELECT * FROM userlist;
INSERT INTO charge VALUES('4210001', 11.00, 12.00, 13.00, 14.00);
INSERT INTO charge VALUES('4210002', 21.00, 22.00, 23.00, 24.00);
INSERT INTO charge VALUES('4210003',31.00, 32.00, 33.00, 34.00);
SELECT * FROM charge;
DELETE FROM charge WHERE telephone IS NULL;

SELECT a.account, COUNT(a.account), IFNULL(SUM(a.rent), 0), IFNULL(SUM(b.fee01), 0), IFNULL(SUM(B.fee02), 0), IFNULL(SUM(b.fee03), 0), IFNULL(SUM(b.fee04), 0) FROM userlist a LEFT JOIN charge b ON a.telephone = b.telephone GROUP BY a.account;

CREATE TABLE taxgrade(
    taxmin NUMERIC(10, 2),
    taxmax NUMERIC(10, 2),
    grade NUMERIC(10) COMMENT "级别"
) COMMENT="税别表";
INSERT INTO taxgrade VALUES(0, 500, 1);
INSERT INTO taxgrade VALUES(500, 1000, 2);
INSERT INTO taxgrade VALUES(1000, 2000, 3);
INSERT INTO taxgrade VALUES(2000, 5000, 4);
INSERT INTO taxgrade VALUES(5000, 10000, 5);
SELECT * FROM taxgrade;
CREATE TABLE empe(
    empname VARCHAR(10),
    empno NUMERIC(10),
    sal NUMERIC(10, 2)
);
INSERT INTO empe VALUES('mary', 1, 450);
INSERT INTO empe VALUES('john', 2, 800);
INSERT INTO empe VALUES('jerry', 3, 1250);
INSERT INTO empe VALUES('kate', 4, 200);
INSERT INTO empe VALUES('neo', 5, 5750);
SELECT * FROM empe;
-- 查询编号为1的员工的税别
SELECT sal FROM empe WHERE empno = 1;
SELECT grade FROM taxgrade WHERE taxmin < (SELECT sal FROM empe WHERE empno = 1) < taxmax; -- 错误，查询出所有的 grade
SELECT grade FROM taxgrade WHERE taxmin < (SELECT sal FROM empe WHERE empno = 1) && (SELECT sal FROM empe WHERE empno = 1) < taxmax; -- ok 
SELECT e.empname, e.empno, e.sal, t.grade FROM empe e JOIN taxgrade t ON e.sal BETWEEN t.taxmin AND t.taxmax;

CREATE TABLE student2(
    sno VARCHAR(5),
    sname VARCHAR(20),
    ssex CHAR(2),
    sage NUMERIC(2),
    sdept VARCHAR(20)
);
CREATE TABLE course(
    cno VARCHAR(20),
    cname VARCHAR(20)
) COMMENT = "课程表";
CREATE TABLE sc(
    sno VARCHAR(5) COMMENT "学号",
    cno VARCHAR(20) COMMENT "课程号",
    grade NUMERIC(2) COMMENT "成绩等级"
) COMMENT = '成绩表';
-- 查询选修了‘计算机原理’的学生学号和姓名
SELECT s.sno, s.sname FROM student2 s, course c, sc sc WHERE sc.cno = c.cno AND c.cname = '计算机原理';
SELECT s.sno, s.sname FROM student2 s JOIN sc sc ON s.sno = sc.sno JOIN course c ON c.cno = sc.cno WHERE c.cname = 'computer';
-- 查询‘周星驰’同学选修了的课程名称
SELECT c.cname FROM student2 s JOIN sc sc ON sc.sno = s.sno JOIN course c ON c.cno = sc.cno WHERE s.sname = '周星驰';

CREATE TABLE test(
    id NUMERIC(4),
    name VARCHAR(4),
    age NUMERIC(2),
    mgr NUMERIC(4) COMMENT '主管的id'
) COMMENT = '练习题4.6 测试表';
INSERT INTO test VALUES(106, 'A', 30, 104);
INSERT INTO test VALUES(109, 'B', 19, 104);
INSERT INTO test VALUES(104, 'C', 20, 111);
INSERT INTO test VALUES(107, 'D', 35, 109);
INSERT INTO test VALUES(112, 'E', 25, 120);
INSERT INTO test VALUES(119, 'F', 45, NULL);
SELECT * FROM test;
-- 查询所有年龄比主管年龄大的人的信息
SELECT * FROM test t , (SELECT t2.age FROM test t2 WHERE t2.mgr = t.id) t3 WHERE t.age > t3.t2.age ; -- 错误语法 
SELECT * FROM test t WHERE t.age > (SELECT m.age FROM test m WHERE m.id = t.mgr);
SELECT t.id, t.name, t.age, t.mgr, m.name, m.id, m.age FROM test t JOIN test m ON t.mgr = m.id WHERE t.age > m.age;
SELECT t.name FROM test t WHERE t.age > (SELECT m.age FROM test m WHERE m.id = t.mgr);

-- day03 EXERCISE 4.7
CREATE TABLE city(
    cityno VARCHAR(10),
    cityname VARCHAR(20),
    stateno VARCHAR(10) COMMENT '省份代码'
) COMMENT '城市信息表';
DESC CITY;
CREATE TABLE state(
    stateno VARCHAR(10),
    statename VARCHAR(20)
) COMMENT '省份信息表';
INSERT INTO city VALUES('BJ', '北京', 'null');
INSERT INTO city VALUES('SH', '上海', 'null');
INSERT INTO city VALUES('GZ', '广州', 'GD');
INSERT INTO city VALUES('DL', '大连', 'LN');
SELECT * FROM city;
INSERT INTO state VALUES('GD', '广东');
INSERT INTO state VALUES('LN', '辽宁');
INSERT INTO state VALUES('SD', '山东');
INSERT INTO state VALUES('NMG', '内蒙古');
SELECT * FROM state;
SELECT c.cityno, c.cityname, s.stateno, s.statename FROM city c LEFT JOIN state s ON c.stateno = s.stateno ORDER BY c.cityno;

-- day03 exercise 5
create table t_student(
student_id numeric(1) primary key,
class_id numeric(1),
student_name char(20)) COMMENT='学员表，记载学员的信息';
insert into t_student values(1,1,'刘一');
insert into t_student values(2,1,'陈二');
insert into t_student values(3,1,'张三');
insert into t_student values(4,1,'李四');
insert into t_student values(5,2,'王五');
insert into t_student values(6,2,'赵六');
CREATE TABLE t_assess_rule (
rule_id NUMERIC ( 1 ) PRIMARY KEY,
class_id NUMERIC ( 1 ),
assess_type CHAR ( 20 ),
scale NUMERIC ( 2 ),
desc1 CHAR ( 20 ) 
) COMMENT = '考核规则表，记载考核规则';
insert into  t_assess_rule values(1,1,'test_score',70,'成绩(固定)');
insert into  t_assess_rule values(2,1,'check_in',10,'考勤');
insert into  t_assess_rule values(3,1,'task_scale',10,'作业完成率');
insert into  t_assess_rule values(4,1,'task_score',10,'作业成绩');
insert into  t_assess_rule values(5,2,'test_score',70,'成绩(固定)');
insert into  t_assess_rule values(6,2,'check_in',15,'考勤');
insert into  t_assess_rule values(7,2,'task_scale',15,'作业完成率');
create table t_subject(
subject_id numeric(1) primary key,
subject_name char(10)
) COMMENT='科目表，记载学员的学习科目数据';
insert into  t_subject values(1,'语文');
insert into  t_subject values(2,'数学');
create table t_performance(
performance_id numeric(2) primary key ,
student_id numeric(1),
subject_id numeric(1),
test_score numeric(3),
check_in numeric(3),
task_scale numeric(3),
task_score numeric(3)
) COMMENT='学员成绩表，（注，各科的成绩计算方法根据考核规则中占有的比率计算）';
insert into t_performance values(1,1,1,90,100,100,90);
insert into t_performance values(2,1,2,67,100,100,78);
insert into t_performance values(3,2,1,71,100,100,80);
insert into t_performance values(4,2,2,100,100,100,95);
insert into t_performance values(5,3,1,85,100,100,90);
insert into t_performance values(6,3,2,88,100,100,90);
insert into t_performance values(7,4,1,81,100,100,90);
insert into t_performance values(8,4,2,78,100,100,88);
insert into t_performance values(9,5,1,63,95,100,66);
insert into t_performance values(10,5,2,87,95,100,90);
insert into t_performance values(11,6,1,84,91,100,82);
insert into t_performance values(12,6,2,72,91,100,70);

-- 如何算出一班(class_id=1)每个学生各科的成绩？
SELECT
    s.student_name,
    sub.subject_name,
    p.test_score 
FROM
    t_student s
    JOIN t_performance p ON s.student_id = p.student_id
    JOIN t_subject sub ON sub.subject_id = p.subject_id 
WHERE
    s.class_id = 1;
    


DESC t_assess_rule;

-- 请对一班(class_id=1)每个学生各科成绩的总分进行排序。
SELECT
    s.student_name,
    sum( p.test_score ) total_score 
FROM
    t_student s
    JOIN t_performance p ON s.student_id = p.student_id
    JOIN t_subject sub ON sub.subject_id = p.subject_id 
WHERE
    s.class_id = 1 
GROUP BY
    s.student_id,
    s.student_name 
ORDER BY
    total_score DESC;

-- 以上查询只是查询了每个学生的各科成绩中的 test_score 分数。并没有使用 t_assess_rule 表中的规则计算真正的各科成绩。



SELECT
    s.student_name,
    sub.subject_name,
    p.test_score / 100 * ( SELECT scale FROM t_assess_rule WHERE class_id = 1 AND assess_type = 'test_score' ) + p.check_in / 100 * ( SELECT scale FROM t_assess_rule WHERE class_id = 1 AND assess_type = 'check_in' ) + p.task_scale / 100 * ( SELECT scale FROM t_assess_rule WHERE class_id = 1 AND assess_type = 'task_scale' ) + p.task_score / 100 * ( SELECT scale FROM t_assess_rule WHERE class_id = 1 AND assess_type = 'task_score' ) totle_score 
FROM
    t_student s
    JOIN t_performance p ON s.student_id = p.student_id
    JOIN t_subject sub ON sub.subject_id = p.subject_id 
WHERE
    s.class_id = 1;
    
-- 查询平均工资最高的部门信息
SELECT deptno, MAX(SELECT AVG(sal) FROM emp GROUP BY deptno) FROM emp; -- 错误语法

SELECT MAX(AVG(sal)) FROM emp GROUP BY deptno; -- Invalid use of group function Orcale 可用
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
SELECT e.deptno, MAX(e.avg_sal) FROM (SELECT deptno, AVG(sal) avg_sal FROM emp GROUP BY deptno) e ; -- 错误
SELECT * FROM emp ORDER BY sal DESC; 
SELECT empno, ename, job, mgr, hiredate, MAX(sal), deptno FROM emp ; -- 错误
SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, AVG(e.sal), e.deptno FROM emp e,( SELECT MAX(e1.avg_sal) max_avg_sal FROM (SELECT AVG(sal) avg_sal, deptno FROM emp GROUP BY deptno) e1) e2 GROUP BY deptno HAVING AVG(e.sal) = e1.max_avg_sal; -- 错误

SELECT
    AVG( e.sal ),
    e.deptno 
FROM
    emp e,
    (SELECT AVG( sal ) avg_sal, deptno FROM emp GROUP BY deptno) ea1,
    (SELECT MAX(ea.avg_sal) ma FROM (SELECT AVG( sal ) avg_sal FROM emp GROUP BY deptno) ea) ea2
WHERE
    e.deptno = ea1.deptno AND ea1.avg_sal = ea2.ma
GROUP BY
    deptno ; -- 正确

SELECT MAX(ea.avg_sal) FROM (SELECT AVG( sal ) avg_sal FROM emp GROUP BY deptno) ea;

SELECT
    ea2.ma,
    ea1.deptno 
FROM
    (SELECT AVG( sal ) avg_sal, deptno FROM emp GROUP BY deptno) ea1,
    (SELECT MAX(ea.avg_sal) ma FROM (SELECT AVG( sal ) avg_sal, deptno FROM emp GROUP BY deptno) ea) ea2
WHERE
    ea1.deptno = ea.deptno AND ea1.avg_sal = ea2.ma
GROUP BY
    deptno ;
    
-- 列出各部门中工资最高的员工的信息
SELECT deptno, MAX(sal) FROM emp GROUP BY deptno;
SELECT ename, sal, deptno FROM emp WHERE (deptno, sal) IN (SELECT deptno, MAX(sal) FROM emp GROUP BY deptno) ORDER BY deptno;
SELECT * FROM emp ORDER BY deptno, sal DESC ;
-- 与上一条SQL不同的是，本条SQL 中的MAX函数基于原表原数据统计，而上一条则是基于 AVG 聚合函数统计。

-- 查询管理者是 KING 的员工的姓名和工资
SELECT ename, sal FROM emp WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');

-- 查询部门所在地为 NEW YORK 的部门的员工信息。
SELECT deptno FROM dept WHERE loc = 'NEW YORK'; -- 第一步先找出 NEW YORK 的 deptno
SELECT e.ename, e.sal, e.job, d.dname, d.deptno FROM emp e JOIN dept d ON e.deptno = d.deptno WHERE e.deptno = (SELECT deptno FROM dept WHERE loc = 'NEW YORK');
SELECT e.ename, e.sal, e.job, d.dname, d.deptno FROM emp e, dept d WHERE e.deptno = d.deptno AND e.deptno = (SELECT deptno FROM dept WHERE loc = 'NEW YORK');

-- 查询工资比公司平均工资高的所有员工信息
SELECT AVG(sal) FROM emp ; -- 先查询出公司的平均工资  2073.214286
SELECT e.ename, e.job, e.sal, e.deptno FROM emp e WHERE e.sal > (SELECT AVG(sal) FROM emp );

-- 查询姓名中包含字母 u 的员工在相同部门的员工信息
SELECT deptno FROM emp WHERE ename LIKE '%u%'; -- 使用 like 运算符查询姓名中包含 u 的员工的部门编号。 结果为：30，只有部门编号为30的部门中的员工名字含有 U ，替换为 A 则查询出所有部门。
SELECT empno, ename, job, sal, deptno FROM emp WHERE deptno IN (SELECT deptno FROM emp WHERE ename LIKE '%U%'); -- 将上条SQL查询结果作为 where 条件的值，当 emp 表中某条记录的 deptno 被包含在上条查询结果中，则符合要求。

-- 查询比本部门平均薪水低的员工信息
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno; -- 查询每个部门的平均工资
SELECT e.empno, e.ename, e.job, e.sal, e.deptno, ea.avg_sal
FROM emp e , (SELECT deptno, AVG(sal) avg_sal FROM emp GROUP BY deptno ) ea
WHERE e.deptno = ea.deptno AND e.sal < ea.avg_sal 
ORDER BY e.deptno;
SELECT empno, ename, sal, deptno FROM emp e WHERE sal < (SELECT AVG(sal) FROM emp b WHERE e.deptno = b.deptno) ORDER BY e.deptno;  -- 主查询与子查询中如何表示同一部门，为什么不需要 GROUP BY deptno 就可以分组求出部门平均工资？

-- 查询 emp 表前5条记录
SELECT * FROM emp WHERE rownum <= 5; -- Oracle 中可行。 MySQL 中语法错误 Unknown column 'rownum' in 'where clause'
SELECT * FROM emp;
SELECT * FROM emp e, (SELECT ROW_NUMBER() OVER() AS rowno, empno FROM emp) t WHERE t.rowno <= 5 AND e.empno = t.empno;
-- 查询工资最高的5名员工的信息
SELECT *, t.rowno FROM emp e, (SELECT row_number() OVER(ORDER BY sal DESC) AS rowno, empno FROM emp ) t WHERE t.rowno <= 5 AND e.empno = t.empno ORDER BY e.sal DESC;
SELECT * FROM emp ORDER BY sal DESC;
-- 查询第3-5条记录，无需排序
SELECT * FROM emp;
SELECT * FROM emp e JOIN (SELECT ROW_NUMBER() OVER() AS rowno, empno FROM emp) t ON t.empno = e.empno WHERE t.rowno >= 3 AND t.rowno <=5;
SELECT * FROM emp e JOIN (SELECT ROW_NUMBER() OVER() AS rowno, empno FROM emp) t ON e.empno = t.empno WHERE t.rowno BETWEEN 3 AND 5; -- between：在两值之间，  >=min&&<=max. AND:逻辑与。&：位运算，按位与。不能使用&。
select * from (select rownum num, e.* from emp e) where num >= 3 and num <= 5; -- Oracle 中用法

-- 查询公司工资最高的3个人
SELECT * FROM emp ORDER BY sal DESC; -- 按工资降序排列
SELECT * FROM (SELECT * FROM emp ORDER BY sal DESC) WHERE ROWNUM <= 3; -- Oracle 中用法。
SELECT * FROM emp e, (SELECT ROW_NUMBER() OVER(ORDER BY sal DESC) AS rowno, empno FROM emp) t WHERE t.rowno <= 5 AND t.empno = e.empno ORDER BY e.sal DESC;

-- 查询公司工资最低的5个人信息
SELECT * FROM emp ORDER BY sal;
SELECT * FROM emp e, (SELECT ROW_NUMBER() OVER(ORDER BY sal) AS rowno, empno FROM emp) t WHERE e.empno = t.empno AND t.rowno <= 5 ORDER BY e.sal;
SELECT * FROM (SELECT * FROM emp ORDER BY sal) WHERE rownum <= 5; -- Oracle 中用法

SELECT VERSION(); -- VERSION() 函数，显示当前 MySQL 版本号

-- 计算职位的人数，其中，“ANALYST”和“MANAGER”职位用“VIP”表示，其余是普通员工，职位用“OPERATION”显示。分别计算VIP职位和普通职员职位的人数
SELECT empno, ename, DECODE(job, 'ANALYST','VIP', 'MANAGER','VIP', 'OPERATION') JOB FROM emp; -- Oracle 中 DECODE() 函数用法
SELECT DECODE(job, 'ANALYST','VIP', 'MANAGER','VIP', 'OPERATION') job, COUNT(1) job_count FROM emp GROUP BY DECODE(job, 'ANALYST','VIP', 'MANAGER','VIP', 'OPERATION'); -- Oracle 中 DECODE() 函数用法

SELECT * FROM emp ORDER BY job;
SELECT empno, ename, IF((job IN ('ANALYST','MANAGER')), 'VIP', 'OPERATION') JOB FROM emp;
SELECT IF((job IN ('ANALYST','MANAGER')), 'VIP', 'OPERATION') JOB, COUNT(1) JOB_COUNT  FROM emp GROUP BY IF((job IN ('ANALYST','MANAGER')), 'VIP', 'OPERATION');
SELECT CASE job WHEN 'ANALYST' THEN 'VIP' WHEN 'MANAGER' THEN 'VIP' ELSE 'OPERATION' END AS JOB, COUNT(1) JOB_COUNT FROM emp GROUP BY CASE job WHEN 'ANALYST' THEN 'VIP' WHEN 'MANAGER' THEN 'VIP' ELSE 'OPERATION' END;
SELECT empno, ename, CASE job WHEN 'ANALYST' THEN 'VIP' WHEN 'MANAGER' THEN 'VIP' ELSE 'OPERATION' END AS JOB FROM emp;
SELECT empno, ename, CASE WHEN job IN ('ANALYST','MANAGER') THEN 'VIP' ELSE 'OPERATION' END AS JOB FROM emp;
SELECT CASE WHEN job IN ('ANALYST', 'MANAGER') THEN 'VIP' ELSE 'OPERATION' END AS JOB, COUNT(*) AS JOB_COUNT FROM emp GROUP BY CASE WHEN job IN ('ANALYST', 'MANAGER') THEN 'VIP' ELSE 'OPERATION' END; -- 不能忘记 END，否则会报错
SELECT 
    SUM(CASE WHEN job IN ('ANALYST','MANAGER') THEN 1 ELSE 0 END) AS VIP, 
    SUM(CASE WHEN job NOT IN ('ANALYST','MANAGER') THEN 1 ELSE 0 END ) AS OPERATION 
FROM emp;

-- 将dept 表中的数据按‘OPERATIONS’、‘ACCOUNTING’、‘SALES’ 进行自定义排序
SELECT deptno, dname, loc FROM dept ORDER BY DECODE(dname, 'OPERATIONS', 1, 'ACCOUNTING', 2, 'SALES', 3); -- Oracle 中用法
SELECT deptno, dname, loc FROM dept ORDER BY CASE dname WHEN 'OPERATIONS' THEN 1 WHEN 'ACCOUNTING' THEN 2 WHEN 'SALES' THEN 3 END ;
SELECT * FROM dept;

-- 使用 ROW_NUMBER 函数实现分组排序。 ROW_NUMBER函数计算的值就表示每组内部排序后的顺序编号，组内连续且唯一。
SELECT deptno, ename, empno, ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY empno) AS emp_id FROM emp; -- Oracle 中用法，MySQL 中同样可用
SELECT deptno, ename, empno, ROW_NUMBER() OVER( ORDER BY empno) AS emp_id FROM emp; -- 若没有 partition by(分割) 则不会按照 deptno 进行分组计算 empno，而是整表所有数据只计算一个行号序列。

-- 使用 RANK 函数实现分组排序
-- 将职员表中按照部门编码分组，同组内按薪水降序排列，相同薪水则按奖金数升序排列，并显示等级标识，用Rank_ID表示
SELECT deptno, ename, sal, comm, RANK() OVER(PARTITION BY deptno ORDER BY sal DESC, comm) 'Rank_ID' FROM emp; -- Oracle 与 MySQL 都可用
-- RANK 函数排序后的等级标识是跳跃的，即如果有相同的数据，则排名相同，比如并列第二，但下一位将是第四。

-- 使用 Dense_Rank 函数实现分组排序
-- DENSE_RANK函数排序后的等级标识是连续的，即如果有并列第二，下一个排序将是三
-- 关联emp和dept表，使用DENSE_RANK函数，按照部门编码分组，每组内按照员工薪水升序排列，列出员工的部门名字、姓名和薪水及等级drank
SELECT d.deptno, d.dname, e.ename, e.sal, DENSE_RANK() OVER(PARTITION BY e.deptno ORDER BY e.sal) AS drank FROM emp e JOIN dept d ON e.deptno = d.deptno ; -- Oracle MySQL 都可用。注意不能使用 rank 作为伪列名。

-- 使用 ROLLUP 函数统计 2010-2011年每月每日的销售额
-- 创建 sales_tab 表，该表存储了2010-2011年每月每日的销售额。并插入测试数据。
CREATE TABLE sales_tab(
    year_id NUMERIC(10) NOT NULL,
    month_id NUMERIC(10) NOT NULL,
    day_id NUMERIC(10) NOT NULL,
    sales_value NUMERIC(10,2) NOT NULL
);
INSERT INTO sales_tab 
    SELECT TRUNC(DBMS_RANDOM.VALUE(2010,2012)) AS year_id,
                 TRUNC(DBMS_RANDOM.VALUE(1, 13)) AS month_id,
                 TRUNC(DBMS_RANDOM, VALUE(1, 32)) AS day_id,
                 ROUND(DBMS_RANDOM, VALUE(1, 100), 2) AS sales_value
  FROM dual 
CONNECT BY level <= 1000; -- Oracle 中可用
SELECT * FROM dual; -- - No tables used
INSERT INTO sales_tab 
    SELECT TRUNCATE(2010 + RAND() * 3, 0) AS year_id,
                 TRUNCATE(1 + RAND() * 12, 0) AS month_id,
                 TRUNCATE(1 + RAND() * 32, 0) AS day_id,
                 TRUNCATE(1 + RAND() * 100, 2)  AS sales_value
  FROM dual 
CONNECT BY level <= 1000; -- MySQL 中暂时没有 CONNECT BY 的用法

SELECT CURRENT_USER(); -- 返回当前MySQL用户名：root@localhost
SELECT DATABASE(); -- 返回当前 MySQL 数据库名；lianxishujuku
SELECT dbms_random.VALUE FROM dual; -- Unknown table 'dbms_random' in field list
SELECT 2010 + TRUNCATE(RAND() * 3, 0); -- truncate(x, y) 直接截取小数点后y位的x

-- 使用存储过程，创建循环语句，执行 procedure 程序
DELIMITER $  -- 设定界定符从 ; 改为 $
CREATE PROCEDURE per() -- 创建匿名块
    BEGIN
    DECLARE i INT;
    SET i = 0;
    WHILE i < 1000 DO
        INSERT INTO sales_tab VALUES(TRUNCATE(2010 + RAND() * 3, 0), TRUNCATE(1 + RAND() * 12, 0), TRUNCATE(1 + RAND() * 32, 0), ROUND(1 + RAND() * 100, 2));
        SET i = i + 1;
        END WHILE;
    END $
DELIMITER ; -- 恢复隔离符为 ;
CALL per();  -- 调用匿名块，执行循环插入1000条数据
SELECT * FROM sales_tab;
SELECT COUNT(1) FROM sales_tab;

-- 使用ROLLUP函数统计2010-2011年每月每日的销售额
-- 对ROLLUP的列从右到左以一次少一列的方式进行分组直到所有列都去掉后的分组(也就是全表分组)。对于n个参数的ROLLUP，有n+1次分组。
SELECT year_id, month_id, day_id, SUM(sales_value) AS sales_values FROM sales_tab GROUP BY ROLLUP(year_id, month_id, day_id) ORDER BY year_id, month_id, day_id; -- Oracle 中可用
-- 上述SQL语句会依次按照（year_id, month_id, day_id）分组、（year_id, month_id）分组、（day_id）分组以及全表分组。
SELECT year_id, month_id, day_id, SUM(sales_value) AS sales_values FROM sales_tab GROUP BY year_id, month_id, day_id WITH ROLLUP ORDER BY year_id, month_id; -- MySQL 中可用用 WITH ROLLUP 替代 ROLLUP 函数。GROUP BY 后面不能加()，否则 Operand should contain 1 column(s)

-- 使用 CUBE 函数统计年月的销售额
-- GROUP BY CUBE(a, b, c) 对cube的每个参数，都可以理解为取值为参与分组和不参与分组两个值的一个维度，所有维度取值组合的集合就是分组后的集合。对于n个参数的cube，有2^n次分组。
-- 如果GROUP BY CUBE(a,b,c)，首先对(a,b,c)进行GROUP BY，然后依次是(a,b)，(a,c)，(a)，(b,c)，(b)，(c)，最后对全表进行GROUP BY操作，所以一共是2^3=8次分组。
-- 等价于 UNION ALL 所有分组组合查询结果。返回两个结果集中的所有行，包括重复的行。UNION 则不包含重复记录，且对结果排序。
-- MySQL 中 WITH ROLLUP 与 ORDER BY 冲突???MySQL 8.0 不冲突。
SELECT year_id, month_id, SUM(sales_value) AS sales_value FROM sales_tab GROUP BY CUBE(year_id, month_id) ORDER BY year_id, month_id; -- Oracle 中可用
-- 上述SQL语句会依次按照(year_id, month_id)分组、（year_id）分组、（month_id）分组以及全表分组。

-- 在 MySQL 中使用 UNION ALL 实现 CUBE 函数的效果。一共查询可得 52 条结果。
SELECT year_id, month_id, SUM(sales_value) AS sales_value FROM sales_tab GROUP BY year_id, month_id -- 36条结果，此处不能加 WITH ROLLUP,因为会整合第3,4条SQL的查询结果。
-- ORDER BY year_id, month_id 不能使用排序
UNION ALL
SELECT  NULL, month_id, SUM(sales_value) AS sales_value FROM sales_tab GROUP BY month_id -- 12条结果，按月份分组总计
-- ORDER BY month_id
UNION ALL
SELECT year_id, NULL, SUM(sales_value) AS sales_value FROM sales_tab GROUP BY year_id -- 3条结果，按年度分组总计
UNION ALL
SELECT NULL, NULL, SUM(sales_value) AS sales_value FROM sales_tab; -- 1条结果，共计

-- 使用GROUPING SETS函数统计年月的销售额
SELECT year_id, month_id, SUM(sales_value) FROM sales_tab GROUP BY GROUPING SETS((year_id), (month_id)) ORDER BY 1, 2; -- Oracle 中可用，该SQL语句会依次按照(year_id)分组、(month_id)分组。
SELECT year_id, month_id, SUM(sales_value) FROM sales_tab GROUP BY year_id, month_id ORDER BY year_id, month_id; -- 36条记录
SELECT year_id, month_id, SUM(sales_value) FROM sales_tab GROUP BY year_id, month_id WITH ROLLUP ORDER BY year_id, month_id; -- 40条记录，多了(a,null)*3,(null,b),(null,null)*1 4条记录。
SELECT null, month_id, SUM(sales_value) FROM sales_tab GROUP BY month_id ORDER BY  month_id; -- 12条记录
SELECT year_id, null, SUM(sales_value) FROM sales_tab GROUP BY year_id ORDER BY year_id; -- 3条记录
SELECT null, null, SUM(sales_values) FROM sales_tab; -- 1条记录

create table mygroup (
group_id NUMERIC(4),
job varchar(10), 
name varchar(10), 
salary NUMERIC(10,2)
);
insert into mygroup values (10,'Coding',    'Bruce',1000);
insert into mygroup values (10,'Programmer','Clair',1000);
insert into mygroup values (10,'Architect', 'Gideon',1000);
insert into mygroup values (10,'Director',  'Hill',1000);
insert into mygroup values (20,'Coding',    'Jason',2000);
insert into mygroup values (20,'Programmer','Joey',2000);
insert into mygroup values (20,'Architect', 'Martin',2000);
insert into mygroup values (20,'Director',  'Michael',2000);
insert into mygroup values (30,'Coding',    'Rebecca',3000);
insert into mygroup values (30,'Programmer','Rex',3000);
insert into mygroup values (30,'Architect', 'Richard',3000);
insert into mygroup values (30,'Director',  'Sabrina',3000);
insert into mygroup values (40,'Coding',    'Samuel',4000);
insert into mygroup values (40,'Programmer','Susy',4000);
insert into mygroup values (40,'Architect', 'Tina',4000);
insert into mygroup values (40,'Director',  'Wendy',4000);
SELECT * FROM mygroup;

DESC student;
SELECT * FROM student;
INSERT INTO student VALUES(1001, 'marry', '',55.0, 101);
INSERT INTO student VALUES(1002, 'jerry', '',66.0, 101);
INSERT INTO student VALUES(1003, 'tom', '',74.0, 101);
INSERT INTO student VALUES(1004, 'jim', '',88.0, 90);
INSERT INTO student VALUES(1005, 'allen', '',100.0, 90);
INSERT INTO student VALUES(1006, 'terry', '',66, 101);
DESC class;
CREATE TABLE class(
    cid NUMERIC(4, 0) COMMENT '专业编码',
    cname VARCHAR(20) COMMENT '专业名称'    
);
INSERT INTO class VALUES(101, 'JAVA');
INSERT INTO class VALUES(90, 'PHP');
SELECT * FROM class;


-- day04 EXERCISE
-- 查询 SALES 部门有哪些职位
SELECT DISTINCT job FROM emp WHERE deptno = (SELECT deptno FROM dept WHERE dname = 'SALES');
-- 哪些人不是别人的经理
SELECT ename FROM emp a WHERE NOT EXISTS (SELECT 1 FROM emp WHERE mgr = a.empno); -- 关联子查询方式实现
SELECT ename FROM emp WHERE empno NOT IN (SELECT DISTINCT mgr FROM emp WHERE mgr IS NOT NULL); -- 普通子查询方式实现
-- 谁的薪水比FORD高，如果有多个同名，比任何一个叫FORD的人高就行。
SELECT ename, sal FROM emp WHERE sal > (SELECT MIN(sal) FROM emp WHERE ename = 'FORD');
SELECT ename, sal FROM emp WHERE sal > ANY(SELECT sal FROM emp WHERE ename = 'FORD');
-- 谁和FORD同部门，列出除了FORD之外的员工名字。
SELECT ename, deptno FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'FORD') AND ename <> 'FORD'; 
-- 哪个部门的人数比部门20的人数多
SELECT deptno, COUNT(*) FROM emp GROUP BY deptno HAVING COUNT(*) > (SELECT COUNT(*) FROM emp WHERE deptno = 20);
-- 查询‘部门平均薪水’大于2000的部门下的员工信息
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno; -- 各部门平均工资
SELECT deptno FROM (SELECT deptno, AVG(sal) avg_sal FROM emp GROUP BY deptno) a WHERE a.avg_sal > 2000; -- 部门平均工资大于2000的部门编号
SELECT * FROM emp e WHERE deptno IN (SELECT deptno FROM (SELECT deptno, AVG(sal) avg_sal FROM emp GROUP BY deptno) a WHERE a.avg_sal > 2000);
SELECT ename, job, deptno FROM emp WHERE deptno IN (SELECT deptno FROM emp GROUP BY deptno HAVING avg(nvl(sal, 0)) > 2000); -- Oracle 中用法，MySQL 中提示 FUNCTION lianxishujuku.nvl does not exist
SELECT ename, job, deptno FROM emp WHERE deptno IN (SELECT deptno FROM emp GROUP BY deptno HAVING avg(IFNULL(sal, 0)) > 2000);

-- 创建测试表 news
CREATE TABLE news(
    id NUMERIC(6) NOT NULL,
    title VARCHAR(200),
    content VARCHAR(1000),
    occurtime DATE
);
DESC news;

DROP PROCEDURE IF EXISTS per_news; -- 若存储过程已经存在，则删除
DELIMITER $  -- 设定界定符从 ; 改为 $
CREATE PROCEDURE per_news() -- 创建存储过程
    BEGIN
    DECLARE i INT;
    SET i = 1;
    WHILE i <= 100 DO
        INSERT INTO news VALUES(i , CONCAT('TITLE', i), 'content', concat( CONCAT(FLOOR(2020 + (RAND() * 1)),'-',LPAD(FLOOR(10 + (RAND() * 2)),2,0),'-',LPAD(FLOOR(1 + (RAND() * 25)),2,0))));
        SET i = i + 1;
        END WHILE;
    END $
DELIMITER ; -- 恢复隔离符为 ;
CALL per_news();
SELECT * FROM news;
DELETE FROM news;

select concat( CONCAT(FLOOR(2020 + (RAND() * 1)),'-',LPAD(FLOOR(10 + (RAND() * 2)),2,0),'-',LPAD(FLOOR(1 + (RAND() * 25)),2,0))) date;

-- 按新闻时间倒序排列，每页输出5条，查询出第二页(6-10)
SELECT * FROM (SELECT a.*, ROWNUM RN FROM (SELECT * FROM news ORDER BY occurtime DESC) a) WHERE ROWNUM <= 10) WHERE RN >= 6; -- Oracle 中可用
SELECT * FROM news n JOIN (SELECT ROW_NUMBER() OVER() AS rn, id FROM news ORDER BY occurtime DESC) a ON a.id = n.id WHERE a.rn BETWEEN 6 AND 10 ORDER BY occurtime DESC;

SELECT ename, job, DECODE(job, 'PRESIDENT', 'A', 'MANAGER','B', 'ANALYST','C', 'SALESMAN','D', 'CLERK','E' ) AS 'Grade' FROM emp; -- Oracle 中可用
SELECT ename, job, CASE job 
                                                WHEN 'PRESIDENT' THEN 'A' 
                                                WHEN 'MANAGER' THEN 'B' 
                                                WHEN 'ANALYST' THEN 'C' 
                                                WHEN 'SALESMAN' THEN 'D' 
                                                WHEN 'CLERK' THEN 'E' 
                                        END 
                                        AS Grade FROM emp ORDER BY Grade;
                                        
-- student表中按照专业分组，同专业内按成绩倒序排序，成绩相同则按学号正序排序，并给予组内等级，用Rank_ID表示。
DESC student;
SELECT * FROM student;
SELECT *, RANK() OVER(PARTITION BY classid ORDER BY score DESC, id) AS Rank_ID FROM student ;
SELECT id, name, score, classid, RANK() OVER(PARTITION BY classid ORDER BY score DESC, id) AS 'Rank_ID' FROM student; -- RANK()OVER() 跳跃排序，与 ROW_NUMBER 区别是结果有重复值。
-- 按照class_id分组，每组内按照学生成绩倒序排序，相同成绩按照学号正序排列，列出学生所在的专业名字、学生姓名、成绩及等级drank。
SELECT * FROM class;
SELECT c.cid, c.cname, s.id, s.name, s.score, RANK() OVER(PARTITION BY s.classid ORDER BY s.score DESC, s.id) AS Rank_ID FROM student s JOIN class c ON s.classid = c.cid;

-- mygroup 表
-- 统计各组工资的和以及工资总和，要求用 rollup 函数完成。
SELECT * FROM mygroup; -- 16条数据
SELECT group_id, COUNT(1) FROM mygroup GROUP BY group_id; -- 4个部门各4条数据
SELECT job, COUNT(1) FROM mygroup GROUP BY job; -- 4种job 各4条数据
SELECT SUM(salary) sum_sal, group_id FROM mygroup GROUP BY group_id WITH ROLLUP;
-- 分别按照 (group_id, job)、(group_id)、(job) 以及全表统计工资和，要求使用 CUBE
SELECT group_id, job, SUM(salary) AS total_salary FROM mygroup GROUP BY CUBE(group_id, job) ORDER BY group_id, job; -- Oracle 中可用
SELECT group_id, job, SUM(salary) AS total_salary FROM mygroup GROUP BY group_id, job 
UNION ALL
SELECT group_id, null, SUM(salary) AS total_salary FROM mygroup GROUP BY group_id
UNION ALL
SELECT null, job, SUM(salary) AS total_salary FROM mygroup GROUP BY job
UNION ALL
SELECT null, null, SUM(salary) AS total_salary FROM mygroup; -- 16+9条结果

-- 分别按(group_id)、(job) 统计工资和，要求使用 GROUPING SETS 函数来完成
SELECT group_id, job, SUM(salary) AS total_salary FROM mygroup GROUP BY GROUPING SETS((group_id), (job)) ORDER BY 1, 2; -- Oracle 中可用
SELECT group_id, null, SUM(salary) AS total_salary FROM mygroup GROUP BY group_id
UNION ALL
SELECT null, job, SUM(salary) AS total_salary FROM mygroup GROUP BY job
UNION ALL
SELECT null, null, SUM(salary) AS total_salary FROM mygroup; -- 9条结果

CREATE VIEW v_student_101 AS SELECT * FROM student WHERE classid = 101;
SELECT * FROM student ;
SELECT * FROM v_student_101;

DESC student;
INSERT INTO v_student_101( id, name, score, classid) VALUES(1234, 'rose', 90, 101);
CREATE VIEW v_student AS (SELECT classid, AVG(score) avg_score FROM student GROUP BY classid UNION SELECT null, AVG(score) avg_score FROM student);
SELECT * FROM v_student;
DROP VIEW v_student; -- 删除视图
UPDATE v_student SET avg_score = 80 WHERE classid = 101; --  The target table v_student of the UPDATE is not updatable 复杂视图不允许 DML 操作。

CREATE VIEW v_stu AS SELECT classid, AVG(score) avg_score, COUNT(*) cnt FROM student GROUP BY classid;
SELECT * FROM v_stu;
UPDATE student SET classid = null WHERE id = 1234;
SELECT * FROM student;
DROP VIEW v_student;
DROP VIEW v_stu;

-- Oracle 中序列的应用
CREATE SEQUENCE emp_seq START WITH 100 INCREMENT BY 10;
SELECT emp_seq.NEXTVAL FROM DUAL;
INSERT INTO emp(empno, ename) VALUES(emp_seq.NEXTVAL, 'donna');
SELECT empno, ename FROM emp WHERE ename = 'donna';
SELECT emp_seq.CURRVAL FROM DUAL;
INSERT INTO emp(empno, ename) VALUES(emp_seq.NEXTVAL, 'donna');
SELECT empno, ename FROM emp;
DESC emp;
SELECT * FROM empe;

-- MySQL 中的序列 AUTO_INCREMENT
CREATE TABLE insect
    (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id),
    name VARCHAR(30) NOT NULL, # type of insect
    date DATE NOT NULL, # date collected
    origin VARCHAR(30) NOT NULL # where collected
);
SELECT * FROM insect;
INSERT INTO insect(id, name, date, origin) VALUES
    (NULL,'housefly','2001-08-01','kitchen'),
    (NULL,'millipede','2001-09-10','driveway'),
    (NULL,'grasshopper','2001-09-10','front yard');
SELECT LAST_INSERT_ID(); -- 1, 假如你使用单INSERT语句插入多个行，  LAST_INSERT_ID() 只返回插入的第一行产生的值。其原因是这使依靠其它服务器复制同样的 INSERT语句变得简单。 

CREATE TABLE emp1(
    empno NUMERIC(4) NOT NULL AUTO_INCREMENT,
    ename VARCHAR(10),
    job VARCHAR(10),
    mrg NUMERIC(4),
    hiredate DATE,
    sal NUMERIC(7, 2),
    comm NUMERIC(7, 2),
    deptno VARCHAR(2)
);
DESC emp1;
DROP TABLE emp1;









