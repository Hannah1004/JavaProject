-- 영화정보 테이블
create table movie_info(
   title varchar2(50) constraint title_pk primary key,
   rating    varchar2(6) not null, --등급
   genre     varchar2(20) not null, --장르
   runtime   varchar2(6) not null,  --총상영시간
   price number(6) not null  
);
INSERT INTO MOVIE_INFO VALUES('암수살인','15세','범죄','110분',10000);
SELECT * FROM MOVIE_INFO;

--영화 스케쥴테이블
create table movie_schedule (
  movie_no int constraint movie_no_pk primary key,  --시퀀스로 주기
  gwan varchar2(50) not null, --몇관인지
  title varchar2(50) constraint title_fk1 references movie_info(title) not null,
  m_date date not null, --날짜
  showtime varchar2(6) not null,  --시작시간
  remaining number(2) not null --잔여자석
);
create sequence MOVIE_SCHEDULE_seq nocache;
insert into movie_schedule values (movie_schedule_seq.nextval, '1관' , '암수살인', '181012', '9:00', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1관' , '암수살인', '181012', '20:30', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1관' , '암수살인', '181012', '12:00', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1관' , '암수살인', '181013', '9:30', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1관' , '암수살인', '181013', '11:00', 50);
SELECT * FROM MOVIE_SCHEDULE;

--나의영화 내역확인 테이블
create table my_movie(
  my_no int primary key,   --시퀀스로 하기
  movie_no int references movie_schedule(movie_no),
  ph_no varchar2(11),  --핸드폰번호
  people number(2) not null,  --인원
  my_price number(6) not null
);
create sequence my_movie_seq nocache;
SELECT * FROM MY_MOVIE;

--할인테이블생성
CREATE TABLE DISCOUNT (
 num number(2) not null,
 dc_name varchar2(20) not null,
 dc_rate  number(2) 
);
insert into DISCOUNT values (1, '통신사할인', 15);
insert into DISCOUNT values (2, '회원할인', 10);
insert into DISCOUNT values (3, '없음', 0);

SELECT * FROM DISCOUNT;

COMMIT




