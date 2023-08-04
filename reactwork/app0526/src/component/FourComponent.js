import React, {useState} from 'react';
import img from "../image/imagejj.png";
import img1 from "../image/imagejj.png";
import img2 from "../image/imagejj.png";
import img3 from "../image/imagejj.png";
import img4 from "../image/imagejj.png";
function FourComponent(props) {
    const [fSize, setFsize] = useState("15px");
    const [divText, setDivText] = useState("");
    const [bColor, setBcolor] = useState("red");
    const [showImg, setShowImg] = useState(false);
    const [Img, setImg] = useState(img);


    const changeFsize = (e) => {
        setFsize(e.target.value);
    }

    const writeText = (e) => {
        setDivText(e.target.value);
    }

    const divBColor = (e) => {
        setBcolor(e.target.value);
    }

    // 이벤트3 : 자동차 이미지 변경
    const onChangeImg = (e) => {
        setImg(e.target.value);
    }
    const showImgChk = (e) => {
        setShowImg(e.target.checked);
    }


    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Four Component 실습
            </h5>
            {fSize}
            <span>글자크기:
                <select onChange={changeFsize}>
                    <option value="5px">5px</option>
                    <option value="10px">10px</option>
                    <option value="15px" selected>15px</option>
                    <option value="20px">20px</option>
                    <option value="25px">25px</option>
                </select>
            </span>
            <br/>
            <input type="text" placeholder="텍스트" onKeyUp={writeText}/>
            <br/>
            <label><input type="radio" name="bcolor" value="red" defaultValue="red" onClick={divBColor}/>빨강</label>
            <label><input type="radio" name="bcolor" defaultValue="orange" onClick={divBColor}/>주황</label>
            <label><input type="radio" name="bcolor" defaultValue="yellow" onClick={divBColor}/>노랑</label>
            <label><input type="radio" name="bcolor" defaultValue="green" onClick={divBColor}/>초록</label>
            <label><input type="radio" name="bcolor" defaultValue="blue" onClick={divBColor}/>파랑</label>
            <br/>
            <div className="input-group">
                <b>사진 선택</b>
                &nbsp;&nbsp;
                <select className="form-select" onChange={onChangeImg}>
                    <option value={img}>img</option>
                    <option value={img1} selected>img1</option>
                    <option value={img2}>img2</option>
                    <option value={img3}>img3</option>
                    <option value={img4}>img4</option>
                </select>
            </div>
            <br/>
            <label><input type="checkbox" onClick={showImgChk} />사진 숨기기</label>
            <div style={{width: "1000px", height: "500px", fontSize: fSize, backgroundColor: bColor}}>
                <span>{divText}</span>
                {!showImg && <img alt="jj" src={Img}/>}
            </div>
        </div>
    );
}

export default FourComponent;