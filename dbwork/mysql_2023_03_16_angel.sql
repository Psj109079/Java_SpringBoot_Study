create table stu(
	num smallint auto_increment primary key,
    name varchar(20) not null,
    score smallint,
    today1 date,
    today2 datetime
);

select * from stu;
-- 컬럼 일부만 데이터 추가하기
insert into stu (name, score, today1, today2) values ('이나영', 89, now(), now()); 
-- 컬럼명 생략시 num에도 값을 넣어줘야 하는데 null 값 넣으면 시퀀스가 알아서 들어간다
insert into stu values (null, '김지숙', 79, now(), now());
-- 삭제
delete from stu where name = '이나영';
insert into stu (name, score, today1, today2) values ('강호동', 100, now(), now());
insert into stu (name, score, today1, today2) values ('이효리', 76, now(), now());
insert into stu (name, score, today1, today2) values ('이나영', 89, now(), now());

-- 날짜 포멧 양식을 이용해서 출력하기
select date_format(now(), '%Y-%m-%d') today from dual; -- 2023-03-16
select date_format(now(), '%y-%M-%d') today from dual; -- %y: 년도 2자리 %M: 문자열로
select date_format(now(), '%Y-%m-%d %H:%i') today from dual; -- %H: 24시간 %i: 분

-- stu 데이터 출력
select num, name, score, date_format(today2, '%Y-%m-%d %H:%i') today from stu;

-- insert score 빼고
insert into stu (name, today2) values ('이영자', now());
insert into stu (name, today2) values ('박민정', now());

select name, ifnull(score, 50) score from stu;

-- age 를 smallint 로 추가하는데 기본값을 10살로
alter table stu add age smallint default 10;
-- today1 컬럼을 제거
alter table stu drop column today1;
-- name 을 varchar(30)으로 수정
alter table stu modify name varchar(30);
-- today2 를 birthday로 수정
alter table stu rename column today2 to birthday;
