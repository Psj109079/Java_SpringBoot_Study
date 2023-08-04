import React, {useEffect, useState} from 'react';
import {NavLink, useNavigate} from "react-router-dom";
import "./foodstyle.css";
import "../App.css";
function FoodRowItem({item}) {
    const [photo, setPhoto] = useState("");
    const navi = useNavigate();
    const p = item.fphoto.split(",")[0]; //이것도 가능
    const photourl1 = process.env.REACT_APP_FOODSMALLURL;
    const photourl2 = process.env.REACT_APP_FOODSMALLURL80;

    // 사진중 첫번째 사진을 photo에 넣기
    useEffect(() => {
        setPhoto(item.fphoto.split(",")[0]);
    }, []);
    return (
        <div className="liststyle">
            <NavLink to={`/food/detail/${item.num}`}>
                <img alt="" className="spin45" src={`${photourl1}${photo}${photourl2}`}/>
            </NavLink>
            <br/>
            <b>{item.fname}</b>
        </div>
    );
}

export default FoodRowItem;