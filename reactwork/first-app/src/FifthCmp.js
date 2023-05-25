import React, {useState} from 'react';

function FifthCmp(props) {
    const [name, setName] = useState("캔디");
    const [addr, setAddr] = useState("강남구");
    
    return (
        <div>
            <h2 className={"title"}>5번째 컴포넌트</h2>
            <div style={{fontSize: "2em"}} className={"App-logo2"}>
                이 름: {name}<br/>
                주 소: {addr}<br/>
            </div>

            <input type="text" value={name} placeholder="이름입력"
            onChange={(e) => {
                setName(e.target.value);
            }}/>

            <input type="text" value={addr} placeholder="주소입력"
            onChange={(e) => {
                setAddr(e.target.value);
            }}
            />
        </div>
    );
}

export default FifthCmp;