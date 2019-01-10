--게시판-----------------------------------------------------------------------------------
--자유게시판 인덱스 시퀀스--
create SEQUENCE free_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence free_board_seq;

--자유게시판 공감수 시퀀스--
create sequence free_likes_seq
increment by 1 start with 1 nocache;

drop sequence free_likes_seq;
--자유게시판 테이블 생성--
create table free_board(
  free_b_num number not null, --글번호
  subject varchar2(250) not null, --제목
  content long not null, --글내용
  id varchar2(20) not null, --작성자
  hits number(6) default 0, --조회수
  likes number(6) default 0, --공감수
  wdate date, --작성일
  constraint free_b_num_pk primary key (free_b_num), --기본키 (글번호)
  constraint free_b_fk foreign key (id)  references user_Info(id) -- 참조키 (id) 
);

drop table free_board;

--자유게시판 댓글 인덱스 시퀀스--
create sequence free_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence free_board_reply_seq;

--자유게시판 댓글테이블 생성--
create table free_board_reply(
  free_b_r_num number not null, --댓글번호
  free_b_num number not null, --참조할 게시글번호
  id varchar2(20) not null, --댓글작성자
  content long not null,--댓글내용
  wdate date, --작성시간
  constraint free_b_r_num_pk primary key (free_b_r_num),
  constraint free_b_num_fk foreign key (free_b_num) 
  references free_board(free_b_num)
);

drop table free_board_reply;
----------------------------------------------------------------------------------------
--유머게시판 인덱스 시퀀스--
create SEQUENCE humor_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence humor_board_seq;
--유머게시판 공감수 시퀀스--
create sequence humor_likes_seq
increment by 1 start with 1 nocache;

drop sequence humor_likes_seq;
--유머게시판 테이블 생성--
create table humor_board(
  humor_b_num number not null, --글번호
  subject varchar2(250) not null, --제목
  content long not null, --글내용
  id varchar2(20) not null, --작성자
  hits number(6) default 0, --조회수
  likes number(6) default 0, --공감수
  wdate date, --작성일
  constraint humor_b_num_pk primary key (humor_b_num), --기본키 (글번호)
  constraint humor_b_fk foreign key (id)  references user_Info(id) -- 참조키 (id) 
);

drop table humor_board;

--유머게시판 댓글 인덱스 시퀀스--
create sequence humor_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence humor_board_reply_seq;

--유머게시판 댓글테이블 생성--
create table humor_board_reply(
  humor_b_r_num number not null,--댓글번호
  humor_b_num number not null, --참조할 게시글번호
  id varchar2(20) not null, --댓글작성자
  content long not null,--댓글내용
  wdate date, --작성시간
  constraint humor_b_r_num_pk primary key (humor_b_r_num),
  constraint humor_b_num_fk foreign key (humor_b_num) 
  references humor_board(humor_b_num)
);

drop table humor_board_reply;
--------------------------------------------------------------------------------------------
--음악게시판 인덱스 시퀀스--
create SEQUENCE music_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence music_board_seq;
--음악게시판 공감수 시퀀스--
create sequence music_likes_seq
increment by 1 start with 1 nocache;

drop sequence music_likes_seq;
--음악게시판 테이블 생성--
create table music_board(
  music_b_num number not null, --글번호
  subject varchar2(250) not null, --제목
  content long not null, --글내용
  id varchar2(20) not null, --작성자
  hits number(6) default 0, --조회수
  likes number(6) default 0, --공감수
  wdate date, --작성일
  constraint music_b_num_pk primary key (music_b_num), --기본키 (글번호)
  constraint music_b_fk foreign key (id)  references user_Info(id) -- 참조키 (id) 
);

drop table music_board;

--음악게시판 댓글 인덱스 시퀀스--
create sequence music_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence music_board_reply_seq;

--음악게시판 댓글테이블 생성--
create table music_board_reply(
  music_b_r_num number not null,--댓글번호
  music_b_num number not null, --참조할 게시글번호
  id varchar2(20) not null, --댓글작성자
  content long not null,--댓글내용
  wdate date, --작성시간
  constraint music_b_r_num_pk primary key (music_b_r_num),
  constraint music_b_num_fk foreign key (music_b_num) 
  references music_board(music_b_num)
);

drop table music_board_reply;

--------------------------------------------------------------------------------------------
--연예게시판 인덱스 시퀀스--
create SEQUENCE star_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence star_board_seq;
--연예게시판 공감수 시퀀스--
create sequence star_likes_seq
increment by 1 start with 1 nocache;

drop sequence star_likes_seq;
--연예게시판 테이블 생성--
create table star_board(
  star_b_num number not null, --글번호
  subject varchar2(250) not null, --제목
  content long not null, --글내용
  id varchar2(20) not null, --작성자
  hits number(6) default 0, --조회수
  likes number(6) default 0, --공감수
  wdate date, --작성일
  constraint star_b_num_pk primary key (star_b_num), --기본키 (글번호)
  constraint star_b_fk foreign key (id)  references user_Info(id) -- 참조키 (id) 
);

drop table star_board;

--연예게시판 댓글 인덱스 시퀀스--
create sequence star_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence star_board_reply_seq;

--연예게시판 댓글테이블 생성--
create table star_board_reply(
  star_b_r_num number not null,--댓글번호
  star_b_num number not null, --참조할 게시글번호
  id varchar2(20) not null, --댓글작성자
  content long not null,--댓글내용
  wdate date, --작성시간
  constraint star_b_r_num_pk primary key (star_b_r_num),
  constraint star_b_num_fk foreign key (star_b_num) 
  references star_board(star_b_num)
);

drop table star_board_reply;


--------------------------------------------------------------------------------------------
--유저정보---------------------------------------------------------------------------------
--유저인덱스
create sequence user_seq
increment by 1 start with 1 nocache;

drop sequence user_seq;

--유저정보 테이블
drop table user_Info;

create table user_Info(
  idx number(6) not null,
  id varchar2(20) not null,
  pwd varchar2(30) not null, 
  nickname varchar2(30) not null,
  email varchar2(120) not null,
  tel varchar2(11) not null,
  reg_date date not null,
  constraint user_id_pk primary key (id)
);


