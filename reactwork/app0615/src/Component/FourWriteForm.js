import React, {useState} from 'react';
import Axios from "axios";
function FourWriteForm({getList}) {
    const [data, setData] = useState({
        num: 0, irum: "noname", address: "no address", birthday: "no birth"
    });

    const [photo, setPhoto] = useState("");

    // const photoUrl = "https://kr.object.ncloudstorage.com/bit701-bucket-106/react/";
    // .env 에 등록한 전역변수 사용하는 방법(앞에 process.env)
    // .env 수정시 npm 재시작
    const photoUrl = process.env.REACT_APP_PHOTOURL;

    // 저장버튼 이벤트
    const saveButtonEvenet = () => {
        let url="/info/insert";
        Axios.post(url,data)
            .then(res=> {
                setData(res.data);
                // 목록 다시 출력
                getList();
            });
    }
    const changePhotoEvent = (e) => {
        let url="/info/photo";
        const imageFile = new FormData();
        imageFile.append("upload", e.target.files[0]);
        imageFile.append("num", data.num);
        console.log(imageFile);
        Axios({
            method: "post",
            url: url,
            data: imageFile,
            headers:{"Content-Type": "multipart/form-data"}
        }).then(res => {
            setPhoto(res.data)
            // 목록 다시 출력
            getList();
        });
    }
    return (
        <div>
            <h4>Info 데이터 입력</h4>
            <div className="input-group" style={{width: "600px"}}>
                <b>이름</b>
                <input type="text" className="form-control" value={data.irum} onChange={(e) => {
                    setData({
                        ...data,
                        irum: e.target.value
                    })
                }}/>&nbsp;&nbsp;
                <b>주소</b>&nbsp;
                <input type="text" className="form-control" value={data.address} onChange={(e) => {
                    setData({
                        ...data,
                        address: e.target.value
                    })
                }}/>&nbsp;&nbsp;
                <b>생년월일</b>&nbsp;
                <input type="date" className="form-control" value={data.birthday} onChange={(e) => {
                    setData({
                        ...data,
                        birthday: e.target.value
                    })
                }}/>&nbsp;&nbsp;
                <button type="button" className="btn btn-sm btn-outline-info" onClick={saveButtonEvenet}>저장</button>
                <h3 className="alert alert-danger">
                    값 확인: {data.num}/{data.irum}/{data.address}/{data.birthday}
                </h3>
                <h4>사진은 데이터를 먼저 저장 후 변경해주세요</h4>
                <input type="file" onChange={changePhotoEvent}/>
                <img alt="" style={{width: "300px", border: "2px solid gray"}} src={photoUrl + photo} align="left"/>

                <button type="button" className="btn btn-danger" style={{width: "100px", height:"100px"}}
                    onClick={()=> {
                        setPhoto("");
                        setData({num: 0, irum:"", address: "", birthday: ""});
                }}>초기화</button>
            </div>
        </div>
    );
}

export default FourWriteForm;