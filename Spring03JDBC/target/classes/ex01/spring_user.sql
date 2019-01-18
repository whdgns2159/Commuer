--drop table spring_user;

create table spring_user(
	idx number primary key,
	name varchar2(30),
	userid varchar2(20) unique not null,
	pwd varchar2(20) not null,
	indate date
);

--drop sequence spring_user_idx_seq;
 
create sequence spring_user_idx_seq
start with 1
increment by 1
nocache;

insert into spring_user(idx,name,userid,pwd,indate)
values(spring_user_idx_seq.nextval,'홍길동','Hong','111', sysdate);

commit;