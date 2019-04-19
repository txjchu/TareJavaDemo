create table f_user(
	id number(5) primary key ,--����
	username varchar2(20) unique,--Ψһ��Լ��
	pwd varchar2(10),
	name varchar2(20),
	age number(3),
	gender char(1),
	phone varchar2(20),
	ask clob	--Ҫ��
	);
select * from f_user;
create sequence fuser_id_seq increment by 1 start with 1;--����f_user��id������
select fuser_id_seq.nextval from dual;	
create table f_pic(--ͼƬ�����������û�����Ƭ
		id number(10) primary key ,
		picName varchar2(100),
		userId number(5)
	);
alter table f_pic add Constraint fpic_userId_fk Foreign key(userId) References f_user(id);--���������� 	