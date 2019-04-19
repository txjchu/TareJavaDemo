CREATE TABLE emp ( 
				id NUMBER(4),
				name CHAR(10),
				age NUMBER(2),
				gender CHAR(4),
				salary NUMBER(6, 2)
				);
DESC emp;				
DROP TABLE emp;
INSERT INTO emp(id, name, age, gender, salary) VALUES(01, '张三', 22, '女', 2222.33);
SELECT * FROM emp;
SELECT LPAD('Aab', 5, '@') AS P1 , RPAD ( 'ABCD', 7, '$') AS P2 FROM DUAL;
SELECT SUBSTR ('ABCD EFG	HIGK', 5, 6) AS S1 FROM DUAL;
--INSTR子串在主字符串中的位置
SELECT INSTR('Doctor Who', 'Who') words FROM DUAL; 
SELECT SYSTIMESTAMP FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAMP, 'SSSS.FF') FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 10) "10周年" FROM DUAL; 
--抽取时间分量
SELECT EXTRACT( HOUR FROM TIMESTAMP '2008-08-08 10:10:10') TIME FROM DUAL;
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20)  NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
	salary NUMBER(6,2),
	comm NUMBER(6,2),
	job VARCHAR2(30),
	manager NUMBER(4),
	deptno NUMBER(2)
	);
SELECT * FROM employee;	
ALTER TABLE employee ADD(hiredate DATE DEFAULT sysdate);
ALTER TABLE employee MODIFY(job VARCHAR2(40) DEFAULT 'CLERK');
--?????DESC命令为什么不可以使用？
DESC TABLE employee;
RENAME employee TO myemp;
SELECT * FROM myemp;
SELECT * FROM emp_zyl;
DROP TABLE employees3;
SELECT * FROM COST;




 