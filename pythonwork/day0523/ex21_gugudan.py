"""
    숫자를 입력하면 해당 구구단 출력
    단, 2 ~ 9 가 아니면 "다시 입력해주세요
    0 을 입력하면 종료하면서 "프로그램 끝"
    출력시 format을 이용해서 출력할것
"""

while True:
    n = int(input("숫자를 입력해주세요(종료: 0): "))
    if 1 >= n and n >= 10:
        print("다시 입력하세요")
        continue
    elif n == 0 :
        print("프로그램 종료")
        break
    else:
        for x in range(1, 10):
            print("{} * {} = {}".format(n, x, n * x))
