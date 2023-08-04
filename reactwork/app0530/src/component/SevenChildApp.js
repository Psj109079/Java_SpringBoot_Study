import React, {useState} from 'react';

// 방법 1
// function SevenChildApp(props) {
//     return (
//         <div>
//             <h2 className="alert alert-dager"
//                 style={{border: "3px solid pink", fontFamily: "Jua", marginBottom: "10px"}}>
//                 내 이름은 {props.name + props.age} 세 랍니다
//                 <button type="button" className="btn btn-info btn-sm" onClick={props.onIncre}>증가</button>
//             </h2>
//
//
//         </div>
//     );
// }
// 방법 2
// function SevenChildApp(props) {
//     const {name, age, onIncre} = props;
//
//     return (
//         <div>
//             <h2 className="alert alert-dager"
//                 style={{border: "3px solid pink", fontFamily: "Jua", marginBottom: "10px"}}>
//                 내 이름은 {name + age} 세 랍니다
//                 <button type="button" className="btn btn-info btn-sm" onClick={onIncre}>증가</button>
//             </h2>
//         </div>
//     );
// }

// 방법 3
function SevenChildApp({name, age, onIncre}) {
    return (
        <div>
            <h2 className="alert alert-dager"
                style={{border: "3px solid pink", fontFamily: "Jua", marginBottom: "10px"}}>
                내 이름은 {name + age} 세 랍니다
                <button type="button" className="btn btn-info btn-sm" onClick={onIncre}>증가</button>
            </h2>
        </div>
    );
}

export default SevenChildApp;