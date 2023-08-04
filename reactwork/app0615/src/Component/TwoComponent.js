import React, {useState} from 'react';
import pd from "../data/PostingData.json";

function TwoComponent(props) {
    let deal = pd.deal
    return (
        <div>
            <h2 className="alert alert-danger">Two Component 실습</h2>
            <div>
                {
                    deal.map((d, idx)=>
                        <div style={{width: "300px", marginBottom: "50px"}} className="App-log">
                            <img alt="" src={d.img} style={{width: "300px", marginBottom: "5px"}}/>
                            <span style={{display: "block", color: "#cccccc", fontSize: "12px", marginBottom: "5px"}}>{d.company}</span>
                            <span style={{display: "block", overflow: "hidden"}}>{d.title}</span>
                            <span style={{display: "block", fontSize: "25px"}}><b style={{color: "skyblue"}}>{d.sale}</b>{d.price}</span>
                        </div>

                    )
                }
            </div>

        </div>
    );
}

export default TwoComponent;