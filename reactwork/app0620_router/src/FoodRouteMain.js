import React from 'react';
import {Routes, Route} from "react-router-dom";
import FoodList from "./food/FoodList";
import FoodForm from "./food/FoodForm";
import FoodDetail from "./food/FoodDetail";
import sorry from "./image/sorry.gif";
import FoodChangePhoto from "./food/FoodChangePhoto";
import FoodUpdateInfo from "./food/FoodUpdateInfo";

function FoodRouteMain(props) {
    return (
        <Routes>
            <Route path="/" element={<FoodList/>}/>
            <Route path="/food/list" element={<FoodList/>}/>
            <Route path="/food/form" element={<FoodForm/>}>
                <Route path="/food/form/:num" element={<FoodForm/>}/>
            </Route>
            <Route path="/food/detail/:num" element={<FoodDetail/>}/>
            <Route path="/food/updatephoto/:num" element={<FoodChangePhoto/>}/>
            <Route path="/food/update/:num" element={<FoodUpdateInfo/>}/>
            {/* 위의 매핑주소 외에는 무조건 에러페이지 표시 */}
            <Route path="*" element={
                <div>
                    <h1>Error 404</h1>
                    <h2>잘못된 페이지 입니다</h2>
                    <img src={sorry}/>
                </div>
            }/>
        </Routes>
    );
}

export default FoodRouteMain;