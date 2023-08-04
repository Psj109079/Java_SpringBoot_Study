import logo from './logo.svg';
import './App.css';
import {useState} from "react";
import OneComponent from "./Component/OneComponent";
import TwoComponent from "./Component/TwoComponent";
import ThreeComponent from "./Component/ThreeComponent";
import FourComponent from "./Component/FourComponent";
import FiveComponent from "./Component/FiveComponent";
import SixComponent from "./Component/SixComponent";
import SevenComponent from "./Component/SevenComponent";
import EightComponent from "./Component/Eight Component";

function App() {
  const [idx, setIdx] = useState(1);

  // select 이벤트
  const changeComponent = (e) => {
    // alert(e.target.value + typeof(e.target.value));

    // setter 함수가 호출될때마다 자동 랜더링
    setIdx(Number(e.target.value));
  }

  return (
      <div className="App">

        <h2>2023-05-26 리액트 수업</h2>
        <select className="form-select" style={{width: "200px", marginLeft: "100px"}}
                onChange={changeComponent}>
          <option value={1} >One Component</option>
          <option value={2} >Two Component</option>
          <option value={3} >Three Component</option>
          <option value={4} >Four Component</option>
          <option value={5} >Five Component</option>
          <option value={6} >Six Component</option>
          <option value={7} >Seven Component</option>
          <option value={8} >Eight Component</option>
        </select>

        {idx}
        <br/><br/>
        {idx === 1 ? <OneComponent/> : idx === 2 ? <TwoComponent/> : idx === 3 ? <ThreeComponent/> : idx === 4 ? <FourComponent/> : idx === 5 ? <FiveComponent/> : idx === 6 ? <SixComponent/> : idx === 7 ? <SevenComponent/> : <EightComponent/>}
      </div>
  );
}

export default App;
