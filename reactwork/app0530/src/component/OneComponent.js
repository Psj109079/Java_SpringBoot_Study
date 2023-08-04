import React, {useEffect, useState} from 'react';

function OneComponent(props) {
    const [number, setNumber] = useState(1);
    const [photo, setPhoto] = useState("432.jpg")
    const [visible, setVisible] = useState("hidden");
    useEffect(() => {
        console.log("useEffect 1");
    }); // 모든 status 변수 변경 시 무조건 자동호출
    
    useEffect(() => {
        console.log("useEffect 1 - 처음 한번만 호출");
    }, []); // 처음 실행시 한번만 호출
    
    useEffect(() => {
        console.log("useEffect 2 - number변경됨");
        setVisible(number % 3 == 0 ? "visible" : "hidden");
    }, [number]); // number 의 값 변경시에만 자동호출

    useEffect(() => {
        console.log("useEffect 3 - photo변경됨");
    }, photo); //photo 값 변경시에만 자동 호출

    const changePhoto = (e) => {
        setPhoto(e.target.value);
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                One Component UseEffect
            </h5>
            <h1>{number}</h1>
            <button type="button" className="btn btn-info"
            onClick={() => {
              setNumber(number -1);
            }}>감소</button>
            &nbsp;&nbsp;&nbsp;
            <button type="button" className="btn btn-info" onClick={() => {
              setNumber(number + 1);
            }}>증가</button>
            <label>
                <input type="radio" name="photo" defaultValue="432.jpg" defaultChecked onClick={changePhoto}/>사진1
            </label>
            &nbsp;
            <label>
                <input type="radio" name="photo" defaultValue="567.jpg" onClick={changePhoto}/>사진2
            </label>
            &nbsp;
            <label>
                <input type="radio" name="photo" defaultValue="678.jpg" onClick={changePhoto}/>사진3
            </label>
            <img src={require(`../image/${photo}`)} width={200} style={{visibility: visible}}/>
        </div>
    );
}

export default OneComponent;