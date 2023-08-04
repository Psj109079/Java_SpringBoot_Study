import React, {useEffect, useState} from 'react';
import "./foodstyle.css";
import {useNavigate} from "react-router-dom";
import Axios from "axios";
import FoodRowItem from "./FoodRowItem";


function FoodList(props) {
    const navi = useNavigate();
    const [datas, setDatas] = useState([]);

    const getData = () => {
        Axios.post("/react/getdata")
            .then(res => {
                setDatas(res.data);
            })
    }

    // 처음 실행 시 딱 한번 호출
    useEffect(() => {
        getData();
    },[]);
    return (
        <div className="foodcontainer">
            <button type="button" className="btn btn-outline-success"
                    onClick={() => navi("/food/form")}>예약추가</button>
            <hr/>
            <h1>총 {datas.length}개의 예약이 있습니다</h1>
            {
                datas.map((item, idx) => <FoodRowItem key={idx} item={item}/>)
            }
        </div>
    );
}

export default FoodList;