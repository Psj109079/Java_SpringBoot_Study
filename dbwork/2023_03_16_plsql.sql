-- PLSQL 연습용 테이블과 연습용 시퀀스 생성
create sequence seq_test nocache; -- 1부터 1씩증가하는 시퀀스(cache size = 0)

create table shop (
    num number(3) constraint shop_pk_num primary key,
    sangpum varchar2(30),
    su number(3),
    dan number(7),
    today date
);

-- 기본 데이터 5개정도 추가
insert into shop values (seq_test.nextval, '청바지', 2, 19000, sysdate);
insert into shop values (seq_test.nextval, '통바지', 1, 21000, sysdate);
insert into shop values (seq_test.nextval, '백바지', 1, 23000, sysdate);
insert into shop values (seq_test.nextval, '티셔츠', 3, 27000, sysdate);
insert into shop values (seq_test.nextval, '블라우스', 2, 32000, sysdate);
commit;

-- PL-SQL: SQL 언어에 절차적 요소를 추가해서 프로그래밍한것을 PLSQL 이라고 한다
-- 형식 
--DECLARE
--  변수선언, 커서 선언
--BEGIN
--  각종 출력 또는 로직들....  
--  DBMS_OUTPUT.PUT_LINE(); (한줄출력 명령어(자바 println 과 비슷함)
--END;
-- set serveroutput on -- 콘솔창에 결과값 나오게 하기 (default = off)
set serveroutput off -- 콘솔창에 결과값 안나오게 하기 (default = off)

DECLARE
    v_no number(4,1); -- 4자리 숫자, 소수점 이하 1자리
BEGIN
    v_no := 10; -- 값 대입
    DBMS_OUTPUT.PUT_LINE('숫자는 '|| v_no ||'입니다'); -- 출력 (put_line: 출력 후 줄넘김)
END;
/

-- shop 테이블에서 특정 상품정보 얻어오기
DECLARE
    v_sangpum varchar2(30);
    v_su number(3);
    v_dan number(7);
    v_num number(3) := 1; -- 검색해서 가져올 num 값
BEGIN
    select sangpum, su, dan
    into v_sangpum, v_su, v_dan
    from shop where num = v_num;
    DBMS_OUTPUT.PUT_LINE(v_num || '번 상품설명');
    DBMS_OUTPUT.PUT_LINE('상품명: ' || v_sangpum);
    DBMS_OUTPUT.PUT_LINE('수 량: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('단 가: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('총금액: ' || v_su * v_dan);
END;
/

-- 위의 코드를 수정해서 상품명으로 검색해서 데이터를 출력하시오
DECLARE
    v_sangpum varchar2(30) := '청바지';
    v_su number(3);
    v_dan number(7);
    v_num number(3) := 1;
BEGIN
    select num, su, dan
    into v_num, v_su, v_dan
    from shop where sangpum = v_sangpum;
    DBMS_OUTPUT.PUT_LINE(v_sangpum || ' 상품설명');
    DBMS_OUTPUT.PUT_LINE('시퀀스값: ' || v_num);
    DBMS_OUTPUT.PUT_LINE('수 량: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('단 가: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('총금액: ' || v_su * v_dan);
END;
/

DECLARE
    v_sangpum varchar2(30) := '청바지';
    v_su number(3);
    v_dan number(7);

BEGIN
    select su, dan
    into v_su, v_dan
    from shop where sangpum = v_sangpum;
    DBMS_OUTPUT.PUT_LINE(v_sangpum || ' 상품설명');
    DBMS_OUTPUT.PUT_LINE('수 량: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('단 가: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('총금액: ' || v_su * v_dan);
END;
/

-- 조건문 
/*
    if 조건식 then
        문장1;
    else
        문장2;
    end if;
다중 조건문
    if 조건식 1 then
        문장1;
    elsif 조건식 2 then
        문장2;
    ........
    end if;
*/

-- 특정년도가 무슨띠인지 구하기
-- 년도를 키보드로 입력받아서 띠를 알아볼 수 있도록 수정하기
accept k_year prompt '년도 4자리를 입력해주세요';
declare
    v_year number(6):= '&k_year';
    v_mod number(2) := mod(v_year, 12); -- 년도를 12로 나눈 나머지
    v_ddi varchar2(10); -- 띠를 구해서 저장
begin
    if v_mod = 0 then v_ddi := '원숭이';
    elsif v_mod = 1 then v_ddi := '닭';
    elsif v_mod = 2 then v_ddi := '개';
    elsif v_mod = 3 then v_ddi := '돼지';
    elsif v_mod = 4 then v_ddi := '쥐';
    elsif v_mod = 5 then v_ddi := '소';
    elsif v_mod = 6 then v_ddi := '호랑이';
    elsif v_mod = 7 then v_ddi := '토끼';
    elsif v_mod = 8 then v_ddi := '용';
    elsif v_mod = 9 then v_ddi := '뱀';
    elsif v_mod = 10 then v_ddi := '말';
    elsif v_mod = 11 then v_ddi := '양';
    end if;
    dbms_output.put_line(v_year || '년생은 ' || v_ddi || '띠 입니다');
end;
/

-- 숫자를 입력받아 홀수 짝수 판별
accept k_num prompt '숫자 입력';
declare
    v_num number(10) := '&k_num';
    v_s varchar2(6);
begin
    if mod(v_num, 2) = 0 then v_s := '짝수';
    else v_s := '홀수';
    end if;
    dbms_output.put_line(v_num || '는 ' || v_s || ' 입니다');
end;
/

/*
    반복문
    loop
        명령;
        exit when 조건; (종료조건)
    end loop;
*/
accept k_dan prompt '구구단 숫자를 입력해주세요';
declare
    v_dan number(3) := '&k_dan';
    v_idx number(2) := 1;
begin
    dbms_output.put_line('***['|| v_dan ||'단]*');
    
    loop
        dbms_output.put_line(v_dan || ' * ' || v_idx || ' = ' || v_dan * v_idx);
        v_idx := v_idx + 1;
        exit when v_idx > 9;
    end loop;
end;
/

/*
    또 다른 조건문 case
    
    변수 :=
        case 표현식
            when 값1 then 결과1
            when 값1 then 결과1
            when 값1 then 결과1
            else 결과4
        end;
*/
declare
    v_grade char(1) := 'D';
    v_msg varchar2(15);
begin
    v_msg :=
        case v_grade
            when 'A' then  'Excellent!!'
            when 'B' then  'Very Good!!'
            when 'C' then  'Good!!'
            else 'Try' 
        end;
    dbms_output.put_line(v_grade || '학점은 ' || v_msg);
end;
/
-- exception 처리
DECLARE
    v_sangpum varchar2(30) := '&k_sang'; -- 키보드로 입력시 가져올 상품명
    v_su number(3);
    v_dan number(7);
    v_num number(3) := 1;
BEGIN
    select num, su, dan
    into v_num, v_su, v_dan
    from shop where sangpum = v_sangpum;
    DBMS_OUTPUT.PUT_LINE(v_sangpum || ' 상품설명');
    DBMS_OUTPUT.PUT_LINE('시퀀스값: ' || v_num);
    DBMS_OUTPUT.PUT_LINE('수 량: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('단 가: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('총금액: ' || v_su * v_dan);
    
    -- 오라클에서 예외 처리하는 방법
    exception 
        when NO_DATA_FOUND then
            dbms_output.put_line(v_sangpum || ' 상품은 DB에 없습니다');
        when too_many_rows then
            dbms_output.put_line(v_sangpum || ' 상품이 여러개 있습니다');
        when oters then
            dbms_output.put_line('알수없는 예외발생');
END;
/

-- shop 테이블 수정
-- shop 테이블에 color 컬럼을 추가하고 기본색을 'green'
alter table shop add color varchar2(20) default 'GREEN';
-- 3번은 pink 5번은 yellow 로 수정
update shop set color = 'PINK' where num = 3;
update shop set color = 'YELLOW' where num = 5;

-- 데이터 추가: 중복된 상품명도 넣기
insert into shop values (seq_test.nextval, '블라우스', 1, 19000, sysdate, 'ORANGE');
insert into shop values (seq_test.nextval, '반바지', 3, 34000, sysdate, 'BLUE');
insert into shop values (seq_test.nextval, '레이스티셔츠', 4, 7000, sysdate, 'GRAY');
insert into shop values (seq_test.nextval, '찢어진청바지', 2, 99000, sysdate, 'DARKBLUE');
commit;

/*
    for 반복문
    
    for 변수명 in (reverse) 시작값..최종값 loop
        문장들;
    end loop;
*/

declare
    v_dan number(5) := '&k_bdan'; -- &: 사용자 입력받기
    v_num number(2);
begin
    dbms_output.put_line(v_dan || '단');
    for v_num in 1..9 loop
        dbms_output.put_line(v_dan || ' * ' || v_num || ' = ' || v_dan * v_num);
    end loop;
    
end;
/

-- db 의 타입을 적용하는 방법
-- db 의 데이터를 레코드 단위로 가져오는 방법
declare
    v_sang shop.sangpum%type := '티셔츠'; -- db의 sangpum 타입을 적용
    v_shop angel.shop%rowtype; -- 레코드단위로 데이터 읽기위한 선언
begin
    select *
    into v_shop
    from shop
    where sangpum = v_sang;
    
    dbms_output.put_line('상품명' || v_shop.sangpum);
    dbms_output.put_line('색상' || v_shop.color);
    dbms_output.put_line('수량' || v_shop.su);
    dbms_output.put_line('단가' || v_shop.dan);
    dbms_output.put_line('구입일' || v_shop.today);
end;
/

/*
    여러 레코드 조회시
    cursor 커서명
    is
    select 문장; -- select 조회의 결과를 cursor에 저장
    
    for 레코드명 in 커서명 loop
        명령;
    end loop;
*/

-- shop 전체 데이터 출력
declare
    cursor s1 
    is
    select * from shop order by dan desc;
    
    v_cnt number(5);
begin
    dbms_output.put_line('번호    상품명    색상 수량  단가   구입일');
    
    for s in s1 loop
        dbms_output.put_line(s.num || ' ' || s.sangpum || ' ' ||
        s.color || '    ' || s.su || '  ' || s.dan || ' ' || s.today);
    end loop;
    
    
    select count(*) into v_cnt from shop;
    dbms_output.put_line('총 ' || v_cnt || '개의 상품이 있습니다');
end;
/

/*
    키보드로 상품명 일부를 입력받아 해당 상품들을 출력하시오
    
    만약 상품명을 '바지' 라고 입력시
    총 4개의 상품이 있습니다
    
    상품명: 청바지
    색상: yellow
    단가: 23000
    
    상품명: 반바지
    .
    .
    .
    
    만약 없을경우
    바지 상품은 목록에 없습니다
*/
declare
    v_sang shop.sangpum%type := '&k_sang';
    cursor s1
    is
    select sangpum, color, dan from shop where instr(sangpum, v_sang) > 0;
    
    v_cnt number(5);
begin
    select count(*) into v_cnt from shop where instr(sangpum, v_sang) > 0;
    
    if v_cnt = 0 then
    dbms_output.put_line(v_sang || ' 상품은 없습니다');
    else
        dbms_output.put_line('총 ' || v_cnt || '개의 상품이 있습니다');
        for s in s1 loop
            dbms_output.put_line('---------------------------------------');
            dbms_output.put_line('상품명: ' || s.sangpum);
            dbms_output.put_line('색상: ' || s.color);
            dbms_output.put_line('단가: ' || ltrim(to_char(s.dan, 'L999,999,999')));
        end loop;
    end if;
end;
/

/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다
 
형식
create: 새로생성, 같은 이름이 있으면 오류발생
create or replace: 덮어쓰기

create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
            	exec 프로시져명(값..)

*/

create or replace procedure mytest
is
begin
    dbms_output.put_line('첫 프로시저 생성!!');
end;
/

-- mytest 프로시저 호출
exec mytest;


-- 구구단을 출력하는 프로시저 생성
create or replace procedure gugu(dan number)
is
begin
    if dan > 1 and dan < 10 then
        dbms_output.put_line('**' || dan || '단**');
        dbms_output.put_line(' ');
        for a in 1..9 loop
            dbms_output.put_line(dan || ' * ' || a || ' = ' || dan * a); 
        end loop;
    else 
        dbms_output.put_line('잘못된 실행입니다');
    end if;
end;
/

-- gugu 실행
exec gugu(5);
exec gugu(6);

-- shop
create or replace procedure addshop(
    sangpum shop.sangpum%type, su shop.su%type,
    dan shop.dan%type, color shop.color%type
)
is
begin
    dbms_output.put_line('shop db 에 ' || sangpum || ' 데이터를 추가합니다');
    insert into shop values (seq_test.nextval, sangpum, su, dan, sysdate, color);
    dbms_output.put_line(sql%rowcount || '개의 상품이 추가되었습니다');
    commit;
end;
/

-- 상품 추가
exec addshop('자켓', 1, 200000, 'white');

/*
    exec searchsangpum('블라우스');
    
    상품명 색상 단가
    ---------------
    블라우스 yellow 33000
    .....
     총 n개 검색
*/

create or replace procedure searchsangpum(s varchar2)
is
    cursor s1
    is
    select sangpum, color, dan from shop where instr(sangpum, s) > 0;
    
    v_cnt number;
begin
    select count(*) into v_cnt from shop where instr(sangpum, s) > 0;
    
    if v_cnt = 0 then
        dbms_output.put_line(s || ' 관련 상품이 없습니다');
    else 
         dbms_output.put_line('총 ' || v_cnt || '개 상품');
         dbms_output.put_line('상품명      색상      단가');
         dbms_output.put_line('------------------------');
         for a in s1 loop
            dbms_output.put_line(a.sangpum || '   ' || a.color || '   ' || a.dan);
         end loop;
    end if;
end;
/

exec searchsangpum('셔');
exec searchsangpum('바지');