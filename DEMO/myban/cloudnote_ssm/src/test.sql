select * from cn_user;
select * from cn_note;
select cn_user_seq.nextval from dual;
--MySQL中没有序列？？？create sequence cn_user_seq start with 1000 increment by 1;
delete from cn_user where cn_user_name = 'tarena22';
delete from cn_user where cn_user_id = 'bf9d2885-f34e-4c78-9ae5-2723f62aa2b5';
select * from cn_notebook_type;
select * from cn_notebook;
