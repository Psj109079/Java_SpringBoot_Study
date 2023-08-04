import React from 'react';
import food from "../image/replacthair2.jpg";
import {useParams} from "react-router-dom";

function Food(props) {
    const {food1} = useParams();
    const {food2} = useParams();
    return (
        <div>
            <h3 className="alert alert-info">Food Page입니다</h3>
            {
                food1 == null && food2 == null ? <div><img src={food}/><h3>오늘 점심은 굶습니다</h3></div>
                    : food2 == null ? <div><img src={food}/><h3>오늘의 점심!!</h3><img src={require(`../image/${food1}.png`)}/></div>
                    : <div><img src={food}/><h3>오늘의 점심!!</h3><img src={require(`../image/${food1}.png`)}/><img src={require(`../image/${food2}.png`)}/></div>
            }
        </div>
    );
}

export default Food;