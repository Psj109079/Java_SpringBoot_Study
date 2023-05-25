// 컬랙션 set: 중복 허용 안함, 비순차적
let set1 = new Set("abcabcabcabc");
console.log(set1);
set1.add("x");      // x 추가
console.log(set1);
console.log(set1.size)
console.log(...set1) // 펼침연산자를 이용해서 결과값 출력
set1.clear(); // 모두 삭제
console.log(set1, set2);

console.log("*".repeat(20));
let map1 = new Map();
let a = {n : 1};

map1.set(a,"A"); // 추가
map1.set("age", 35);
console.log(map1);
console.log(...map1); // 펼침연산자
map1.delete("age");   // 삭제
console.log(...map1); //"펼침연산자"
map1.clear();         // 전체삭제       