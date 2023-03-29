-- emp 테이블 전체 컬럼 조회 * = 테이블 전체 컬럼 출력
select * from emp;
-- emp 테이블에 있는 직업의 종류를 출력(같은 직업은 한번만)
select DISTINCT job from emp;
-- 컬럼명에 별칭을 지정
select ename as "사원명", job as "직업" from emp;
-- as생략, 별칭은 제목 중간에 공백이 없을 시 " 생략 가능
select ename "은행 사원명", job 직업 from emp;
--조건: empno 가 7369,7566 두개의 데이터 확인
select * from emp where empno = 7369 or empno = 7566;
-- SMITH,WARD 의 데이터 출력 (별칭 선언 제외 문자는 모두 ''로)
select * from emp where ename = 'SMITH' or ename = 'WARD';
-- in 연산자 (or 연산자로 조회하는경우 in 으로도 조회 가능)
select * from emp where ename in ('SMITH', 'WARD', 'SCOTT', 'FORD');
select * from emp where empno in (7369, 7654, 7788, 7876);
-- and 연산으로 조회하는 경우
select ename,job,sal,comm from emp where sal >= 1500 and sal <= 3000;
-- 위의 sql문을 between으로 조회 가능
select ename, job, sal, comm from emp where sal between 1500 and 3000;
-- 직업이 MANAGER인 사람중 sal이 2000 이상인사람
select * from emp where job = 'MANAGER' and sal >= 2000;
-- comm 이 null 인 경우만 출력
select * from emp where comm is null;
-- comm 이 null 이 아닌 경우만 출력
select * from emp where comm is not null;
-- ename 이 A로 시작하는 데이터 조회
select * from emp where ename like 'A%';
-- ename 이 S로 끝나는 데이터 조회
select * from emp where ename like '%S';
-- ename 이 A 나 S로 시작하는 데이터 조회
select * from emp where ename like 'A%' or ename like 'S%';
-- ename 의 2번째나 3번째 글자가 A인사람 조회
select * from emp where ename like '_A%' or ename like '__A%';
-- job 이 MANAGER 나 ANALYST 중 SAL 이 2500 이상인 사람만 조회
select * from emp where (job = 'MANAGER' or job = 'ANALYST') and SAL >= 2500;
-- in 으로 수정
select * from emp where job in ('MANAGER', 'ANALYST') and sal >= 2500;
-- SCOTT 의 연봉과 같은 연봉을 받는 사람을 조회 (서브쿼리 - SUBQUERY)
select * from emp where sal = (select sal from emp where ename = 'SCOTT');
-- ALLEN 의 직업과 같은 직업을 가진 사람을 조회
select * from emp where job = (select job from emp where ename = 'ALLEN');
-- console 에 출력 시 테이블명을 dual
-- ppt 48페이지 내장함수 중 - 숫자함수
select abs(-6), abs(6) from dual; -- abs: 절대값, 무조건 양수로 출력
select ceil(2.35), ceil(2.11), ceil(2) from dual; -- 무조건 올림 정수 반환
select floor(2.35), floor(2.11) from dual; -- 무조건 내림 정수 반환
select round(2.356, 1), round(2.223, 2) from dual; -- 소숫점 n째 자리까리구함(반올림)
select trunc(2.356, 1), trunc(2.223, 2) from dual; -- 소숫점 n째 자리까지 구함(내림)
select round(235678, -1), round(235678, -2) from dual; -- 235680, 235700
select power(2, 3), power(3, 4) from dual; -- 8, 81 제곱
select mod(7, 2), mod(10, 2) from dual; -- 나머지 구하기 1, 0

-- ppt 49페이지 내장함수 중 - 문자함수
select concat('JAVA', 'SPRING') from dual; -- 문자열 합치기
-- 문자열을 합칠경우 || 도 가능
select 'JAVA' || 'SPRING' from dual;
-- table emp로 해보기
select ename || '님의 직업은 ' || job || '입니다' message from emp; -- message 는 컬럼명
select ename, job abc from emp;
--table emp 로 해보기
select ename || '님의 연봉은 ' || sal || '만원 입니다' abc from emp;
select initcap(ename) from emp; -- 첫글자만 대문자로 출력
select upper(ename) ename, lower(ename) from emp; -- 대문자, 소문자로 변환 후 출력
-- lpad, rpad: 특정 문자로 채우기
select lpad('happy', 10, '*') from dual;
select rpad('happy', 10, '*') from dual;
select ename, lpad(sal, 10, '0') from emp;
-- substr: 문자열 추출
select substr('Happy Day', 3, 3), substr('Happy Day', -3, 3) from dual;
--             3번째글자부터 3글자          뒤에서 3번쨰부터 3글자
select rpad(substr(ename, 1, 2), 5, '*') ename from emp;
select substr(ename, 1, 2) || '***' ename from emp;
-- length 길이 구하기
select ename || '님의 글자 길이는 ' || length(ename) || '글자입니다' 메세지 from emp;
-- replace: 대치
select replace('Hello Kitty', 't', '*') from dual;
-- instr: 특정문자열의 위치 구하기
select instr('Good Day', 'Day') from dual; -- 6: 6번째에서 발견됨
select instr('Good Day', 'happy') from dual; -- 0: 없을경우 0

select '*' || trim('      he llo        ') || '*' from dual; -- 양쪽 공백 제거
select '*' || ltrim('      he llo        ') || '*' from dual; -- 왼쪽 공백만 제거
select '*' || rtrim('      he llo        ') || '*' from dual; -- 오른쪽 공백만 제거

-- sysdate = 현재날짜 구하기
select sysdate from dual;
-- 내일 날짜 구하기
select sysdate + 1 from dual;
-- 일주일 뒤
select sysdate + 7 from dual;
select sysdate + 359 from dual;

select to_char(sysdate, 'yyyy-mm-dd') today from dual; -- 2023-03-14
select to_char(sysdate, 'yyyy-mm-dd am hh:mi;ss') today from dual; -- 2023-03-14 오후 03:22:04
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') today from dual; -- 2023-03-14 15:22:04
select to_char(sysdate, 'YYYY-MM-DD hh24:mi:ss') today from dual;
select to_char(2345678, 'L999,999,999')from dual; -- 지역 화폐 단위로 나옴 ￦2,345,678
select to_char(2345678, 'L000,000,000')from dual;
-- 9 = 자릿수에 값이 없으면 나타내지 않음
-- 0 = 자릿수에 값이 없으면 0으로표시
select to_char(2345678, '$999,999,999')from dual; -- 달러 $2,345,678
select to_char(2.3, '0.00') from dual; -- 2.30 남는 자리는 0으로 채워짐

-- NVL: null일경우 특정갑으로 출력(Mysql 에서는 ifnull)
select nvl(mgr, 1000), nvl(comm, 0) from emp;
select sal + comm from emp; -- 연산값중 하나라도 null 일경우 결과값도 null
-- comm 이 null 일경우 10으로 계산
select sal + nvl(comm, 10) pay from emp;
-- decode: 값에 따라 서로 다른 값 출력
select ename, deptno, decode(deptno,10,'서울',20,'강원도',30,'경기도',40,'제주도') city from emp;

-- order 순서대로 출력
select ename, sal from emp order by ename asc; -- ename 의 오름차순(asc 생략가능)
select ename, sal from emp order by sal desc; -- sal 의 내림차순

-- 직업 오름차순 출력, 같은 직업일경우 연봉의 내림차순
select ename, job, sal from emp order by job, sal desc;
-- sal 의 오름차순 출력시 sal 이 3번째 출력하므로 열번호 3으로 정렬
select ename, job, sal from emp order by 3;

-- 연봉 1500 - 3000 까지만 출력하는데 이름의 오름차순
select ename, sal from emp where sal between 1500 and 3000 order by ename;

-- 그룹함수: ppt 57페이지
-- count, max, min, sum, avg
select count(*) from emp; -- emp 의 데이터 갯수
select max(sal) from emp; -- 최고급여
select min(sal) from emp; -- 최저급여
select sum(sal) from emp; -- 급여의 합계
select round(avg(sal), -1) from emp; -- 급여의 평균, 1원 단위에서 반올림

-- group 별 함수 적용
-- 각 직업별 인원수와 sal 의 평균을 구해보자
select job 직업, count(*) 인원수, round(avg(sal), -1) 평균연봉 from emp group by job;

-- 위의 쿼리문에서 인원수가 작은 것부터 출력
select job 직업, count(*) 인원수, round(avg(sal), -1) 평균연봉 from emp group by job group by job order by 2;

-- 위의 쿼리문에서 직업별 인원수가 3명 이상인 데이터만 출력
-- 그룹함수를 이용해서 조건을 나타낼때는 having 조건
select job 직업, count(*) 인원수, round(avg(sal), -1) 평균연봉 from emp group by job group by job having count(*) >= 3 order by 2;

-- 각 직업별로 인원수와 최고연봉, 최저연봉을 출력(직업의 오름차순)
select job 직업, count(*) 인원수, max(sal) 최고연봉, min(sal) 최저연봉 from emp group by job order by job; -- job == 컬럼번호 1 == 직업 

-- 위의 쿼리문에 금액앞에 화폐단위르 붙이고 3자리 컴마 추가
select job 직업, count(*) 인원수, to_Char(max(sal), 'L999,999') 최고연봉, to_char(min(sal), 'L999,999') 최저연봉 from emp group by job order by job;

-- 1. emp테이블에서 ename a나 s로 시작하는사람 출력(대소문자 상관없음)
select * from emp where lower(ename) like 'a%' or lower(ename) like 's%';
-- 2. emp테이블에서 ename 에서 두번째 글자가 'A' 인사람 출력
select * from emp where ename like '_A%';
-- 3. job 에서 같은 직업군일경우 한번씩만 출력하시오
select job from emp group by job;
select distinct job from emp;
-- 4. job 종류별로 인원수를 구하시오
select job 직업, count(*) 인원 from emp group by job;
-- 5. job 종류별로 sal 의 평균급여를 구하시오
select job 직업, round(avg(sal), 0) 평균급여 from emp group by job;
-- 6. job 종류별로 sal 의 최대값과 최소값을 구하시오
select job 직업, max(sal) 최대, min(sal) 최소 from emp group by job;
-- 7. deptno 가 10인경우 '홍보부'
-- 20 인경우 '개발부' 30인경우 '관리부' 부서를 구하여
-- ename, 부서 를 출력하시오
select ename, decode(deptno,10,'홍보부',20,'개발부',30,'관리부') 부서 from emp;
-- 8. 급여(sal)가 sal 의 평균보다 더 높은 사람만 ename 과 sal 을 출력하시오
select ename, sal from emp where sal > (select avg(sal) from emp);
-- 9. hiredate 에서 월이 5월인 사람만 ename 과 hiredate 를 출력하시오
select ename, hiredate from emp where substr(hiredate, 5, 1) = 5;
select ename, hiredate from emp where to_char(hiredate, 'mm') = 5;
-- 10. SCOTT 의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하라
select ename, sal from emp where sal >= (select sal from emp where ename = 'SCOTT');









