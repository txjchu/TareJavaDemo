select * from account;
select * from emp where mgr = (select empno from emp where ename = 'tom') order by empno;
select * from emp where ename = 'marry';
select * from emp where empno between 3700 and 3710;
select * from dept;
select * from emp where ename = '泡泡';
select * from emp where deptno = 10;
update emp set job = 'ANALYST' WHERE ename = '张三';
update emp set job = 'MANAGER' WHERE ENAME = 'ROSE';
select deptseq.nextval from dual;
alter table dept modify(deptno NUMBER(4));
--创建一个序列，用于生成empno主键
CREATE Sequence emp_seq_forexer Start With 1 Increment By 1;
select emp_seq_forexer.nextval from dual;
select * from account;
drop table account;

--JDBCday03案例05
create table account(
		account_id number(9) constraint account1_id_pk primary key,--主键限制
		recommender_id number(9) constraint account1_recommender_id_fk references account(account_id),--外键限制
		login_name varchar2(30) not null,
		login_passwd varchar2(30) not null,
		status char(1) constraint account1_status_ck check(status in (0, 1, 2)) not null,--检查约束		
		create_date date default sysdate,
		pause_date date,
		close_date date,
		real_name varchar2(20) not null,
		idcard_no char(18) not null constraint account1_idcard_no unique,--唯一性约束
		birthdate date,
		gender char(1) constraint account1_gender_ck check(gender in (0, 1)) not null,--性别
		occupation varchar2(50),--职业
		telephone varchar2(15) not null,
		email  varchar2(50),
		mailaddress  varchar2(200),
		zipcode  char(6),
		qq  varchar2(15),
		last_login_time date,
		last_login_ip  varchar2(15)
		);
select * from account;
select account_recommender_id_fk from dual;
SELECT account_id_pk from dual;
select account_status_ck from dual;
select account_idcard_no from dual;
select account_gender_ck from dual;		
desc account;		
show columns from account;
select * from account;
select table_name from all_tables;--查看数据库中所有的表
desc all_tab_columns;
show table account;
Create Sequence account_seq ;
select account_seq.nextval from dual;
Insert Into account(account_id, recommender_id, login_name, login_passwd, status, create_date, pause_date, close_date, real_name, idcard_no, birthdate, gender, occupation, telephone, email, mailAddress, zipcode, qq, last_login_time, last_login_ip) 
			Values(account_seq.nextval, null, 'a', '123', '0', sysdate, null, null, 'zhangsan', '1234', to_date('1981-01-01','yyyy-mm-dd'), '0', 'job', '123', 'a@b.c', 'test avenue', '1223', '1234', sysdate, '192.168.22.22');
create sequence role_seq;
select role_seq.nextval from dual;
select * from role_info;
delete from role_info where role_id between 100 and 600;
insert into role_info(role_id,name)values(role_seq.nextval,'管理员');
insert into role_info(role_id,name)values(role_seq.nextval,'柜台人员');
insert into role_info(role_id,name)values(role_seq.nextval,'中层领导');
commit;













