select * from t_sale;
create table t_sale(
		id number(6) primary key,		--id
		prodName varchar2(20),			--��Ʒ
		qty number(10)					--������
		);
create sequence sal_id_seq increment by 1 start with 1;
insert into t_sale values(sal_id_seq.nextval, '�Ϳ�', 234);
select * from t_sale order by qty;
--������������ǰ4����Ʒ
select * from ( select rownum r, a.* from (select * from t_sale order by qty desc) a) b where b.r < 4; 
