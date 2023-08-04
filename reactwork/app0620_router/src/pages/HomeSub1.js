import React from 'react';
import soccer from "../image/soccer.gif"
function HomeSub1(props) {
    return (
        <div style={{width: "200px", height: "200px", border: "1px solid black", textAlign: "center", lineHeight:"198px"}}>
            <h2>Home Sub1페이지</h2>
            <img src={soccer}/>
        </div>
    );
}

export default HomeSub1;