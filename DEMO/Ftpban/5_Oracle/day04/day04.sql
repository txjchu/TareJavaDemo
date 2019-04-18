��ҵ1
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


��ҵ2:
1:
SELECT MAX(sal)
FROM emp
GROUP BY deptno,job


��ҵ3:
2:
SELECT MAX(score)
FROM student
GROUP BY classid,subject

������:
�����ӵ������ָ�Լ������Լ�����һ��
������ϵ����˼��:�Լ����һ����¼����
��Ӧ�Լ���Ķ�����¼��
������������������ڱ���ͬ�����͵����ݣ�
�����ִ��ڸ��Ӽ�(���¼�)��ϵ����״�ṹ��


SELECT empno,ename,mgr
FROM emp

�鿴ÿ��Ա���Լ���˾������?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno(+)

�鿴KING����������˭?
SELECT e.ename
FROM emp e,emp m
WHERE e.mgr=m.empno
AND m.ename='KING'



��BLAKE��ͬ���ŵ�Ա��?


�Ӳ�ѯ:
Ϊ����SQL����ṩ���ݡ�
��ʱ��������ִ��ĳ��SQL���ʱ����Ҫ��
���ݲ���ȷ��ֵ������Ҫ�Ȳ�ѯһ�α�õ���
��ô��ִ�е������ѯ���������Ƕ����ʵ
��Ҫִ�е�SQL���֮�У�Ϊ���ṩ���ݵġ�
��ô�����ѯ�������Ӳ�ѯ��

SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='BLAKE')


��DDL����ʹ���Ӳ�ѯ
CREATE TABLE employee
AS
SELECT e.empno,e.ename,e.job,
       e.sal,d.deptno,d.dname,
       d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno



��DML��ʹ��
ɾ��BLAKE���ڲ��ŵ�����Ա��

DELETE FROM emp
WHERE deptno=(SELECT deptno 
              FROM emp
              WHERE ename='BLAKE')

SELECT * FROM emp

�Ӳ�ѯ���ݲ�ѯ������ֶ��������¼��
��Ϊ:
���е����Ӳ�ѯ
���е����Ӳ�ѯ
���ж����Ӳ�ѯ

���е����Ӳ�ѯ������WHERE����Ϊ��
������
�����г�����һ�ű���������FROM�Ӿ���

���Һ�SCOTTְͬλ��Ա����
SELECT ename,job,sal
FROM emp
WHERE job=(SELECT job
           FROM emp
           WHERE ename='SCOTT')


����нˮ����������ƽ��нˮ�ߵ�Ա��
SELECT ename,sal
FROM emp
WHERE sal>(SELECT AVG(sal)
           FROM emp)


�鿴��SALESMANͬ���ŵ�����ְλԱ��?
SELECT ename,job,deptno
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 WHERE job='SALESMAN')
AND job <> 'SALESMAN'

�鿴������SALESMAN��CLERK���ʶ��ߵ�Ա
����Ϣ?
SELECT ename,sal
FROM emp
WHERE sal>ALL(SELECT sal
              FROM emp
              WHERE job IN('SALESMAN','CLERK'))


SELECT * FROM dept


EXISTS�ؼ��ֺ����һ���Ӳ�ѯ��ֻҪ��
��ѯ�ܲ�ѯ������һ����¼����ô�ͷ���true

�鿴��Ա���Ĳ���?
SELECT deptno, dname 
FROM dept d
WHERE 
 EXISTS(SELECT * FROM emp e
        WHERE d.deptno = e.deptno);


��ѯ�г����нˮ���ڲ���30�����нˮ
�Ĳ�����Ϣ
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp
                 WHERE deptno=30)


�鿴���Լ����ڲ���ƽ�����ʸߵ�Ա����Ϣ?
SELECT e.ename,e.sal,e.deptno
FROM emp e,(SELECT AVG(sal) avg_sal,
                   deptno
            FROM emp
            GROUP BY deptno) t
WHERE e.deptno=t.deptno
AND e.sal>t.avg_sal

�Ӳ�ѯ������SELECT�Ӿ��У�ͨ����ʵ��
�����ӵ�Ч��:
SELECT e.ename, e.sal, 
       (SELECT d.dname 
        FROM dept d 
        WHERE d.deptno=e.deptno) dname
FROM emp e;

SELECT ename,deptno
FROM emp


��ҳ��ѯ
��һ����ѯ���ִ�к�������������Ӵ�ʱ
ͨ�����ȡʵ�÷�ҳ��ʩ��һ��ֻ��ѯ����
�е�һ�������ݣ��ֶλ�ȡ�������������
��Ӧ�ٶȣ��Լ�����ϵͳ��Դ�Ŀ�����

��ҳ��SQL���û�б�׼�����Բ�ͬ�����ݿ�
�ķ�ҳ��䲻ͬ��
ORACLE����ʹ���к�(ROWNUM)�Ĳ��ԣ�Ϊ
�������ţ�Ȼ���ȡ��������ʵ�ֵġ�

SELECT ROWNUM,ename,sal,job,deptno
FROM emp

ROWNUM��α�У����Ǳ��е�һ����ʵ�ֶΣ�
����Ӧ�����κ�һ�ű��У��ڽ����������
�����Ӿ���ÿһ�м�¼��һ���кš�
�к����ڲ�ѯ���ݵĹ��������ɵģ�ֻҪSQL
����ܲ�ѯ��һ����¼��ROWNUM�ͻ�Ϊ����
��¼��һ���кţ���1��ʼ��

�鿴Ա��6-10��?
SELECT ROWNUM,ename,sal,job,deptno
FROM emp
WHERE ROWNUM BETWEEN 6 AND 10

����ROWNUMֻ�в�ѯ��һ�����ݺ󣬲�
��Ϊ���ţ�Ȼ�������������������
�ڵ�һ�β�ѯ���ݽ��б�ŵĹ����в�
Ҫʹ��ROWNUM���д���1���ϵ�������
Ϊ���������������ѯ�����κ�����!
SELECT *
FROM(SELECT ROWNUM rn,ename,
            sal,job,deptno
     FROM emp) t
WHERE t.rn BETWEEN 6 AND 10

����ORDER BY����������ݶ�����ѯ��
������������Բ�������Ĵ��벻��ʵ��
Ч����
�鿴��˾�й��ʵ�6-10��?
SELECT *
FROM(SELECT ROWNUM rn,ename,
            sal,job,deptno
     FROM emp) t
WHERE t.rn BETWEEN 6 AND 10
ORDER BY sal DESC

���ԣ�����ҳ�д�����������ʱ����Ӧ��
������Ȼ���ٱ�ţ�����ձ��ȡ��
Χ�ڵ����ݡ�
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,job,sal
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10          

pageSize:ÿҳ��ʾ����Ŀ��
page:ҳ��
ͨ����������ֵ�����кŷ�Χ:
start:(page-1)*pageSize+1
end:page*pageSize


DECODE����������ʵ�������ڷ�֧�Ľṹ��
SELECT ename, job, sal,
  DECODE(job,  
        'MANAGER', sal * 1.2,
        'ANALYST', sal * 1.1,
        'SALESMAN', sal * 1.05,
        sal
     ) bonus
FROM emp;


ͳ��analyst/manager���ƶ����ˣ�
����ְλ���ƶ�����?
����GROUP BYֻ�ܸ��ݺ���ָ��������ֵ
��ͬ�ļ�¼����һ�顣�������ǿ��Խ�����
�ֶε�ֵ��ͬ��ʹ��DECODEת��Ϊ��ͬ��
ֵ���ɡ�
SELECT COUNT(*),DECODE(job,
                'MANAGER','VIP',
                'ANALYST','VIP',
                'OTHER')
FROM emp
GROUP BY DECODE(job,
                'MANAGER','VIP',
                'ANALYST','VIP',
                'OTHER')

NULL�������б���Ϊ�����ֵ��
Ӧ����������:
SELECT deptno, dname, loc
FROM dept
ORDER BY 
      DECODE(dname, 
            'OPERATIONS',1,
            'ACCOUNTING',2,
            'SALES',3);


������
���԰���ָ�����ֶη��飬����ָ�����ֶ�
����Ȼ���������ڵı�š�

ROW_NUMBER()����:
��������������Ψһ������

�鿴ÿ�����ŵĹ�������:
SELECT 
  ename,sal,deptno,
  ROW_NUMBER() OVER(
    PARTITION BY deptno 
    ORDER BY sal DESC
  ) rank      
FROM emp

RANK�������������ڲ�����Ҳ��Ψһ
�����֡�
SELECT 
  ename,sal,deptno,
  RANK() OVER(
    PARTITION BY deptno 
    ORDER BY sal DESC
  ) rank      
FROM emp

DENSE_RANK()����
���������������ǲ�Ψһ������
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

ÿ��Ӫҵ��:
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
ORDER BY year_id,month_id,day_id

ÿ��Ӫҵ��:
SELECT year_id,month_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
ORDER BY year_id,month_id

ÿ��Ӫҵ��:
SELECT year_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id
ORDER BY year_id

�ܹ���Ӫҵ��:
SELECT SUM(sales_value)
FROM sales_tab


ROLLUP����
ROLLUP��������GROUP BY�Ӿ��У�
����Ϊ�����ṩ���ɷ��鷽ʽ��Ȼ��
����Щ����Ľ������һ���������
��ʾ��
���鷽ʽ:
GROUP BY ROLLUP(a,b,c)
��ͬ��
GROUP BY a,b,c
UNION
GROUP BY a,b
UNION
GROUP BY a
UNION
ȫ��

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY ROLLUP(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id


GROUP BY CUBE(a,b,c)
��ͬ��
abc
ab
ac
bc
a
b
c
ȫ��

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id


GROUPING SETS()
�ø߼����麯�������ո����ļ��з���
��ʽ����ͳ�ƣ�Ȼ����һ�����������
ʾ���Ƚ����㡣

�鿴ÿ����ÿ�µ����۶�
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
 GROUPING SETS(
   (year_id,month_id,day_id),
   (year_id,month_id)  
 )
ORDER BY year_id,month_id,day_id






