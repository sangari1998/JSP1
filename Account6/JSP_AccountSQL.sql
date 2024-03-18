CREATE TABLE jsp_member (
    id        VARCHAR2(20)    PRIMARY KEY,
    password  VARCHAR2(30)    NOT NULL,
    name      VARCHAR2(20)    NOT NULL,
    tel       VARCHAR2(15)    NOT NULL,
    email     VARCHAR2(30)    NOT NULL,
    granted   VARCHAR2(10)    NOT NULL,
    CONSTRAINT check_granted CHECK (granted IN ('member', 'admin'))
);

select * from jsp_member;

insert into jsp_member values('joo888880','as15as19','주진홍','010-9064-4481','joo888889@naver.com','admin');

create table getPass (
	id			varchar2(20)			primary key,
	temp_pass		varchar2(10)			not null
);

select * from getpass;

create table jsp_accounting(
	seq			number(9)		primary key,
	regdate		date			not null,
	category	varchar2(15)	not null CHECK (category IN ('출금', '입금')),
	money		number(12)		not null,
	note		varchar2(20)	
);

create SEQUENCE seq_jsp_accounting
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

insert into jsp_accounting values (seq_jsp_accounting.nextval,'2024-02-02','입금',100000,'저축');
insert into jsp_accounting values (seq_jsp_accounting.nextval,'2024-02-24','출금',50000,'옷 구매');
insert into jsp_accounting values (seq_jsp_accounting.nextval,'2024-03-02','입금',200000,'지원금');
insert into jsp_accounting values (seq_jsp_accounting.nextval,'2024-02-21','출금',4000,'카페');
insert into jsp_accounting values (seq_jsp_accounting.nextval,'2024-03-03','입금',150000,'저축');
insert into jsp_accounting values (seq_jsp_accounting.nextval,'2024-03-04','출금',200000,'자전거 구매');

insert into jsp_accounting values (seq_jsp_accounting.nextval,regdate,?,?,?);

select max(seq)+1 from jsp_accounting;

select * from jsp_accounting order by seq desc; 

select * from jsp_accounting where regdate between '24/02/02' and '24/04/24' and category ='입금';
select * from jsp_accounting where regdate between '24/02/02' and '24/04/24' and category ='출금';

select * from jsp_accounting where seq = 1;

update jsp_accounting set regdate=sysdate,category='입금',money=10000,note='바꿔버림' where seq=1;

delete jsp_accounting where seq = '1';
rollback;
commit;

update jsp_accounting set category='출금',money=10000,note='바꿈' where seq=1;


drop table jsp_accounting;