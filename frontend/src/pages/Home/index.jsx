
import React from "react";
import { Row, Col } from "react-bootstrap";
import Image from "react-bootstrap/Image";
import heroImage from "../../assets/images/sleeping-man-relax-removebg-preview.png";

import "./homeStyle.css";

function HomeView() {
  return (
    <>
    <Row className="justify-content-md-center align-items-center">
    <Col xl="auto">
      <Image className="hero-image mt-5" src={heroImage} roundedCircle />
    </Col>
  </Row>
  <row className="justify-content-md-center align-items-center ">
    <Col className=" text-center " xl="auto">
      <div className="home-text  mt-5 mx-auto">
        <h2 className="color-primary">Zero disasters detected...</h2>
        <h4 className="color-secondary-light-grey">
          All clear! No disasters to report. Kick back, relax, and enjoy
          the tranquility. We'll be ready when action calls!
        </h4>
      </div>
    </Col>
  </row>
  </>
  )
}

export default HomeView