import React, {useState} from 'react';
import OneWriteForm from "./OneWriteForm";
import OneArrayList from "./OneArrayList";

function OneComponent(props) {
    const [list, setList] = useState([
        {irum: "조", message: "안녕하세요", today: new Date()},
        {irum: "Jo", message: "Hello", today: new Date()},
    ]);

    // 추가 이벤트
    const addListHandler= (data) => {
        setList(list.concat(
            {
                ...data,
                today: new Date()
            }
        ));
    }

    const deleteData = (idx) => {
        setList(list.filter((d, i) => i !== idx));
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>One Component-간단 방명록</h5>
            <OneWriteForm onSave={addListHandler}/>
            <hr/>
            {
                list.map((ele, idx) => <OneArrayList key={idx} idx={idx} row={ele} onDelete={deleteData}/>)
            }
        </div>
    );
}

export default OneComponent;