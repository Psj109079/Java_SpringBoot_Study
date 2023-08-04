import React, {useState} from 'react';

function ThreeSubApp(props) {


    const onSelectChange = (e) => {
        let photo = e.target.value;
        let photoName = e.target.options[e.target.selectedIndex].text;

        props.dataChange(photo,photoName);
    }
    return (
        <div style={{width: "200px"}}>
            <select className="form-select" onChange={onSelectChange}>
                <option value={"killer.jpg"}>조</option>
                <option value={"killer2.jpg"}>형</option>
                <option value={"killer3.jpg"}>기</option>
                <option value={"killerjo1.jpg"}>입</option>
                <option value={"killerjo2.jpg"}>니</option>
                <option value={"killerjo3.jpg"}>다</option>
            </select>
        </div>
    );
}

export default ThreeSubApp;