select * from t_emp;
select * from t_user;
--drop table t_user;
create table t_user(
	id number(4) primary key,
	username varchar2(20) unique,
	pwd varchar2(30),
	name varchar2(50),
	gender char(2)
);
create sequence user_id_seq increment by 1 start with 1;
insert into t_user values(user_id_seq.nextval, 'cat', '123456', '��ķ', 'm');
select * from t_user order by id;
update t_user set pwd='123455', name='����' where id=2;
delete from t_user where id=5;
insert into t_user values(3, 'duck','123456','����','w');

create table t_1(
	name varchar2(20),
	�������� varchar2(20),
	��� number(12,2)
);
insert into t_1 values('tom', '�¹���', 5000);
insert into t_1 values('tom', '�꽱��', 5000);
update t_1 set ���= 10000 where name='tom' and ��������='�¹���';
update t_1 set ���= 50000 where name='tom' and ��������='�꽱��';
insert into t_1 values('jack', '�¹���', 12000);
insert into t_1 values('jack', '�꽱��', 80000);
select * from t_1;
select  name as ����, max(case   when ��������='�¹���' then ��� end) as �¹���, max(case when ��������='�꽱��' then ��� * 10 end) as �꽱�� from t_1 group by name;
select  name as ����, max(case �������� when '�¹���' then ��� end) as �¹���, max(case �������� when '�꽱��' then ��� * 10 end) as �꽱�� from t_1 group by name;
select name, max(case when ��������='�¹���' then ��� else 0 end) as �¹��� from t_1 group by name;
select name, '�¹���', '�꽱��' from t_1 group by name;bonus  
create table t_2(
	���� varchar2(20),
	�¹��� number(12, 2),
	�꽱�� number(12, 2)
);
select ��� from t_1 where name='tom' and ��������='�¹���';
insert into t_2 values('tom', (select ��� from t_1 where name='tom' and ��������='�¹���'),(select ��� from t_1 where name='tom' and ��������='�꽱��') );
update t_2 set �꽱��=((select �꽱�� from t_2 where ����='tom') * 10) where ����='tom';
insert into t_2 values('jack', (select ��� from t_1 where name='jack' and ��������='�¹���'),(select ��� from t_1 where name='jack' and ��������='�꽱��')*10 );
select * from t_2;
insert into t_2 values(tom, 2222,1111);
select * from t_user order by id;
delete from t_user where pwd is NULL;
select * from t_user where username=null;
rollback;
select * from t_emp;
select * from t_user order by id;
select * from t_user where id=18;
select * from t_user where username IS NULL;
select * from t_user where pwd IS NULL;
delete from t_user where pwd=12;












