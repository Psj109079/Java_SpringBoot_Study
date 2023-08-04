import React from 'react';
import HomeSub2 from "./HomeSub2";
import HomeSub1 from "./HomeSub1";
import HomeSub3 from "./HomeSub3";
import {NavLink, Routes, Route} from "react-router-dom";
import replacthair from "../image/replacthair2.jpg";
import joo from "../image/shinyhaed.png"

function Home(props) {
    return (
        <div>
            <h3 className="alert alert-info">Home Page입니다</h3>
            <img src={replacthair}/>
            <img className="App-logo" src={joo}/>
            <br/><br/><br/><br/>
            <NavLink to="/home/sub1">Sub1</NavLink>
            &nbsp;&nbsp;
            <NavLink to="/home/sub2">Sub2</NavLink>
            &nbsp;&nbsp;
            <NavLink to="/home/sub3">Sub3</NavLink>
            <br/><br/><br/>
            {/* 중첩 라우터 설정 -home 안에 sub1, sub2, sub3 설정*/}
            <Routes>
                <Route path="sub1" element={<HomeSub1/>}/>
                <Route path="sub2" element={<HomeSub2/>}/>
                <Route path="sub3" element={<HomeSub3/>}/>
            </Routes>
        </div>
    );
}

export default Home;