import turtle as t
import random as rnd

ws = t.Screen()
ws.colormode(255)

t.shape("turtle")
t.turtlesize(5)
t.width(5)

r = rnd.randint(0, 255)
g = rnd.randint(0, 255)
b = rnd.randint(0, 255)

t.color(r,g,b)
t.setheading(90) # 위
t.fd(100)

t.color(r,g,b)
t.setheading(360) # 우측
t.fd(100)

t.color(r,g,b)
t.setheading(270) # 아래
t.fd(100)

t.color(r,g,b)
t.setheading(180) # 좌측
t.fd(100)

t.exitonclick()
