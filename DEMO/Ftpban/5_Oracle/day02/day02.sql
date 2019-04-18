CREATE TABLE emp(
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2)
);
CREATE TABLE dept(
  deptno NUMBER(2),
  dname VARCHAR2(14),
  loc VARCHAR2(13)
);
INSERT INTO dept VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO dept VALUES(20,'RESEARCH','DALLAS');
INSERT INTO dept VALUES(30,'SALES','CHICAGO');
INSERT INTO dept VALUES(40,'OPERATIONS','BOSTON');
INSERT INTO emp VALUES(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO emp VALUES(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO emp VALUES(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO emp VALUES(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO emp VALUES(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO emp VALUES(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO emp VALUES(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO emp VALUES(7788,'SCOTT','ANALYST',7566,to_date('19-4-87','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO emp VALUES(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO emp VALUES(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO emp VALUES(7876,'ADAMS','CLERK',7788,to_date('23-5-87','dd-mm-yyyy'),1100,NULL,20);
INSERT INTO emp VALUES(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO emp VALUES(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO emp VALUES(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);





SELECT * FROM emp
SELECT * FROM dept


��ѯָ���е���Ϣ
SELECT ename,job,sal,deptno
FROM emp

SELECT�Ӿ��п���ֱ��ָ���ֶ�����
Ҳ����ָ��һ��������Ȼ��Ὣ�ú���
�Ľ����Ϊ��һ�е�ֵ��ʾ:
CONCAT����,����ƴ���ַ�����

SELECT 
 CONCAT(CONCAT(ename,':'),sal)
FROM emp

ƴ���ַ�����ʹ��"||"�����ӣ�����
SELECT ename||':'||sal
FROM emp


LENGTH()��������ѯ�ַ����ַ�����:
SELECT ename,LENGTH(ename)
FROM emp


DUAL:ORACLE�е�α��
��ʹ��SELECT����ѯ����ʱ���﷨Ҫ��
FROM�Ӿ�������Ҫ��һ�������������ǲ�
ѯ�����ݲ��������κ�һ�ű�ʱ������ʹ��
α��������ѯ�����ļ�¼ֻ����һ����¼��

UPPER,LOWER,INITCAP����:
����������ת��Ϊȫ��д��ȫСд������ĸ
��д��

����INITCAP���ԣ����ʼ����ʹ�ÿո��
������ôÿ����������ĸ�����д��

SELECT 
  UPPER('hello world'),
  LOWER('HELLO WORLD'),
  INITCAP('HELLO WORLD')
FROM dual



TRIM����:
ȥ���ַ������������������ظ���ָ��
�ַ���
SELECT 
  TRIM('e' FROM 'eeeeliteeee')
FROM dual

LTRIM,RTRIM
����ȥ���ַ�����������������

ȥ����ʽ:
ȥ�������Ҳ�ָ�����ַ����е������ַ���
ֱ��ָ�����ַ�����û�и��ַ�Ϊֹ��
SELECT 
 LTRIM('esddesddesdliteee','eds')
FROM dual

LPAD��RPAD��������λ����:
LPAD(char1,len,char2)
����char2�����ǵ�һ��һ���ַ���
����Ϊ:��ʾchar1���ݣ�Ҫ����ʾlen
λ�������㣬�����������ɸ�char2
�Դﵽ��λ���������������ȡchar1
���ݣ�ֻ��ʾlenλ��

RPAD����ʵ������룬��LPAD����ʵ��
�Ҷ���:
SELECT 
 ename,RPAD(sal,5,' ')
FROM emp 


SUBSTR����:
��ȡ�ַ����������ݣ���ָ���ַ�����
ָ���±괦��ʼ��������ȡָ�����ַ���

��java����:
1:���ݿ����±궼�Ǵ�1��ʼ��������0
2:��ȡ�����ַ��������������ǽ�ȡ��
  ʲôλ�á�

SUBSTR(str,m,n)
m:ָ��λ�ô���Ӧ��1��ʼ��
  ��Ҳ������0���߸�����
  ���Ǹ��������Ǵӵ���
  λ�ÿ�ʼ��ȡ��
  
n:��ȡ���ַ����ȣ���д����  ��ȡ��ĩ
  β�����������Խ�ȡ���ܳ��ȣ���Ҳ��
  ��ȡ��ĩβ��

SELECT 
  SUBSTR('thinking in java',-7,2)
FROM dual  


INSTR(char1,char2[,n,m])
�鿴char2��char1�е�λ��
n:�ӵڼ����ַ���ʼ����,Ĭ��Ϊ1
m:�ڼ��γ��֣�Ĭ��Ϊ1

����Ĵ���:
�鿴�ӵ�4���ַ���ʼ�󣬵ڶ��γ���
in��λ�á�
SELECT 
  INSTR('thinking in java',
        'in',4,2)
FROM
  dual

����ѯ����ָ�����ݷ���ֵΪ0��





ROUND��������������
�ڶ�������������������0��������
������ʾ����С��������λ��
0��ʾ����������λ��
������ʾ������С����ǰ��λ����
-1Ϊʮλ��-2Ϊ��λ��
SELECT ROUND(45.678, 2) 
FROM DUAL; 
SELECT ROUND(45.678, 0) 
FROM DUAL;
SELECT ROUND(45.678, -1) 
FROM DUAL;

TRUNC(n[,m])
��ȡ���֣�mĬ��Ϊ0����ROUND��������
�ڽ���ȡ���֣�������������:
SELECT TRUNC(45.678, 2) 
FROM DUAL; 
SELECT TRUNC(45.678, 0) 
FROM DUAL;
SELECT TRUNC(45.678, -1) 
FROM DUAL;

MOD(m,n)
��m����n,��������n��Ϊ0,��ֱ�ӷ���m
�鿴ÿ��Ա����λһ�µĹ������:
SELECT ename,sal,MOD(sal,1000)
FROM emp

CEIL(n)��FLOOR(n)
����n�����֣�ͨ����С����
CEIL:���ش��ڸ������ֵ���С����(����ȡ��)
FLOOR:����С�ڸ������ֵ��������(����ȡ��)

SELECT CEIL(45.678) FROM DUAL; --46?
SELECT FLOOR(45.678) FROM DUAL;--45


CREATE TABLE student (
  id NUMBER(4),
  name CHAR(20),
  registerDate DATE DEFAULT SYSDATE
);

INSERT INTO student
VALUES
(1,'JACK',SYSDATE)


SYSTIMESTAMP
��Ӧһ���ڲ���������ʾһ��ʱ�������
�ĵ�ǰϵͳʱ���ֵ��
SELECT SYSTIMESTAMP FROM dual

��������֮����ԱȽϴ�С��ʱ����Ĵ�
ʱ�����С��
����֮�������������������Ϊ����������
���ڿ��ԼӼ����֣���ͬ�ڼӼ�ָ����������

SELECT SYSDATE+1 FROM dual


SELECT ename,sal
FROM emp
WHERE sal>2500


TO_DATE()����
���԰��ո��������ڸ�ʽ�����������ַ���
��ת��Ϊһ��DATE���͵�ֵ���ء�
�鿴1981���Ժ���ְ��Ա��:
SELECT ename, hiredate 
FROM emp 
WHERE hiredate >
      TO_DATE('1981-01-01',
              'YYYY-MM-DD');


��дSQL���鿴������Ϊֹ�������˶�����?
SELECT 
  CEIL(
    SYSDATE-TO_DATE('1992-03-24',
                    'YYYY-MM-DD')
  )
FROM
  dual

�鿴ÿ��Ա��������Ϊֹ����ְ��������?
SELECT ename,TRUNC(SYSDATE-hiredate)
FROM emp

TO_CHAR()����
�����뽫һ�����ڰ��ո��������ڸ�ʽ
ת��Ϊ�ַ���

��ÿ��Ա������ְʱ��ת��ΪYYYY-MM-DD��
��ʽ:
SELECT 
  TO_CHAR(hiredate,'YYYY-MM-DD')
FROM
  emp

����RRָ��������:

SELECT 
  TO_CHAR(
    TO_DATE('95-12-21','RR-MM-DD'),
    'YYYY-MM-DD')    
FROM
  dual

��ϵͳʱ�����Ϊ:YYYY��MM��DD��
SELECT 
 TO_CHAR(SYSDATE,
         'YYYY"��"MM"��"DD"��"')
FROM 
 dual

���ڸ�ʽ�ַ����У�����ĸ��������
�����ַ�����Ҫʹ��˫������������


LAST_DAY(date)
�ú������ظ������������µ����һ��:
SELECT LAST_DAY(SYSDATE) 
FROM DUAL;

ADD_MONTHS(date,i)
�Ը������ڼ��ϸ������¡�
i�����ɸ����������Ǽ�ȥ��
�鿴ÿ��Ա����ְ20���������:
SELECT ename, 
  ADD_MONTHS(hiredate, 
             20 * 12)
FROM emp;


MONTHS_BETWEEN(date1,date2)
���ظ�����������������������
���������:date1-date2

�鿴ÿ��Ա���������˶��ٸ���?
SELECT 
  ename,
  MONTHS_BETWEEN(SYSDATE,
                 hiredate)
FROM
  emp



NEXT_DAY(date,i)
���ؾݸ�����������ģ���û�й����ܼ�?
1��ʾ���գ�7��ʾ����

SELECT 
  NEXT_DAY(SYSDATE, 4)
FROM DUAL;

LEAST,GREATEST����
�䳤���������Դ������������������һ��
���ɡ�
LEAST:���ز�������С��
GREATEST:���ز���������
SELECT 
 LEAST(SYSDATE, 
       TO_DATE('2008-10-10',
               'YYYY-MM-DD') 
      )         
FROM DUAL;

EXTRACT ����
������ȡһ��������ָ��ʱ�������Ӧ��ֵ:
SELECT 
 EXTRACT(YEAR FROM SYSDATE)
FROM DUAL;


SELECT ename,sal,hiredate
FROM emp
WHERE EXTRACT(YEAR FROM hiredate)=1987



CREATE TABLE student
    (id NUMBER(4), name CHAR(20), gender CHAR(1));

INSERT INTO student VALUES(1000, '��Ī��', 'F');

INSERT INTO student VALUES(1001, '��ƽ֮', NULL);

INSERT INTO student(id, name) VALUES(1002, '���޼�');

SELECT * FROM student

���ֶθ���ΪNULL:
UPDATE student
SET gender=NULL

�鿴�Ա�ΪNULL�Ķ���˭?
SELECT *
FROM student
WHERE gender IS NOT NULL

�ж�һ��ֵ�Ƿ�ΪNULL������ʹ��"="
��Ҫʹ��IS NULL��
�жϷǿ���IS NOT NULL


NULL���ַ���ƴ�ӣ�����ʲôҲû����
NULL���������㣬�������NULL��

�鿴ÿ��Ա��������(����+����):
SELECT ename,sal,comm,sal+comm
FROM emp

��ֵ����:
NVL(arg1,arg2)
��arg1ΪNULL����������arg2��ֵ��
���򷵻�arg1��
��˵���ǽ�NULLֵ�滻Ϊһ����NULLֵ

SELECT ename,sal,comm,
       sal+NVL(comm,0)
FROM emp


�鿴ÿ��Ա���Ľ���������н����
��ʾ"�н���"û�н������ʾ"û�н���"

NVL2(arg1,arg2,arg3)
��arg1��ΪNULLʱ����������arg2
��arg1ΪNULLʱ����������arg3

SELECT ename,comm,
       NVL2(comm,'�н���','û�н���')
FROM emp

NVL2���������������Ͳ����ڵ�һ��һ�¡�
ֻҪ������һ�¼��ɡ�


