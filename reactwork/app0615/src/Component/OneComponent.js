import React, {useRef, useState} from 'react';
import cate from "../data/CateData.json";
import "../App.css";
function OneComponent(props) {
    const navData = cate.navData;
    const cateData = cate.categoryData;

    const mainRefImage = useRef(null);
    return (
        <div>
            <h2 className="alert alert-danger">One Component-CateDate.json 출력</h2>

            <div className="nav_container">
                <ul className="nav_category">
                    {
                        navData.map((nav, idx) =>
                            <li>
                                {/*<div>*/}
                                {/*    <img alt="" src={nav.img} className="imgcategory"/>*/}
                                {/*</div>*/}
                                {/*<div>*/}
                                {/*    {nav.title}*/}
                                {/*"</div>*/}
                                <figure>
                                    <img alt="" src={nav.img} className="imgcategory" onClick={(e) => {
                                        mainRefImage.current.src = e.target.src;
                                    }}/>
                                    <figcaption style={{textAlign:"center"}}>
                                        <b>{nav.title}</b>
                                    </figcaption>
                                </figure>
                            </li>
                        )
                    }
                </ul>
            </div>

            <div className="nav_container">
                <ul className="nav_category">
                    {
                        cateData.map((nav, idx)=>
                            <li>
                                <figure>
                                    <img alt="" src={nav.img} className="imgcategory" onClick={(e) => {
                                        mainRefImage.current.src = e.target.src;
                                    }}/>
                                    <figcaption style={{textAlign:"center"}}>
                                        <b>{nav.title}</b>
                                    </figcaption>
                                </figure>
                            </li>
                        )
                    }
                </ul>
            </div>

            <div>
                <img alt="" src="../logo192.png" className="App-logo" style={{position:"absolute", left: "1000px", top:"300px"}} ref={mainRefImage}/>
            </div>
        </div>
    );
}

export default OneComponent;