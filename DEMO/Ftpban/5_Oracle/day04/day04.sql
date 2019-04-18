作业1
SELECT ename,deptno
FROM emp
WHERE deptno IN (20,30)

SELECT ename,job
FROM emp
WHERE mgr IS NULL
ORDER BY job

SELECT ename,sal,comm
FROM emp
WHERE comm IS NOT NULL
ORDER BY sal DESC

SELECT ename
FROM emp
WHERE ename LIKE '__A%'

SELECT ename||','||job||','||sal OUT_PUT
FROM emp


SELECT empno,ename,sal,sal*1.2
FROM emp

SELECT ename,sal
FROM emp
WHERE sal > 1200
ORDER BY hiredate

SELECT deptno,dname,loc
FROM dept
WHERE dname<>'ACCOUNT'


作业2:
1:
SELECT MAX(sal)
FROM emp
GROUP BY deptno,job


作业3:
2:
SELECT MAX(score)
FROM student
GROUP BY classid,subject

自连接:
自连接的设计是指自己表与自己表有一个
关联关系，意思是:自己表的一条记录可以
对应自己表的多条记录。
这样的设计往往是用于保存同样类型的数据，
但有又存在父子级(上下级)关系的树状结构。


SELECT empno,ename,mgr
FROM emp

查看每个员工以及上司的名字?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno(+)

查看KING的下属都是谁?
SELECT e.ename
FROM emp e,emp m
WHERE e.mgr=m.empno
AND m.ename='KING'



与BLAKE相同部门的员工?


子查询:
为其他SQL语句提供数据。
有时候我们在执行某条SQL语句时，需要的
数据不是确定值，必须要先查询一次表得到，
那么先执行的这个查询语句往往是嵌套在实
际要执行的SQL语句之中，为其提供数据的。
那么这个查询语句就是子查询。

SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='BLAKE')


在DDL当中使用子查询
CREATE TABLE employee
AS
SELECT e.empno,e.ename,e.job,
       e.sal,d.deptno,d.dname,
       d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno



在DML中使用
删除BLAKE所在部门的所有员工

DELETE FROM emp
WHERE deptno=(SELECT deptno 
              FROM emp
              WHERE ename='BLAKE')

SELECT * FROM emp

子查询根据查询结果的字段数量与记录数
分为:
单行单列子查询
多行单列子查询
多行多列子查询

其中单列子查询常用于WHERE中作为过
滤条件
而多列常当做一张表看待出现在FROM子句中

查找和SCOTT同职位的员工：
SELECT ename,job,sal
FROM emp
WHERE job=(SELECT job
           FROM emp
           WHERE ename='SCOTT')


查找薪水比整个机构平均薪水高的员工
SELECT ename,sal
FROM emp
WHERE sal>(SELECT AVG(sal)
           FROM emp)


查看与SALESMAN同部门的其他职位员工?
SELECT ename,job,deptno
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 WHERE job='SALESMAN')
AND job <> 'SALESMAN'

查看比所有SALESMAN和CLERK工资都高的员
工信息?
SELECT ename,sal
FROM emp
WHERE sal>ALL(SELECT sal
              FROM emp
              WHERE job IN('SALESMAN','CLERK'))


SELECT * FROM dept


EXISTS关键字后面跟一个子查询，只要该
查询能查询出至少一条记录，那么就返回true

查看有员工的部门?
SELECT deptno, dname 
FROM dept d
WHERE 
 EXISTS(SELECT * FROM emp e
        WHERE d.deptno = e.deptno);


查询列出最低薪水高于部门30的最低薪水
的部门信息
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp
                 WHERE deptno=30)


查看比自己所在部门平均工资高的员工信息?
SELECT e.ename,e.sal,e.deptno
FROM emp e,(SELECT AVG(sal) avg_sal,
                   deptno
            FROM emp
            GROUP BY deptno) t
WHERE e.deptno=t.deptno
AND e.sal>t.avg_sal

子查询出现在SELECT子句中，通常是实现
外连接的效果:
SELECT e.ename, e.sal, 
       (SELECT d.dname 
        FROM dept d 
        WHERE d.deptno=e.deptno) dname
FROM emp e;

SELECT ename,deptno
FROM emp


分页查询
当一条查询语句执行后的数据量过于庞大时
通常会采取实用分页措施，一次只查询出其
中的一部分数据，分段获取。这样可以提高
响应速度，以及减少系统资源的开销。

分页的SQL语句没有标准，所以不同的数据库
的分页语句不同。
ORACLE中是使用行号(ROWNUM)的策略，为
结果集编号，然后获取部分数据实现的。

SELECT ROWNUM,ename,sal,job,deptno
FROM emp

ROWNUM：伪列，不是表中的一个真实字段，
可以应用在任何一张表中，在结果集中体现
的样子就是每一行记录出一个行号。
行号是在查询数据的过程中生成的，只要SQL
语句能查询出一条记录，ROWNUM就会为该条
记录出一个行号，从1开始。

查看员工6-10条?
SELECT ROWNUM,ename,sal,job,deptno
FROM emp
WHERE ROWNUM BETWEEN 6 AND 10

由于ROWNUM只有查询出一条数据后，才
会为其编号，然后自身进行增长，所以
在第一次查询数据进行编号的过程中不
要使用ROWNUM进行大于1以上的数字作
为过滤条件。否则查询不出任何数据!
SELECT *
FROM(SELECT ROWNUM rn,ename,
            sal,job,deptno
     FROM emp) t
WHERE t.rn BETWEEN 6 AND 10

由于ORDER BY是在最后数据都被查询出
来后才排序，所以不能下面的代码不能实现
效果。
查看公司中工资的6-10名?
SELECT *
FROM(SELECT ROWNUM rn,ename,
            sal,job,deptno
     FROM emp) t
WHERE t.rn BETWEEN 6 AND 10
ORDER BY sal DESC

所以，若分页中存在排序需求时，就应当
先排序，然后再编号，最后按照编号取范
围内的数据。
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,job,sal
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10          

pageSize:每页显示的条目数
page:页码
通过以上两个值计算行号范围:
start:(page-1)*pageSize+1
end:page*pageSize


DECODE函数，可以实现类似于分支的结构。
SELECT ename, job, sal,
  DECODE(job,  
        'MANAGER', sal * 1.2,
        'ANALYST', sal * 1.1,
        'SALESMAN', sal * 1.05,
        sal
     ) bonus
FROM emp;


统计analyst/manager共计多少人，
其他职位共计多少人?
由于GROUP BY只能根据后面指定的内容值
相同的记录看做一组。所以我们可以将给定
字段的值不同的使用DECODE转换为相同的
值即可。
SELECT COUNT(*),DECODE(job,
                'MANAGER','VIP',
                'ANALYST','VIP',
                'OTHER')
FROM emp
GROUP BY DECODE(job,
                'MANAGER','VIP',
                'ANALYST','VIP',
                'OTHER')

NULL在排序中被认为是最大值。
应用在排序中:
SELECT deptno, dname, loc
FROM dept
ORDER BY 
      DECODE(dname, 
            'OPERATIONS',1,
            'ACCOUNTING',2,
            'SALES',3);


排序函数
可以按照指定的字段分组，按照指定的字段
排序，然后生成组内的编号。

ROW_NUMBER()函数:
生成组内连续且唯一的数字

查看每个部门的工资排名:
SELECT 
  ename,sal,deptno,
  ROW_NUMBER() OVER(
    PARTITION BY deptno 
    ORDER BY sal DESC
  ) rank      
FROM emp

RANK函数，生成组内不连续也不唯一
的数字。
SELECT 
  ename,sal,deptno,
  RANK() OVER(
    PARTITION BY deptno 
    ORDER BY sal DESC
  ) rank      
FROM emp

DENSE_RANK()函数
生成组内连续但是不唯一的数字
SELECT 
  ename,sal,deptno,
  DENSE_RANK() OVER(
    PARTITION BY deptno 
    ORDER BY sal DESC
  ) rank      
FROM emp

SELECT ename, job, sal FROM emp 
WHERE job = 'MANAGER'
UNION ALL
SELECT ename, job, sal FROM emp 
WHERE sal > 2500;


SELECT * FROM sales_tab
ORDER BY year_id,month_id,day_id

每天营业额:
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
ORDER BY year_id,month_id,day_id

每月营业额:
SELECT year_id,month_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
ORDER BY year_id,month_id

每年营业额:
SELECT year_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id
ORDER BY year_id

总共的营业额:
SELECT SUM(sales_value)
FROM sales_tab


ROLLUP函数
ROLLUP函数用在GROUP BY子句中，
可以为我们提供若干分组方式，然后
将这些分组的结果并在一个结果集中
显示。
分组方式:
GROUP BY ROLLUP(a,b,c)
等同于
GROUP BY a,b,c
UNION
GROUP BY a,b
UNION
GROUP BY a
UNION
全表

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY ROLLUP(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id


GROUP BY CUBE(a,b,c)
等同于
abc
ab
ac
bc
a
b
c
全表

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id


GROUPING SETS()
该高级分组函数允许按照给定的集中分组
方式进行统计，然后并在一个结果集中显
示。比较灵活方便。

查看每天与每月的销售额
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
 GROUPING SETS(
   (year_id,month_id,day_id),
   (year_id,month_id)  
 )
ORDER BY year_id,month_id,day_id






