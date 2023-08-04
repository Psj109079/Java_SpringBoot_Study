import React, {useContext} from 'react';
import "./App.css";
import {ThemeContext} from "./context/ThemeContext";

// function Footer({isDark, setIsDark}) {
//     const toggleButton = () => {
//         console.log("click" + isDark);
//         setIsDark(!isDark);
//     }
//     return (
//         <footer className="footer" style={{backgroundColor: isDark? "black" : "lightgray"}}>
//             <button type="button" className="button" onClick={toggleButton}>Dark Mode</button>
//
//         </footer>
//     );
// }

function Footer() {
    const {isDark, setIsDark} = useContext(ThemeContext);
    const toggleButton = () => {
        console.log("click: " + isDark);
        setIsDark(!isDark);
    }
    return (
        <footer className="footer" style={{backgroundColor: isDark? "black" : "lightgray"}}>
            <button type="button" className="button" onClick={toggleButton}>Dark Mode</button>
        </footer>
    );
}

export default Footer;