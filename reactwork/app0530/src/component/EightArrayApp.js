import React from 'react';

function EightArrayApp(props) {
    const {idx, row, onDel} = props;
    return (
        <tr>
            <td>{idx + 1}</td>
            <td>{row.name}</td>
            <td>{row.blood}형</td>
            <td>{row.addr}</td>
            <td>
                <img src={require(`../image/${row.photo}`)} style={{height: "100px"}}/>
            </td>

            <td>
                <button type="button" onClick={() => {
                    onDel(idx);
                }}>삭제</button>
            </td>
        </tr>
    );
}

export default EightArrayApp;