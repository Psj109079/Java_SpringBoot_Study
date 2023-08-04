import React from 'react';
import {useParams} from "react-router-dom";
import sorry from "../image/sorry.gif";
import nosorry from "../image/nosorry.gif";
import sorry2 from "../image/ksorry.gif";
import verysorry from "../image/sorryfast.gif";

function About(props) {
    // emp 파라미터 읽기
    const {emp} = useParams();
    
    return (
        <div>
            <h3 className="alert alert-info">About Page입니다</h3>
            {
                emp == null?<div><img src={nosorry}/><h3>저는 안죄송합니다</h3></div>
                    : emp == "죄송" ? <div><img src={sorry}/><h4>저는 {emp}합니다</h4></div>
                    :emp == "많이죄송"? <div><img src={verysorry}/><h4>저는 {emp}합니다</h4></div> : <div><img src={sorry2}/><h4>저는 {emp}합니다</h4></div>
            }

        </div>
    );
}

export default About;