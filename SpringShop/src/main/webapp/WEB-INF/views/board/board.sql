/*게시판*/

drop table board;

create table board(
	idx number(8) constraint board_pk primary key,--글번호
	name varchar2(30) not null,--작성자
	pwd varchar2(20) not null,--비번
	subject varchar2(200),--제목
	content varchar2(2000),--내용
	wdate timestamp default systimestamp,--작성일
	readnum number(8) default 0, --조회수
	filename varchar2(200),--첨부파일명[년월일시분초_a.jpg]
	originFilename varchar2(200), --원본파일명[a.jpg]
	filesize number(8), --첨부파일 크기
	refer  number(8),--글그룹번호[답변형 게시판일 때 사용]
	lev  number(8), --답변 레벨[답변형 게시판일 때 사용]
	sunbun number(8)--같은 글 그룹내의 순서 정렬[답변형 게시판일 때 사용]
);

drop sequence board_seq;

create sequence board_seq nocache;






