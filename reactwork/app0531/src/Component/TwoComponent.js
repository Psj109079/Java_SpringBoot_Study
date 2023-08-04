import React from 'react';
import {Button} from "@mui/material";
import Swal from "sweetalert2";
import image from "../image/killer.jpg";
import image2 from "../image/steal.jpg";
import image3 from "../image/killerjo2.jpg";
import image4 from "../image/killer2.jpg";
function TwoComponent(props) {
    const buttonEvent1 = () => {
        // Swal.fire("안녕하세요");
        Swal.fire("아침", "안녕하세요");
    }
    const buttonEvent2 = () => {
        Swal.fire({
            title: "사진넣기",
            html: "<h5>갖고싶은 자동차!!</h5>",
            imageUrl: image2,
            imageWidth: 200,
            imageHeight: 250

        })
    }
    const buttonEvent3 = () => {
        Swal.fire({
            html: `<b style="color:red">오늘 점심은 짜파게티!!!</b>
                   <h5>Merry Christmas!!!!</h5>`,
            imageUrl: "../logo192.png", /* public 의 사진 가져오는 방법*/
            icon: "success",
            confirmButtonText: "Yes!!!",
            confirmButtonColor: "#abcabc",
            showCancelButton: true,
            cancelButtonText: "No!!!",
        }).then((r) => {
            if(r.isConfirmed) {
                Swal.fire("성공");
            } else {
                Swal.fire("ㅋㅋ");

            }
        })
    }
    const buttonEvent4 = () => {
        Swal.fire({
            title: "Input Email Address",
            input: "email",
            inputLabel: "Your email Address",
            inputPlaceholder: "Enter your email address!"
        }).then((result) => {
            Swal.fire(`당신의 이메일 주소는 ${result.value} 입니다`);
        })
    }
    const buttonEvent5 = () => {
        let arr = [
            {photo:image, likesid: "angel"},
            {photo:image2, likesid: "Jo"},
            {photo:image3, likesid: "조"}];

        let s = "";
        for(let m of arr) {
            s += `<img alt="" src=${m.photo} width=60/>&nbsp;<b>${m.likesid}</b><br/>`
        }

        Swal.fire({
            title: "좋아요 누른 회원들",
            imageUrl: image4,
            html: s
        })
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>Two Component-SweetAlert</h5>
            <Button variant="contained" color="warning" onClick={buttonEvent1}>SweetAlert연습 #1</Button>
            <br/><br/>
            <Button variant="outlined" color="error" onClick={buttonEvent2}>SweetAlert연습 #2</Button>
            <br/><br/>
            <Button variant="contained" color="success" onClick={buttonEvent3}>SweetAlert연습 #3</Button>
            <br/><br/>
            <Button variant="outlined" color="primary" onClick={buttonEvent4}>SweetAlert연습 #4</Button>
            <br/><br/>
            <Button variant="contained" color="info" onClick={buttonEvent5}>SweetAlert연습 #5</Button>
        </div>
    );
}

export default TwoComponent;