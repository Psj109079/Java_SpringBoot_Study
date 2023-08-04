import React, {useEffect, useRef, useState} from 'react';

function FiveComponent(props) {
    const nameRef = useRef();
    const javaRef = useRef();
    const mysqlRef = useRef();
    const springRef = useRef();

    const [arr, setArr] = useState({name: "", java: 0, mysql: 0, spring: 0, sum: 0, avg: 0});
    const result = () => {
        let java = Number(javaRef.current.value);
        let mysql = Number(mysqlRef.current.value);
        let spring = Number(springRef.current.value);

        setArr({name: nameRef.current.value, java: java, mysql: mysql, spring : spring, sum: java + mysql + spring, avg: ((java + mysql + spring) / 3).toFixed(1)});
    }

    useEffect(() => {
        nameRef.current.value = "";
        javaRef.current.value = "";
        mysqlRef.current.value = "";
        springRef.current.value = "";
    })

    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Five Component
            </h5>
            <div>
                <div>
                    <span>이름</span>
                    <input type="text" placeholder="이름" ref={nameRef}/>
                </div>
                <div>
                    <span>JAVA</span>
                    <input type="text" placeholder="JAVA" ref={javaRef}/>
                </div>
                <div>
                    <span>MYSQL</span>
                    <input type="text" placeholder="MYSQL" ref={mysqlRef}/>
                </div>
                <div>
                    <span>SPRING</span>
                    <input type="text" placeholder="SPRING" ref={springRef}/>
                </div>
                <div>
                    <button type="button" onClick={result}>결과 확인</button>
                </div>
                <div>이름: {arr.name}<br/>JAVA:{arr.java}<br/> MYSQL:{arr.mysql}<br/> SPRING:{arr.spring}<br/> 총점:{arr.sum}<br/> 평균{arr.avg}<br/></div>
            </div>
        </div>
    );
}

export default FiveComponent;