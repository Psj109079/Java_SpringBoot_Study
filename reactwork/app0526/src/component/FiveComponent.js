import React from 'react';

function FiveComponent(props) {
    const names = ["장미꽃", "안개꽃", "다알리아", "프리지아", "국화꽃"];

    // 배열 출력 방법 #1
    const nameList = names.map((item, idx) => (<li>{idx}:{item}</li>));
    
    // 배열 출력 방법 #2 - 잘 사용 안함
    const arrloop = () => {
        let arr = [];
        for(let i = 0; i < names.length; i++) {
            arr.push(<h5>{names[i]}</h5>)
        }
        return arr;
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Five Component 실습
            </h5>
            {nameList}
            <hr/>
            {arrloop()}
            <hr/>
            {// 출력 방법 #3 직접 map 으로 출력
                names.map((item, idx) => (<h6>{idx}:{item}</h6>))}
            <hr/>
            {
                [...new Array(5)].map((item, idx) => <h6>{idx + 1}</h6>)
            }
            <hr/>
            {
                [...new Array(15)].map((item, idx) => <img alt="img" key={idx} src={require(`../image/car/car${idx + 1}.png`)}/>)
            }

        </div>
    );
}

export default FiveComponent;