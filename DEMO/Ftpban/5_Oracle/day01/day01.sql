CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

�鿴��ṹ
DESC employee

SQL��䱾���ǲ����ִ�Сд�ģ�����Ϊ��
���ӿɶ��ԣ�ͨ���Ὣ�ؼ�����ǹؼ���ʹ
�ô�Сд���ֿ���
ͨ���ؼ���ʹ��ȫ��д���ǹؼ���ʹ��ȫС
д��

������Ҫע�⣬�ַ�����ֵ�����ִ�Сд�ģ�
���ݿ��У��ַ�����������ʹ�õ�������������


���ݿ��У��ֶ�����ʲô���ͣ�Ĭ��ֵ
����NULL���ڲ�������ʱ��ֻҪ���ֶ�
û�и���ֵ���ͻὫNULL������ֶΡ�
���Ե���ʹ��DEFAULT�ؼ���Ϊ�ֶ�ָ
��Ĭ��ֵ����������ֵʱ��ʹ��ָ����
Ĭ��ֵ��������NULL��

CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

ɾ����
DROP TABLE ����
DROP TABLE employee

�ǿ�Լ��
�ǿ�Լ��Ҫ��ָ�����ֶ����κ�ʱ��
ֵ��������ΪNULL��
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

�޸ı�
1:�޸ı���
RENAME old_name TO new_name

RENAME employee TO myemp

DESC employee  ����������
DESC myemp

2:�޸ı�ṹ
2.1:�����������ֶ�
��Ҫע�⣬��ӵ��ֶ�ֻ�ᱻ׷�ӵ���
����󣬶������������ֶ��м�"����"
һ���ֶ�

��myemp�������һ���ֶ�hiredate��
����ΪDATE��Ĭ��ֵΪ��ǰϵͳʱ�䡣

SYSDATE:�ùؼ��ֱ�ʾDATE���͵�
ֵ����ֵ�ǵ�ǰϵͳʱ�䡣

ALTER TABLE myemp 
ADD(
  hiredate DATE DEFAULT SYSDATE
)

DESC myemp

ɾ�����������ֶΣ�����Ǳ���û������
��ʱ����У������д������ݣ��Ὣÿһ��
��¼��Ӧ�ĸ��ֶε�ֵ��Ҫɾ������������
��ʱ���Ƚ�����

ɾ��myemp���е��ֶ�hiredate
ALTER TABLE myemp DROP(hiredate)

�޸ı����ֶ�:
�����޸��ֶε����ͣ����ȣ����Ĭ��ֵ
�����Ƿ�Ϊ�ա�

ͬ���������ڱ����Ѿ��������ݺ����޸ģ�
�п����޸Ĳ��ɹ�:
���Ⱦ�����Ҫ���٣�����������������Ҫ��
�Ļ������޸Ĳ��ɹ��ġ�
�������޸����͡�

�޸ı�myemp����job��������Ĭ��ֵ������
ALTER TABLE myemp 
MODIFY(
 job VARCHAR2(40) DEFAULT 'CLERK' 
);

DML���
��������ɾ���ı������ݡ���������

��������:
INSERT INTO table_name
(col_name1,col_name2,...)
VALUES
(value1,value2,....)

INSERT INTO myemp
(id,name,gender,salary,deptno)
VALUES
(1,'JACK','M',5000,20)

SELECT * FROM myemp

gender������Ĭ��ֵ�����Բ�ָ��
Ҳ��ʹ��'M'��ΪĬ��ֵ
INSERT INTO myemp
(id,name,salary,deptno)
VALUES
(2,'tom',5000,20)

����name��NOT NULL�ģ�
��������SQLִ�лᱨ��
INSERT INTO myemp
(id,salary,deptno)
VALUES
(3,6000,10)

�ύ�������ݲ���ı����뵽����
COMMIT

����Ŀ�����ر�
����Ŀ���:
��ִ�е�һ��DML���ʱ�����Զ�����
һ������Ȼ��ִ�и���䣬�ڴ�֮��
���б�ִ�е�DML��䶼����һ������
���Ʒ�Χ�ڡ�

����Ĺر�:
�������ύ���ǻ��ˣ����񶼻�رա�
�ύ:����������е�����DML����ȫ��
    ��ʵִ�У��Ա���в������ύ��
    �޷��ٽ��лع���
�ع�:���˵�������ǰ��״̬���������
    �����е�DML��������������

�����������͵�ֵ
����ֱ��ʹ���ַ��������Ǹ�ʽ��Ҫ��
������'DD-MON-RR',���������Բ��죬
�µ�д����ͬ�����Բ�����ʹ�á�

����ʹ��TO_DATE���������н��ַ���
����ָ�������ڸ�ʽת��ΪDATEֵ��

INSERT INTO myemp
(id,name,salary,birth)
VALUES
(3,'CLARK',4000,
 TO_DATE('1990-05-21',
         'YYYY-MM-DD')
)

INSERT�����Բ�ָ���ֶΣ�����
ָ��������ȫ�в��룬��ôVALUES
������뽫����ֵ���ձ����ֶ�˳��
ȫ��ָ��������ᱨ��
INSERT INTO myemp
VALUES
(3,'CLARK',4000,
 TO_DATE('1990-05-21',
         'YYYY-MM-DD')
)

UPDATE��䣬�����޸ı�������
UPDATE table_name
SET col_name1=new_value1,
    col_name2=new_value2,...
[WHERE con=con_value]    

UPDATE myemp
SET gender='F'
WHERE name='tom'

SELECT * FROM myemp

UPDATE����޸ı�������ʱ��ͨ��
Ҫʹ��WHERE�Ӿ��������������
Ҫ�޸ĵļ�¼���������ܽ�ֻ����
WHERE�����ļ�¼�����޸ģ�����
�������ȫ��ÿһ����¼���޸ģ�
ͨ�����ٻ���������


