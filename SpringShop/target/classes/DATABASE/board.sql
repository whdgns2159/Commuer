/*�Խ���*/

drop table board;

create table board(
	idx number(8) constraint board_pk primary key,--�۹�ȣ
	name varchar2(30) not null,--�ۼ���
	pwd varchar2(20) not null,--���
	subject varchar2(200),--����
	content varchar2(2000),--����
	wdate timestamp default systimestamp,--�ۼ���
	readnum number(8) default 0, --��ȸ��
	filename varchar2(200),--÷�����ϸ�[����Ͻú���_a.jpg]
	originFilename varchar2(200), --�������ϸ�[a.jpg]
	filesize number(8), --÷������ ũ��
	refer  number(8),--�۱׷��ȣ[�亯�� �Խ����� �� ���]
	lev  number(8), --�亯 ����[�亯�� �Խ����� �� ���]
	sunbun number(8)--���� �� �׷쳻�� ���� ����[�亯�� �Խ����� �� ���]
);

drop sequence board_seq;

create sequence board_seq nocache;






