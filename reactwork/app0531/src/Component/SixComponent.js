import React, {useState} from 'react';
import SixRowItem from "./SixRowItem";
import SixWriteForm from "./SixWriteForm";

function SixComponent(props) {
    const [data, setData] = useState([
        {"irum" : "마이클", "blood" : "O", "hp" : "010-2222-3333"},
        {"irum" : "조", "blood" : "AB", "hp" : "010-4122-65533"}
    ])

    // 데이터 추가
    const addDataEvent = (item) => {
        setData(data.concat(item));
    }
    return (
        <div>
            <h2 className="alert alert-info">Six Component 복습문제</h2>
            <SixWriteForm addData={addDataEvent}/>
            <hr/>
            <h5>{data.length}명 등록</h5>
            {
                data.map((ele, idx) => <SixRowItem key={idx} idx={idx} ele={ele}/>)
            }
        </div>

    );
}

export default SixComponent;