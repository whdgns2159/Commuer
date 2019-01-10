--�Խ���-----------------------------------------------------------------------------------
--�����Խ��� �ε��� ������--
create SEQUENCE free_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence free_board_seq;

--�����Խ��� ������ ������--
create sequence free_likes_seq
increment by 1 start with 1 nocache;

drop sequence free_likes_seq;
--�����Խ��� ���̺� ����--
create table free_board(
  free_b_num number not null, --�۹�ȣ
  subject varchar2(250) not null, --����
  content long not null, --�۳���
  id varchar2(20) not null, --�ۼ���
  hits number(6) default 0, --��ȸ��
  likes number(6) default 0, --������
  wdate date, --�ۼ���
  constraint free_b_num_pk primary key (free_b_num), --�⺻Ű (�۹�ȣ)
  constraint free_b_fk foreign key (id)  references user_Info(id) -- ����Ű (id) 
);

drop table free_board;

--�����Խ��� ��� �ε��� ������--
create sequence free_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence free_board_reply_seq;

--�����Խ��� ������̺� ����--
create table free_board_reply(
  free_b_r_num number not null, --��۹�ȣ
  free_b_num number not null, --������ �Խñ۹�ȣ
  id varchar2(20) not null, --����ۼ���
  content long not null,--��۳���
  wdate date, --�ۼ��ð�
  constraint free_b_r_num_pk primary key (free_b_r_num),
  constraint free_b_num_fk foreign key (free_b_num) 
  references free_board(free_b_num)
);

drop table free_board_reply;
----------------------------------------------------------------------------------------
--���ӰԽ��� �ε��� ������--
create SEQUENCE humor_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence humor_board_seq;
--���ӰԽ��� ������ ������--
create sequence humor_likes_seq
increment by 1 start with 1 nocache;

drop sequence humor_likes_seq;
--���ӰԽ��� ���̺� ����--
create table humor_board(
  humor_b_num number not null, --�۹�ȣ
  subject varchar2(250) not null, --����
  content long not null, --�۳���
  id varchar2(20) not null, --�ۼ���
  hits number(6) default 0, --��ȸ��
  likes number(6) default 0, --������
  wdate date, --�ۼ���
  constraint humor_b_num_pk primary key (humor_b_num), --�⺻Ű (�۹�ȣ)
  constraint humor_b_fk foreign key (id)  references user_Info(id) -- ����Ű (id) 
);

drop table humor_board;

--���ӰԽ��� ��� �ε��� ������--
create sequence humor_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence humor_board_reply_seq;

--���ӰԽ��� ������̺� ����--
create table humor_board_reply(
  humor_b_r_num number not null,--��۹�ȣ
  humor_b_num number not null, --������ �Խñ۹�ȣ
  id varchar2(20) not null, --����ۼ���
  content long not null,--��۳���
  wdate date, --�ۼ��ð�
  constraint humor_b_r_num_pk primary key (humor_b_r_num),
  constraint humor_b_num_fk foreign key (humor_b_num) 
  references humor_board(humor_b_num)
);

drop table humor_board_reply;
--------------------------------------------------------------------------------------------
--���ǰԽ��� �ε��� ������--
create SEQUENCE music_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence music_board_seq;
--���ǰԽ��� ������ ������--
create sequence music_likes_seq
increment by 1 start with 1 nocache;

drop sequence music_likes_seq;
--���ǰԽ��� ���̺� ����--
create table music_board(
  music_b_num number not null, --�۹�ȣ
  subject varchar2(250) not null, --����
  content long not null, --�۳���
  id varchar2(20) not null, --�ۼ���
  hits number(6) default 0, --��ȸ��
  likes number(6) default 0, --������
  wdate date, --�ۼ���
  constraint music_b_num_pk primary key (music_b_num), --�⺻Ű (�۹�ȣ)
  constraint music_b_fk foreign key (id)  references user_Info(id) -- ����Ű (id) 
);

drop table music_board;

--���ǰԽ��� ��� �ε��� ������--
create sequence music_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence music_board_reply_seq;

--���ǰԽ��� ������̺� ����--
create table music_board_reply(
  music_b_r_num number not null,--��۹�ȣ
  music_b_num number not null, --������ �Խñ۹�ȣ
  id varchar2(20) not null, --����ۼ���
  content long not null,--��۳���
  wdate date, --�ۼ��ð�
  constraint music_b_r_num_pk primary key (music_b_r_num),
  constraint music_b_num_fk foreign key (music_b_num) 
  references music_board(music_b_num)
);

drop table music_board_reply;

--------------------------------------------------------------------------------------------
--�����Խ��� �ε��� ������--
create SEQUENCE star_board_seq 
increment by 1 START WITH 1 nocache;

drop sequence star_board_seq;
--�����Խ��� ������ ������--
create sequence star_likes_seq
increment by 1 start with 1 nocache;

drop sequence star_likes_seq;
--�����Խ��� ���̺� ����--
create table star_board(
  star_b_num number not null, --�۹�ȣ
  subject varchar2(250) not null, --����
  content long not null, --�۳���
  id varchar2(20) not null, --�ۼ���
  hits number(6) default 0, --��ȸ��
  likes number(6) default 0, --������
  wdate date, --�ۼ���
  constraint star_b_num_pk primary key (star_b_num), --�⺻Ű (�۹�ȣ)
  constraint star_b_fk foreign key (id)  references user_Info(id) -- ����Ű (id) 
);

drop table star_board;

--�����Խ��� ��� �ε��� ������--
create sequence star_board_reply_seq
increment by 1 start with 1 nocache;

drop sequence star_board_reply_seq;

--�����Խ��� ������̺� ����--
create table star_board_reply(
  star_b_r_num number not null,--��۹�ȣ
  star_b_num number not null, --������ �Խñ۹�ȣ
  id varchar2(20) not null, --����ۼ���
  content long not null,--��۳���
  wdate date, --�ۼ��ð�
  constraint star_b_r_num_pk primary key (star_b_r_num),
  constraint star_b_num_fk foreign key (star_b_num) 
  references star_board(star_b_num)
);

drop table star_board_reply;


--------------------------------------------------------------------------------------------
--��������---------------------------------------------------------------------------------
--�����ε���
create sequence user_seq
increment by 1 start with 1 nocache;

drop sequence user_seq;

--�������� ���̺�
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


