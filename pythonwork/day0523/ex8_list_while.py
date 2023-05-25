import turtle

# colors = ["red", "purple", "pink", "green", "orange", "gray", "yellow"]

# a = t.Turtle()

# t.bgcolor("black")

# a.speed(10)      # 가장 빠른 속도
# a.width(3)
# length = 10

# # 반복문 while
# while length < 500:
#     a.forward(200)
#     a.left(170)
#     # a.forward(length)
#     # a.pencolor(colors[length % 7])
#     # a.right(144)
#     length += 5
# a.exitonclick()

class MyTurtle(turtle.Turtle):
    def __init__(self):
        super(MyTurtle, self).__init__()
        self.shape("turtle")
        self.shapesize(2, 2)
        self.color("purple")

        self.window = turtle.Screen()
        self.window.onclick(self.on_mouse_clicked)

        self.is_moving = False

    def loop(self):
        self.window.mainloop()

    def on_mouse_clicked(self, x, y):
        if self.acquire_lock():
            self.goto(x, y)
            self.release_lock()

    def acquire_lock(self):
        if self.is_moving is True:
            return False

        self.is_moving = True
        return True

    def release_lock(self):
        self.is_moving = False


t = MyTurtle()
t.loop()
