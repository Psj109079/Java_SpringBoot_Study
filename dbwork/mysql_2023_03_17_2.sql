create table bitcamp(
	num int auto_increment primary key,
    name varchar(20),
    java smallint constraint bc_ck_java check(java between 0 and 100),
    spring smallint constraint bc_ck_spring check(spring between 0 and 100),
    today date
);

select * from information_schema.table_constraints where table_name = 'bitcamp';

-- 데이터 10개 추가

insert into bitcamp values(null, '김씨', 80, 90, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '이씨', 77, 98, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '박씨', 96, 65, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '오씨', 45, 68, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '최씨', 88, 70, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '강씨', 78, 96, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '김씨', 56, 82, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '이씨', 87, 94, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '박씨', 76, 65, date_format(now(), '%Y-%m-%d'));
insert into bitcamp values(null, '최씨', 68, 48, date_format(now(), '%Y-%m-%d'));

select num, name, java + spring sum, round(java + spring / 2, 1) avg, today 
from bitcamp 
where name like '김%';

select * from bitcamp where ((java + spring) / 2) >= 80;