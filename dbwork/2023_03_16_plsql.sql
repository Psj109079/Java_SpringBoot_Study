-- PLSQL ������ ���̺�� ������ ������ ����
create sequence seq_test nocache; -- 1���� 1�������ϴ� ������(cache size = 0)

create table shop (
    num number(3) constraint shop_pk_num primary key,
    sangpum varchar2(30),
    su number(3),
    dan number(7),
    today date
);

-- �⺻ ������ 5������ �߰�
insert into shop values (seq_test.nextval, 'û����', 2, 19000, sysdate);
insert into shop values (seq_test.nextval, '�����', 1, 21000, sysdate);
insert into shop values (seq_test.nextval, '�����', 1, 23000, sysdate);
insert into shop values (seq_test.nextval, 'Ƽ����', 3, 27000, sysdate);
insert into shop values (seq_test.nextval, '���콺', 2, 32000, sysdate);
commit;

-- PL-SQL: SQL �� ������ ��Ҹ� �߰��ؼ� ���α׷����Ѱ��� PLSQL �̶�� �Ѵ�
-- ���� 
--DECLARE
--  ��������, Ŀ�� ����
--BEGIN
--  ���� ��� �Ǵ� ������....  
--  DBMS_OUTPUT.PUT_LINE(); (������� ��ɾ�(�ڹ� println �� �����)
--END;
-- set serveroutput on -- �ܼ�â�� ����� ������ �ϱ� (default = off)
set serveroutput off -- �ܼ�â�� ����� �ȳ����� �ϱ� (default = off)

DECLARE
    v_no number(4,1); -- 4�ڸ� ����, �Ҽ��� ���� 1�ڸ�
BEGIN
    v_no := 10; -- �� ����
    DBMS_OUTPUT.PUT_LINE('���ڴ� '|| v_no ||'�Դϴ�'); -- ��� (put_line: ��� �� �ٳѱ�)
END;
/

-- shop ���̺��� Ư�� ��ǰ���� ������
DECLARE
    v_sangpum varchar2(30);
    v_su number(3);
    v_dan number(7);
    v_num number(3) := 1; -- �˻��ؼ� ������ num ��
BEGIN
    select sangpum, su, dan
    into v_sangpum, v_su, v_dan
    from shop where num = v_num;
    DBMS_OUTPUT.PUT_LINE(v_num || '�� ��ǰ����');
    DBMS_OUTPUT.PUT_LINE('��ǰ��: ' || v_sangpum);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ�: ' || v_su * v_dan);
END;
/

-- ���� �ڵ带 �����ؼ� ��ǰ������ �˻��ؼ� �����͸� ����Ͻÿ�
DECLARE
    v_sangpum varchar2(30) := 'û����';
    v_su number(3);
    v_dan number(7);
    v_num number(3) := 1;
BEGIN
    select num, su, dan
    into v_num, v_su, v_dan
    from shop where sangpum = v_sangpum;
    DBMS_OUTPUT.PUT_LINE(v_sangpum || ' ��ǰ����');
    DBMS_OUTPUT.PUT_LINE('��������: ' || v_num);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ�: ' || v_su * v_dan);
END;
/

DECLARE
    v_sangpum varchar2(30) := 'û����';
    v_su number(3);
    v_dan number(7);

BEGIN
    select su, dan
    into v_su, v_dan
    from shop where sangpum = v_sangpum;
    DBMS_OUTPUT.PUT_LINE(v_sangpum || ' ��ǰ����');
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ�: ' || v_su * v_dan);
END;
/

-- ���ǹ� 
/*
    if ���ǽ� then
        ����1;
    else
        ����2;
    end if;
���� ���ǹ�
    if ���ǽ� 1 then
        ����1;
    elsif ���ǽ� 2 then
        ����2;
    ........
    end if;
*/

-- Ư���⵵�� ���������� ���ϱ�
-- �⵵�� Ű����� �Է¹޾Ƽ� �츦 �˾ƺ� �� �ֵ��� �����ϱ�
accept k_year prompt '�⵵ 4�ڸ��� �Է����ּ���';
declare
    v_year number(6):= '&k_year';
    v_mod number(2) := mod(v_year, 12); -- �⵵�� 12�� ���� ������
    v_ddi varchar2(10); -- �츦 ���ؼ� ����
begin
    if v_mod = 0 then v_ddi := '������';
    elsif v_mod = 1 then v_ddi := '��';
    elsif v_mod = 2 then v_ddi := '��';
    elsif v_mod = 3 then v_ddi := '����';
    elsif v_mod = 4 then v_ddi := '��';
    elsif v_mod = 5 then v_ddi := '��';
    elsif v_mod = 6 then v_ddi := 'ȣ����';
    elsif v_mod = 7 then v_ddi := '�䳢';
    elsif v_mod = 8 then v_ddi := '��';
    elsif v_mod = 9 then v_ddi := '��';
    elsif v_mod = 10 then v_ddi := '��';
    elsif v_mod = 11 then v_ddi := '��';
    end if;
    dbms_output.put_line(v_year || '����� ' || v_ddi || '�� �Դϴ�');
end;
/

-- ���ڸ� �Է¹޾� Ȧ�� ¦�� �Ǻ�
accept k_num prompt '���� �Է�';
declare
    v_num number(10) := '&k_num';
    v_s varchar2(6);
begin
    if mod(v_num, 2) = 0 then v_s := '¦��';
    else v_s := 'Ȧ��';
    end if;
    dbms_output.put_line(v_num || '�� ' || v_s || ' �Դϴ�');
end;
/

/*
    �ݺ���
    loop
        ���;
        exit when ����; (��������)
    end loop;
*/
accept k_dan prompt '������ ���ڸ� �Է����ּ���';
declare
    v_dan number(3) := '&k_dan';
    v_idx number(2) := 1;
begin
    dbms_output.put_line('***['|| v_dan ||'��]*');
    
    loop
        dbms_output.put_line(v_dan || ' * ' || v_idx || ' = ' || v_dan * v_idx);
        v_idx := v_idx + 1;
        exit when v_idx > 9;
    end loop;
end;
/

/*
    �� �ٸ� ���ǹ� case
    
    ���� :=
        case ǥ����
            when ��1 then ���1
            when ��1 then ���1
            when ��1 then ���1
            else ���4
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
    dbms_output.put_line(v_grade || '������ ' || v_msg);
end;
/
-- exception ó��
DECLARE
    v_sangpum varchar2(30) := '&k_sang'; -- Ű����� �Է½� ������ ��ǰ��
    v_su number(3);
    v_dan number(7);
    v_num number(3) := 1;
BEGIN
    select num, su, dan
    into v_num, v_su, v_dan
    from shop where sangpum = v_sangpum;
    DBMS_OUTPUT.PUT_LINE(v_sangpum || ' ��ǰ����');
    DBMS_OUTPUT.PUT_LINE('��������: ' || v_num);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_su);
    DBMS_OUTPUT.PUT_LINE('�� ��: ' || v_dan);
    DBMS_OUTPUT.PUT_LINE('�ѱݾ�: ' || v_su * v_dan);
    
    -- ����Ŭ���� ���� ó���ϴ� ���
    exception 
        when NO_DATA_FOUND then
            dbms_output.put_line(v_sangpum || ' ��ǰ�� DB�� �����ϴ�');
        when too_many_rows then
            dbms_output.put_line(v_sangpum || ' ��ǰ�� ������ �ֽ��ϴ�');
        when oters then
            dbms_output.put_line('�˼����� ���ܹ߻�');
END;
/

-- shop ���̺� ����
-- shop ���̺� color �÷��� �߰��ϰ� �⺻���� 'green'
alter table shop add color varchar2(20) default 'GREEN';
-- 3���� pink 5���� yellow �� ����
update shop set color = 'PINK' where num = 3;
update shop set color = 'YELLOW' where num = 5;

-- ������ �߰�: �ߺ��� ��ǰ�� �ֱ�
insert into shop values (seq_test.nextval, '���콺', 1, 19000, sysdate, 'ORANGE');
insert into shop values (seq_test.nextval, '�ݹ���', 3, 34000, sysdate, 'BLUE');
insert into shop values (seq_test.nextval, '���̽�Ƽ����', 4, 7000, sysdate, 'GRAY');
insert into shop values (seq_test.nextval, '������û����', 2, 99000, sysdate, 'DARKBLUE');
commit;

/*
    for �ݺ���
    
    for ������ in (reverse) ���۰�..������ loop
        �����;
    end loop;
*/

declare
    v_dan number(5) := '&k_bdan'; -- &: ����� �Է¹ޱ�
    v_num number(2);
begin
    dbms_output.put_line(v_dan || '��');
    for v_num in 1..9 loop
        dbms_output.put_line(v_dan || ' * ' || v_num || ' = ' || v_dan * v_num);
    end loop;
    
end;
/

-- db �� Ÿ���� �����ϴ� ���
-- db �� �����͸� ���ڵ� ������ �������� ���
declare
    v_sang shop.sangpum%type := 'Ƽ����'; -- db�� sangpum Ÿ���� ����
    v_shop angel.shop%rowtype; -- ���ڵ������ ������ �б����� ����
begin
    select *
    into v_shop
    from shop
    where sangpum = v_sang;
    
    dbms_output.put_line('��ǰ��' || v_shop.sangpum);
    dbms_output.put_line('����' || v_shop.color);
    dbms_output.put_line('����' || v_shop.su);
    dbms_output.put_line('�ܰ�' || v_shop.dan);
    dbms_output.put_line('������' || v_shop.today);
end;
/

/*
    ���� ���ڵ� ��ȸ��
    cursor Ŀ����
    is
    select ����; -- select ��ȸ�� ����� cursor�� ����
    
    for ���ڵ�� in Ŀ���� loop
        ���;
    end loop;
*/

-- shop ��ü ������ ���
declare
    cursor s1 
    is
    select * from shop order by dan desc;
    
    v_cnt number(5);
begin
    dbms_output.put_line('��ȣ    ��ǰ��    ���� ����  �ܰ�   ������');
    
    for s in s1 loop
        dbms_output.put_line(s.num || ' ' || s.sangpum || ' ' ||
        s.color || '    ' || s.su || '  ' || s.dan || ' ' || s.today);
    end loop;
    
    
    select count(*) into v_cnt from shop;
    dbms_output.put_line('�� ' || v_cnt || '���� ��ǰ�� �ֽ��ϴ�');
end;
/

/*
    Ű����� ��ǰ�� �Ϻθ� �Է¹޾� �ش� ��ǰ���� ����Ͻÿ�
    
    ���� ��ǰ���� '����' ��� �Է½�
    �� 4���� ��ǰ�� �ֽ��ϴ�
    
    ��ǰ��: û����
    ����: yellow
    �ܰ�: 23000
    
    ��ǰ��: �ݹ���
    .
    .
    .
    
    ���� �������
    ���� ��ǰ�� ��Ͽ� �����ϴ�
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
    dbms_output.put_line(v_sang || ' ��ǰ�� �����ϴ�');
    else
        dbms_output.put_line('�� ' || v_cnt || '���� ��ǰ�� �ֽ��ϴ�');
        for s in s1 loop
            dbms_output.put_line('---------------------------------------');
            dbms_output.put_line('��ǰ��: ' || s.sangpum);
            dbms_output.put_line('����: ' || s.color);
            dbms_output.put_line('�ܰ�: ' || ltrim(to_char(s.dan, 'L999,999,999')));
        end loop;
    end if;
end;
/

/*
���ν���(procedure)
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����
 
����
create: ���λ���, ���� �̸��� ������ �����߻�
create or replace: �����

create [or replace] procedure ���ν�����
   [�Ķ���� ��� ����ŸŸ��,....]
is
       	���� ����
begin
            	�ڵ�;
end;
/
 
ȣ��:   exec ���ν�����
            	exec ���ν�����(��..)

*/

create or replace procedure mytest
is
begin
    dbms_output.put_line('ù ���ν��� ����!!');
end;
/

-- mytest ���ν��� ȣ��
exec mytest;


-- �������� ����ϴ� ���ν��� ����
create or replace procedure gugu(dan number)
is
begin
    if dan > 1 and dan < 10 then
        dbms_output.put_line('**' || dan || '��**');
        dbms_output.put_line(' ');
        for a in 1..9 loop
            dbms_output.put_line(dan || ' * ' || a || ' = ' || dan * a); 
        end loop;
    else 
        dbms_output.put_line('�߸��� �����Դϴ�');
    end if;
end;
/

-- gugu ����
exec gugu(5);
exec gugu(6);

-- shop
create or replace procedure addshop(
    sangpum shop.sangpum%type, su shop.su%type,
    dan shop.dan%type, color shop.color%type
)
is
begin
    dbms_output.put_line('shop db �� ' || sangpum || ' �����͸� �߰��մϴ�');
    insert into shop values (seq_test.nextval, sangpum, su, dan, sysdate, color);
    dbms_output.put_line(sql%rowcount || '���� ��ǰ�� �߰��Ǿ����ϴ�');
    commit;
end;
/

-- ��ǰ �߰�
exec addshop('����', 1, 200000, 'white');

/*
    exec searchsangpum('���콺');
    
    ��ǰ�� ���� �ܰ�
    ---------------
    ���콺 yellow 33000
    .....
     �� n�� �˻�
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
        dbms_output.put_line(s || ' ���� ��ǰ�� �����ϴ�');
    else 
         dbms_output.put_line('�� ' || v_cnt || '�� ��ǰ');
         dbms_output.put_line('��ǰ��      ����      �ܰ�');
         dbms_output.put_line('------------------------');
         for a in s1 loop
            dbms_output.put_line(a.sangpum || '   ' || a.color || '   ' || a.dan);
         end loop;
    end if;
end;
/

exec searchsangpum('��');
exec searchsangpum('����');