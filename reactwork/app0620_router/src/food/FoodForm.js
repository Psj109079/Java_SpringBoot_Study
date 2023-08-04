import React, {useState, useRef, useEffect} from 'react';
import "./foodstyle.css";
import {useNavigate, useParams} from "react-router-dom";
import { CameraAltOutlined } from '@mui/icons-material';
import Axios from "axios";
import joo from "../image/shinyhaed.png";
import "../App.css"
function FoodForm(props) {
    const [fphoto, setfphoto] = useState([]);
    const [fname, setFname] = useState("");
    const [fhp, setFhp] = useState("");
    const [bookingday, setBookingday] = useState("");

    const contentRef = useRef();
    const navi = useNavigate();
    const photourl1 = process.env.REACT_APP_FOODSMALLURL;
    const photourl2 = process.env.REACT_APP_FOODSMALLURL80;
    const {num} = useParams();

    const getData = () => {
        if(num != null) {
            Axios.get("/react/detail?num=" + num)
                .then(res => {
                    setFname(res.data.fname);
                    setFhp(res.data.fhp);
                    setBookingday(res.data.bookingday);
                    contentRef.current.value= res.data.fcontent;
                    setfphoto(res.data.fphoto.split(","));
                })
        }
    }

    useEffect(() => {
        getData();
        console.log(num);
    }, []);


    // 파일 업로드 이벤트
    const fileUploadEvent = (e) => {
        // 파일 갯수가 3개가 넘을경우 이벤트 종료
        if(e.target.files.length > 3) {
            alert("파일은 3개까지만 업로드 가능합니다");
            return;
        }

        const upload = new FormData();
        for(let i = 0; i < e.target.files.length; i++) {
            upload.append("upload", e.target.files[i]);
        }
        // 스프링 서버로 보내고 업로드된 파일명 리턴받기
        Axios({
            method: "post",
            url: "/react/upload",
            data: upload,
            headers: {"Content-Type" : "multipart/form-data"}
        }).then(res => {
            setfphoto(res.data);
        })
    }

    // submit 이벤트 발생시 호출 함수
    const onSubmitEvent=(e)=> {
        // 기본 이벤트 무효화(action 호출 막기 위함)
        e.preventDefault();
        
        if(fphoto.length == 0) {
            alert("사진을 먼저 업로드 해주세요");
            return;
        }
        // 하고싶은말
        const fcontent = contentRef.current.value;
        // 서버에 보내기
        Axios.post("/react/insert", {fname, fhp, fcontent, bookingday})
            .then(res=> {
                // 목록 페이지로 이동
                navi("/food/list");
            })
    }

    const onUpdateEvent=(e)=> {
        // 기본 이벤트 무효화(action 호출 막기 위함)
        e.preventDefault();

        if(fphoto.length == 0) {
            alert("사진을 먼저 업로드 해주세요");
            return;
        }
        // 하고싶은말
        const fcontent = contentRef.current.value;
        // 서버에 보내기
        Axios.post("/react/formtoupdate", {num, fname, fhp, fphoto, fcontent, bookingday})
            .then(res=> {
                // 목록 페이지로 이동
                navi("/food/list");
            })
    }


    return (
        <div className="foodcontainer">
            <button type="button" className="btn btn-outline-danger"
                    onClick={() => navi("/food/list")}>예약목록</button>
            <hr/>
            <img className="App-logo" src={joo}/>
            <input type="file" style={{display: "none"}} id="file" multiple onChange={fileUploadEvent}/>
            <CameraAltOutlined style={{fontSize: "30px",cursor: "pointer"}}
            onClick={() => document.getElementById("file").click()}/>
            
            <h5>업로드한 사진 미리보기</h5>
            <div>
                {fphoto.map((photo, idx) => <img key={idx} alt="" src={`${photourl1}${photo}${photourl2}`}
                    style={{border: "2px solid pink", borderRadius: "30px", marginRight: "10px"}}/>)}
            </div>
            <h5>예약에 필요한 나머지 정보 입력</h5>
            <form onSubmit={num == null ? onSubmitEvent : onUpdateEvent}>
                <table className="table" style={{width: "400px"}}>
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
                            <button type="submit" className="btn btn-outline-danger">DB저장</button>
                            <button type="reset" className="btn btn-outline-danger"
                            style={{marginLeft: "10px"}}>초기화</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    );
}

export default FoodForm;