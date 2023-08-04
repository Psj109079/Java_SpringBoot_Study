import React, {useContext} from 'react';
import "./App.css";
import {ThemeContext} from "./context/ThemeContext";
import {UserContext} from "./UserContext";

// function Header({isDark}) {
//     return (
//         <header className="header" style={{backgroundColor: isDark ? "black" : "lightgray" }}>
//             <h1>Welcome 비트캠프!</h1>
//         </header>
//     );
// }
function Header() {
    const {isDark} = useContext(ThemeContext);
    const text = useContext(UserContext); // 변수로 넣어놓은 값이 아니라서 중괄호 넣으면 값이 나오지 않음
    return (
        <header className="header" style={{backgroundColor: isDark ? "black" : "lightgray" }}>
            <h1>Welcome {text}</h1>
        </header>
    );
}

export default Header;