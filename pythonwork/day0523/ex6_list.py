#list 자료형
list1 = ["hello"]

print(list1)

list1.append("orange")
list1.append("apple")
print(list1)


# 선언만
list2 = []
list2.append("red")
list2.append("pink")
list2.append("green")
list2.append("yellow")
list2.append("black")

print(list2)

# 일부만 출력
print("list1의 첫 데이터: ", list1[0])
print("list2의 1 ~ 3 데이터: ", list2[1:4])
print("list2의 2부터 끝까지: ", list2[2:])

# 리스트 안에 또 리스트를 담을 수 있다
list3 = ["모닝", "그랜저", ["벤츠", "미니"]]
print(list3)
print(list3[1]) # 그랜저
print(list3[2][0]) # 벤츠