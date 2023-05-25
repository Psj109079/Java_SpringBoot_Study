"""
    파이썬에서 함수(모듈, 메서드) 선언하는 방법
    def 함수명([인수]):
        코드1
        코드2
        [return 값]

"""

def func1():
    print("함수 호출!!")


# 숫자를 인자로 받아서 1부터 그 숫자까지 출력하는 함수
def numout(n):
    for i in range(1, n + 1):
        print(i, end = " ")
    print()

# 숫자를 인자로 받아서 1부터 그 숫자까지의 합을 반환하는 함수
def numsum(n):
    sum = 0
    for i in range(1, n + 1):
        sum += i
    return sum

# func1() 함수 호출
func1()
func1()

# numout() 함수 호출
# numout(1000000000000000)

# numsum() 함수 호출
print(numsum(100000000))