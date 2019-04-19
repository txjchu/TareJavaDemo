select * from emp order by empno;
select e.empno, e.ename, e.job, e.sal, e.deptno, d.dname, d.loc from emp e right join dept d on e.deptno = d.deptno;
select e.empno, e.ename, e.job, e.sal, e.deptno, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno;
select empseq.currval from dual;
select account_seq.nextval from dual;
select account_seq.currval from dual;
select service_seq.nextval from dual;
drop sequence service_seq;
create sequence service_seq start with 2009 increment by 1;
select * from service;
select * from account;
insert into account values(1022, 1011,'zhang2','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345673',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1023, 1011,'zhang3','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345672',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1024, 1011,'zhang4','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345671',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1025, 1011,'zhang5','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345670',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1026, 1011,'zhang6','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345604',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1027, 1011,'zhang7','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345694',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1028, 1011,'zhang8','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345684',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1029, 1011,'zhang9','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345654',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(1030, 1020,'zhang0','zhang12345', 0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','012345678912345664',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(account_seq.nextval, 1019,'lili1','lili12345',   0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','025345678912345644',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(account_seq.nextval, 1019,'lili2','lili12345',   0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','034345678912345634',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(account_seq.nextval, 1019,'lili3','lili12345',   0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','043345678912345624',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(account_seq.nextval, 1019,'lili4','lili12345',   0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','052345678912345611',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
insert into account values(account_seq.nextval, 1019,'lili5','lili12345',   0, to_date('2012-12-12','YYYY-MM-DD'), null, null,'guojing','061345678912345004',to_date('1990-12-12','YYYY-MM-DD'),1,'daxia','12345678901','111@111.com','xxxadress',012345,'3277777',sysdate,'192.168.0.26' )  ;
commit;
select * from account order by account_id;
insert into emp values(empseq.nextval, 'ÓñµÛ', '×Ü¹Ü', null, sysdate, 9999.99, 9999.99, 10);












