// 객체 할당
let obj1 = {"name": "lee","age" :23, "addr": "seoul"};

console.log(obj1);
console.log(obj1.name);
console.log(obj1.age);
console.log(obj1.addr);

// 오브젝트 통으로 대입
let obj2 = obj1;

console.log(obj2.name);

// es6 에서 오브젝트로부터 값을 얻을경우
let {name, age} = obj1;
console.log("name = " + name + "age = " + age);

// 함수에서 매개변수를 객체타입으로 받는데 초기값을 지정한경우
let f1 = ({name = "수지", age = 30} = {}) => console.log("이름:" + name +", 나이: " + age );

f1();           // 수지, 30
f1(obj1.name);  // 수지, 30
f1(obj1);       // lee, 23