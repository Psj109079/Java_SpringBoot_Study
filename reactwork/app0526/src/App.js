import logo from './image/jjenergy.png';
import img from './image/nohead.png';
import img2 from './image/noheadreplact.png';
import img3 from './image/noheadbuttom.png';
import img4 from './image/noheadtop.png';
import './App.css';
import {useEffect, useState} from "react";
import OneComponent from "./component/OneComponent";
import TwoComponent from "./component/TwoComponent";
import ThreeComponent from "./component/ThreeComponent";
import FourComponent from "./component/FourComponent";
import FiveComponent from "./component/FiveComponent";
import SixComponent from "./component/SixComponent";
import SevenComponent from "./component/SevenComponent";
import ExComponent from "./component/ExComponent";

function App() {
    const [idx, setIdx] = useState(1);
    const [xy, setXY] = useState({x: 0, y: 0});
    const handleMouseMove = (e) => {
        setXY({x: e.clientX, y: e.clientY});
    }
    const [y, setY] = useState(0);
    const scrollImgMove = () => {
        setY(window.scrollY || document.documentElement.scrollTop);
    }
    // select 이벤트
    const changeComponent = (e) => {
        // alert(e.target.value + typeof(e.target.value));
        
        // setter 함수가 호출될때마다 자동 랜더링
        setIdx(Number(e.target.value));
    }

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
    <div className="App" style={{cursor: "none"}}  onMouseMove={(e) => handleMouseMove(e)}>
       <br/><br/><br/><br/><br/>
        <div>
            <img src={img} style={{position: "absolute", left: xy.x - 60, top:Number(y + xy.y - 168), zIndex: 9999}} className="App-logo " alt="jj"/>
            <img src={img2} style={{position: "absolute", left: xy.x - 495, top:Number(y + xy.y - 168), zIndex: 9999}} className="App-logo " alt="jj"/>
            <img src={img3} style={{position: "absolute", left: xy.x - 115, top:Number(y + xy.y - 40), zIndex: 9999}} className="App-logo " alt="jj"/>
            <img src={img4} style={{position: "absolute", left: xy.x - 140, top:Number(y + xy.y - 338), zIndex: 9999}} className="App-logo " alt="jj"/>
        </div>


        <img src={logo} style={{position: "absolute", left: Number(xy.x - 73), top: Number(y + xy.y - 73), display: energy ? "inline" : "none" , zIndex: 9999}} className={energy ? "energyin" : "energyout"} alt="energy"/>
      <h2>2023-05-26 리액트 수업</h2>
      <select className="form-select" style={{width: "200px", marginLeft: "100px"}}
      onChange={changeComponent} onMouseOver = {() => energyon()} onMouseOut = {() => energyout()}>
        <option value={1} >One Component</option>
        <option value={2} >Two Component</option>
        <option value={3} >Three Component</option>
        <option value={4} >Four Component</option>
        <option value={5} >Five Component</option>
        <option value={6} >Six Component</option>
        <option value={7} >Seven Component</option>
        <option value={8} >Ex Component</option>
      </select>

        {idx}
        <br/><br/>
        {idx === 1 ? <OneComponent/> : idx === 2 ? <TwoComponent/> : idx === 3 ? <ThreeComponent/> : idx === 4 ? <FourComponent/> : idx ===5 ? <FiveComponent/> : idx === 6 ? <SixComponent/> : idx === 7 ? <SevenComponent/> : <ExComponent/>}
    </div>
  );
}

export default App;
