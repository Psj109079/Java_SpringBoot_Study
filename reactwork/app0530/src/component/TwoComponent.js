import React, {useEffect, useState} from 'react';

function TwoComponent(props) {

    const [nameArray, setNameArray] = useState(["쏘니", "안쏘니"]);
    const [name, setName] = useState("");

    // 이름을 배열에 추가하는 함수(버튼 이벤트)
    const addName = () => {
        // set 메서드를 연속해서 호출할경우 순차적으로 실행이 안될수도 있음
        // 그런경우 반드시 nameArray 가 변경된후 name 이 변경되도록 하려면
        // name 은 useEffect를 이용해서 변겨앟면 됨
        setNameArray(nameArray.concat(name));
        // setName("");
    }

    useEffect(() => {
       setName("");
    }, [nameArray]);
    
    // idx번지의 이름을 삭제하는 삭제버튼 이벤트
    const deleteName = (idx) => {
        setNameArray(nameArray.filter((item, i) => i !== idx))
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Two Component
            </h5>
            <div className="input-group" style={{width:"250px"}}>
                <h4 className="alert alert-info">이름입력</h4>
                <input type="text" className="form-control" value={name}
                onChange={(e) => {
                    setName(e.target.value);
                }}/>
                <button type="button" className="btn btn-sm btn-outline-danger"
                onClick={addName}>추가</button>
            </div>
            <hr/>
            {
                nameArray.map((item, idx) => (
                    <div className="input-group" style={{width: "300px", marginBottom: "10px", fontFamily: "Jua"}}
                    key={idx}>
                        <h4 style={{width: "200px"}}>{item}</h4>
                        <button type="button" className="btn btn-sm btn-danger" style={{marginLeft: "10px"}}
                        onClick={() => {
                            deleteName(idx);
                        }}>삭제</button>
                    </div>
                ))
            }
        </div>

    );
}

export default TwoComponent;