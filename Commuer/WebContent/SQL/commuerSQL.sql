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


