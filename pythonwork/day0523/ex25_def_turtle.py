import mydef
import turtle

ws = turtle.Screen()
ws.colormode(255)

#turtle 여러개 생성
# t1 = turtle.Turtle()
# t2 = turtle.Turtle()
# t3 = turtle.Turtle()
# t4 = turtle.Turtle()
# t5 = turtle.Turtle()

# mydef.showturtle(t1)
# mydef.showturtle(t2)
# mydef.showturtle(t3)
# mydef.showturtle(t4)
# mydef.showturtle(t5)
turtle.speed(0)
a = []
for x in range(10001):
    a.append(turtle.Turtle())
    mydef.showturtle(a[x])
print(a)
turtle.exitonclick()