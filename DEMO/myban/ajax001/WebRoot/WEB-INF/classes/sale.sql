select * from t_sale;
create table t_sale(
		id number(6) primary key,		--id
		prodName varchar2(20),			--产品
		qty number(10)					--销售量
		);
create sequence sal_id_seq increment by 1 start with 1;
insert into t_sale values(sal_id_seq.nextval, '耐克', 234);
select * from t_sale order by qty;
--查找销量最多的前4个产品
select * from ( select rownum r, a.* from (select * from t_sale order by qty desc) a) b where b.r < 4; 
