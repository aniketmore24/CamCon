import React from 'react'
import { Nav, Navbar, NavDropdown } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { NavLink } from 'react-router-dom';

export default function FacultySideBar() {
  return (
<Navbar bg="secondary" variant="dark" expand="lg" className="flex-column" style={{position: 'fixed', top: 0, bottom: 0, left: 0, width: '250px'} }>
      <Navbar.Brand href="/StudentHome">CamCon</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="flex-column">
        <Nav.Link href="/viewstudents">Students Data</Nav.Link>
          <Nav.Link href="/AddFaculty">Faculty Data</Nav.Link>

          <Nav.Link href="/AddModule">Modules</Nav.Link>
          <Nav.Link href="/Addnotice">Add Notice</Nav.Link>

          <Nav.Link href="/showfeedback">Feedback</Nav.Link>

          
          
         
        </Nav>
      </Navbar.Collapse>
      <div className="mt-auto">
    <Nav className="flex-column">
      <Nav.Link href="/About">About Us</Nav.Link>
      <Nav.Link href="/logout">Log out</Nav.Link>

    </Nav>
  </div>
    </Navbar>
    
  )
}
