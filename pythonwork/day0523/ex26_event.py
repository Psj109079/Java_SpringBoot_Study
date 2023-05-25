import turtle as t
import random as r
def mywrite(msg):
    t.write(msg, font=("Impact", 24, "bold"))

def key_up():
    m = r.randint(50, 100)
    # t.clear() # 그래픽 전체 지우기
    t.forward(m)
    mywrite("Up Key!!")
def key_down():
    m = r.randint(50, 100)
    # t.clear() # 그래픽 전체 지우기
    t.forward(m)
    mywrite("Down Key!!")
def key_left():
    m = r.randint(50, 100)
    # t.clear() # 그래픽 전체 지우기
    t.forward(m)
    mywrite("Left Key!!")
def key_right():
    m = r.randint(50, 100)
    # t.clear() # 그래픽 전체 지우기
    t.forward(m)
    mywrite("Right Key!!") 
def key_sp():
    # t.clear() # 그래픽 전체 지우기
    t.left(10)
    mywrite("Space Key!!")


#이벤트 발생
t.onkeypress(key_up, "Up") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_down, "Down") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_left, "Left") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_right, "Right") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_sp, "space") # 호출할 함수명, 키값(첫글자 반드시 대문자)
t.listen() #키를 받을 수 있도록 포커스를 그래픽창으로 주는것


t.exitonclick()