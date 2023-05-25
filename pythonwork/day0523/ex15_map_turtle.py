import turtle as t
import random

myshape = {"반지름": "90", "색상": "green", "선굵기": "5", "선색상": "purple"}

# t.color(myshape.get("색상"))
# t.pencolor(myshape.get("선색상"))
# t.width(myshape.get("선굵기"))
# t.begin_fill()
# t.circle(int(myshape.get("반지름")))
# t.end_fill()
# t.exitonclick()

wn = t.Screen()
# wn.setup(600, 600, 0, 0);   # width, height, x, y
# t.width(10)
# wn.colormode(1.0);
# t.color(0, 1.0, 0.3);

t.shape("turtle")
wn.colormode(255)

t.speed(0)
num = 10000

lt = 25
while True:
    m = random.randint(1, 50)
    # m = 50;
    # lt = random.randint(1, 50)
    r = random.randint(1, 255)
    g = random.randint(1, 255)
    b = random.randint(1, 255)
    t.color(r, g, b)
    t.fd(m)
    t.lt(lt)
    t.fd(m)
    t.lt(lt)
    t.fd(m)
    t.lt(lt)
    t.fd(m)
    t.lt(lt)
    t.fd(m)
    t.lt(lt)

print("종료")