import React, {useEffect, useRef, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import Axios from "axios";

function FoodUpdateInfo(props) {
    const {num} = useParams();
    const [fname, setFname] = useState("");
    const [fhp, setFhp] = useState("");
    const [bookingday, setBookingday] = useState("");

    const contentRef = useRef();
    const navi = useNavigate();

    // num에 해당하는 dto를 얻어서 data에 넣기
    const getData = () => {
        const detailUrl = "/react/detail?num=" + num;

        Axios.get(detailUrl)
            .then(res => {
                setFname(res.data.fname);
                setFhp(res.data.fhp);
                setBookingday(res.data.bookingday);
                contentRef.current.value = res.data.fcontent;
            })
    }

    useEffect(() => {
        getData();
    }, []);

    const reset = () => {
        setFname("");
        setFhp("");
        setBookingday("");
        contentRef.current.value = "";
    }

    const updateInfo = () => {
        let fcontent = contentRef.current.value;
        Axios.post("/react/update", {num, fname, fhp, fcontent, bookingday,})
            .then(res => {
                navi(`/food/detail/${num}`);
            })
    }
    return (
        <div>
            <table className="table" style={{width: "400px", margin: "20px 20px"}}>
                <tr>
                    <th style={{width: "150px", backgroundColor: "#dddddd"}}>예약자 이름</th>
                    <td>
                        <input type="text" value={fname} className="form-control" onChange={(e)=> setFname(e.target.value)} required/>
                    </td>
                </tr>
                <tr>
                    <th style={{width: "150px", backgroundColor: "#dddddd"}}>핸드폰</th>
                    <td>
                        <input type="text" value={fhp} className="form-control" onChange={(e) => setFhp(e.target.value)}/>
                    </td>
                </tr>
                <tr>
                    <th style={{width: "150px", backgroundColor: "#dddddd"}}>예약날짜</th>
                    <td>
                        <input type="date" value={bookingday} className="form-control" onChange={(e) => setBookingday(e.target.value)} required/>
                    </td>
                </tr>
                <tr>
                    <th style={{width: "150px", backgroundColor: "#dddddd"}}>하고싶은말</th>
                    <td>
                        <textarea ref={contentRef} className="form-control" style={{width: "100%", height: "100px"}}></textarea>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align="center">
                        <button type="button" className="btn btn-outline-danger" onClick={updateInfo}>DB저장</button>
                        <button type="button" className="btn btn-outline-danger"
                                style={{marginLeft: "10px"}} onClick={reset}>초기화</button>
                    </td>
                </tr>
            </table>
        </div>
    );
}

export default FoodUpdateInfo;