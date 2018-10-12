-- ��ȭ���� ���̺�
create table movie_info(
   title varchar2(50) constraint title_pk primary key,
   rating    varchar2(6) not null, --���
   genre     varchar2(20) not null, --�帣
   runtime   varchar2(6) not null,  --�ѻ󿵽ð�
   price number(6) not null  
);
INSERT INTO MOVIE_INFO VALUES('�ϼ�����','15��','����','110��',10000);
SELECT * FROM MOVIE_INFO;

--��ȭ ���������̺�
create table movie_schedule (
  movie_no int constraint movie_no_pk primary key,  --�������� �ֱ�
  gwan varchar2(50) not null, --�������
  title varchar2(50) constraint title_fk1 references movie_info(title) not null,
  m_date date not null, --��¥
  showtime varchar2(6) not null,  --���۽ð�
  remaining number(2) not null --�ܿ��ڼ�
);
create sequence MOVIE_SCHEDULE_seq nocache;
insert into movie_schedule values (movie_schedule_seq.nextval, '1��' , '�ϼ�����', '181012', '9:00', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1��' , '�ϼ�����', '181012', '20:30', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1��' , '�ϼ�����', '181012', '12:00', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1��' , '�ϼ�����', '181013', '9:30', 50);
insert into movie_schedule values (movie_schedule_seq.nextval, '1��' , '�ϼ�����', '181013', '11:00', 50);
SELECT * FROM MOVIE_SCHEDULE;

--���ǿ�ȭ ����Ȯ�� ���̺�
create table my_movie(
  my_no int primary key,   --�������� �ϱ�
  movie_no int references movie_schedule(movie_no),
  ph_no varchar2(11),  --�ڵ�����ȣ
  people number(2) not null,  --�ο�
  my_price number(6) not null
);
create sequence my_movie_seq nocache;
SELECT * FROM MY_MOVIE;

--�������̺����
CREATE TABLE DISCOUNT (
 num number(2) not null,
 dc_name varchar2(20) not null,
 dc_rate  number(2) 
);
insert into DISCOUNT values (1, '��Ż�����', 15);
insert into DISCOUNT values (2, 'ȸ������', 10);
insert into DISCOUNT values (3, '����', 0);

SELECT * FROM DISCOUNT;

COMMIT




