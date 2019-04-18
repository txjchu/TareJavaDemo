CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

查看表结构
DESC employee

SQL语句本身是不区分大小写的，但是为了
增加可读性，通常会将关键字与非关键字使
用大小写区分开。
通常关键字使用全大写，非关键字使用全小
写。

但是需要注意，字符串的值是区分大小写的，
数据库中，字符串的字面量使用单引号括起来。


数据库中，字段无论什么类型，默认值
都是NULL，在插入数据时，只要该字段
没有给定值，就会将NULL插入该字段。
可以单独使用DEFAULT关键字为字段指
定默认值，这样不给值时则使用指定的
默认值而不再是NULL。

CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

删除表
DROP TABLE 表名
DROP TABLE employee

非空约束
非空约束要求指定的字段在任何时候
值都不允许为NULL。
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

修改表
1:修改表名
RENAME old_name TO new_name

RENAME employee TO myemp

DESC employee  报错，不存在
DESC myemp

2:修改表结构
2.1:向表中添加新字段
需要注意，添加的字段只会被追加到表
的最后，而不能在现有字段中间"插入"
一个字段

向myemp表中添加一个字段hiredate，
类型为DATE，默认值为当前系统时间。

SYSDATE:该关键字表示DATE类型的
值，该值是当前系统时间。

ALTER TABLE myemp 
ADD(
  hiredate DATE DEFAULT SYSDATE
)

DESC myemp

删除表中现有字段，最好是表中没有数据
的时候进行，若表中存在数据，会将每一条
记录对应的该字段的值都要删除，数据量大
的时候会比较慢。

删除myemp表中的字段hiredate
ALTER TABLE myemp DROP(hiredate)

修改表中字段:
可以修改字段的类型，长度，添加默认值
设置是否为空。

同样不建议在表中已经存在数据后再修改，
有可能修改不成功:
长度尽量不要减少，否则不满足现有数据要求
的话，是修改不成功的。
尽量不修改类型。

修改表myemp的列job，并增加默认值的设置
ALTER TABLE myemp 
MODIFY(
 job VARCHAR2(40) DEFAULT 'CLERK' 
);

DML语句
用于增，删，改表中数据。伴随事务。

插入数据:
INSERT INTO table_name
(col_name1,col_name2,...)
VALUES
(value1,value2,....)

INSERT INTO myemp
(id,name,gender,salary,deptno)
VALUES
(1,'JACK','M',5000,20)

SELECT * FROM myemp

gender设置了默认值，所以不指定
也会使用'M'作为默认值
INSERT INTO myemp
(id,name,salary,deptno)
VALUES
(2,'tom',5000,20)

由于name是NOT NULL的，
所以下面SQL执行会报错
INSERT INTO myemp
(id,salary,deptno)
VALUES
(3,6000,10)

提交事务，数据才真的被插入到表中
COMMIT

事务的开启与关闭
事务的开启:
当执行第一条DML语句时，会自动开启
一个事务，然后执行该语句，在此之后
所有被执行的DML语句都在这一个事务
控制范围内。

事务的关闭:
无论是提交或是回退，事务都会关闭。
提交:将这次事务中的所有DML操作全部
    真实执行，对表进行操作。提交后
    无法再进行回滚。
回滚:回退到事务开启前的状态，这次事务
    中所有的DML操作均被撤销。

插入日期类型的值
可以直接使用字符串，但是格式有要求，
必须是'DD-MON-RR',由于有语言差异，
月的写法不同，所以不建议使用。

可以使用TO_DATE函数，自行将字符串
按照指定的日期格式转换为DATE值。

INSERT INTO myemp
(id,name,salary,birth)
VALUES
(3,'CLARK',4000,
 TO_DATE('1990-05-21',
         'YYYY-MM-DD')
)

INSERT语句可以不指定字段，若不
指定，则是全列插入，那么VALUES
后面必须将所有值按照表中字段顺序
全部指定，否则会报错。
INSERT INTO myemp
VALUES
(3,'CLARK',4000,
 TO_DATE('1990-05-21',
         'YYYY-MM-DD')
)

UPDATE语句，用于修改表中数据
UPDATE table_name
SET col_name1=new_value1,
    col_name2=new_value2,...
[WHERE con=con_value]    

UPDATE myemp
SET gender='F'
WHERE name='tom'

SELECT * FROM myemp

UPDATE语句修改表中数据时，通常
要使用WHERE子句添加条件来限制
要修改的记录。这样才能将只满足
WHERE条件的记录进行修改，若不
添加则是全表每一条记录都修改，
通常很少会这样做！


