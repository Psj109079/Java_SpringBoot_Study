"""
    list 에 10 개정도의 색상을 넣어놓고
    방향키를 움직일때마다 랜덤 색상으로 거북이가 해당 방향으로 10씩 이동하도록 한다
    거북이 크기,굵기들은 모두 마음대로
"""

import turtle as t
import random as rnd

ws = t.Screen()
ws.colormode(255)

t.shape("turtle")
t.turtlesize(3)
t.width(3)

def mywrite(msg):
    t.write(msg, font=("Impact", 24, "bold"))

def key_up():
    r = rnd.randint(0, 255)
    g = rnd.randint(0, 255)
    b = rnd.randint(0, 255)
    t.color(r,g,b)
    t.setheading(90)
    # m = int(r.randint(50, 100))
    # t.clear() # 그래픽 전체 지우기
    t.forward(50)
    # mywrite("Up Key!!")

def key_down():
    r = rnd.randint(0, 255)
    g = rnd.randint(0, 255)
    b = rnd.randint(0, 255)
    t.color(r,g,b)
    t.setheading(270)
    # m = int(r.randint(50, 100))
    # t.clear() # 그래픽 전체 지우기
    t.forward(50)
    # mywrite("Down Key!!")

def key_left():
    r = rnd.randint(0, 255)
    g = rnd.randint(0, 255)
    b = rnd.randint(0, 255)
    t.color(r,g,b)
    t.setheading(180)
    # m = int(r.randint(50, 100))
    # t.clear() # 그래픽 전체 지우기
    t.forward(50)
    # mywrite("Left Key!!")

def key_right():
    r = rnd.randint(0, 255)
    g = rnd.randint(0, 255)
    b = rnd.randint(0, 255)
    t.color(r,g,b)
    t.setheading(360)
    # m = int(r.randint(50, 100))
    # t.clear() # 그래픽 전체 지우기
    t.forward(50)
    # mywrite("Right Key!!") 

def key_k():
    # t.clear() # 그래픽 전체 지우기
    t.left(10)
    # mywrite("Space Key!!")


def key_l():
    # t.clear() # 그래픽 전체 지우기
    t.right(10)
    # mywrite("Space Key!!")

def key_a():
    # t.clear() # 그래픽 전체 지우기
    r = rnd.randint(0, 255)
    g = rnd.randint(0, 255)
    b = rnd.randint(0, 255)
    t.color(r,g,b)
    t.forward(50)
    # mywrite("a Key!!")



#이벤트 발생
t.onkeypress(key_up, "Up") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_down, "Down") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_left, "Left") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_right, "Right") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_k, "k") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_l, "l") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_a, "a")
t.listen() #키를 받을 수 있도록 포커스를 그래픽창으로 주는것


t.exitonclick()