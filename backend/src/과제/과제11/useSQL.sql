drop database if exists sqldb4web;
create database sqldb4web;

drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;

drop table if exists member;
create table member(
	mno int not null unique,
    mid varchar(30) not null unique,	-- 자동부여[무조건 pk만가능]
    mpw varchar(30) not null,		-- 중복허용
    mname varchar(30) not null,		-- 중복허용
    mphone varchar(13) not null unique,
    primary key(mno)
    
)

