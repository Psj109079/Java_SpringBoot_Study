import React, {useContext} from 'react';
import "./App.css";
import {ThemeContext} from "./context/ThemeContext";
import {UserContext} from "./UserContext";

// function Content({isDark}) {
//     return (
//         <div className="content" style={{backgroundColor: isDark? "black" : "white"}}>
//             <p>비트캠프님! 즐거운 하루되세요!!!</p>
//
//         </div>
//     );
// }

function Content() {
    const {isDark} = useContext(ThemeContext);
    const text = useContext(UserContext); // 변수로 넣어놓은 값이 아니라서 중괄호 넣으면 값이 나오지 않음
    return (
        <div className="content" style={{backgroundColor: isDark? "black" : "white"}}>
            <p>{text}님! 즐거운 하루되세요!!!</p>

        </div>
    );
}

export default Content;