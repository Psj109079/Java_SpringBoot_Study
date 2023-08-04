import React, {useEffect, useState} from 'react';
import FiveWriteForm from "./FiveWriteForm";
import FiveRowList from "./FiveRowList";
import Axios from "axios";

function FiveComponent(props) {
    const [memoList, setMemoList] = useState([]);

    // 출력 이벤트
    const handleMemoList = () => {
        Axios.get("/memo/list")
            .then(res => {
                setMemoList(res.data);
            })
    }

    // 처음 시작시 전체 메모 출력(한번만)
    useEffect(() => {
        handleMemoList();
    }, []);

    // 저장 이벤트
    const handleSaveMemo = (memo) => {
        // axios.get(/test?name=veneas)
        // axios.post('/test', form)
        // Axios.get("/memo/insert?dto=" + memo)
        Axios.post("/memo/insert",memo)
            .then(res => {
                handleMemoList();
            })
    }

    // 삭제 이벤트
    const handleDeleteMemo = (num) => {
        const url = "/memo/delete?num=" + num;
        Axios.delete(url)
            .then(res => {
                // 삭제 후 다시 출력
                handleMemoList();
            })
    }

    const handleSearch = (e) => {
        let search = e.target.value;
        const url = "/memo/list?search=" + search;
        Axios.get(url)
            .then(res => {
                setMemoList(res.data);
                console.log(res.data)
            })
    }
    return (
        <div>
            <h2 className="alert alert-danger">Five Component-Memo</h2>
            <FiveWriteForm onSave = {handleSaveMemo}/>
            <h4 className="alert alert-success">총 {memoList.length}개의 메모가 있습니다</h4>
            <input type="text" placeholder="검색" onChange={handleSearch}/><br/><br/><br/>
            {
                memoList.map((memo, idx) => <FiveRowList key={idx} memo={memo} onDelete = {handleDeleteMemo}/>)
            }
            <hr/>

        </div>
    );
}

export default FiveComponent;