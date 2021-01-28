create table boardlist(
	boardno int unsigned auto_increment,
	boardwriter varchar(200) not null,
	boardtitle varchar(200) not null,
	boardcontent varchar(1000) not null,
	boardregdate date not null,
	primary key(boardno)
)default charset=utf8;

insert into boardlist(boardwriter, boardtitle, boardcontent, boardregdate) values('관리자', '제목', '내용', now());