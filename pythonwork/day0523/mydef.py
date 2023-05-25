import random as rnd

def mystar(num):
    for n in range(1, num + 1):
        for i in range(1, n + 1):
            print("☆", end = " ")
        print()
    print("=" * 40)


# mystar(1000000000)

# turtle 값을 인자로 받아서 색상과 크기를 랜덤하게 만드는 함수
def showturtle(tt):
    tt.penup() # 펜을 들어서 이동하기 위한 동작
    tt.shape("turtle") # 거북이 모양으로 변경

    r = rnd.randint(1, 255)
    g = rnd.randint(1, 255)
    b = rnd.randint(1, 255)
    ts = rnd.randint(2, 10)

    tt.color(r, g, b) # 거북이 색상 변경
    tt.turtlesize(ts) # 거북이 크기 변경

    # 위치도 랜덤하게
    x = rnd.randint(-1000, 500)
    y = rnd.randint(-1000, 500)

    tt.goto(x, y)

