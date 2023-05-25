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
import {useState} from "react";



function App() {
    const [idx, setIdx] = useState(Number("1"));
    const [xy, setXY] = useState({x: 0, y: 0});
    const handleMouseMove = (e) => {
        setXY({x: Number(e.clientX - 138), y: e.clientY - 48});
    }
     return (
        <div className="App" style={{cursor: "none"}} onMouseMove={(e) => handleMouseMove(e)}>
            {xy.x}
            <img src={img5} style={{position: "absolute", left: xy.x, top:xy.y}} className="App-logo2" alt="jj"/>
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
                >
                    <MenuItem value="1">1</MenuItem>
                    <MenuItem value="2">2</MenuItem>
                    <MenuItem value="3">3</MenuItem>
                    <MenuItem value="4">4</MenuItem>
                    <MenuItem value="5">5</MenuItem>
                </Select>
            </FormControl>
            <img src={img1} className="photo1" alt="logo" />
            <img src={logo} className="App-logo4" alt="logo" />
            <img src={img2 } className="" alt="logo" />
            {idx === 1 ? <FirstCmp/> : idx === 2 ? <secondCmp/> : idx === 3 ? <ThirdCmp/> : idx === 4 ? <FourthCmp/> : <FifthCmp/> }
            <img src={img4 } className="App-logo6" alt="logo" />
        </div>
    );
}

export default App;
