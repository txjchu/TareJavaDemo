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


查询指定列的信息
SELECT ename,job,sal,deptno
FROM emp

SELECT子句中可以直接指定字段名，
也可以指定一个函数，然后会将该函数
的结果作为这一列的值显示:
CONCAT函数,用于拼接字符串。

SELECT 
 CONCAT(CONCAT(ename,':'),sal)
FROM emp

拼接字符串常使用"||"来连接，更简单
SELECT ename||':'||sal
FROM emp


LENGTH()函数，查询字符串字符个数:
SELECT ename,LENGTH(ename)
FROM emp


DUAL:ORACLE中的伪表
在使用SELECT语句查询内容时，语法要求
FROM子句后面必须要跟一个表名。当我们查
询的数据不来自于任何一张表时，可以使用
伪表，这样查询出来的记录只会有一条记录。

UPPER,LOWER,INITCAP函数:
将给定内容转换为全大写，全小写，首字母
大写。

对与INITCAP而言，单词间可以使用空格分
隔，那么每个单词首字母都会大写。

SELECT 
  UPPER('hello world'),
  LOWER('HELLO WORLD'),
  INITCAP('HELLO WORLD')
FROM dual



TRIM函数:
去除字符串中左右两边连续重复的指定
字符。
SELECT 
  TRIM('e' FROM 'eeeeliteeee')
FROM dual

LTRIM,RTRIM
单独去除字符串左面或右面的内容

去除方式:
去除左侧或右侧指定的字符串中的所有字符，
直到指定的字符串中没有该字符为止。
SELECT 
 LTRIM('esddesddesdliteee','eds')
FROM dual

LPAD，RPAD函数，补位函数:
LPAD(char1,len,char2)
其中char2必须是单一的一个字符，
作用为:显示char1内容，要求显示len
位，若不足，则左侧添加若干个char2
以达到该位数。若超过，则截取char1
内容，只显示len位。

RPAD可以实现左对齐，而LPAD可以实现
右对齐:
SELECT 
 ename,RPAD(sal,5,' ')
FROM emp 


SUBSTR函数:
截取字符串部分内容，从指定字符串的
指定下标处开始，连续截取指定个字符。

与java区分:
1:数据库中下标都是从1开始，而不是0
2:截取的是字符串个数，而不是截取到
  什么位置。

SUBSTR(str,m,n)
m:指定位置处，应从1开始，
  但也可以是0或者负数。
  若是负数，则是从倒数
  位置开始截取。
  
n:截取的字符长度，不写则是  截取到末
  尾，若超过可以截取的总长度，则也是
  截取到末尾。

SELECT 
  SUBSTR('thinking in java',-7,2)
FROM dual  


INSTR(char1,char2[,n,m])
查看char2在char1中的位置
n:从第几个字符开始检索,默认为1
m:第几次出现，默认为1

下面的代码:
查看从第4个字符开始后，第二次出现
in的位置。
SELECT 
  INSTR('thinking in java',
        'in',4,2)
FROM
  dual

若查询不到指定内容返回值为0。





ROUND函数，四舍五入
第二个参数可以是正数，0，负数，
正数表示保留小数点后多少位，
0表示保留到整数位。
负数表示保留到小数点前得位数，
-1为十位，-2为百位。
SELECT ROUND(45.678, 2) 
FROM DUAL; 
SELECT ROUND(45.678, 0) 
FROM DUAL;
SELECT ROUND(45.678, -1) 
FROM DUAL;

TRUNC(n[,m])
截取数字，m默认为0。与ROUND的区别在
于仅截取数字，不做四舍五入:
SELECT TRUNC(45.678, 2) 
FROM DUAL; 
SELECT TRUNC(45.678, 0) 
FROM DUAL;
SELECT TRUNC(45.678, -1) 
FROM DUAL;

MOD(m,n)
用m除以n,求余数。n若为0,则直接返回m
查看每个员工百位一下的工资情况:
SELECT ename,sal,MOD(sal,1000)
FROM emp

CEIL(n)与FLOOR(n)
其中n是数字，通常是小数。
CEIL:返回大于给定数字的最小整数(向上取整)
FLOOR:返回小于给定数字的最大整数(向下取整)

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
对应一个内部函数，表示一个时间戳类型
的当前系统时间的值。
SELECT SYSTIMESTAMP FROM dual

日期类型之间可以比较大小，时间晚的大，
时间早的小。
日期之间可以做减法操作，差为相差的天数。
日期可以加减数字，等同于加减指定的天数。

SELECT SYSDATE+1 FROM dual


SELECT ename,sal
FROM emp
WHERE sal>2500


TO_DATE()函数
可以按照给定的日期格式解析给定的字符串
并转换为一个DATE类型的值返回。
查看1981年以后入职的员工:
SELECT ename, hiredate 
FROM emp 
WHERE hiredate >
      TO_DATE('1981-01-01',
              'YYYY-MM-DD');


编写SQL，查看到今天为止，您活了多少天?
SELECT 
  CEIL(
    SYSDATE-TO_DATE('1992-03-24',
                    'YYYY-MM-DD')
  )
FROM
  dual

查看每个员工到今天为止，入职多少天了?
SELECT ename,TRUNC(SYSDATE-hiredate)
FROM emp

TO_CHAR()函数
常用与将一个日期按照给定的日期格式
转换为字符串

将每个员工的入职时间转换为YYYY-MM-DD的
形式:
SELECT 
  TO_CHAR(hiredate,'YYYY-MM-DD')
FROM
  emp

测试RR指定的世纪:

SELECT 
  TO_CHAR(
    TO_DATE('95-12-21','RR-MM-DD'),
    'YYYY-MM-DD')    
FROM
  dual

将系统时间输出为:YYYY年MM月DD日
SELECT 
 TO_CHAR(SYSDATE,
         'YYYY"年"MM"月"DD"日"')
FROM 
 dual

日期格式字符串中，除字母与符号外的
其他字符都需要使用双引号括起来。


LAST_DAY(date)
该函数返回给定日期所在月的最后一天:
SELECT LAST_DAY(SYSDATE) 
FROM DUAL;

ADD_MONTHS(date,i)
对给定日期加上给定的月。
i可正可负，负数则是减去。
查看每个员工入职20周年纪念日:
SELECT ename, 
  ADD_MONTHS(hiredate, 
             20 * 12)
FROM emp;


MONTHS_BETWEEN(date1,date2)
返回给定的两个日期相差的月数。
计算规则是:date1-date2

查看每个员工至今工作了多少个月?
SELECT 
  ename,
  MONTHS_BETWEEN(SYSDATE,
                 hiredate)
FROM
  emp



NEXT_DAY(date,i)
返回据给定日期最近的，还没有过的周几?
1表示周日，7表示周六

SELECT 
  NEXT_DAY(SYSDATE, 4)
FROM DUAL;

LEAST,GREATEST函数
变长参数，可以传入任意个参数，类型一致
即可。
LEAST:返回参数中最小的
GREATEST:返回参数中最大的
SELECT 
 LEAST(SYSDATE, 
       TO_DATE('2008-10-10',
               'YYYY-MM-DD') 
      )         
FROM DUAL;

EXTRACT 函数
可以提取一个日期中指定时间分量对应的值:
SELECT 
 EXTRACT(YEAR FROM SYSDATE)
FROM DUAL;


SELECT ename,sal,hiredate
FROM emp
WHERE EXTRACT(YEAR FROM hiredate)=1987



CREATE TABLE student
    (id NUMBER(4), name CHAR(20), gender CHAR(1));

INSERT INTO student VALUES(1000, '李莫愁', 'F');

INSERT INTO student VALUES(1001, '林平之', NULL);

INSERT INTO student(id, name) VALUES(1002, '张无忌');

SELECT * FROM student

将字段更新为NULL:
UPDATE student
SET gender=NULL

查看性别为NULL的都有谁?
SELECT *
FROM student
WHERE gender IS NOT NULL

判断一个值是否为NULL，不能使用"="
而要使用IS NULL。
判断非空用IS NOT NULL


NULL与字符串拼接，等于什么也没做。
NULL与数字运算，结果还是NULL。

查看每个员工的收入(工资+奖金):
SELECT ename,sal,comm,sal+comm
FROM emp

空值函数:
NVL(arg1,arg2)
若arg1为NULL，则函数返回arg2的值，
否则返回arg1。
简单说就是将NULL值替换为一个非NULL值

SELECT ename,sal,comm,
       sal+NVL(comm,0)
FROM emp


查看每个员工的奖金情况，有奖金的
显示"有奖金"没有奖金的显示"没有奖金"

NVL2(arg1,arg2,arg3)
当arg1不为NULL时，函数返回arg2
当arg1为NULL时，函数返回arg3

SELECT ename,comm,
       NVL2(comm,'有奖金','没有奖金')
FROM emp

NVL2后两个参数的类型不用于第一个一致。
只要后两个一致即可。


