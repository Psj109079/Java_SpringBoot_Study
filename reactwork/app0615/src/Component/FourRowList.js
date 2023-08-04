import * as React from 'react';
import "../App.css";
import noimg from "../bbororo.jpg"
import Button from '@mui/material/Button';
import Axios from "axios";
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

function FourRowList({item, getList}) {
    const [updateData, setUpdateData] = React.useState({
        num: item.num, irum:item.irum, address: item.address, birthday: item.birthday
    });
    const photoUrl = "https://kr.object.ncloudstorage.com/bit701-bucket-106/react/";
    const fileRef= React.useRef(null);

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };


    const handleUpdate = () => {
        setOpen(false);

        Axios.post("/info/update", updateData)
            .then(res => {
                // 수정 후 목록 다시 출력
                getList();
            })
    }

    //사진변경 버튼 이벤트
    const changePhotoEvent=(e)=>{

        let url="/info/photo";
        const imageFile=new FormData();
        imageFile.append("upload",e.target.files[0]);
        imageFile.append("num",item.num);

        Axios({
            method:'post',
            url:url,
            data:imageFile,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=>{
            //목록 다시 출력
            getList();
        });//반환된 버켓에 저장된 이름을 photo 에 넣는다
    }


    // 삭제
    const deleteInfo = () => {
        let c = window.confirm("삭제하시려면 [확인]을 눌러주세요");
        if(c) {
            let url = `/info/delete/${item.num}`;
            Axios.delete(url)
                .then(res => {
                    getList();
                })

        }
    }

    return (
        <div className="rowstyle">
            <img alt="" src={item.photo === null ? noimg : photoUrl + item.photo}/>
            <br/>
            이름: {item.irum}<br/>
            주소: {item.address}<br/>
            생년월일: {item.birthday}<br/>
            가입일: {item.birthday}<br/>

            <input type='file' onChange={changePhotoEvent} style={{display:'none'}} ref={fileRef}/>
            <div style={{textAlign: "center", marginTop: "10px"}}>
                <i className="bi bi-pencil-square" style={{fontSize: "25px", margin:"0 10px 0 10px"}} onClick={()=>{fileRef.current.click()}}></i>
                <i className="bi bi-trash" style={{fontSize: "25px", margin:"0 10px 0 10px"}} onClick={deleteInfo}></i>
                <i className="bi bi-pencil" style={{fontSize: "25px", margin:"0 10px 0 10px"}} onClick={handleClickOpen}></i>
            </div>
            {/* 수정 다이얼로그*/}
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    정보 수정
                </DialogTitle>
                <DialogContent>
                    <DialogContentText id="alert-dialog-description">
                        <input type="text" value={updateData.irum} onChange={(e) =>
                            setUpdateData({
                                ...updateData,
                                irum:e.target.value
                            })}/>

                        <input type="text" value={updateData.address} onChange={(e) =>
                            setUpdateData({
                                ...updateData,
                                address:e.target.value
                            })}/>
                        <br/>
                        <input type="text" value={updateData.birthday} onChange={(e) =>
                            setUpdateData({
                                ...updateData,
                                birthday:e.target.value
                            })}/>
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>취소</Button>
                    <Button onClick={handleUpdate} autoFocus>수정</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}

export default FourRowList;