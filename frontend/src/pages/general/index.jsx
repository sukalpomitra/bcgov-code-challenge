import DisasterCardList from 'components/disasterCardList';
import Volunteer from 'components/voluenteerList';
import React, { useEffect, useState } from 'react';
import { Col, Row, } from 'react-bootstrap';
import {
  getAllDisasters,
  getEligibleVolunteers,
} from 'services/disasterservice';
import Image from "react-bootstrap/Image";
import heroImage from "../../assets/images/sleeping-man-relax-removebg-preview.png";

import "./homeStyle.css";
function GeneralView() {
  const [disasterList, setDisasterList] = useState([]);
  const [volunteers, setVolunteers] = useState([]);

  useEffect(() => {
    (async () => {
      try {
        const { data } = await getAllDisasters({ disasterStatus: 'ACTIVE' });
        const disasters = data.map((item, key) => {
          return {
            ...item,
            selected: key === 0 ? true : false
          }
        });
        setDisasterList(disasters);
      } catch (error) {
        console.log(error);
      }
    })();
  }, []);

  useEffect(() => {
    const selectedDisaster = disasterList.find(item => item.selected);
    if (selectedDisaster) {
      loadVolunteers(selectedDisaster.id);
    }
  }, [disasterList]);

  const handleDisasterSelect = (disaster) => {
    setDisasterList(
      disasterList.map((item) => {
        item.selected = false;
        if (item.id === disaster.id) {
          return {
            ...item,
            selected: true,
          };
        }
        return item;
      }),
    );
    // loadVolunteers(disaster.id);
  };

  const loadVolunteers = async (id) => {
    try {
      const { data } = await getEligibleVolunteers(id);
      setVolunteers(data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      {disasterList.length === 0 ? (
        <>
          <Row className='justify-content-md-center align-items-center'>
            <Col xl='auto'>
              <Image
                className='hero-image mt-5'
                src={heroImage}
                roundedCircle
              />
            </Col>
          </Row>
          <row className='justify-content-md-center align-items-center '>
            <Col className=' text-center ' xl='auto'>
              <div className='home-text  mt-5 mx-auto'>
                <h2 className='color-primary'>Zero disasters detected...</h2>
                <h4 className='color-secondary-light-grey'>
                  All clear! No disasters to report. Kick back, relax, and enjoy
                  the tranquility. We'll be ready when action calls!
                </h4>
              </div>
            </Col>
          </row>
        </>
      ) : (
        <>
          <Row>
            <Col xs={6} style={{ overflowY: 'auto', height: '100vh' }}>
              <DisasterCardList
                onClick={handleDisasterSelect}
                disasterList={disasterList}
              ></DisasterCardList>
            </Col>
            <Col xs={6}>
              <Volunteer volunteers={volunteers}></Volunteer>
            </Col>
          </Row>
        </>
      )}
    </>
  );
}

export default GeneralView;
