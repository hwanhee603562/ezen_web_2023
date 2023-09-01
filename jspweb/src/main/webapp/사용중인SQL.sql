drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists visitlog;
create table visitlog(
	vno			int auto_increment , 		-- 식별번호( 방문록번호 ) , 자동번호 부여 
    vwriter 	varchar(30) not null , 		-- (방문록작성자명) , 공백불가능 
    vpwd 		varchar(10) not null , 		-- (방문록비밀번호) , 공백불가능 
    vcontent	text not null , 			-- (방문록 내용 ) 
    vdate		datetime default now() , 	-- (방문록 작성일/시간 ) , 생략시 자동날짜/시간 등록 
    primary key( vno )
);
drop table if exists member;
create table member(
	mno int auto_increment ,				-- 식별번호( 회원번호 ) , 자동번호 부여 
    mid varchar(50) not null unique ,		-- ( 회원아이디 ) , 공백불가능 , 중복불가능  
    mpwd varchar(20) not null , 			-- ( 회원비밀번호 ) , 공백불가능  
    memail varchar(50) not null unique ,	-- ( 회원이메일 )  , 공백불가능  
    mimg longtext ,							-- ( 회원 프로필의 이미지사진 이름 ) , 공백가능 
    primary key( mno )
);
drop table if exists library;
create table library(
   lno int auto_increment,    	-- 회원 번호
   lname varchar(20),          	-- 이름 
   lphone varchar(20) unique,   -- 전화번호 
   lseat int default 0,       	-- 현재 좌석번호
    primary key(lno)
);
drop table if exists hrm;
create table hrm(
	hno int auto_increment,    		-- 직원 번호
	himg longtext,       			-- 직원 사진
	hname varchar(30) not null, 	-- 직원이름 
	hphone varchar(30) unique,  	-- 전화번호 
	hrank varchar(30) not null,		-- 직급
    hdate datetime default now(),	-- 등록일
	primary key(hno)
);
use jspweb;

drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment,			-- 카테고리 번호
	bcname varchar(30) not null,		-- 카테고리명
    primary key(bcno)
);

drop table if exists board;
create table board(
	bno int auto_increment,			-- 번호
    btitile varchar(30) not null,	-- 제목
    bcontent longtext,				-- 내용
    bfile longtext,					-- 첨부파일
    bdate datetime default now(),	-- 작성일
    bview int default 0,			-- 조회수
    mno int,						-- 작성자
    bcno int,
    foreign key(mno) references member (mno) on delete cascade,	
	-- 회원탈퇴시 게시물도 같이 삭제 [제약조건]
    foreign key(bcno) references bcategory (bcno) on delete cascade on update cascade,
    -- 카테고리 삭제시 게시물도 삭제, 카테고리번호 변경시 fk도 같이 변경 [제약조건]
    primary key(bno)

);
delete from bcategory;
select * from bcategory;

insert into bcategory(bcname) value('공지사항');
insert into bcategory(bcname) value('자유게시판');
insert into bcategory(bcname) value('노하우');

















