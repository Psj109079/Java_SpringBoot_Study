import turtle as t
import random as r

# 이동할 거리길이를 입력해서 반환하는 함수(입력을 다이얼로그로 받기)

def inp():
    n = int(t.textinput("이동거리 입력 >> ","input number?"))
    h = int(t.textinput("머리방향 입력 >> ","input number?"))
    return n, h

list = ["red", "pink", "orange", "green", "gray"]

t.shape("turtle")
t.width(3)
t.shapesize(3) # 크기는 3배


n = inp()
print(n)
print(n[0])
while True:
    n = inp()

    if n == 0:
        print("종료합니다")
        break
    idx = r. randint(0, 4)
    t.color(list[idx])
    t.fd(n[0]) # 입력한 길이만큼 앞으로 전진
    t.setheading(abs(n[1])) # 거북이 머리방향 회전

t.exitonclick()