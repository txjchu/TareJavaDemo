��ҵ5:
INSERT INTO t_account
(id,login_name,login_passwd,create_date,real_name,idcard_no,telephone)
VALUES
(1,'shiyl','256528',TO_DATE('2014-03-02','YYYY-MM-DD'),
 'shiyuanli','410381194302256523','13669351234')
 
��ҵ6��
1:
SELECT 
  TO_CHAR(SYSDATE,
          'YYYY"��"MM"��"DD"��" HH24"ʱ"MI"��"SS"��"')
FROM dual          
 
2:
SELECT ename,
       TO_CHAR(hiredate,'YYYY"��"MM"��"DD"��"'),
       TO_CHAR(hiredate,'YYYY/MM/DD')
FROM emp       


��ҵ8
SELECT * 
FROM customer
WHERE birthday IS NULL


��ҵ9
SELECT empno,ename,sal+NVL(comm,0)
FROM emp

��ҵ10
SELECT empno,ename,
       NVL2(hiredate,
            TO_CHAR(hirdate,'YYYY-MM-DD'),
            'not available')
FROM emp


�еı���:
��������SELECT�Ӿ��в�ѯ�����ݲ���
ֱ��ʹ���ֶε����֣����Ǳ��ʽ������
һ����������ʱ���ڲ�ѯ�����Ľ������
���е����־�������������߱��ʽ����
���ԲΪ�ˣ����ǿ���Ϊ��ǰ����ӱ�
��������������е�ǰ�е����־��Ǹñ���

��������ϣ�����ִ�Сд���ߺ��пո�ʱ��
����ʹ��˫������������

��ʹ���Ӳ�ѯʱ��ͨ��Ҫ���б��ʽ��
�������ֶα���ӱ�����

SELECT ename,sal*12 "year sal"
FROM emp


WHERE�Ӿ���SELECT����е�������
��ӹ�������������һ��ֻ�Ὣ����
�����ļ�¼��ѯ������

�鿴10�Ų��ŵ�Ա��:
SELECT * FROM emp
WHERE deptno=10

�鿴ְλ��'SALESMAN'��Ա��:
SELECT * FROM emp
WHERE job='SALESMAN'
 
 
SELECT ename, sal, hiredate 
FROM emp 
WHERE hiredate > 
      to_date('1982-1-1','YYYY-MM-DD');

����WHERE����Ҫʹ�ö����������
����ʱ������ʹ��AND��OR��
AND�����ҹ�ϵ��������Ϊ��ʱ��Ϊ��
OR: ���߹�ϵ��������Ϊ��ʱ��Ϊ��
 
SELECT ename, sal, job 
FROM emp 
WHERE sal>1000 
AND job='CLERK';
 
�鿴���ʸ���1250��CLERK
��SALESMAN��Ա����Ϣ? 
SELECT ename,sal,job
FROM emp
WHERE sal>1250
AND (job='CLERK'
OR job='SALESMAN')
 
OR�����ȼ�����AND����������Ҫ
������ȼ�������ʹ����������ߡ�
 
LIKE:���ڶ��ַ�������ģ��ƥ�䡣
֧������ͨ���:
_:��ʾ����һ���ַ�
%:��ʾ������ַ�(0-���)
�鿴���ֵڶ�����ĸ��"A"��Ա����Ϣ:
SELECT ename, job FROM emp 
WHERE ename LIKE '_A%';

IN(list):�жϵ����б����κ�һ���
�������ж��Ӳ�ѯ�Ľ���������������
������OR����ġ�
NOT IN �����жϲ����б��С�
SELECT ename, job 
FROM emp  
WHERE job IN ('MANAGER','CLERK');

ANY(list)��ALL(list)
����Ҫ�ж�����>,>=,<,<=���ֵʱ��
Ҫ���ANY��ALLʹ�á�
>ANY:�����б�����С�ļ���
>ALL:�����б�������
<ANY:С���б�������
<ALL:С���б�����С��
ͨ����Ϊ�ж��Ӳ�ѯ���ʹ�ã��б����
ֱ�Ӹ��������̶�ֵ��
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal > ANY (3500,4000,4500);
 
 
WHERE�Ӿ����ʹ�ú������߱��ʽ�Ľ��
��Ϊ����������
SELECT ename, sal, job 
FROM emp 
WHERE ename = UPPER('rose');

SELECT ename, sal, job 
FROM emp 
WHERE sal * 12 >50000;

DISTINCT�ؼ��֣�ȥ���ظ���
���������ָ���ֶ�ֵ�ظ���ȥ����

DISTINCT�ؼ��ֱ��������SELECT
�ؼ���֮��

�鿴��˾�ܹ��ж�����ְλ:
SELECT DISTINCT job
FROM emp

DISTINCT�Զ���ֶ�ȥ��,���ܱ�֤
�������ĳһ���ֶ�û���ظ�ֵ��
�����Ǳ�֤�⼸���ֶ�ֵ�����û��
�ظ��ġ�
SELECT DISTINCT job,deptno
FROM emp
 
ORDER BY�Ӿ�
�������������԰��ո������ֶε�
ֵ����"����"����"����"���С�
ORDER BY��ִ��˳�����Ƚ���SELECT
��ѯ���ݣ�Ȼ���ٶԲ�ѯ�����Ľ����
����ָ�����ֶν��е�����
����ORDER BY�Ӿ����д��SELECT���
�����
DESC:���򣬴Ӵ�С
ASC:���򣬴�С����Ĭ�Ͼ�������
    ����ASC�ؼ���ͨ����д��
 
�鿴��˾�����������:
SELECT ename,sal,job
FROM emp
ORDER BY sal DESC
 
SELECT ename,hiredate
FROM emp
ORDER BY hiredate DESC
 
ORDER BYҲ���԰��ն���ֶ�����
ÿ���ֶζ����Էֱ�ָ��������
����������ȼ����Ȱ��յ�һ���ֶ�
���������������򣬵���һ���ֶ�
ֵһ���ļ�¼���Żᰴ�յڶ����ֶ�
�����������������Դ����ơ�
 
SELECT ename,deptno,sal
FROM emp
ORDER BY deptno ,sal DESC
 
 
�ۺϺ���:
�������к��������麯����
�����ǽ���ͳ�ƹ��������Խ�������¼��ֵ
����ͳ��Ȼ��õ�һ�������
 
MAX()��MIN()
�����ֵ����Сֵ�� 
 
�鿴��˾��߹�������͹���:
SELECT MAX(sal),MIN(sal)
FROM emp
 
 
AVG()��SUM()
��ƽ��ֵ���ܺ�
 
�鿴��˾ƽ�������Լ������ۺ� 
SELECT AVG(sal),SUM(sal)
FROM emp
 
�鿴ƽ������,�����ܺ� 
SELECT AVG(comm),SUM(comm)
FROM emp

�������SQL����������ۺϺ�����
����NULLֵ�ġ�ֻ��4����¼comm��
ֵ������ƽ�������ܺͳ���4�Ľ����
SELECT ename,comm
FROM emp

���Խ�NULL�滻0��������ƽ����ͳ��
SELECT AVG(NVL(comm,0)) 
FROM emp 
 
COUNT()����
����ͳ��ָ���ֶη�NULL�ļ�¼�ܹ�
�����������������ֶξ���ȡֵ��

�鿴��˾�ܹ�������?
SELECT COUNT(ename)
FROM emp

ͨ���鿴һ�ű�ļ�¼��������ʹ��
COUNT(*)��
SELECT COUNT(*)
FROM emp
 
 
GROUP BY�Ӿ�
GROUP BY���Ը���ָ�����ֶ�ֵ��ͬ��
��¼���з��飬Ȼ������麯�����и���
����ͳ�ƹ�����
 
�鿴ÿ�����ŵ���߹�������͹���? 
SELECT MAX(sal),MIN(sal),deptno 
FROM emp
GROUP BY deptno
 
��SELECT�Ӿ��г����˾ۺϺ�������ô
�����ھۺϺ����е������ֶα��������
GROUP BY�Ӿ��С���֮���Ǳ���ġ�

���ֶη��飬���ǰ����⼸���ֶ�ֵ���
һ���Ŀ���һ��:
�г�ͬ����ְͬλ��Ա������߹�����
��͹���:
SELECT MAX(sal),MIN(sal),job,deptno 
FROM emp
GROUP BY job,deptno 


SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno

�鿴����ƽ�����ʸ���2000�Ĳ��ŵ�
ƽ������?
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

HAVING���ܶ������ڣ��������GROUP BY
�Ӿ�֮�����ڽ��з���ͳ�ƺ���й���ʹ��
��WHERE������:
WHERE���ڵ�һ�β���ʱ����й��ˣ�ֻ
������WHEREҪ��ļ�¼�Żᱻ��ѯ������
��HAVING���ڲ�ѯ�������ݻ����Ͻ�����
����ͳ�ƺ�õ��Ľ�����еĹ��ˡ�
����WHERE�Ƚ��еĹ��ˣ�HAVING����С�

HAVING�в���SELECT�в�ѯʲô���ſ���
���ڹ��ˡ�
�鿴ƽ�����ʸ���2000�Ĳ��ŵ���߹�����
��͹���:
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000


��������ѯ
��������ѯ������������ʮ����Ҫ�ģ�
���ܸ�֪���ݿ��ڱ���������֮�����
���������ҵ���Ӧ��ϵ���Ӷ���ѯ���ݡ�

�鿴SALES���ŵ�Ա������?
SELECT ename
FROM emp,dept
WHERE emp.deptno=dept.deptno
AND dept.dname='SALES'
 
�鿴ÿ��Ա�����֣����ű�ţ�
�������ƣ��������ڵ�?

SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
 
����ѯ���ֶ������ϲ�ѯ�ı��о���
���֣���ô������ȷָ�������ű���
ȡ���ֶε�ֵ��
����Ϊ����ӱ�����Ȼ��ʹ�ñ�����
�������ָ���ֶΡ�

N�ű��ѯ����Ҫ��N-1������������
�������ֵѿ�����
�ѿ�������������������ǲ�����
��¼�����˻��Ľ�����Ǹ����õĽ��
����������Դ�޴�Ҫ������֣�
 
SELECT e.ename,d.dname
FROM emp e,dept d
 
��DALLAS������Ա������˭?�����Ƕ���?
SELECT e.ename,e.sal
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.loc = 'DALLAS' 
 
ʹ��������ʵ�ֹ�����ѯ:
������ʹ��JOIN�����ӱ���ON
�Ӿ�����д������������Դ�ͳ��
������ѯ�����ԣ��ǽ���������
����������ֿ��ڲ�ͬ�ĵط���д��
������������
 
�鿴ÿ��Ա���Լ����ڲ�������
SELECT e.ename,d.dname
FROM emp e JOIN dept d
ON e.deptno = d.deptno
 
�鿴SALES����Ա����Ϣ 
SELECT e.ename,e.sal,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE d.dname='SALES'
 
ְλ��SALESMAN��Ա���������﹤��? 
SELECT e.job,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE e.job='SALESMAN'
 
SCOTT���Ÿ�Ϊ50��
UPDATE emp
SET deptno=50
WHERE ename='SCOTT'

�鿴ÿ��Ա�������֣�ְλ�����ʣ�
���źţ���������?
SELECT e.ename,e.job,e.sal,
       d.deptno,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno

SCOTTû�б���ѯ������ԭ����
SCOTT�����������������䲿��
����50����dept����û�в��ź�
��50�ļ�¼��

����Ҫ�����������������ļ�¼Ҳ�ڹ���
��ѯ����ʾ����ʱ����Ҫʹ�������ӡ�

�����ӷ�Ϊ�������ӣ��������ӣ�ȫ������
��������:��JOIN���ı�Ϊ������(��ʾ��
        �����ݵı�)������������е���
        �ε����������������ǣ�ȫ��
        ΪNULL��
        
�鿴����Ա����Ϣ�����в��Ž��䲿������ʾ
����:
SELECT e.ename,e.deptno,d.dname
FROM emp e LEFT|RIGHT|FULL 
           OUTER JOIN dept d
ON e.deptno=d.deptno
 
 
SELECT e.ename,e.deptno,d.dname
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno
 
 
 
 
 
 
 