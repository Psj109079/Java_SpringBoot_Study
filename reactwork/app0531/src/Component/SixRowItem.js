import React from 'react';

function SixRowItem({ele}) {
    return (
        <div style={{marginBottom: "10px", width: "400px", height: "70px", border: "3px solid gray"}}>
            <b>이름 : {ele.irum}</b>
            <b style={{marginLeft: "10px"}}>혈액형 : {ele.blood}</b>
            <b style={{marginLeft: "10px"}}>핸드폰 : {ele.hp}</b>
            

        </div>
    );
}

export default SixRowItem;