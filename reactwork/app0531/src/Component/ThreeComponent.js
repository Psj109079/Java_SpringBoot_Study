import React, {useState} from 'react';
import ThreeSubApp from "./ThreeSubApp";

function ThreeComponent(props) {
    const [data, setData] = useState({
        photo: "killerjo2.jpg",
        photoName: "취미"
    });

    const changeData = (photo, photoName) => {
        setData({photo: photo, photoName: photoName});
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>Three Component</h5>
            <ThreeSubApp dataChange={changeData}/>
            <hr/>
            <h3><b>{data.photoName}</b></h3>
            <br/><br/>
            <img alt="" src={require(`../image/${data.photo}`)} style={{maxWidth: "300px"}}/>
        </div>
    );
}

export default ThreeComponent;