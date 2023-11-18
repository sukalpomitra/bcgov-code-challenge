import TableDropDown from 'components/Table/tableDropDown';
import toast from 'react-simple-toasts';
import React, { useEffect, useState } from 'react';
import { Table, FormControl, FormCheck } from 'react-bootstrap';
import { getAllDisasters, updateDisaster } from 'services/disasterservice';

function AdminView() {
  const [disasters, setDisasters] = useState([]);

  useEffect(() => {
    (async () => {
      try {
        const { data } = await getAllDisasters();
        setDisasters(data);
        console.log(data);
      } catch (error) {
        console.log(error);
      }
    })();
  }, []);

  const handleDisasterChange = async (disaster, value, key) => {
    console.log(disaster, value, key);
    setDisasters(disasters.map((item) => {
      if (item.id === disaster.id) {
        return {
          ...item,
          [key]: value
        }
      }
      return item;
    }));

    try {
      await updateDisaster(disaster.id, {
        ...disaster,
        [key]: value
      });
      toast("Disaster record updated successfully", {
        duration: 5000,
        theme: "success",
      });
    } catch (error) {
      console.log(error);
      toast("Something went wrong, Please try again...", {
        duration: 5000,
        theme: "failure",
      });
    }
  }


  return (
    <div style={{ padding: '60px' }}>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Disaster</th>
            <th>Critical Level</th>
            <th>Location</th>
            <th>Time</th>
            <th>Date</th>
            <th>Disaster Status</th>
          </tr>
        </thead>
        <tbody>
          {
            disasters.map((item) => {
              return (
                <tr key={item.id}>
                  <td>{item.name}</td>
                  <td>
                    <TableDropDown onChange={(e) => handleDisasterChange(item, e, 'criticalLevel')} selectedValue={item.criticalLevel} />
                  </td>
                  <td>{item.location}</td>
                  <td>
                    <FormControl
                      type='time'
                      value={item.disasterTime}
                      onChange={(e) => handleDisasterChange(item, e.target.value, 'disasterTime')}
                      />
                  </td>
                  <td>
                    <FormControl
                    onChange={(e) => handleDisasterChange(item, e.target.value, 'disasterDate')}
                    type='date' value={item.disasterDate} />
                  </td>
                  <td>
                    <FormCheck type='switch' isValid={true}
                    onChange={(e) => handleDisasterChange(item, e.target.checked ? "ACTIVE": "INACTIVE", 'disasterStatus')}
                    defaultChecked={item.disasterStatus === 'ACTIVE'} />
                  </td>
                </tr>
              )
            })
          }
        </tbody>
      </Table>
    </div>
  )
}

export default AdminView
