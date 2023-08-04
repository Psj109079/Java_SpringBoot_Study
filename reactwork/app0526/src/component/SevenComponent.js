import React, {useEffect, useState} from 'react';
import "../App.css";
function SevenComponent(props) {
    const [array, setArray] = useState(["red", "blue", "green", "orange"]);

    function getRandomValue(min, max) {
        return Math.random() * (max - min) + min;
    }

    function FallingElement() {
        useEffect(() => {
            const fallingElement = document.querySelector('.falling-element');
            const viewportWidth = window.innerWidth;

            fallingElement.style.left = getRandomValue(0, viewportWidth) + 'px';
        }, []);

        return <div className="falling-element"></div>;
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Seven Component 실습
            </h5>
            <div>
                <h5>색상을 추가해보세요(색상 더블클릭시 삭제!)</h5>
                <input type="text" placeholder="색상을 입력해주세요" onKeyUp={(e) => {
                    // alert(e.target.value);
                    // setArray(array.push(e.target.value)); // 배열에 추가 안됨
                    
                    // 리액트는 배열에 추가를 concat을 이용해서 추가한다
                    if(e.key === "Enter") {
                        setArray(array.concat(e.target.value));
                        e.target.value = "";
                    }
                }}/>
                <br/>
                <input type="color" value={"#abcabc"}
                       onBlur={(e) => {
                         setArray(array.concat(e.target.value));
                       }}/>
            </div>
            <div>
            {
                array.map((color, idx) =>(
                    <div style={{clear:"both", marginLeft:"200px"}}>
                        <div key={idx} style={{backgroundColor:color}} onDoubleClick={() => {
                          setArray([...array.slice(0,idx), ...array.slice(idx + 1, array.length)])
                        }}>{idx + 1}</div>
                        <h5>{color}</h5>
                    </div>
                ))
            }
            </div>
        </div>
    );
}

export default SevenComponent;