import React, {useState} from 'react';
import img from "../image/jjenergy.png";

function ThreeComponent(props) {
    const [name, setName] = useState("");
    const [score, setScore] = useState(0);
    const [grade, setGrade] = useState("");
    const [tcolor, setTcolor] = useState("green");
    const [show, setShow] = useState(true);
    // radio 클릭 이벤트
    const radioChangeColor = (e) => {
        setTcolor(e.target.value);
    }

    // 이름 변경시 바로 적용
    const changeName = (e) => {
        setName(e.target.value);
    }

    // 점수 입력시 바로 적용 - 숫자가 아닐경우 경고 후 종료
    const changeScore = (e) => {
        if(isNaN(e.target.value)) {
            alert("숫자만 입력해주세요");
            return;
        }
        setScore(Number(e.target.value));
    }

    // 등급 계산
    const calcGrade = () => {
        if(score >= 90) {
            setGrade("훌륭합니다");
        } else if(score >= 80) {
            setGrade("짝꿍에게 물어보세요");
        } else {
            setGrade("재설치");
        }
    }
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Three Component 실습
            </h5>
            <h6>글자색을 선택하세요</h6>
            <div>
                <label>
                    <input type="radio" name="tcolor" defaultValue={"red"}
                    onClick={radioChangeColor}/>빨강색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="tcolor" defaultValue={"green"}
                           onClick={radioChangeColor}/>초록색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="tcolor" defaultValue={"magenta"}
                           onClick={radioChangeColor}/>핑크색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="tcolor" defaultValue={"black"}
                           onClick={radioChangeColor}/>검정색
                </label>
            </div>
            <div className="input-group" style={{marginTop: "30px", fontSize: "20px", width: "300px"}}>
                <b>이 름 : </b>
                <input type="text" className="form-control" onChange={changeName}/>
                &nbsp;&nbsp;
                <b>점 수 : </b>
                <input type="text" className="form-control" onChange={changeScore}/>
                &nbsp;&nbsp;
                <button type="button" className="btn btn-outline-danger btn-sm" onClick={calcGrade}>등급 계산</button>
            </div>
            <div style={{marginTop: "30px", fontSize: "20px", width: "300px", color: tcolor}}>
                이 름 : {name}<br/>
                점 수 : {score}점<br/>
                등 급 : {grade}<br/>
            </div>

            <h5>사진 보였다/ 숨겼다 하기</h5>
            <label>
                <input type="checkbox" defaultChecked onClick={(e) => {
                    setShow(e.target.checked); // ture/false
                }}/>&nbsp; 사진 보이게 하기
            </label>
            <br/><br/>
            {
                show &&
                <img alt="" src={img}/>
            }
        </div>
    );
}

export default ThreeComponent;