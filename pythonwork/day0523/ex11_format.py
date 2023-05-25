# format 함수 연습

a = 6.56789
b = 23
money = 5678932

print(format(a, "8.3f")) # 전체자리수 8, 소숫점이하 자리수 3 6.568
print(format(b, "20d")) # 전체자리수 20, 우측정렬
print(format(money, "3,d")) # 3자리마다 컴마 찍기

# 변환기호 : %f: 실수, %d: 정수, %s: 문자열, %c: 단일문자
num1 = 20
num2 = 45
print(num1, "+", num2, "=", num1 + num2)
print("%d + %d = %d"%(num1, num2, num1 + num2))

name = "송혜교"
age = 34
height = 165.9
weight = 49.8

print("이름: %s, 나이: %d세, 키: %0.1f, 몸무게: %0.1f"%(name, age, height, weight))
print("내 이름은 {} 이고 내 나이는 {}세 랍니다.".format(name, age))