import React, {useState} from 'react';
import '../App.css';
import img1 from "../image/432.jpg";
function OneComponent(props) {
    const [carName1, setCarName1] = useState("펭귄");
    const [carName2, setCarName2] = useState("강아지 ");

    // 출력은 가능하지만 수정은 할수 없음
    let message = "Have a Good Day!";
    return (
        <div className="App main">
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                One Component 실습
            </h5>
            <h4 className="one two">{message}</h4>
            <h5>import를 이용해서 src  이미지 가져오기</h5>
            <img alt="img" src={img1} width={200}/>
            <b>{carName1}</b>
            
            <br/>
            <h5>require 를 이용해서 src 이미지 가져오기</h5>
            <img alt="img" src={require(`../image/1234567.jpg`)} width={200}/>
            <b>{carName2}</b>
            <hr/>
            <div className="input-group">
                <input type="text" className="form-control" placeholder="첫번째 사진"
                onKeyUp={(e) => {
                    setCarName1(e.target.value);
                }}
                />
                
                <input type="text" className="form-control" placeholder="두번째 사진"
                onKeyUp={(e) => {
                  //   if(e.keyCOde === 13) {
                  if(e.key === "Enter") {
                      setCarName2(e.target.value);
                  }
                }}
                />
            </div>
        </div>
    );
}

export default OneComponent;