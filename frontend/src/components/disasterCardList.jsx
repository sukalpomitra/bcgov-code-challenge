import React, { useEffect, useState } from 'react';
import DisasterCard from './Cards/disasterCard';

function DisasterCardList({ disasterList, onClick }) {
    return (
        <>
            {
                disasterList.map(disaster => {
                    return (<DisasterCard disaster={disaster} onClick={(e) => onClick(disaster, e)}></DisasterCard>)
                })
            }
        </>
    )
}

export default DisasterCardList
