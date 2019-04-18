作业5:
INSERT INTO t_account
(id,login_name,login_passwd,create_date,real_name,idcard_no,telephone)
VALUES
(1,'shiyl','256528',TO_DATE('2014-03-02','YYYY-MM-DD'),
 'shiyuanli','410381194302256523','13669351234')
 
作业6：
1:
SELECT 
  TO_CHAR(SYSDATE,
          'YYYY"年"MM"月"DD"日" HH24"时"MI"分"SS"秒"')
FROM dual          
 
2:
SELECT ename,
       TO_CHAR(hiredate,'YYYY"年"MM"月"DD"日"'),
       TO_CHAR(hiredate,'YYYY/MM/DD')
FROM emp       


作业8
SELECT * 
FROM customer
WHERE birthday IS NULL


作业9
SELECT empno,ename,sal+NVL(comm,0)
FROM emp

作业10
SELECT empno,ename,
       NVL2(hiredate,
            TO_CHAR(hirdate,'YYYY-MM-DD'),
            'not available')
FROM emp


列的别名:
当我们在SELECT子句中查询的内容不是
直接使用字段的名字，而是表达式，或者
一个函数。这时候在查询出来的结果集中
该列的名字就是这个函数或者表达式，可
读性差，为此，我们可以为当前列添加别
名，这样结果集中当前列的名字就是该别名

别名中若希望区分大小写或者含有空格时，
可以使用双引号括起来。

在使用子查询时，通常要求含有表达式，
函数的字段必须加别名。

SELECT ename,sal*12 "year sal"
FROM emp


WHERE子句在SELECT语句中的作用是
添加过滤条件，这样一来只会将满足
条件的记录查询出来。

查看10号部门的员工:
SELECT * FROM emp
WHERE deptno=10

查看职位是'SALESMAN'的员工:
SELECT * FROM emp
WHERE job='SALESMAN'
 
 
SELECT ename, sal, hiredate 
FROM emp 
WHERE hiredate > 
      to_date('1982-1-1','YYYY-MM-DD');

当在WHERE中需要使用多个条件进行
过滤时，可以使用AND和OR。
AND：并且关系，两个都为真时才为真
OR: 或者关系，两个都为假时才为假
 
SELECT ename, sal, job 
FROM emp 
WHERE sal>1000 
AND job='CLERK';
 
查看工资高于1250的CLERK
与SALESMAN的员工信息? 
SELECT ename,sal,job
FROM emp
WHERE sal>1250
AND (job='CLERK'
OR job='SALESMAN')
 
OR的优先级低于AND，所以若需要
提高优先级，可以使用括号来提高。
 
LIKE:用于对字符串进行模糊匹配。
支持两个通配符:
_:表示任意一个字符
%:表示任意个字符(0-多个)
查看名字第二个字母是"A"的员工信息:
SELECT ename, job FROM emp 
WHERE ename LIKE '_A%';

IN(list):判断等于列表中任何一项即可
常用于判断子查询的结果，这种情况下是
不能用OR代替的。
NOT IN 则是判断不在列表中。
SELECT ename, job 
FROM emp  
WHERE job IN ('MANAGER','CLERK');

ANY(list)与ALL(list)
当需要判断诸如>,>=,<,<=多个值时，
要配合ANY和ALL使用。
>ANY:大于列表中最小的即可
>ALL:大于列表中最大的
<ANY:小于列表中最大的
<ALL:小于列表中最小的
通常是为判断子查询结果使用，列表很少
直接给定几个固定值。
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal > ANY (3500,4000,4500);
 
 
WHERE子句可以使用函数或者表达式的结果
作为过滤条件。
SELECT ename, sal, job 
FROM emp 
WHERE ename = UPPER('rose');

SELECT ename, sal, job 
FROM emp 
WHERE sal * 12 >50000;

DISTINCT关键字，去除重复行
将结果集中指定字段值重复的去除。

DISTINCT关键字必须紧跟在SELECT
关键字之后。

查看公司总共有多少中职位:
SELECT DISTINCT job
FROM emp

DISTINCT对多个字段去重,不能保证
结果集中某一个字段没有重复值。
作用是保证这几个字段值的组合没有
重复的。
SELECT DISTINCT job,deptno
FROM emp
 
ORDER BY子句
排序结果集，可以按照给定的字段的
值进行"升序"或者"降序"排列。
ORDER BY的执行顺序是先进行SELECT
查询数据，然后再对查询出来的结果集
按照指定的字段进行的排序。
所以ORDER BY子句必须写在SELECT语句
的最后。
DESC:降序，从大到小
ASC:升序，从小到大，默认就是升序，
    所以ASC关键字通常不写。
 
查看公司工资排名情况:
SELECT ename,sal,job
FROM emp
ORDER BY sal DESC
 
SELECT ename,hiredate
FROM emp
ORDER BY hiredate DESC
 
ORDER BY也可以按照多个字段排序
每个字段都可以分别指定升降序。
排序存在优先级，先按照第一个字段
的排序规则进行排序，当第一个字段
值一样的记录，才会按照第二个字段
的排序规则进行排序。以此类推。
 
SELECT ename,deptno,sal
FROM emp
ORDER BY deptno ,sal DESC
 
 
聚合函数:
又名多行函数，分组函数。
作用是进行统计工作，可以将多条记录的值
进行统计然后得到一个结果。
 
MAX()与MIN()
求最大值与最小值。 
 
查看公司最高工资与最低工资:
SELECT MAX(sal),MIN(sal)
FROM emp
 
 
AVG()与SUM()
求平均值与总和
 
查看公司平均工资以及工资综合 
SELECT AVG(sal),SUM(sal)
FROM emp
 
查看平均奖金,奖金总和 
SELECT AVG(comm),SUM(comm)
FROM emp

从上面的SQL结果看出，聚合函数是
忽略NULL值的。只有4条记录comm有
值，所以平均数是总和除以4的结果。
SELECT ename,comm
FROM emp

可以将NULL替换0，来进行平均数统计
SELECT AVG(NVL(comm,0)) 
FROM emp 
 
COUNT()函数
用来统计指定字段非NULL的记录总共
多少条。并不关心字段具体取值。

查看公司总共多少人?
SELECT COUNT(ename)
FROM emp

通常查看一张表的记录数，可以使用
COUNT(*)。
SELECT COUNT(*)
FROM emp
 
 
GROUP BY子句
GROUP BY可以根据指定的字段值相同的
记录进行分组，然后配合组函数进行更新
至的统计工作。
 
查看每个部门的最高工资与最低工资? 
SELECT MAX(sal),MIN(sal),deptno 
FROM emp
GROUP BY deptno
 
当SELECT子句中出现了聚合函数，那么
凡不在聚合函数中的其他字段必须出现在
GROUP BY子句中。反之则不是必须的。

多字段分组，则是按照这几个字段值组合
一样的看做一组:
列出同部门同职位的员工的最高工资与
最低工资:
SELECT MAX(sal),MIN(sal),job,deptno 
FROM emp
GROUP BY job,deptno 


SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno

查看部门平均工资高于2000的部门的
平均工资?
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

HAVING不能独立存在，必须跟在GROUP BY
子句之后。用于进行分组统计后进行过滤使用
与WHERE的区别:
WHERE是在第一次查表的时候进行过滤，只
有满足WHERE要求的记录才会被查询出来，
而HAVING是在查询出的数据基础上进行了
分组统计后得到的结果进行的过滤。
所以WHERE先进行的过滤，HAVING后进行。

HAVING中并非SELECT中查询什么，才可以
用于过滤。
查看平均工资高于2000的部门的最高工资与
最低工资:
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000


多表关联查询
多表关联查询中连接条件是十分重要的，
它能告知数据库在表与表的数据之间如何
进行连线找到对应关系，从而查询数据。

查看SALES部门的员工姓名?
SELECT ename
FROM emp,dept
WHERE emp.deptno=dept.deptno
AND dept.dname='SALES'
 
查看每个员工名字，部门编号，
部门名称，工作所在地?

SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
 
当查询的字段在联合查询的表中均有
出现，那么必须明确指定从那张表上
取该字段的值。
可以为表添加别名，然后使用别名来
代替表名指定字段。

N张表查询至少要有N-1个连接条件，
否则会出现笛卡尔积
笛卡尔积，结果集的条数是参与表的
记录总数乘积的结果。是个无用的结果
集，消耗资源巨大，要避免出现！
 
SELECT e.ename,d.dname
FROM emp e,dept d
 
在DALLAS工作的员工都有谁?工资是多少?
SELECT e.ename,e.sal
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.loc = 'DALLAS' 
 
使用内连接实现关联查询:
内连接使用JOIN来连接表。在ON
子句中书写连接条件，相对传统的
关联查询语句而言，是将连接条件
与过滤条件分开在不同的地方书写，
语句表达更清晰。
 
查看每个员工以及所在部门名称
SELECT e.ename,d.dname
FROM emp e JOIN dept d
ON e.deptno = d.deptno
 
查看SALES部门员工信息 
SELECT e.ename,e.sal,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE d.dname='SALES'
 
职位是SALESMAN的员工都在那里工作? 
SELECT e.job,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE e.job='SALESMAN'
 
SCOTT部门改为50。
UPDATE emp
SET deptno=50
WHERE ename='SCOTT'

查看每个员工的名字，职位，工资，
部门号，部门名称?
SELECT e.ename,e.job,e.sal,
       d.deptno,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno

SCOTT没有被查询出来，原因是
SCOTT不满足连接条件，其部门
号是50，而dept表中没有部门号
是50的记录。

当需要将不满足连接条件的记录也在关联
查询中显示出来时，就要使用外连接。

外连接分为左外连接，右外连接，全外连接
左外连接:以JOIN左侧的表为驱动表(显示所
        有数据的表)，来自右面表中的字
        段当不满足连接条件是，全部
        为NULL。
        
查看所有员工信息，若有部门将其部门名显示
出来:
SELECT e.ename,e.deptno,d.dname
FROM emp e LEFT|RIGHT|FULL 
           OUTER JOIN dept d
ON e.deptno=d.deptno
 
 
SELECT e.ename,e.deptno,d.dname
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno
 
 
 
 
 
 
 