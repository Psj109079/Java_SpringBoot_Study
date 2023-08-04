import React from 'react';
import burn from "../image/burn.gif";

function HomeSub2(props) {
    return (
        <div style={{width: "200px", height: "200px", border: "1px solid black", textAlign: "center", lineHeight:"198px"}}>
            <h2>Home Sub2페이지</h2>
            <img src={burn}/>
        </div>

    );
}

export default HomeSub2;