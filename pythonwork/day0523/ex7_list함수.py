# list 타입의 각종 함수 연습
list = ["green", "blue", "white", "yellow", "orange"];
print("list: ", list)
print("list: ", list.pop())   # 마지막 데이터 꺼내기 orange
list2 = list.copy() # 남은 데이터 복사
print("list2: ",  list2)
print("list: ", list)

list2.sort()
print("list: ", list)         # 넣은 순서대로 출력
print("list2: ", list2)        # 정렬되서 출력


list.reverse()
print("list: ", list)         # 거꾸로 출력

list.insert(1, "gray") # 1번 인덱스 이전에 추가됨
print("list: ", list)


list.remove("white")
print("list: ", list)