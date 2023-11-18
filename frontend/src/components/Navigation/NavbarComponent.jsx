import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import { Link } from "react-router-dom/dist";
import "bootstrap-icons/font/bootstrap-icons.css";

const NavbarComponent = (props) => {
  const { pageTitle, path } = props;

  return (
    <>
      <Navbar
        collapseOnSelect
        expand="lg"
        className="bg-body-tertiary justify-content-end"
        variant="light"
        bg="#edeef0"
      >
        <Navbar.Brand className="color-primary px-5">
          <Link to="/ ">
          <i class="bi bi-house"></i>
          </Link>
          
        </Navbar.Brand>
        <Container className="justify-content-end" fluid>
          <Navbar.Brand className="color-primary px-5">
            <center>
              <h2>{pageTitle}</h2>
            </center>
          </Navbar.Brand>

          <Nav>
            {path !== "/" && (
              <Link to="/govemployee/volunteer">
                <Button variant="primary">Join Now</Button>
              </Link>
            )}
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default NavbarComponent;
