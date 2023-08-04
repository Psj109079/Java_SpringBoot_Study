import React, {useState} from 'react';
import {Button, TextField} from "@mui/material";
import InputEmojiWithRef from 'react-input-emoji';
function OneWriteForm({onSave}) {
    const [irum, setIrum] = useState("");
    const [message, setMessage] = useState();

    const handelOnEnter = (text) => {
        setMessage(text);
        console.log(text);
    }

    return (
        <div>
            <TextField required id="outline-required" label="NickName"
            value={irum}
            onChange={(e) => {setIrum(e.target.value)}}/>
            &nbsp;&nbsp;
            <Button variant="contained" size="large"
            onClick={() => {
                if(irum === "") {
                    alert("닉네임을 입력해주세요");
                    return;
                }
                if(message === "") {
                    alert("메세지를 입력 후 엔터를 눌러주세요");
                    return;
                }
                // 부모 컴포넌트로 입력 데이터를 보낸다
                onSave({irum, message})
                setIrum("");
                setMessage("");
            }}>등록</Button>
            <br/><br/>
            <InputEmojiWithRef cleanOnEnter placeholder="Type a message" onEnter={handelOnEnter}/>
        </div>

    );
}

export default OneWriteForm;