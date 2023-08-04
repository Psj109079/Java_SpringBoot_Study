import React, {useEffect, useState} from 'react';
import Axios from "axios";
function ThreeComponent(props) {
    const [irum, setIrum] = useState("");
    const [message, setMessage] = useState("");
    const [list, setList] = useState([]);

    // 전체 데이터 출력
    const dataListEvent=()=> {
        // let url="http://localhost:9000/test/list";
        let url="/test/list"; // package.json 에서 proxy 설정시
        Axios.get(url)
            .then(res => {
                setList(res.data);
            })
    }
    
    // 처음 실행시 list 함수 한번만 호출
    useEffect(() => {
        dataListEvent();
    }, []);
    
    // 추가 버튼 이벤트
    const addDataEvent=()=> {
        // let url = "http://localhost:9000/test/insert";
        let url = "/test/insert";
        Axios.post(url,{irum, message})
            .then(res => {
                alert(res.data);
                setIrum("");
                setMessage("");
                // 목록 다시 호출
                dataListEvent();
            })
            .catch(err => alert(err));
    }

    // 삭제함수
    const deleteData = (num) => {
        // alert(num);
        // 방법 1 : 파라미터로 num 값 전달하는 경우
        // let url="/test/delete?num=" + num;
        // 방법 2 : url 로 num 값을 넣는방법
        let url = `/test/delete/${num}`;
        Axios.delete(url)
            .then(res=> {
                alert(res.data);
                // 목록 다시 호출
                dataListEvent();
            })
            .catch(err => alert(err));
    }
    return (
        <div>
            <h2 className="alert alert-danger">Three Component 실습</h2>
            <h4>데이터 추가하기</h4>
            <div>
                <input type="text" onChange={(e)=> setIrum(e.target.value)} placeholder="이름 입력" style={{width: "120px"}} value={irum}/>
                
                <input type="text" onChange={(e)=> setMessage(e.target.value)} placeholder="메세지 입력" style={{width: "200px", marginLeft: "10px"}} value={message}/>

                <button type="button" className="btn btn-info btn-sm" style={{marginLeft: "10px"}} onClick={addDataEvent}>db추가</button>
            </div>
            
            <div>
                <h4>test db 전체 출력</h4>
                {
                    list.map((data, idx)=>
                        <div>
                            이름: {data.irum}, 메세지: <b>{data.message}</b>, 날짜: {data.writeday}
                            &nbsp;
                            <button type="button" style={{marginLeft: "10px"}} onClick={() => {
                                deleteData(data.num);
                            }}>삭제</button>
                        </div>
                    )
                }
            </div>
        </div>
    );
}

export default ThreeComponent;