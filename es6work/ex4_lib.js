let a = 12;
let b = 23.0;
let c = 12.6;

console.log(a + "는 정수인가? " + Number.isInteger(a));
console.log(b + "는 정수인가? " + Number.isInteger(b));
console.log(c + "는 정수인가? " + Number.isInteger(c));

// isNaN : NaN 이 나올때만 true
console.log(12 / 'a'); // NaN : 수식에 오류가 있을경우 NaN 이라고 표기

let a1 = "NaN";
let b1 = NaN;
let c1 = "안녕";
let d1 = 12;
console.log(a1);
console.log(b1);

console.log("es5의 isNaN");         // 숫자가 아닐경우 모두 true
console.log("a1 = " + isNaN(a1));   // true
console.log("b1 = " + isNaN(b1));   // true 
console.log("c1 = " + isNaN(c1));   // true
console.log("d1 = " + isNaN(d1));   // false

console.log("es6의 Number.isNaN");  // NaN 일경우에만 true
console.log("a1 = " + Number.isNaN(a1));    // false
console.log("b1 = " + Number.isNaN(b1));    // true
console.log("c1 = " + Number.isNaN(c1));    // false
console.log("d1 = " + Number.isNaN(d1));    // false

// 반복함수
console.log("반복 함수 repeat");
console.log("사랑해".repeat(20));
console.log("=".repeat(20));


