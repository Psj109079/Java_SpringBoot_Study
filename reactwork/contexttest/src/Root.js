import React, {useState} from 'react';
import "./App.css";
import Page from "./Page";
import {ThemeContext} from "./context/ThemeContext";
import {UserContext} from "./UserContext";

function Root(props) {
    const [isDark, setIsDark] = useState(false);
    return (
        // <div>
        //     {/* Page는  실제 isDark 변수를 사용하지 않음, 단지 서브 컴포넌트로 전달하기 전달하기해서 사용하기 위해서* props로 보냄 */}
        //     <Page isDark={isDark} setIsDark={setIsDark}/>
        // </div>
        <UserContext.Provider value={'네이버클라우드'}>
            <ThemeContext.Provider value={{isDark, setIsDark}}>
                <Page/>
            </ThemeContext.Provider>
        </UserContext.Provider>
    );
}

export default Root;