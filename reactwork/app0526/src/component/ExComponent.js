import React, {useState} from 'react';
import img1 from "../image/imagejj.png";
import img2 from "../image/nohead.png";
import img3 from "../image/noheadreplact.png";
import img4 from "../image/noheadtop.png";
import img5 from "../image/noheadbuttom.png";
function ExComponent(props) {
    const [imgOn, setImgOn] = useState(false);
    const [textBox, setTextBox] = useState();
    const [imgSelect, setImgSelect] = useState(img1);
    const [borderSelect, setBorderSelect] = useState("solid");
    const [imgSize, setImgSize] = useState(300);
    const imgShow = (e) => {
        setImgOn(e.target.checked);
    }
    const smaller = () => {
        setImgSize(imgSize - 10);
    }

    const bigger = () => {
        setImgSize(imgSize + 10);
    }

    const imgChange = (e) => {
        setImgSelect(e.target.value);
    }

    const borderChange = (e) => {
        setBorderSelect(e.target.value);
    }

    const inputText = (e) => {
        setTextBox(e.target.value);
    }

    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                ExCompent 연습
            </h5>
            {imgSize}
            <h1>{textBox}</h1>
                <div>
                    <label><input type="checkbox" onClick={imgShow}/>사진숨김</label>
                    <button type="button" onClick={smaller}>점점 작게</button>
                    <button type="button" onClick={bigger}>점점 크게</button>
                </div>
                <input type="text" placeholder="텍스트" onKeyUp={inputText}/>
                <div>
                    <select onChange={imgChange}>
                        <option value={img1} selected>jj</option>
                        <option value={img2}>hswR</option>
                        <option value={img3}>hswL</option>
                        <option value={img4}>hswT</option>
                        <option value={img5}>hswB</option>
                    </select>
                    <select onChange={borderChange}>
                        <option selected>solid</option>
                        <option>dotted</option>
                        <option>dashed</option>
                        <option>groove</option>
                        <option>inset</option>
                    </select>
                </div>
                {
                    !imgOn && <img id="photo" alt="hero" style={{border: `5px ${borderSelect} blue`, height: imgSize}} src={imgSelect}/>
                }
        </div>
    );
}

export default ExComponent;