import React from 'react';
import "../App.css";
import {Delete, DeleteForever} from "@mui/icons-material";
import Swal from "sweetalert2";

function OneArrayList(props) {
    const {idx, row, onDelete} = props;

    return (
        <div className="rowstyle">
            <b>{row.irum}</b>
            <span className="day">
                {row.today.toLocaleString("ko-KR")}&nbsp;<Delete style={{cursor: "pointer"}} onClick={() => {onDelete(idx)}}/>
                <DeleteForever style={{cursor: "pointer"}} onClick={() => {
                    Swal.fire({
                        // title: "삭제 확인",
                        // text: "해당 방명록 글을 삭제할까요?",
                        html: "삭제확인<br/>해당 방명록을 삭제할까요?<br/>삭제하려면 [예] 클릭!!",
                        icon: "warning",
                        confirmButtonColor: "#3085d6",
                        confirmButtonText: "예",
                        showCancelButton: true,
                        cancelButtonColor: "#cccccc",
                        cancelButtonText: "취소"
                    }).then((result) => {
                        if (result.isConfirmed) {
                            // 삭제 gkatn ghcnf
                            onDelete(idx);
                            Swal.fire("삭제했습니다");
                        } else {
                            Swal.fire("취소했습니다");
                        }
                    })
                }}/>
            </span>
            <br/><br/>
            <h5><b>{row.message}</b></h5>
        </div>
    );
}

export default OneArrayList;