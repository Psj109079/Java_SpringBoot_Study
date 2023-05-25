"""
    영어 단어를 입력하면 리스트 목록에 추가
    단, 영어가 아닌 글자가 포함 시 경고표시 후 다시 입력
    'q'입력시 조욜

    종류 후 1. 오름차순, 2.내림차순 3.입력순 4. 종료
"""

engList  = []

while True:
    eng = input("영어 단어를 입력해주세요(종료: q) ")
    if eng.lower() == 'q' :
        print("입력을 종료합니다")
        break
    if not eng.isalpha():
        print("경고: 알파벳만 입력해주세요")
        continue # 처음으로 돌아감
    
    if not eng.islower():
        print("경고: 한글, 숫자 안됩니다")
    #endList에 추가
    engList.append(eng)

list = engList.copy()

while True:
    print("1. 오름차순 2. 내림차순 3. 입력순 4. 종료")
    n = int(input("번호를 입력해주세요"))

    if n == 4:
        print("안녕히 가세요!!")
        break
    if n == 1:
        engList.sort() # 오름차순
        print(engList)
    elif n == 2:
        engList.sort(reverse=True) # 내림차순
        print(engList)
    elif n == 3:
        print(list)
    else: 
        print("번호가 잘못입력되었어요!!")
