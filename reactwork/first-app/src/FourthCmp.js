import React, {useState} from 'react';
import "./mystyle.css";
import {AddAlarm, AddAPhoto, DeleteForeverRounded, DeleteOutline, DeleteSharp} from "@mui/icons-material";
import InputEmojiWithRef from "react-input-emoji";
import {Button} from "@mui/material";
function FourthCmp(props) {
    // react 에서 값을 변경하려면 반드시 useState 를 이용해야만 한다
    const [number, setNumber] = useState(1);
    // number 변수에 초기값을  1로 지정 얘를 변경하는 함수는 setNumber
    return (
        <div>
            <h2 className={"title"}>네번째 컴포넌트</h2>
            <DeleteSharp className={"App-logo2"}/>
            <DeleteOutline className={"App-logo2"}/>
            <DeleteForeverRounded/>
            <AddAPhoto/>
            <AddAlarm/>

            <InputEmojiWithRef style={{width: "200px"}} laceholder="메시지를 입력해주세요"/>
            <hr/>
            <a className="stylenum">{number}</a>
            <br/>
            <Button variant="contained" color="success" onClick={() => {
                if(number <= 0) {
                    alert("0보다 작아질 수 없습니다");
                    return;
                }
                setNumber(number - 1);

            }}>감소</Button>
            &nbsp;&nbsp;
            <Button variant="contained" color="warning" onClick={() => {
                if(number < 10) {
                    setNumber(number + 1);
                } else {
                    alert("더 이상 증가할 수 없습니다")
                }
            }}>증가</Button>
            
        </div>
    );
}

export default FourthCmp;