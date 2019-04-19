SELECT *FROM emp_zyl;
CREATE TABLE t_account(id number(4) primary key,username varchar2(10),password varchar2(10));

--≤‚ ‘sql◊¢»Î
insert into t_account values(1,'aaa','aaa');
insert into t_account values(2,'ccc','ccc');
insert into t_account values(3,'ddd','ddd');

SELECT * FROM t_dept_lc;
SELECT * FROM t_accout_zyl;
SELECT * FROM account;
RENAME account TO accout;
select * from accout;
rename accout to account;
select account_id, login_name, login_passwd from account;
update account set login_passwd = '123456' where login_name = 'taiji001';
select * from account where login_name = 'taiji001';