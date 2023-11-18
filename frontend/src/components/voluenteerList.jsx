import React, { useState } from 'react';
import { Table } from 'react-bootstrap';

function Volunteer({ volunteers }) {
    return (
        <Table striped>
            <thead>
                <tr>
                    <th>Volunteer Name</th>
                    <th>Availability</th>
                    <th>Mobile Number</th>
                </tr>
            </thead>
            <tbody>
                {
                    (volunteers || []).map((volunteer) => {
                        return (<tr>
                            <td>{volunteer.firstName}</td>
                            <td>
                              {volunteer.profile.availabilityType === 'IMMEDIATE' ?
                                <div style={{ color: 'green'}}>Available Now</div> :
                                (volunteer.profile.availableDays || [])
                                .map((day) => {
                                  day = day.toLowerCase();
                                  return day.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });;
                                })
                                .join(',')
                                }
                              </td>
                            <td>{volunteer.phoneNumber}</td>
                        </tr>)
                    })
                }
            </tbody>
        </Table>
    )
}

export default Volunteer
