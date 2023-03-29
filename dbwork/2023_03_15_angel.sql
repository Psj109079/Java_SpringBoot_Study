-- ppt 23������ table
-- table ���� (person): ��ȣ, �̸�, ����, ����, ����, ���糯¥
create table person (
    num number(3) primary key, -- ����Ÿ�� 3���� �⺻Ű
    name varchar2(15) not null, -- not null : null �� ��� x
    age number(3),
    gender varchar2(10) default '����', -- �⺻��(���� ���� ������): ����
    city varchar2(15) default '����',
    today date
);

-- ������ ��ȸ
select * from person;

-- insert �÷������� �Ϻθ� �߰��� ���
insert into person (num, name, today) values (1, 'ȫ�浿', sysdate);
-- pk(primary key), no(not null) �̰�� ���� �ȳ־��ָ� ���� �߻�- Ȯ��


insert into person (name, age, today) values ('��ö��', 23, '2022-10-10'); -- ����
-- ���� ���� -ORA-01400: NULL�� ("ANGEL"."PERSON"."NUM") �ȿ� ������ �� �����ϴ�

-- nn �Ӽ��� �� Ŀ���� ������ �־���� �Ѵ�, �̹����� num�� ���� �����͸� �־��
insert into person (num, name, age, today) values (1, '��ö��', 23, '2022-10-10');
-- ���� ���� - ORA-00001: ���Ἲ ���� ����(ANGEL.SYS_C008318)�� ����˴ϴ�

-- �������� �������� �־��
insert into person (num, name, age, today) values (2, '��ö��', 23, '2022-10-10');

-- ��� �÷����� ������� �÷��� ���� ����
insert into person values (3, '��ȣ��', 34, '����', '���ֵ�', '2021-12-25');

-- ���� 7������ �߰��ϱ�
insert into person values (4, '��ȿ��', 34, '����', '�λ�', '2023-1-25');
insert into person values (5, '������', 45, '����', '�ϻ�', sysdate);
insert into person values (6, '����', 39, '����', '����', '2022-05-10');
insert into person values (7, '������', 19, '����', '����', '2020-11-22');
insert into person values (8, '��ȣ��', 41, '����', '�뱸', sysdate);
insert into person values (9, '������', 32, '����', '�λ�', '2019-09-25');
insert into person values (10, '��ȿ��', 28, '����', '���ֵ�', '2021-12-11');
commit;

-- �������� age, city ����
update person set age = 26, city = '���ֵ�' where name = '������';

-- ȫ�浿�� ���� ����
update person set age = 29 where name = 'ȫ�浿';

-- ������ today �� ���糯¥�� ����
update person set today = sysdate where name = '����';
update person set name = '��ȣ��' where name = '��ȣ��' and num = 8;
commit;
-- delete : where ������ �Ⱦ��� ��ü ��� ������
delete from person;
-- �ٽ� �츮��
rollback; -- ������ commit ���ı����� �ѹ��

-- ������ �̿��ؼ� ����
delete from person where name = 'ȫ�浿';
-- ���̰� 30�� �̸��ΰ�� ��� ����
delete from person where age < 30;
rollback;

-- ���ݺ��ʹ� ���̺� ������ �����ϴ� ����
-- ���̺� �÷� �߰� (add)
alter table person add score number(3) default 50;

-- ��� �߰��� score �÷��� ���� (drop) �ٸ� ���̺�� ����Ǿ��ִ� �÷��̸� ���ŵ��� ����
alter table person drop column score;

-- �÷� Ÿ�Լ��� (modify)
alter table person modify city varchar2(20);

-- �÷� �̸����� (rename)
alter table person rename column today to ipsaday;

-- ���������� ����: name �� not null ���������� ����ִ�(�������� �̸��� �ȢZ �⺻ �̸����� ���ִ�)
-- SYS_C008317
alter table person drop constraint SYS_C008317;

-- name �� ���ο� ���������� �߰��ϱ�(unique)
alter table person add constraint person_uq_name UNIQUE(name);

-- �̸��� ���� �̸��� ������ ���� ������ �߻�
-- ���� ���� -ORA-00001: ���Ἲ ���� ����(ANGEL.PERSON_UQ_NAME)�� ����˴ϴ�
insert into person(num,name) values (11,'��ȣ��'); -- ����

-- gender�� '����', '����' ���� �����͸� ������ ������ �߻��Ƿη� check �������� �ֱ�
alter table person add constraint persson_ck_gender check(gender in ('����', '����'));

-- age�� 10 ~ 50 ������ �����ϵ��� ���������� �߰��ϱ�
alter table person add constraint person_ck_age check(age >= 10 and age <= 50);

-- �������ǿ� ����ǵ��� ���� �߰��غ���
-- ���� ���� -ORA-02290: üũ ��������(ANGEL.PERSON_CK_AGE)�� ����Ǿ����ϴ�
insert into person (num, name, age) values (100, '�̻��', 60); -- ����

-- ���� 
-- pk ���������� ���� �� person_pk_num �̶�� ���ο� ���������� �߰��ϱ�
alter table person drop constraint SYS_C008318;
alter table person add constraint person_pk_num primary key(num);

-- ����2
-- buseo �÷� �߰� varchar2(10) �⺻��: '������'
alter table person add buseo varchar2(10) default '������';
-- buseo �������� �߰� '������', 'ȫ����', '�λ��' 3���� �߰��� �����ϰ� �ϱ�
alter table person add constraint person_ck_buseo check(buseo in ('������', 'ȫ����', '�λ��'));

-- ����3 ����, �̾����� ���� ������� ��� '�λ��' �� ������ ����
update person set buseo = '�λ��' where name like '��%' or name like '��%';

-- �ھ�, �达 ���� ���� ������� ��� 'ȫ����'�� ����
update person set buseo = 'ȫ����' where  name like '��%' or name like '��%';

-- ����4
-- ���� ���� ������ �ο����� ��ճ���(����Ÿ��) ���ϱ� �ο����� �����ͺ��� ���
select gender ����, count(*) �ο���, round(avg(age), 0) ��ճ��� from person group by gender order by 1 desc;
-- �μ����� �ο����� ��ճ��� ���ϱ� -- �μ����� ������������ ���
select buseo �μ�, round(avg(age), 0) ��ճ��� from person group by buseo order by �μ� asc;

-- ������ ppt 78������
-- ���� ���� ����ϴ� �⺻ ������: 1���� 1�� �����ϴ� ������
create sequence seq1;
create sequence seq2 start with 1 increment by 1; -- ���� ����
create sequence seq3 start with 10 increment by 5 nocache; -- nocache: cache�� 0����
create sequence seq4 maxvalue 100; -- max ���� 100������ �߻���
-- ������ ��ȸ
select * from seq;
-- ���̺� ��ȸ
select * from tab;

-- ������ ����
drop sequence seq2;
drop sequence seq4;

-- ������ �߻� nextval, ���簪 currval
select seq1.nextval, seq3.nextval from dual; -- �ݺ��ؼ� �����غ���

select seq1.currval, seq3.currval from dual; -- ������ �߻��� ��
commit;
