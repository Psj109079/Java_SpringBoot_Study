import React, {useRef, useState} from 'react';

function ThreeComponent(props) {
    const [count, setCount] = useState(1);

    const countRef = useRef(1);
    console.log("렌더링중...");

    const stateIncreEvent = () => {
        setCount(count + 1); // 값이 변경될때마다 랜더링 발생
    }

    const refIncreEvent = () => {
        countRef.current = countRef.current + 1; // 값은 변경되지만 랜더링되지는 않음(랜더링 발생시 변경된 화면에 출력됨)
        console.log("countRef변수값: " + countRef.current);
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Three Component-useRef
            </h5>
            <h1>state:{count}</h1>
            <h1>ref:{countRef.current}</h1>
            <button type="button" onClick={stateIncreEvent}>증가-state변수 증가</button>
            <button type="button" onClick={refIncreEvent}>증가-ref로 변수 증가</button>
        </div>

    );
}

export default ThreeComponent;