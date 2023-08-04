import React, {useState} from 'react';
import SevenChildApp from "./SevenChildApp";
import SevenChildApp2 from "./SevenChildApp2";

/*
    부모, 자식간 통신하기
    1. 부모 컴포넌트에서 자식 컴포넌트로 props를 통해서 값이나 이벤트를 전달할 수 있다
    2. 자식 컴포넌트에서는 부모 컴포넌트의 값을 props로 받아서 출력은 가능하지만 직접 변경은 불가능하다
    3. 만약 부득이하게 변경을 해야할 경우 props로 전달받은 이벤트를 통해서 값 변경을 할 수 있다
    4. 자식 컴포넌트로 보낼 props는 부모만이 정할 수 있으며 자식 컴포넌트에서는 읽기만 가능(값일경우)
*/
function SevenComponent(props) {
    const [count, setCount] = useState(0);

    const countIncre = () => setCount(count + 1);
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>Seven Component</h5>
            <h5 className="alert alert-success">방문 횟수 : {count}</h5>
            <SevenChildApp name={"캔디"} age={21} onIncre={countIncre}/>
            <SevenChildApp name={"이랴이랴"} age={80} onIncre={countIncre}/>
            <SevenChildApp name={"으쌰으쌰"} age={60} onIncre={countIncre}/>
            <hr/>
            <SevenChildApp2 name="펭귄" price="3500만원" photo="432.jpg"/>
            <SevenChildApp2 name="양" price="4700만원" photo="567.jpg"/>
        </div>
    );
}

export default SevenComponent;