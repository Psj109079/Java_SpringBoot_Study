import React, {useState} from 'react';

function EightWriteApp({onSave}) {
    const [name, setName] = useState("No-Head");
    const [blood, setBlood] = useState("C");
    const [addr, setAddr] = useState("독도");
    const [photo, setPhoto] = useState("nohead.png");
    
    // 추가 버튼 이벤트
    const addButton = () => {
        // onSave({name: name, blood: blood, addr: addr, photo: photo});
        // key, value 값이 같을경우 밑에처렁 사용 가능
        onSave({name, blood, addr, photo}); // 4개의 변수값에 객체 형태로 data 변수로 들어간다
    }
    return (
        <div>
            <input type="text" value={name} onChange={(e) => setName(e.target.value)}/>
            <br/>
            <input type="text" value={blood} onChange={(e) => setBlood(e.target.value)}/>
            <br/>
            <input type="text" value={addr} onChange={(e) => setAddr(e.target.value)}/>
            <br/>
            <input type="text" value={photo} onChange={(e) => setPhoto(e.target.value)}/>
            <br/>
            <button type="button" onClick={addButton}>추가</button>
        </div>

    );
}

export default EightWriteApp;