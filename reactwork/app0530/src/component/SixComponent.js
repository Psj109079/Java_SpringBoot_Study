import React, {useState} from 'react';

function SixComponent(props) {
    const [inputArray, setInputArray] = useState([]);
    const [data, setData] = useState({
       name: "전주식당",
       age: 85,
       hp: "02-123-4589",
       addr: "강남구 역삼동"
    });

    // 4개의 input 태그 입력시 호출되는 함수
    const changeData = (e) => {
        // console.log(e.target.name);
        // console.log(e.target.value);
        const {name, value} = e.target;

        setData({
            ...data, /* 나머지 데이터는 그대로 유지*/
            [name]:value /* name 에 해당하는 value만 변경 */
        });
        console.log(data);
    }
    
    // 데이터 추가버튼
    const addButton = () => {
        setInputArray(inputArray.concat(data));
    }
    
    // 데이터 초기화 버튼
    const initButton = () => {
        setData({name: "", age: "", hp: "", addr: ""});
    }

    const deleteidx = (idx) => {
        setInputArray(inputArray.filter((item, i) => i !== idx));
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Six Component-한꺼번에 묶어서 배열에 추가하기
            </h5>
            <table className="table table-bordered" style={{width: "300px"}}>
                <caption align="top">데이터 입력</caption>
                <tbody>
                    <tr>
                        <th width="100">이름</th>
                        <td>
                            <input type="text" name="name" className="form-control" onChange={changeData} value={data.name}/>
                        </td>
                    </tr>
                    <tr>
                        <th width="100">나이</th>
                        <td>
                            <input type="text" name="age" className="form-control" onChange={changeData} value={data.age}/>
                        </td>
                    </tr>
                    <tr>
                        <th width="100">핸드폰</th>
                        <td>
                            <input type="text" name="hp" className="form-control" onChange={changeData} value={data.hp}/>
                        </td>
                    </tr>
                    <tr>
                        <th width="100">주소</th>
                        <td>
                            <input type="text" name="addr" className="form-control" onChange={changeData} value={data.addr}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align="center">
                            <button type="button" onClick={addButton}>데이터추가</button>
                            <button type="button" onClick={initButton}>입력값 초기화</button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr/>
            <table className="table table-bordered" style={{width:"500ox"}}>
                <thead>
                    <tr style={{backgroundColor: "#dddddd"}}>
                        <th width="50">번호</th>
                        <th width="100">이름</th>
                        <th width="80">나이</th>
                        <th width="150">핸드폰</th>
                        <th width="150">주소</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    inputArray.map((item, idx) => (
                        <tr key={idx}>
                            <td>{idx + 1}</td>
                            <td>{item.name}</td>
                            <td>{item.age}</td>
                            <td>{item.hp}</td>
                            <td>{item.addr}</td>
                            <td>
                                <button type="button" onClick={() => {
                                    deleteidx(idx);
                                }}>삭제</button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>

    );
}

export default SixComponent;