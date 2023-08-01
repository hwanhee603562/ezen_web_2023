/* 여기에 SQL문을 작성해서 DB관리할 예정 */
-- 한줄주석


/*
	- 데이터베이스의 종류
		1. 계층형 데이터 베이스 		: 트리형태
        2. 네트워크형 데이터 베이스 	: 양방향 형태
        3. 관계형 데이터 베이스 		: 행/열 구성되는 테이블[표] 형태
        4. NoSQL 데이터 베이스 		: key-value 형태


	- 용어
		DBA[ 데이터베이스 관리자 ]
        
        DBMS[ 데이터베이스 관리 시스템]
			- MYSPL, ORACLE, MARIADB, SQLSERVER - 각 회사별 소프트웨어
			- SQL [ 구조화된 질의 언어 ]
        DB[ 데이터베이스 ]
			- 실제 데이터 저장된 곳 = DB SERVER
            - 메모리 [ 16진수/기계어 ] : 개발자가 직접적으로 관리하기가 힘듬
            
         
	- SQL	: DB 조작/관리/제어할 때 사용되는 언어/문법 (대소문자 구분x)
		1. DDL [ 데이터베이스 정의어 ]
			- CREATE	: 데이터베이스, 테이블 생성
				- CREATE DATABASE DB명;
                - create table table명( 필드명 속성명 , 필드명 속성명 , 필드명 속성명 );
            - DROP		: 데이터베이스, 테이블 삭제
				- DROP DATABASE DB명;
                - drop database if exists db명;
            - ALTER		: 테이블 속성 수정
            - TRUNCATE	: 테이블 내 데이터 초기화/삭제
            - RENAME	: 테이블의 이름 변경
            - SHOW
				- SHOW DATABASES;					: 데이터베이스 전체 목록보기
                - SHOW VARIABLES LIKE 'datadir';	: 데이터베이스 저장소 로컬 경로 확인
			
        2. DML [ 데이터베이스 조작어 ]
			- INSERT	: 테이블에 레코드(행) 삽입
            - SELECT	: 테이블에 레코드(행) 조회
				- select * from 테이블명	: 테이블내 모든 필드의 레코드(행) 검색 [ * : 와일드카드(모든) ]
            - UPDATE	: 테이블에 레코드(행) 수정
            - DELETE	: 테이블에 레코드(행) 삭제
        3. DCL [ 데이터베이스 제어어 ]
			- GRANT		: 사용자 권한 부여
            - REVOKE	: 사용자 권한 취소
        4. TCL [ 트렌잭션 제어어 ]
			- COMMIT	: ★ 트랜젝션[명령어 단위] 완료
            - ROLLBACK	: 트랜잭션[명령어 단위] 취소
            
            
		- 데이터 필드 타입	[ DBMS마다 다름 ]
			() : 바이트단위
            - 정수
					tinyint(1)		: -128 ~ 127
                    smallint(2)		: 약 +-3만
                    midiumint(3)	: 약 +-8백만
                    int(4)			: 약 +-21억
                    bigint(8)		: 약 +-21억 이상('경' 단위)
			- 실수
					float(4), double(8)
			- 문자[ 여기서의 소괄호는 글자의 수를 사전에 설정하는 것으로 길이가 넘어갈 경우 잘리게 된다 ]
					[ 글자수 최소1~ 최대255 ]
					char	[문자길이 - 고정길이]		char(3) 	-> 'ab' == 3바이트		[저장할 데이터의 글자 수가 정확히 정해져 있는 경우]
                    [ 글자수 최소1~ 최대65535 ]	*myspl 8버전 기준
                    varchar	[문자길이 - 가변길이]		varchar(3)	-> 'ab' == 2바이트		[저장할 데이터의 글자 수가 정확하지 않을 경우]
			- 날짜
					date(YYYY-MM-DD), time(HH:MM:SS), datetime(YYYY-MM-DD HH:MM:SS)
			- 대용량
					[최소1 ~ 최대65535]
					text
                    [최소1 ~ 최대 16000000]
                    mediumtext
					longtext(4GB)	: 긴 글 텍스트 등에 사용
			- 논리
					boolean(1)		: 0 or 1

		
*/

-- 예1 : 데이터베이스( 여러 개의 테이블들이 저장되는 공간 ) 생성
CREATE DATABASE sqldb1;
	# CREATE		: 생성한다
    # DATABASE		: 데이터베이스
    # sqldb1		: 이름정의
	# ;				: 명령어 끝마침.
		# 실행 : 해당 명령어 줄에 커서 위치한 상태에서 ctrl + enter
        
CREATE DATABASE sqldb2;
CREATE DATABASE sqldb3;
CREATE DATABASE sqldb4;

-- 예2 : 데이터베이스 목록 보기
SHOW DATABASES;

-- 예3 : 데이터베이스가 저장된 로컬[PC] 경로 확인
SHOW VARIABLES LIKE 'datadir';

-- 예4 : 데이터베이스 삭제
DROP DATABASE sqldb1;
DROP DATABASE sqldb2;
DROP DATABASE sqldb3;
DROP DATABASE sqldb4;
	# DROP		: 삭제한다
    # DATABASE	: 데이터베이스
    # sqldb1	: DB명
    
-- 예5 : 만약에 데이터베이스 존재했을 때 삭제 [ *만약에 데이터베이스 없을 때 삭제명령어 사용하면 오류발생 ]
DROP DATABASE IF EXISTS sqldb1;
	# if exists 	: 만약에 존재하면
    
    
CREATE DATABASE sqldb1;
CREATE DATABASE sqldb2;
-- 예6 : 여러 개의 데이터베이스 중 사용할 데이터베이스 선택
USE sqldb1;
USE sqldb2;
    
/*-----------------------------------------------------*/    
-- 활용1 : 데이터베이스 새롭게 생성
-- 1. 데이터베이스 존재하면 삭제처리
DROP DATABASE IF EXISTS test1;
-- 2. 데이터베이스 생성
CREATE DATABASE test1;
-- 3. 데이터베이스 사용준비
USE test1;
    

/*---------------------활용1 테이블만들기----------------------*/
-- 테이블은 데이터베이스 안에 저장되는 테이블 [ * 무슨 데이터베이스에서 생성할 것인지 'USE DB명']
-- 예1 : 테이블 생성
USE sqldb1;						-- 테이블을 생성할 데이터베이스 선택
CREATE TABLE member(			-- 테이블 생성
	아이디 text, 비밀번호 text		-- ()소괄호를 이용하여 테이블의 속성/열/필드 정의		-- (필드명 타입, 필드명 타입member비밀번호아이디, ....)
);		

-- 예2 : 테이블 확인
SELECT * FROM member;

-- 예3 : 테이블 삭제
DROP TABLE member;



/*---------------------활용2----------------------*/
-- 문제1

/*
	문제1 : 
		1. 웹개발 하는데 DB저장소 'sqldb1web' 이름으로 DB 생성
		2. 해당 db에 member 테이블 생성 
			id( 문자열 최대 20 )	
            password( 문자열 최대 10 )
*/


-- 1 만약에 생성할 이름의 db명이 존재하면 삭제
DROP database if exists sqldb1web;

-- 2 DB생성
CREATE database sqldb1web;

-- 3 DB 사용 선택
USE sqldb1web;

-- 4 table 생성 전 생성할 이름의 테이블명이 존재하면 삭제
DROP table if exists member;

-- 5 테이블 생성 (필드명 타입, 필드명 타입)
CREATE TABLE member(
	id varchar(20), password varchar(20)
);

-- 6 테이블생성 여부 확인
SELECT * FROM member;



-- 문제2


/*
	문제2 : 
		1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
		2. 해당 db에 board 테이블 생성 
				게시물번호 	( 필드명 :no  		타입 : 최대 21억정도 )
				게시물제목		( 필드명 :title 		타입 : 문자열 최대 100 )	
				게시물내용 	( 필드명 :content 	타입 : 문자열 최대 6만5천 이상 )
				게시물조회수	( 필드명 :view 		타입 : 최대 21억정도 )
				게시물작성일 	( 필드명 :date 		타입 : 날짜/시간 )
*/



-- 1 데이터베이스 생성
DROP database if exists sqldbweb2;
create database sqldb1web2;
-- 2 테이블 생성
USE sqldb1web2;
DROP table if exists board;
create table board(
	no int, tilte varchar(100), contnet longtext, view int, date datetime
);
select * from board



























