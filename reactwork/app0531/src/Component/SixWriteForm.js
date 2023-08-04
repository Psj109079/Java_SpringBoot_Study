import React, {useState} from 'react';
import SixRowItem from "./SixRowItem";

function SixWriteForm({addData}) {
    const [data, setData] = useState({irum : "", blood : "", hp : ""});

    // 데이터 추가
    const changeEvenet = (e) => {
        let {name, value} = e.target;

        // 입력한 항목만 변경
        setData({
            ...data,
            [name]: value
        })
    }

    return (
        <div>
            이름: {data.irum}, 혈액형: {data.blood}, 핸드폰: {data.hp}<br/>
            이름: <input type="text" name="irum" placeholder="이름" size={5} onChange={changeEvenet}/><br/>
            혈액형: <input type="text" name="blood" placeholder="혈액형" size={5} onChange={changeEvenet}/><br/>
            핸드폰: <input type="text" name="hp" placeholder="휴대폰" size={10} onChange={changeEvenet}/><br/>
            <button type="button" onClick={() => addData(data)}>데이터 추가</button>
        </div>

    );
}

export default SixWriteForm;