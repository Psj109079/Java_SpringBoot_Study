import React from 'react';
import rider from "../image/rider.gif";
function HomeSub3(props) {
    return (
        <div style={{
            width: "200px",
            height: "200px",
            border: "1px solid black",
            textAlign: "center",
            lineHeight: "198px"
        }}>
            <h2>Home Sub3페이지</h2>
            <img src={rider}/>
        </div>
    );
}

export default HomeSub3;