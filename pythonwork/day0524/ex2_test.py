list = []

def data_in():
    s = input("이름을 입력하세요 >> ")
    list.append(s)

def data_out():
    print("** 전체 멤버 이름 출력하기 **")
    for data in list:
        print(data)

def menu():
    print("1.데이터 추가 2. 전체 출력 3. 종료")
    n = int(input("메뉴 번호 입력 >> "))
    return n

def question():
    ans = input("계속하려면 y, 종료하려면 n 을 눌러주세요")
    if ans == "y":
        print("** 계속 진행하겠습니다 **")
    elif ans == "n":
        import sys
        sys.exit()
    else:
        question() # 재귀호출

# 호출
while True:
    # 메뉴 번호를 리턴받는다
    n = menu()
    if n == 1:
        data_in()
    elif n == 2:
        data_out()
    else: 
        question()