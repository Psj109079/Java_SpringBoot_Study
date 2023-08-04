import React from 'react';
import "../App.css";

function SixComponent(props) {
    const array1 = ["red", "blue", "green", "orange", "gray", "pink", "white", "yellow"]

    const array2 = [
        {"carphoto":"car1.png","carname":"아우디레드","carprice":"3500만"},
        {"carphoto":"car2.png","carname":"벤츠노랑이","carprice":"2700만"},
        {"carphoto":"car3.png","carname":"폭스바겐분홍이","carprice":"1900만"},
        {"carphoto":"car4.png","carname":"봉고노랑이","carprice":"4700만"},
        {"carphoto":"car5.png","carname":"벤츠화이트","carprice":"5500만"}];

    // 배열 출력 방법 #1
    const list = array2.map((item, idx) => (<li>{idx}:{item.carname},
        <img src={require(`../image/car/${item.carphoto}`)}/>{item.carprice}</li>));
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Six Component 실습
            </h5>
            <div>
                <h6>array1 배열 출력하기</h6>
                {
                    array1.map((color, idx) => (<div key={idx} style={{backgroundColor: color}}>{idx + 1}</div>))
                }
            </div>

            <br style={{clear:"both"}}/>
            <div style={{marginTop:"20px"}}>
                <h6>배열 출력하기</h6>

                {list}

            </div>
        </div>
    );
}

export default SixComponent;