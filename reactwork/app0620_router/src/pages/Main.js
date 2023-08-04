import React from 'react';
import "../App.css";
import {useNavigate} from "react-router-dom";
function Main(props) {
    // 리액드에서 페이지 이동시 Navigate 이용해서 이동
    const navi = useNavigate();
    return (
        <div>
            <button type="button" className="mybtn" onClick={() => navi("/home")}>Home이동</button>
            <button type="button" className="mybtn" onClick={() => navi("/food")}>Food이동</button>
            <button type="button" className="mybtn" onClick={() => navi("/about")}>About이동</button>
            <button type="button" className="mybtn" onClick={() => navi("/food/3")}>Food2이동</button>
            <button type="button" className="mybtn" onClick={() => navi("/about/죄송")}>About2이동</button>
        </div>
    );
}

export default Main;