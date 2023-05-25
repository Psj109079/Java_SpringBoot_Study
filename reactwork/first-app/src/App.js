import logo from './image/OIP.jpg';
import img1 from './image/다운로드4 (1).jpg';
import img2 from "./image/567.jpg";
import img4 from "./image/KakaoTalk_20230525_174609223.jpg";
import img5 from "./image/imagejj.png";

import './App.css';
import './mystyle.css';
import {FirstCmp} from "./firstCmp";
import SecondCmp from "./secondCmp";
import ThirdCmp from "./ThirdCmp";
import FourthCmp from "./FourthCmp";
import FifthCmp from "./FifthCmp";
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useEffect, useState} from "react";



function App() {
    const [idx, setIdx] = useState(Number("1"));
    const [xy, setXY] = useState({x: 0, y: 0});
    const handleMouseMove = (e) => {
        setXY({x: e.clientX, y: e.clientY});
    }

    const [y, setY] = useState(0);
    const scrollImgMove = () => {
        setY(window.scrollY || document.documentElement.scrollTop);
    }

    // let spirited = new Audio("./image/sound.mp3");

    // const start = () => {
    //     spirited.play();
    // }

    const [energy, setEnergy] = useState(false);
    const energyon = () => {
        setEnergy(true);
    }
    const energyout = () => {
        setEnergy(false);
    }

    useEffect(() => {
        window.addEventListener("scroll", scrollImgMove);
    }, []);


     return (
        <div className="App" className="cursor" onMouseMove={(e) => handleMouseMove(e)}>
            {xy.x}&nbsp;{y}
            <img src={img5} style={{position: "absolute", left: Number(xy.x - 108), top: Number(y + xy.y - 37), zIndex: 9999}} className="App-logo2" alt="jj"/>
            <img src={logo} style={{position: "absolute", left: Number(xy.x - 69), top: Number(y + xy.y - 75),  zIndex: 9999}} className={energy ? "energyin" : "energyout"} alt="energy"/>
            <br/><br/><br/>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">abcde</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value = {idx}
                    label="abcde"
                    onChange={(e) => {
                        setIdx(Number(e.target.value));
                    }}
                    onMouseOver = {() => energyon()}
                    onMouseOut = {() => energyout()}
                >
                    <MenuItem value="1" onClick = {() => energyout()}>1</MenuItem>
                    <MenuItem value="2" onClick = {() => energyout()}>2</MenuItem>
                    <MenuItem value="3" onClick = {() => energyout()}>3</MenuItem>
                    <MenuItem value="4" onClick = {() => energyout()}>4</MenuItem>
                    <MenuItem value="5" onClick = {() => energyout()}>5</MenuItem>
                </Select>
            </FormControl>
            <img src={img1} className="photo1" alt="logo" />
            <img src={logo} className="App-logo4" alt="logo" />
            <img src={img2 } className="" alt="logo" />
            {/*{y}*/}
            {energy}
            {idx === 1 ? <FirstCmp/> : idx === 2 ? <secondCmp/> : idx === 3 ? <ThirdCmp/> : idx === 4 ? <FourthCmp/> : <FifthCmp/> }
            <img src={img4 } className="App-logo6" alt="logo" />
        </div>
    );
}

export default App;
