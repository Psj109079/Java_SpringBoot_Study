import React, {useEffect, useState} from 'react';
import "./foodstyle.css";
import {useNavigate, useParams} from "react-router-dom";
import Axios from "axios";
import "./foodstyle.css"
import "../App.css";
import joo from "../image/smilejoo.jpg"
function FoodDetail(props) {
    const navi = useNavigate();
    const [data, setData] = useState({});
    const [photo, setPhoto] = useState([]);
    const {num} = useParams();

    const photourl = process.env.REACT_APP_FOODURL;
    // num에 해당하는 dto를 얻어서 data에 넣기
    const getData = () => {
        const detailUrl = "/react/detail?num=" + num;

        Axios.get(detailUrl)
            .then(res => {
                setData(res.data);
                // data중 fphoto는 ,로 분리해서 photo에 넣기
                setPhoto(res.data.fphoto.split(","));
            })
    }

    const deletebook = () => {
        let c = window.confirm("삭제하려면 [확인]을 눌러주세요");
        if(c) {
            Axios.get("/react/delete?num=" + num)
                .then(res => {
                    navi("/food/list");
                })
        }
    }

    useEffect(() => {
        getData();
    }, []);
    return (
        <div className="foodcontainer">
            <div>
                <button type="button" className="btn btn-outline-success" style={{width: "90px", marginRight: "10px"}}
                        onClick={() => navi("/food/form")}>예약추가</button>
                <button type="button" className="btn btn-outline-success" style={{width: "90px", marginRight: "10px"}}
                        onClick={() => navi(`/food/form/${num}`)}>추가에서 수정</button>
                <button type="button" className="btn btn-outline-success" style={{width: "90px", marginRight: "10px"}}
                    onClick={() => navi("/food/list")}>예약목록</button>
                <button type="button" className="btn btn-outline-success" style={{width: "90px", marginRight: "10px"}}
                onClick={() => navi(`/food/updatephoto/${num}`)}>사진수정</button>
                <button type="button" className="btn btn-outline-success" style={{width: "90px", marginRight: "10px"}}
                onClick={() => navi(`/food/update/${num}`)}>내용수정</button>
                <button type="button" className="btn btn-outline-success" style={{width: "90px", marginRight: "10px"}}
                onClick={deletebook}>삭제</button>
            </div>
            <h4>예약자명: {data.fname}</h4>
            <h5>사진들</h5>
                {photo.map((p, i) => <img alt="사진줘" src={`${photourl}${p}`} className="myphoto"/>)}
            <br/>
            <h5>주문내용</h5>
            <h5>핸드폰: {data.fhp}</h5>
            <h5>예약일: {data.bookingday}</h5>
            <pre style={{marginLeft: "10px", fontSize: "18px", color: "red"}}>{data.fcontent}</pre>
            <img className="imgenlargement" src={joo}/>
        </div>
    );
}

export default FoodDetail;