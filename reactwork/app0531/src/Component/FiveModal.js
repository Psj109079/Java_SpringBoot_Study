import React, {useEffect, useRef, useState} from 'react';
import "../modal.css";
function FiveModal(props) {

    // 모달 외부 클릭시 끄기 처리
    // Modal 창을 useRef로 취득
    const modalRef = useRef(null);

    useEffect(() => {
        // 이벤트 핸들러 함수
        const handler = (e) => {
            // mousedown 이벤트가 발생한 영역이 모달창이 아닐 때, 모달창 제거 처리
            if (modalRef.current && !modalRef.current.contains(e.target)) {
                props.modalClose();
            }
        };

        // 이벤트 핸들러 등록
        document.addEventListener('mousedown', handler);
        // document.addEventListener('touchstart', handler); // 모바일 대응

        return () => {
            // 이벤트 핸들러 해제
            document.removeEventListener('mousedown', handler);
            // document.removeEventListener('touchstart', handler); // 모바일 대응
        };
    });

    return (
        // 모달창을 useRef로 잡아준다.
        <div ref={modalRef} className="container">
            모달
            <button className="close" type="button" onClick={props.modalClose}>close</button>
        </div>
    );
}

export default FiveModal;