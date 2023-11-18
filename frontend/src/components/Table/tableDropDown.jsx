import React, { useState } from 'react'
import { Form } from 'react-bootstrap'

function TableDropDown({ selectedValue, onChange }) {

    const [selectedNum, setSelectedNum] = useState(selectedValue);
    const numbers = Array.from({ length: 3 }, (_, index) => index + 1);

    const handleSelect = (e) => {
        setSelectedNum(e);
        onChange(e);
    }
    return (
      <Form.Select
        value={selectedNum}
        onChange={(e) => handleSelect(e.target.value)}>
        {numbers.map((number) => (<option value={number}>{number}</option>)) };
      </Form.Select>
    )
}

export default TableDropDown
