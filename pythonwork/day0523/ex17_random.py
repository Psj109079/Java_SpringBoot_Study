import random as r
import turtle as t

rnd = r.randint(1, 100) # 1부터 100 사이의 난수 구하기
print (rnd)

ws = t.Screen()
ws.colormode(255)

while True: 
    x = int(input("x 좌표 입력(종료: 999): "))
    if x == 999 :
        print("프로그램 종료")
        break

    y = int(input("y 좌표 입력(종료: 999): "))
    if y == 999 :
        print("프로그램 종료")
        break
    


    t.penup()
    red = r.randint(1, 255)
    green = r.randint(1, 255)
    blue = r.randint(1, 255)
    t.shape("turtle")
    t.goto(x, y)
    t.color(red, green, blue)
    t.write("Good!!", align="center", font=("Comic Sans MS", 30, "bold"))
