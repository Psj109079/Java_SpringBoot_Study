import React,{Component} from "react";
import img1 from './logo.svg';
import img3 from "./image/OIP.jpg";
import './App.css';
import './mystyle.css';

class FirstCmp extends Component {
    // constructor(props) {
    //     console.log("FirstCmp 생성자 호출");
    // }

    render() {
        return (
            <div>
                <h2 className="title" style={{color:'green',border:"180px solid orange", backgroundColor:"pink"}}>React 첫 컴포넌트</h2>
                <h6 >src의 이미지 나타내기</h6>
                <img src={img1} className="App-logo" style={{width: "200px;"}} alt="이미지"/>
                {/*<img src={img3} className="App-logo" style={{width: "200px;"}} alt="이미지"/>*/}

                {/* public 의 이미지는 상대주소로..... */}
                <h6>public의 이미지 나타내기</h6>
                <img alt="이미지" className="bounce" src="12345.jpg"/>
            </div>
        );
    }
}

// default 로 export 할 경우 import 시에 이름을 마음대로 정할 수 있다
// export default 는 파일 내에서 한번만 가능하다
// export default FirstCmp;
export {FirstCmp};