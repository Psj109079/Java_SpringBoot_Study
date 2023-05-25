s1 = "Have a Nice Day";
s2 = "Happy Day";
print(s1.startswith("Have"));   #True
print(s1.startswith("Happy"));  #False
print(s2.endswith("Day"));      #True
s3 = s1.replace(" ", "*");
print(s3);
print(s1.count("a"));           #s1에서 a의갯수 구하기
print(s1.lower(), s1.upper);    # 소문자, 대문자 변환
print("/" .join(s1));           # 모든 글자 사이에 / 넣기
print(s1.isalpha);              # 모두 알파벳일경우  true
print(s1.isdigit);              # 모두 숫자일경우  true


