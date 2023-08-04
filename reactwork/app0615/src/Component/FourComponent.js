import React, {useEffect, useState} from 'react';
import FourWriteForm from "./FourWriteForm";
import Axios from "axios";
import FourRowList from "./FourRowList";
function FourComponent(props) {
    const [list, setList] = useState([]);

    // 전체 데이터를 가져오는 함수
    const getList = () => {
        const listUrl = "/info/list";
        Axios.get(listUrl)
            .then(res => setList(res.data))

    }

    // 처음 실행 시 딱 한번 호출
    useEffect(() => {
        getList();
    },[]);

    return (
        <div>
            <h2 className="alert alert-danger">Four Component 실습</h2>
            <FourWriteForm getList={getList}/>
            <hr/>
            <h4 className="alert alert-success">총 {list.length}개의 정보가 있습니다</h4>
            {
                list.map((item, idx) => <FourRowList key={idx} item={item} getList={getList}/>)
            }
        </div>
    );
}

export default FourComponent;