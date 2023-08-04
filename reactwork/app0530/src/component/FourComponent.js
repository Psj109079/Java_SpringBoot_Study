import React, {useRef, useState} from 'react';

function FourComponent(props) {
    const [content, setContent] = useState();
    const [content2, setContent2] = useState();

    const contentRef = useRef(); // ref변수선언

    console.log("랜더링중...");
    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>
                Four Component-useRef
            </h5>
            <textarea style={{width: "300px", height: "100px"}}
            onChange = {(e) => {
                // 글자 하나 입력할떄만다 랜더링 발생
              setContent(e.target.value);
            }}></textarea>
            <h4 className="alert alert-danger">{content}</h4>
            <textarea style={{width: "300px", height: "100px"}} ref={contentRef}></textarea>
            <button type="button" onClick={() => {
                // 입력 도중 버튼을 누르면 content2 에 값이 들어가면서  렌더링 발생
              setContent2(contentRef.current.value);
            }}>ref content 적용</button>
            <h4 className="alert alert-danger">{content2}</h4>
        </div>
    );
}

export default FourComponent;