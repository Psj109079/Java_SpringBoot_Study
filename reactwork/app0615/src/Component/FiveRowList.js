import React from 'react';
import "../App.css";
import {DeleteForeverRounded} from "@mui/icons-material";
function FiveRowList({memo, onDelete}) {
    return (
        <div className="memolist">
            <div>
                닉네임: {memo.nickname}
                <span style={{float: "right", color: "gray", fontSize: "0.8em"}}>작성일: {memo.writeday}</span>
            </div>
            <b>{memo.kormsg}</b>
            <br/>
            <b style={{color:"orange"}}>{memo.engmsg}</b>
            <br/>
            <DeleteForeverRounded style={{marginLeft: "450px", color: "red", cursor: "pointer"}}
            onClick = {() => {
              let b = window.confirm("삭제하려면 [확인]을 눌러주세요");
              if(!b) {
                  return;
              }
              onDelete(memo.num);
            }}
            />
        </div>
    );
}

export default FiveRowList;