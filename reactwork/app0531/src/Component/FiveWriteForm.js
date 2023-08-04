import React, {useState} from 'react';

function FiveWriteForm(props) {
    const [writer, setWriter] = useState("");
    const [subject, setSubject] = useState("");
    const [content, setContent] = useState("");
    const [photo, setPhoto] = useState("killer.jpg");
    const buttonAddEvent = () => {
        props.addBoard({writer, subject, content, photo});
    }
    return (
        <div>
            작성자: <input type="text" onChange={(e) => setWriter(e.target.value)}/><br/>
            제 목: <input type="text" onChange={(e) => setSubject(e.target.value)}/><br/>
            사 진: 
            <select onChange={(e) => setPhoto(e.target.value)}>
                <option value={"killer.jpg"}>조</option>
                <option value={"killer1.jpg"}>형</option>
                <option value={"killer2.jpg"}>기</option>
                <option value={"killerjo1.jpg"}>입</option>
                <option value={"killerjo2.jpg"}>니</option>
                <option value={"killerjo3.jpg"}>다</option>
            </select><br/>
            <textarea style={{width: "400px", height: "130px"}} onChange={(e) => setContent(e.target.value)}></textarea>
            <br/>
            <button type="button" onClick={buttonAddEvent}>게시글 등록</button>

        </div>
    );
}

export default FiveWriteForm;