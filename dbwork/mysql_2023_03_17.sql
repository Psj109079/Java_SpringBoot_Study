-- sawon 에 제약조건 추가하기
-- score 는 0 ~ 100 만 추가 가능하도록 제약조건 추가
alter table sawon add constraint sawon_ck_score check (score between 0 and 100);

-- gender 에 '남자', '여자' 만 가능하도록 check 제약조건 추가
alter table sawon add constraint sawon_ck_gender check(gender in ('남자', '여자'));

-- mysql 에서 제약조건 확인하기
select * from information_schema.table_constraints where table_name = 'sawon';

-- 데이터 추가
insert into sawon values(null, '이상아', 78, '여자', '홍보부');
insert into sawon (name, score , gender) values ('강호동', 89, '남자');
insert into sawon values(null, '이효리', 100, '여자', '인사부');
insert into sawon values(null, '유재석', 99, '남자', '교육부');
insert into sawon values(null, '강인호', 69, '남자', '인사부');

-- 쿼리문 연습하기
-- 강씨 성을 가진 사람의 인원 수 구하기
select count(num) from sawon where name like '강%';

-- 평균 점수보다 높은 사람 출력하기
select * from sawon where score > (select avg(score) from sawon);

-- 부서별 인원수와 평균점수 최고점수 최저점수 구하기(제목도 수정)
select buseo 부서, count(buseo) 인원수, round(avg(score), 1) 평균점수 , max(score) 최고점수 , min(score) 최저점수 
from sawon group by buseo; 
select buseo, count(buseo) emp, round(avg(score), 1) avgscore, max(score) maxscore, min(score) minscore 
from sawon group by buseo; 
-- 인사부에서 이씨성을 가진사람이 누가 있는지 출력
select * from sawon where name like '이%' and buseo = '인사부';

-- 이효리의 부서를 '교육부' 로 수정
update sawon set buseo = '교육부' where name = '이효리';
update sawon set buseo = '인사부' where name = '이효리';

-- join 연습할 서브 테이블 생성 (on delete cascade) sawoninfo idx, num(외래키), addr, hp, age 컬럼
-- 부모테이블 테이터 삭제 시 서브테이블 데이터 자동 삭제하려면 제약조건 뒤에 on delete cascade 추가
create table sawoninfo(
	idx smallint auto_increment primary key,
    num smallint,
    addr varchar(30),
    hp varchar(20),
    age smallint,
    constraint info_fk_num foreign key(num) references sawon(num)
);

desc sawoninfo;
-- 제약조건 확인
select * from information_schema.table_constraints where table_name = 'sawoninfo';
-- sawoninfo 데이터 추가(반드시 sawon 의 num 에 있는 값만 넣을 수 있다)
insert into sawoninfo values (null, 2, '강남구', '010-2222-3333', 35);
insert into sawoninfo values (null, 1, '강서구', '010-5656-3333', 31);
insert into sawoninfo values (null, 4, '영등포구', '010-1212-3333', 28);
insert into sawoninfo values (null, 5, '강동구', '010-9999-3333', 25);

-- sawoninfo 만 데이터 확인
select * from sawoninfo;

-- sawon 테이블과 join 으로 사원정보 모두 출력하기
-- join 방법 1
select sawon.num, name, gender, buseo, age, hp, addr, score
from sawon, sawoninfo info where sawon.num = info.num;

-- 컬럼명 대신에 * 도 가능
select *
from sawon, sawoninfo info where sawon.num = info.num;

-- join 방법 2
select sawon.num, name, gender, buseo, age, hp, addr, score
from sawon 
inner join sawoninfo on sawon.num = sawoninfo.num;

-- on delete cascade: sawon 에서 2번 데이터 삭제 시 sawoninfo 에서도 삭제된다

alter table sawoninfo drop constraint info_fk_num;
alter table sawoninfo add constraint info_fk_num foreign key(num) references sawon(num) on delete cascade;

delete from sawon where num = 2;
-- join 으로 데이터 다시 확인
select sawon.num, name, gender, buseo, age, hp, addr, score
from sawon 
inner join sawoninfo on sawon.num = sawoninfo.num;

-- mysql 함수들 연습
select now() from dual; -- 현재 날짜와 시간 
select year(now()) from dual; -- 2023 년도만 추출
select month(now()) from dual; -- 월만 추출 3
select monthname(now()) from dual; -- 월을 영어로
select dayname(now()) from dual; -- 요일을 영어로
select dayofmonth(now()) from dual; -- 일

-- 문자 함수
select concat('Happy', 'Day', '!!') from dual; -- concat 문자열합치기(갯수 제한x)
select replace('Hello', 'e', '*') from dual; -- 특정문자 치환
select instr('Happy Day', 'Day') from dual; -- 위치 찾기
select left('Bitcamp 701 Class', 7) from dual; -- 왼쪽에서 7글자 추출
select right('Bitcamp 701 Class', 9) from dual; -- 오른쪽에서 9글자 추출
select mid('Bitcamp 701 Class', 9, 3) from dual; -- 9번째부터 3글자 추출
select substring('Bitcamp 701 Class', 9, 3) from dual; -- 9번째부터 3글자 추출
select concat('*', trim('              he     llo             '), '*') from dual; -- 양쪽 공백 제거
select concat('*', ltrim('              he     llo             '), '*') from dual; -- 왼쪽 공백 제거
select concat('*', rtrim('              he     llo             '), '*') from dual; -- 오른쪽 공백 제거
select ucase('Happy'), upper('Happy') from dual; -- 두 함수 모두 대문자로 치환
select lcase('Happy'), lower('Happy') from dual; -- 두 함수 모두 소문자로 치환
select reverse('Happy') from dual; -- 거꾸로 출력

-- 숫자 함수
select ceiling(7.1), ceil(7.1) from dual; -- 올림
select floor(7.9) from dual; -- 무조건 내림
select round(7.47, 1) from dual; -- 반올림
select round(7.478, 2) from dual; -- 반올림
select mod(7, 2) from dual; -- 나머지
select greatest(12, 34, 56, 100, 66) from dual; -- 변수 중 가장 큰 숫자 
select least(12, 34, 56, 100, 66) from dual; -- 변수 중 가장 작은 숫자 

select count(*) cnt from sawon

