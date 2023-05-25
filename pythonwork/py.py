import turtle
# import time as ti

# print(1,2,3)
# name = "비트캠프"
# print("name = " + name)
# myname = input("이름 입력 >>")
# print(myname);

# curYear=ti.localtime().tm_year;
# myName=input("이름을 입력하세요:")
# myYear=input("태어난 년도를 입력하세요:")
# myAge=curYear-int(myYear)+1
# print("이름:",myName)
# print("나이:",myAge)


# ws=t.Screen()
# t.shape('turtle')
# ws.colormode(255)


# r=int(input("색상의 R값 입력:"))
# g=int(input("색상의 G값 입력:"))
# b=int(input("색상의 B값 입력:"))
# rad=int(input("반지름 입력:"))
# t.color((r,g,b))
# t.begin_fill()
# t.circle(rad)
# t.end_fill()
# t.exitonclick()


import random

# 졸라맨 그리기에 필요한 색상 설정
HEAD_COLOR = "#FFDD00"     # 노란색
BODY_COLOR = "#00A8E8"     # 파란색
ARM_COLOR = "#FF9500"      # 주황색
BG_COLOR = "#FFFFFF"       # 흰색

# 졸라맨 그리기
def draw_zolaman():
    # 머리 그리기
    turtle.fillcolor(HEAD_COLOR)
    turtle.begin_fill()
    turtle.circle(30)
    turtle.end_fill()

    # 몸체 그리기
    turtle.penup()
    turtle.goto(-20, -50)
    turtle.pendown()
    turtle.fillcolor(BODY_COLOR)
    turtle.begin_fill()
    turtle.circle(40)
    turtle.end_fill()

    # 팔 그리기
    turtle.penup()
    turtle.goto(-60, -30)
    turtle.pendown()
    turtle.fillcolor(ARM_COLOR)
    turtle.begin_fill()
    turtle.forward(80)
    turtle.left(90)
    turtle.forward(20)
    turtle.left(90)
    turtle.forward(80)
    turtle.end_fill()

# Turtle 그래픽 초기화
screen = turtle.Screen()
screen.bgcolor(BG_COLOR)

# Turtle 객체 생성
t = turtle.Turtle()
t.speed(3)  # 그리는 속도 설정

# 졸라맨 그리기
for _ in range(100):
    x = random.randint(-200, 200)
    y = random.randint(-200, 200)

    t.penup()
    t.goto(x, y)
    t.pendown()
    draw_zolaman()

# Turtle 그래픽 창 유지
turtle.done()






