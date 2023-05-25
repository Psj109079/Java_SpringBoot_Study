import turtle as t
list = ["red", "green", "pink", "yellow", "orange", "gray"]

t.speed(0)

# for count in range(6): # 0 ~ 5
#     t.begin_fill()
#     t.color(list[count])
#     t.circle(100)
#     t.left(360 / 6)
#     t.end_fill()

# t.exitonclick()

for item in list: # 0 ~ 5
    t.begin_fill()
    t.color(item)
    print(list.index(item), item)
    t.circle(100)
    t.left(360 / 6)
    t.end_fill()

t.exitonclick()

