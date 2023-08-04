import React, {useState} from 'react';
import FiveWriteForm from "./FiveWriteForm";
import FiveRowList from "./FiveRowList";
import FiveModal from "./FiveModal";

function FiveComponent(props) {

    const [dataList, setDataList] = useState([
        {writer: "곽", subject: "안녕하세요",content: "반가워요", photo: "steal.jpg", today: new Date()},
        {writer: "조", subject: "Hello",content: "재밌네요", photo: "killer2.jpg", today: new Date()}
    ]);

    // 게시글 추가 이벤트
    const addBoard = (item) => {
        setDataList(dataList.concat({
            ...item,
            today: new Date()
        }));
    }

    // 모달창 노출 여부
    const [modalOpen, setModalOpen] = useState(false);

    // 모달 노출
    const showModal = () => {
        setModalOpen(true);
    };

    // 모달 끄기
    const closeModal = () => {
        setModalOpen(false);
    }

    return (
        <div>
            <h5 style={{border: "3px solid gray", backgroundColor: "#add8e6"}}>Five Component</h5>
            <FiveWriteForm addBoard={addBoard}/>
            <hr/>
            <table className="table table-bordered" style={{width: "700px",marginLeft: "50px"}}>
                <thead>
                    <tr style={{backgroundColor:"red"}}>
                        <th style={{width: "60px"}}>번호</th>
                        <th style={{width: "300px"}}>제목</th>
                        <th style={{width: "100px"}}>작성자</th>
                        <th style={{width: "100px"}}>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        dataList.map((item, idx) => (<FiveRowList key={idx} row={item} idx={idx} openModal={showModal}/>))
                    }
                </tbody>
            </table>
            {modalOpen && <FiveModal modalClose={closeModal}/>}

        </div>
    );
}

export default FiveComponent;

