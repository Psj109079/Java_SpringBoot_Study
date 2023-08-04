import React from 'react';

function FiveRowList(props) {
    const {row, idx, openModal} = props;

    return (
        <tr>
            <td align="center">{idx + 1}</td>
            <td align="left" onClick={openModal}>{row.subject}</td>
            <td align="left">{row.writer}</td>
            <td align="left">{row.today.toLocaleDateString("ko-KR")}</td>
        </tr>
    );
}

export default FiveRowList;

