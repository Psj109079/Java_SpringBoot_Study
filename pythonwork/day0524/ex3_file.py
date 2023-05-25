"""
    파일변수 = open("파일명", "모드")
    모드: w: 쓰기, r: 읽기, a: 추가
"""

import os
print(os.path.isfile("d:/data.txt")) # 파일이 존재하면 True
print(os.path.isfile("d:/data1.txt"))
print(os.path.isfile("d:/bit701naver")) # 폴더 존재 시 True

f1 = open("d:/data1.txt", "w")
str = "hello\npython\nspring boot"
f1.write(str)
f1.close()

print("data1.txt 를 확인해보세요")

f2 = open("d:/data2.txt", "w")
str2 = "안녕하세요\n파이썬 공부중입니다\n재밌어요!!!"
f2.writelines(str)
f2.close()

print("data2.txt 를 확인해보세요")

f3 = open("d:/data3.txt", "w")
list = ["빨강색\n", "노랑색\n", "분홍색\n", "초록색"]
# f3.write(list) # TypeError: write() argument must be str, not list <- 오류메세지
f3.writelines(list)
f3.close()

print("data3.txt 를 확인해보세요")
