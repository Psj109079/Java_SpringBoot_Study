import React, {useContext} from 'react';
import "./App.css";
import Content from "./Content";
import Footer from "./Footer";
import Header from "./Header";

function Page() {
    // const data = useContext(ThemeContext);
    // console.dir(data);
    return (
        <div className="page">
            <Header/>
            <Content/>
            <Footer/>
        </div>
    );
}

export default Page;