-- ����
-- ���̺� ���� (student): num ����(5), name ���ڿ�(10), height ����(5,1),
-- java ����(3) �⺻�� 10, spring ����(3) �⺻�� 10 ban ���ڿ�(20)

create table student(
    num number(5),
    name varchar2(10),
    height number(5, 1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar2(20)
);

-- ������ ���� seq_stu �⺻(1���� 1������), nocache �߰�
create sequence seq_stu nocache;

-- �������ǵ� �߰�
-- num �� primary key �߰� 
alter table student add constraint student_pk_num primary key(num);
-- java, spring �� 1 ~ 100 �� �����ϵ��� check �������� �߰�
alter table student add constraint student_ch_java check(java > 0 and java <= 100);
alter table student add constraint student_ch_sprint check(spring > 0 and spring <= 100);
-- ban �� '�޴Թ�', '�޴Թ�', '���Թ�' �� �߰��� �� �ֵ��� check �߰�
alter table student add constraint student_ck_ban check(ban in('�޴Թ�', '�޴Թ�', '���Թ�'));

-- ������ 5�� �߰�
insert into student (num, name, java, height, ban) values (seq_stu.nextval, '������', 89, 167.5, '�޴Թ�');
insert into student values (seq_stu.nextval, '��ȿ��', 178.6, 67, 88, '�޴Թ�');
insert into student values (seq_stu.nextval, '�踻��', 155.6, 100, 90, '���Թ�');
insert into student values (seq_stu.nextval, '����', 165.9, 55, 67, '�޴Թ�');
insert into student values (seq_stu.nextval, '��ö��', 179.1, 90, 86, '�޴Թ�');

-- num �� 3�� ����� java������ 99��, ban�� '�޴Թ�' ���� ����
update student set java = 99, ban = '�޴Թ�' where num = 3;
-- num5 �� ����� Ű�� 188.9 �� ����
update student set height = 188.9 where num = 5;
-- num2 �� �����ͻ���
delete from student where num = 2;
-- ��ȸ �̸� �� �ڹ� ������ ���� ��� ������ ���� ������� ���
select name �̸�, ban ��, java, spring, java + spring ����, round((java + spring) / 2, 1) ��� from student order by 5 desc;
commit;

-- DB ����ȭ(Normalization)
--����ȭ�� �Ѹ���� db������ �޸𸮸� �������� �ʱ� ���ؼ� � ���̺��� �ĺ��ڸ� ������
--�������� ���̺�� ������ ������ ����ȭ ��� �Ѵ� ����ȭ�� �����ͺ��̽��� �ߺ���
--�ּ�ȭ�ǵ��� ����� �����ͺ��̽��̴�
--����: �޸𸮸� ������ �� �ִ�.
--     ����ȭ�� �ý������� ���ؼ� ������ ���ϴ�
--����: ��ȸ������ �ſ� ���� �ý����� ��쿡�� ���̺��� join ������ �ݺ������� 
--      �̷����� ������ ���� ���� �ӵ��� ��¦ �ʾ��� �� �ִ�

-- student �� num �� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo �� ������
-- �ܺ�Ű�� ���̺� ���� �� �����ص� �ǰ� ���� �� ���̺� �������� �߰��ص� ��
-- ppt 29������
create table stuinfo (
    idx number(5) constraint info_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(15)
);

-- �ܺ�Ű �������� �߰�
-- stuinfo�� num �� student �� num ���� ���� �� �ֵ��� ����
alter table stuinfo add constraint info_fk_num foreign key(num) references student(num);

-- stuinfo �� num�� ���� 3�� �߰��ߴٸ� student ���̺��� num = 3�� �����ʹ� ������ �� ����
-- �� �������� �߰� �� on delete cascade �� �߰����� ���� �θ����̺��� num = 3 �� ������ ���� ��
-- stuinfo �� num = 3 �� ��� �����ʹ� �ڵ� �����ȴ�

-- stuinfo �� ������ �߰��ϱ�
insert into stuinfo values (seq_stu.nextval, 3, '����� ������', '010-2222-3333');

-- student �� ���� 2�� �߰��غ���
-- ���� ���� -ORA-02291: ���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
insert into stuinfo values (seq_stu.nextval, 2, '����� ������', '010-5454-1212'); -- ����

-- 4������ �߰�
insert into stuinfo values (seq_stu.nextval, 4, '����� ������', '010-5454-1212');
insert into stuinfo values (seq_stu.nextval, 1, '���ֵ� �ֿ���', '010-7777-8888');
commit;

-- ��ȸ
-- ���� ��ȸ�� ��� ��� ������ �˼� ����
select * from stuinfo;

-- join ���� �� ���̺��� ���ؼ� �ʿ��� ���� ��������
-- ppt 43������
-- inner join �Ǵ� equi join �̶�� �Ѵ�. ���� num���� ���� ��쿡�� �����´�
select sd.num ������, sd.name �л���, sd.height Ű, sd.ban ��,si.addr �ּ�,
si.hp �ڵ���, sd.java �ڹ�, sd.spring ������ 
from student sd, stuinfo si where sd.num = si.num;

-- �̶� ���� ���̺� ���������� ���� �ִ� �÷��� �����ϰ�� �տ� ���̺�� ���� ����
-- ���߿� ���� ���̺��� ���� ���̺��� �÷����� ����� �� ������ ���̺�� �Է��� �ִ°� ����
select sd.num ������, name �л���, height Ű, ban ��,addr �ּ�,
hp �ڵ���, java �ڹ�, spring ������ 
from student sd, stuinfo si where sd.num = si.num;

-- outer join ���� �߰����� ���� ������ ã�ƺ���
-- sub ���̺��ʿ� (+)
select sd.num ������, name �л���, height Ű, ban ��,addr �ּ�,
hp �ڵ���, java �ڹ�, spring ������ 
from student sd, stuinfo si where sd.num = si.num(+) and addr is null;
-- �������̺� �߰��������� �����Ͷ�� �������̺� ���� null �̱� ������
-- �������̺� �ƹ� �÷��� is null ����ϸ� �������̺��� ���� �������̺��� �ִ°��� ����

-- student ���̺��� num = 1 �� ������ �����غ���
-- ���� ���� -ORA-02292: ���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
delete from student where num = 1; -- ����(�ڽ����̺� ���ڵ尡 �ֱ⶧���� �������̺��� �������� ����)
-- ���� �����ϰ� �ʹٸ� �ڽ����̺��� �����͸� ���� ���� �� student �� �����͸� �����Ѵ�

-- �������̺��� num = 1�� ���� �� �θ����̺��� num = 1 �����ϱ�
delete from stuinfo where num = 1;
delete from student where num = 1;

-- ���̺� ���� �� ���� ���̺��� ���� ���� �� �θ� ���̺��� ����
drop table stuinfo;
drop table student;
--------------------------------------------------------------------------------
-- �θ� ���̺��� ������ ���� �� �������̺��� �����͵� �ڵ����� �����ǵ��� �ܺ�Ű �����ϱ�
-- ������ ����
create sequence seq_shop;
-- shop, cart
create table shop(
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar(30),
    sang_price number(10)
);

-- �ܺ�Ű ������ on delete cascade �� ���̸� �θ����̺� ���� �� �ڽ����̺� �߰��� �����͵� ���� ������
create table cart (
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

-- 5���� ��ǰ ���
insert into shop values (seq_shop.nextval, '���콺', 12000);
insert into shop values (seq_shop.nextval, '����', 19000);
insert into shop values (seq_shop.nextval, 'û����', 25000);
insert into shop values (seq_shop.nextval, 'üũ��Ʈ', 99000);
insert into shop values (seq_shop.nextval, 'Ƽ����', 11000);
commit;

-- 3���� ��ǰ�� īƮ�� ��ƺ���
insert into cart values (seq_shop.nextval, 2, 3, sysdate);
insert into cart values (seq_shop.nextval, 3, 1, '2023-01-13');
insert into cart values (seq_shop.nextval, 5, 3, sysdate);
commit;

-- ��ȸ sang_no ��ǰ��ȣ, ��ǰ��, �ܰ�, ����, ������(��4-��2-��2 �������� ���) inner join
select shop.sang_no ��ǰ��ȣ, shop.sang_name ��ǰ��, to_char(shop.sang_price, 'L999,999,999') �ܰ�, cart.cnt ����, to_char(cart.cartday, 'yyyy-mm-dd') ������
from shop, cart where shop.sang_no = cart.sang_no;
-- cart �� ����� ���� ��ǰ�� ��ǰ��ȣ�� ��ǰ�� ��� outer join
select shop.sang_no ��ǰ��ȣ, shop.sang_name ��ǰ�� from shop, cart where shop.sang_no = cart.sang_no(+) and cartday is null;

-- ���� Ȯ�� (2, 3, 5 �� ��ǰ�� cart �� �������)
-- shop �� 2��,3�� ��ǰ�� ���� �� cart ���̺��� Ȯ���ϱ�
delete from shop where sang_no = 2 or sang_no = 3;

-- ������ ��� ���̺�� ������ �����ϱ�
drop table cart;
drop table shop;
drop table person;
drop sequence seq_shop;
drop sequence seq_stu;
drop sequence seq1;
drop sequence seq3;

-------------------------------------------------------------------------------
--seq_food ������
create sequence seq_food;
--restaurant  ���̺�
--
--    food_num �⺻Ű
--    food_name ���ڿ�(30)
--    food_price ����(7)
create table restaurant(
    food_num number(3) constraint restaurant_pk_fn primary key,
    food_name varchar2(30),
    food_price number(7)
);
--resorder ���̺�    
--     order_num �⺻Ű
--     order_name ���ڿ�(20)
--    food_num  ->restaurant �� food_num �� �ܺ�Ű�� ����(on delete cascade)
--    order_day ��¥Ÿ��(���೯¥)
--    jumun_day ��¥Ÿ��(���糯¥����)
--    inwon  ����(3)
create table resorder (
    order_num number(3) constraint resorder_pk_on primary key,
    order_name varchar2(20),
    food_num number(3),
    order_day date,
    jumun_day date,
    inwon number(3),
    constraint resorder_fk_fn foreign key(food_num) references restaurant(food_num) on delete cascade
);
--����Ÿ �߰��ϱ�
--  ���İ�Ƽ   23000
--  ���캺���� 11000
--  ������  19000
--  ����Ƣ�� 10000
--  ¥��� 5000
insert into restaurant values(seq_food.nextval, '���İ�Ƽ', 23000);
insert into restaurant values(seq_food.nextval, '���캺����', 11000);
insert into restaurant values(seq_food.nextval, '������', 19000);
insert into restaurant values(seq_food.nextval, '����Ƣ��', 10000);
insert into restaurant values(seq_food.nextval, '¥���', 5000);
--�ֹ� ���̺�
--�̻��,  ���İ�Ƽ�ֹ�, ������ 2023-11-20  �ֹ���:����ð���� �ο��� :4
--��ȣ��,���캺�����ֹ�, ������ 2023-12-25  �ֹ���:����ð���� �ο��� :3
--��ȣ��,�������ֹ�, ������ 2023-12-20  �ֹ���:����ð���� �ο��� :3
--�̿���, ���İ�Ƽ�ֹ�, ������ 2023-05-11  �ֹ���:����ð���� �ο��� :2
insert into resorder values(seq_food.nextval, '�̻��', 1, '2023-11-20', sysdate, 4);
insert into resorder values(seq_food.nextval, '��ȣ��', 2, '2023-12-25', sysdate, 3);
insert into resorder values(seq_food.nextval, '��ȣ��', 3, '2023-12-20', sysdate, 3);
insert into resorder values(seq_food.nextval, '�̿���', 1, '2023-05-11', sysdate, 2);

--���
--�ֹ���  ������  ���ĸ�  ���İ���  �ֹ���(��-��-�� ��:��)   �ο���
select o.order_name �ֹ���, r.food_name ����, o.order_day ������, r.food_price ����,
to_char(o.jumun_day, 'yyyy-mm-dd hh24:mi') �ֹ���, o.inwon �ο�
from restaurant r, resorder o where r.food_num = o.food_num;
--������� �޴��� ������ ������ ���� ���̺����� �����Ǿ����� Ȯ���ϱ� 

delete restaurant where food_name = '������';
select * from resorder;

drop table resorder;
drop table restaurant;
drop sequence seq_food;


