import React from 'react';

function SevenChildApp2({name, price, photo}) {
    return (
        <div>
            <span>이름: {name}</span>
            <span>가격: {price}</span>
            <span>사진:
            <img src={require(`../image/${photo}`)}/>
            </span>
        </div>
    );
}

export default SevenChildApp2;