import React from "react";
import './mystyle.css';
import img from "./image/765.jpg";

const SecondCmp= () => {
    return (
        <div>
            <h2 className="title">두번째 컴포넌트</h2>
            <h3 className="App-logo msg1">Happy Day!!!</h3>
            <img alt="이미지" src={img} className="photo1 bounce"/>
            
        </div>
    )
}
export default SecondCmp;