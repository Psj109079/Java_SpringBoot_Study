import React, {useRef, useState} from 'react';
import Axios from "axios";

function FiveWriteForm({onSave}) {
    
    const [nickName, setNickName] = useState("");
    const [korMsg, setKorMsg] = useState("");
    const [engMsg, setEngMsg] = useState("");
    
    // 메세지 입력시 이벤트
    const handleChangeMessage = (e) => {
        if(e.key === "Enter") {
            if(e.target.value == "") {
                setEngMsg("");
                return;
            }

            const url = "/memo/trans?korMsg=" + e.target.value;
            Axios.get(url)
                .then(res => {
                    setEngMsg(res.data.message.result.translatedText);
                })
        }

    }
    // 저장버튼 이벤트
    const onSaveButtonEvent = () => {
        if(nickName==="") {
            alert("닉네임을 입력해주세요");
            return;
        }
        
        if(korMsg === "") {
            alert("메세지를 입력해주세요");
            return;
        }
        
        if(engMsg === "") {
            alert("메세지를 입력 후 엔터를 눌러주세요");
            return;
        }
        onSave({nickname:nickName, kormsg:korMsg, engmsg:engMsg});
        setNickName("");
        setKorMsg("");
        setEngMsg("");
        alert("저장되었습니다");
    }

    return (
        <div>
            <span>닉네임: <input type="text" value = {nickName} onChange={(e) => setNickName(e.target.value)}/></span><br/>
            <b>메세지 입력 후 엔터를 눌러주세요</b><br/>
            <span>메세지: <input type="text" value={korMsg} onChange={(e) => setKorMsg(e.target.value)}
            onKeyUp={handleChangeMessage}/></span><br/>
            <button type="button" onClick={onSaveButtonEvent}>저장</button>
            <div  style={{width: "600px", height:"200px", border: "1px solid black", margin: "10px 10px 10px 10px"}}>{engMsg}</div>
        </div>
    );
}

export default FiveWriteForm;