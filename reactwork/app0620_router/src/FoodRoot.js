import React from 'react';
import {BrowserRouter} from "react-router-dom";
import FoodRouteMain from "./FoodRouteMain";

function FoodRoot(props) {
    return (
        <div>
            <BrowserRouter>
                <FoodRouteMain/>
            </BrowserRouter>
        </div>
    );
}

export default FoodRoot;