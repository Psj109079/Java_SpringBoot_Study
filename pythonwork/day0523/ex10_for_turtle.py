import turtle as t

t.color("pink")
t.begin_fill()      # 채우기색 시작
t.pencolor("blue")  # 펜 색상
t.width(5)          # 펜 굵기

t.speed(0) # 0 ~ 10 0은 10과 같이 가장 빠른속도(1이 가낭 느림)
n = 100000
m = 2
for x in range(n):
    t.fd(m)
    t.lt(m)
    t.fd(m)
    t.lt(m)
    t.fd(m)
    t.lt(m)
    t.fd(m)
    t.lt(m)
    t.fd(m)
    t.lt(m)
    m += 1
t.end_fill() # 채우기색 끝
t.exitonclick()
