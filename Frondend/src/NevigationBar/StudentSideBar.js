import React from 'react'
import { Nav, Navbar, NavDropdown } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import logo from '../Images/ietlogo.jpg';


export default function StudentSideBar() {
  return (

    <Navbar bg="secondary" variant="dark" expand="lg" className="flex-column" style={{position: 'fixed', top: 0, bottom: 0, left: 0, width: '250px'} }>
   <Navbar.Brand href="/StudentHome">
        <img
          src={logo}
          width="60"
          height="60"
          className="d-inline-block align-top"
          alt="CamCon Logo"
        />
      </Navbar.Brand>
  <Navbar.Brand href="/StudentHome">CamCon</Navbar.Brand>
  <Navbar.Toggle aria-controls="basic-navbar-nav" />
  <Navbar.Collapse id="basic-navbar-nav">
    <Nav className="flex-column">
      <Nav.Link href="/NotesDownload">Notes</Nav.Link>
      <Nav.Link href="/AssignmentDownload">Assignments</Nav.Link>
      <Nav.Link href="/Notice">Notice</Nav.Link>
      <Nav.Link href="/Discussion">Discussion Forum</Nav.Link>
      <Nav.Link href="/feedbackform">Feedback</Nav.Link>
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
