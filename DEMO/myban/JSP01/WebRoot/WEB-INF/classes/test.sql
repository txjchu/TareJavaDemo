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
insert into t_user values(user_id_seq.nextval, 'cat', '123456', '汤姆', 'm');
select * from t_user order by id;
update t_user set pwd='123455', name='狗狗' where id=2;
delete from t_user where id=5;
insert into t_user values(3, 'duck','123456','糖糖','w');

create table t_1(
	name varchar2(20),
	收入类型 varchar2(20),
	金额 number(12,2)
);
insert into t_1 values('tom', '月工资', 5000);
insert into t_1 values('tom', '年奖金', 5000);
update t_1 set 金额= 10000 where name='tom' and 收入类型='月工资';
update t_1 set 金额= 50000 where name='tom' and 收入类型='年奖金';
insert into t_1 values('jack', '月工资', 12000);
insert into t_1 values('jack', '年奖金', 80000);
select * from t_1;
select  name as 姓名, max(case   when 收入类型='月工资' then 金额 end) as 月工资, max(case when 收入类型='年奖金' then 金额 * 10 end) as 年奖金 from t_1 group by name;
select  name as 姓名, max(case 收入类型 when '月工资' then 金额 end) as 月工资, max(case 收入类型 when '年奖金' then 金额 * 10 end) as 年奖金 from t_1 group by name;
select name, max(case when 收入类型='月工资' then 金额 else 0 end) as 月工资 from t_1 group by name;
select name, '月工资', '年奖金' from t_1 group by name;bonus  
create table t_2(
	姓名 varchar2(20),
	月工资 number(12, 2),
	年奖金 number(12, 2)
);
select 金额 from t_1 where name='tom' and 收入类型='月工资';
insert into t_2 values('tom', (select 金额 from t_1 where name='tom' and 收入类型='月工资'),(select 金额 from t_1 where name='tom' and 收入类型='年奖金') );
update t_2 set 年奖金=((select 年奖金 from t_2 where 姓名='tom') * 10) where 姓名='tom';
insert into t_2 values('jack', (select 金额 from t_1 where name='jack' and 收入类型='月工资'),(select 金额 from t_1 where name='jack' and 收入类型='年奖金')*10 );
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












