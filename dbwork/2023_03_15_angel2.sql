-- 문제
-- 테이블 생성 (student): num 숫자(5), name 문자열(10), height 숫자(5,1),
-- java 숫자(3) 기본값 10, spring 숫자(3) 기본값 10 ban 문자열(20)

create table student(
    num number(5),
    name varchar2(10),
    height number(5, 1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar2(20)
);

-- 시퀀스 생성 seq_stu 기본(1부터 1씩증가), nocache 추가
create sequence seq_stu nocache;

-- 제약조건들 추가
-- num 에 primary key 추가 
alter table student add constraint student_pk_num primary key(num);
-- java, spring 은 1 ~ 100 만 가능하도록 check 제약조건 추가
alter table student add constraint student_ch_java check(java > 0 and java <= 100);
alter table student add constraint student_ch_sprint check(spring > 0 and spring <= 100);
-- ban 은 '햇님반', '달님반', '별님반' 만 추가할 수 있도록 check 추가
alter table student add constraint student_ck_ban check(ban in('햇님반', '달님반', '별님반'));

-- 데이터 5개 추가
insert into student (num, name, java, height, ban) values (seq_stu.nextval, '김진아', 89, 167.5, '햇님반');
insert into student values (seq_stu.nextval, '이효리', 178.6, 67, 88, '달님반');
insert into student values (seq_stu.nextval, '김말자', 155.6, 100, 90, '별님반');
insert into student values (seq_stu.nextval, '이진', 165.9, 55, 67, '달님반');
insert into student values (seq_stu.nextval, '이철수', 179.1, 90, 86, '햇님반');

-- num 이 3인 사람의 java점수를 99로, ban을 '달님반' 으로 수정
update student set java = 99, ban = '달님반' where num = 3;
-- num5 인 사람의 키를 188.9 로 수정
update student set height = 188.9 where num = 5;
-- num2 인 데이터삭제
delete from student where num = 2;
-- 조회 이름 반 자바 스프링 총점 평균 총점이 높은 사람부터 출력
select name 이름, ban 반, java, spring, java + spring 총점, round((java + spring) / 2, 1) 평균 from student order by 5 desc;
commit;

-- DB 정규화(Normalization)
--정규화란 한마디로 db서버의 메모리를 낭비하지 않기 위해서 어떤 테이블의 식별자를 가지는
--여러개의 데이블로 나누는 과정을 정규화 라고 한다 정규화된 데이터베이스는 중복이
--최소화되도록 설계된 데이터베이스이다
--장점: 메모리를 절약할 수 있다.
--     구조화된 시스템으로 인해서 관리가 편하다
--단점: 조회비율이 매우 높은 시스템의 경우에는 테이블간의 join 연산이 반복적으로 
--      이뤄지기 때문에 질의 응답 속도가 살짝 늦어질 수 있다

-- student 의 num 을 외부키로 갖는 새로운 테이블 stuinfo 를 만들어보자
-- 외부키는 테이블 생성 시 설정해도 되고 생성 후 테이블 수정으로 추가해도 됨
-- ppt 29페이지
create table stuinfo (
    idx number(5) constraint info_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(15)
);

-- 외부키 제약조건 추가
-- stuinfo의 num 은 student 의 num 값만 넣을 수 있도록 설정
alter table stuinfo add constraint info_fk_num foreign key(num) references student(num);

-- stuinfo 의 num에 만약 3을 추가했다면 student 테이블에서 num = 3인 데이터는 삭제할 수 없다
-- 단 제약조건 추가 시 on delete cascade 를 추가했을 경우는 부모테이블의 num = 3 인 데이터 삭제 시
-- stuinfo 의 num = 3 인 모든 데이터는 자동 삭제된다

-- stuinfo 에 데이터 추가하기
insert into stuinfo values (seq_stu.nextval, 3, '서울시 강남구', '010-2222-3333');

-- student 에 없는 2번 추가해보기
-- 오류 보고 -ORA-02291: 무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다
insert into stuinfo values (seq_stu.nextval, 2, '서울시 강동구', '010-5454-1212'); -- 오류

-- 4번으로 추가
insert into stuinfo values (seq_stu.nextval, 4, '서울시 강동구', '010-5454-1212');
insert into stuinfo values (seq_stu.nextval, 1, '제주도 애월읍', '010-7777-8888');
commit;

-- 조회
-- 각각 조회할 경우 모든 정보를 알수 없다
select * from stuinfo;

-- join 으로 두 테이블을 합해서 필요한 정보 가져오기
-- ppt 43페이지
-- inner join 또는 equi join 이라고 한다. 서로 num값이 같을 경우에만 가져온다
select sd.num 시퀀스, sd.name 학생명, sd.height 키, sd.ban 반,si.addr 주소,
si.hp 핸드폰, sd.java 자바, sd.spring 스프링 
from student sd, stuinfo si where sd.num = si.num;

-- 이때 양쪽 테이블에 공통적으로 갖고 있는 컬럼을 제외하고는 앞에 테이블명 생략 가능
-- 나중에 서브 테이블에서 메인 테이블의 컬럼명을 사용할 수 있으니 테이블명도 입력해 주는게 좋다
select sd.num 시퀀스, name 학생명, height 키, ban 반,addr 주소,
hp 핸드폰, java 자바, spring 스프링 
from student sd, stuinfo si where sd.num = si.num;

-- outer join 으로 추가되지 않은 데이터 찾아보기
-- sub 테이블쪽에 (+)
select sd.num 시퀀스, name 학생명, height 키, ban 반,addr 주소,
hp 핸드폰, java 자바, spring 스프링 
from student sd, stuinfo si where sd.num = si.num(+) and addr is null;
-- 서브테이블에 추가되지않은 데이터라면 서브테이블 값은 null 이기 때문에
-- 서브테이블 아무 컬럼에 is null 사용하면 서브테이블에는 없고 메인테이블에만 있는값이 나옴

-- student 테이블의 num = 1 인 데이터 삭제해보기
-- 오류 보고 -ORA-02292: 무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from student where num = 1; -- 오류(자식테이블에 레코드가 있기때문에 메인테이블에서 삭제되지 않음)
-- 만약 삭제하고 싶다면 자식테이블의 데이터를 먼저 삭제 후 student 의 데이터를 삭제한다

-- 서브테이블의 num = 1을 삭제 후 부모테이블의 num = 1 삭제하기
delete from stuinfo where num = 1;
delete from student where num = 1;

-- 테이블 제거 시 서브 테이블을 먼저 제거 후 부모 테이블을 제거
drop table stuinfo;
drop table student;
--------------------------------------------------------------------------------
-- 부모 테이블의 데이터 삭제 시 서브테이블의 데이터도 자동으로 삭제되도록 외부키 설정하기
-- 시퀀스 생성
create sequence seq_shop;
-- shop, cart
create table shop(
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar(30),
    sang_price number(10)
);

-- 외부키 설정시 on delete cascade 를 붙이면 부모테이블 삭제 시 자식테이블에 추가된 데이터도 같이 삭제됨
create table cart (
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

-- 5개의 상품 등록
insert into shop values (seq_shop.nextval, '블라우스', 12000);
insert into shop values (seq_shop.nextval, '조끼', 19000);
insert into shop values (seq_shop.nextval, '청바지', 25000);
insert into shop values (seq_shop.nextval, '체크코트', 99000);
insert into shop values (seq_shop.nextval, '티셔츠', 11000);
commit;

-- 3개의 제품을 카트에 담아보기
insert into cart values (seq_shop.nextval, 2, 3, sysdate);
insert into cart values (seq_shop.nextval, 3, 1, '2023-01-13');
insert into cart values (seq_shop.nextval, 5, 3, sysdate);
commit;

-- 조회 sang_no 상품번호, 상품명, 단가, 수량, 구입일(년4-월2-일2 형식으로 출력) inner join
select shop.sang_no 상품번호, shop.sang_name 상품명, to_char(shop.sang_price, 'L999,999,999') 단가, cart.cnt 수량, to_char(cart.cartday, 'yyyy-mm-dd') 구입일
from shop, cart where shop.sang_no = cart.sang_no;
-- cart 에 담기지 않은 상품의 상품번호와 상품명 출력 outer join
select shop.sang_no 상품번호, shop.sang_name 상품명 from shop, cart where shop.sang_no = cart.sang_no(+) and cartday is null;

-- 삭제 확인 (2, 3, 5 번 상품이 cart 에 담겨있음)
-- shop 의 2번,3번 상품을 삭제 후 cart 테이블을 확인하기
delete from shop where sang_no = 2 or sang_no = 3;

-- 연습한 모든 테이블과 시퀀스 제거하기
drop table cart;
drop table shop;
drop table person;
drop sequence seq_shop;
drop sequence seq_stu;
drop sequence seq1;
drop sequence seq3;

-------------------------------------------------------------------------------
--seq_food 시퀀스
create sequence seq_food;
--restaurant  테이블
--
--    food_num 기본키
--    food_name 문자열(30)
--    food_price 숫자(7)
create table restaurant(
    food_num number(3) constraint restaurant_pk_fn primary key,
    food_name varchar2(30),
    food_price number(7)
);
--resorder 테이블    
--     order_num 기본키
--     order_name 문자열(20)
--    food_num  ->restaurant 의 food_num 을 외부키로 설정(on delete cascade)
--    order_day 날짜타입(예약날짜)
--    jumun_day 날짜타입(현재날짜저장)
--    inwon  숫자(3)
create table resorder (
    order_num number(3) constraint resorder_pk_on primary key,
    order_name varchar2(20),
    food_num number(3),
    order_day date,
    jumun_day date,
    inwon number(3),
    constraint resorder_fk_fn foreign key(food_num) references restaurant(food_num) on delete cascade
);
--데이타 추가하기
--  스파게티   23000
--  새우볶음밥 11000
--  전복죽  19000
--  새우튀김 10000
--  짜장면 5000
insert into restaurant values(seq_food.nextval, '스파게티', 23000);
insert into restaurant values(seq_food.nextval, '새우볶음밥', 11000);
insert into restaurant values(seq_food.nextval, '전복죽', 19000);
insert into restaurant values(seq_food.nextval, '새우튀김', 10000);
insert into restaurant values(seq_food.nextval, '짜장면', 5000);
--주문 테이블
--이상아,  스파게티주문, 예약일 2023-11-20  주문일:현재시간등록 인원수 :4
--강호동,새우볶음밥주문, 예약일 2023-12-25  주문일:현재시간등록 인원수 :3
--강호동,전복죽주문, 예약일 2023-12-20  주문일:현재시간등록 인원수 :3
--이영자, 스파게티주문, 예약일 2023-05-11  주문일:현재시간등록 인원수 :2
insert into resorder values(seq_food.nextval, '이상아', 1, '2023-11-20', sysdate, 4);
insert into resorder values(seq_food.nextval, '강호동', 2, '2023-12-25', sysdate, 3);
insert into resorder values(seq_food.nextval, '강호동', 3, '2023-12-20', sysdate, 3);
insert into resorder values(seq_food.nextval, '이영자', 1, '2023-05-11', sysdate, 2);

--출력
--주문자  예약일  음식명  음식가격  주문일(연-월-일 시:분)   인원수
select o.order_name 주문자, r.food_name 음식, o.order_day 예약일, r.food_price 가격,
to_char(o.jumun_day, 'yyyy-mm-dd hh24:mi') 주문일, o.inwon 인원
from restaurant r, resorder o where r.food_num = o.food_num;
--레스토랑 메뉴중 전복죽 삭제후 에약 테이블에서도 삭제되었는지 확인하기 

delete restaurant where food_name = '전복죽';
select * from resorder;

drop table resorder;
drop table restaurant;
drop sequence seq_food;


