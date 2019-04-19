create table f_user(
	id number(5) primary key ,--主键
	username varchar2(20) unique,--唯一性约束
	pwd varchar2(10),
	name varchar2(20),
	age number(3),
	gender char(1),
	phone varchar2(20),
	ask clob	--要求
	);
select * from f_user;
create sequence fuser_id_seq increment by 1 start with 1;--生成f_user中id的序列
select fuser_id_seq.nextval from dual;	
create table f_pic(--图片表，用来保存用户的照片
		id number(10) primary key ,
		picName varchar2(100),
		userId number(5)
	);
alter table f_pic add Constraint fpic_userId_fk Foreign key(userId) References f_user(id);--添加外键关联 	