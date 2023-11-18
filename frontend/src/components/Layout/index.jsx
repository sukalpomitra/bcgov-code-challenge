import React from "react";
import { Row, Col, Container } from "react-bootstrap";
import { useLocation} from 'react-router-dom';
import NavbarComponent from "components/Navigation/NavbarComponent";
import "./layout.css";


/**
 * Layout component for arranging content in a structured grid layout.
 * @param {Object} props - The props for the Layout component.
 * @param {React.ReactNode} props.children - The child elements to be rendered within the layout.
 * @returns {JSX.Element} A JSX element representing the layout structure.
 */
function Layout({ children }) {
  const location = useLocation();

  // Access the pathname property to get the current URL path
  const currentPath = location.pathname;
  let pageTitle;
  if (currentPath === "/govemployee/volunteer") {
    pageTitle = 'Volunteer Enrollment Application '
  } else if (currentPath === "/govemployee/admin") {
    pageTitle = 'Publish incident page'
  } else if (currentPath === '/govemployee') {
    pageTitle = 'Join us, Make a difference today!'
  } else if (currentPath === "/") {
    pageTitle = 'General View'
  }


  return (
    <>
      <Container fluid className="p-0">
        <NavbarComponent pageTitle={pageTitle} path={currentPath} />
        <Row className="app-content-area">
          <Col>
            <div>{children}</div>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default Layout;
