import React, {useState} from 'react';
import EightArrayApp from "./EightArrayApp";
import EightWriteApp from "./EightWriteApp";

function EightComponent(props) {
    const [array, setArray] = useState([
        {"name": "No-Head", "blood": "B", "addr": "강남", "photo" : "nohead.png"},
        {"name": "양", "blood": "A", "addr": "강동", "photo" : "567.jpg"},
        {"name": "펭귄", "blood": "O", "addr": "강북", "photo" : "432.jpg"}
    ]);

    // 삭제 함수
    const deletedata = (idx) => {
        setArray(array.filter((item, i) => i !== idx));
    }

    // 배열에 추가하는 함수
    const addData = (data) => setArray(array.concat(data));

    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>Eight Component</h5>
            <EightWriteApp onSave={addData}/>
            <table className="table table-bordered" style={{width: "800px"}}>
                <thead>
                    <tr style={{backgroundColor: "orange"}}>
                        <th width="60">번호</th>
                        <th width="70">이름</th>
                        <th width="70">혈액형</th>
                        <th width="100">서식지</th>
                        <th width="100">몽타주</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    array.map((ele,idx) => (<EightArrayApp key={idx} row={ele} idx={idx} onDel={deletedata}/>))
                }
                </tbody>
            </table>
        </div>
    );
}

export default EightComponent;