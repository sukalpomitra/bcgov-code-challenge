import React from 'react'
import { Card } from 'react-bootstrap'

function DisasterCard({ onClick, disaster }) {

  const SiteCard = ({ site, siteSelectedCallback }) => (
    // eslint-disable-next-line jsx-a11y/anchor-is-valid
    <a style={{ cursor: 'pointer' }} onClick={onClick} >
      <Card className='m-3' style={{ backgroundColor: disaster.selected ? '#edeef0': '' }}>
        <Card.Body>
            <Card.Title>{disaster.name}</Card.Title>
            <Card.Text>
                <h6>Location : {disaster.location}</h6>
                <h6>Critical Level : 0{disaster.criticalLevel}</h6>
                <h6>Date and Time : {disaster.disasterTime}, {disaster.disasterDate}</h6>
            </Card.Text>
        </Card.Body>
      </Card>
    </a>
  );
  return (<SiteCard />)
}

export default DisasterCard
