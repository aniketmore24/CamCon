import React from 'react'
import { Container, Row, Col  } from 'react-bootstrap'
import "./NoticeCSS.css"
import axios from 'axios';

export default function NoticeDisplay(props) {


//   <div >
//   {notices.map(notice => (
//     <Alert variant="info" key={notice.id}  >
//       <Alert.Heading>{notice.title}</Alert.Heading>
//       <p>{notice.description}</p>
//       <hr />
//       <p className="mb-0">{notice.date}</p>
//     </Alert>
//   ))}
// </div>

const handleDelete = (id) => {
  // Send the notice ID to the backend for deletion
  axios.delete(`http://localhost:8080/noticeBoard/deletebyid/${id}`)
    .then(response => {
  
        // Remove the deleted notice from the list
        
        props.deletenotice(id);
     
    })
    .catch(error => {
      console.error(error);
    });
};



  return (

    <Container>
      <h1 className="notice-board">Notice Board</h1>

    {props.notices.map((notice, index) => (
      <Row className="justify-content-center" key={index}>
        <Col xs={12} md={8} lg={6}>
          <div className="notice p-3 mb-3">
            <h3 className="notice-title mb-3">{notice.title}</h3>
            <p className="notice-description mb-3">{notice.content}</p>
            <p className="notice-date mb-0">{notice.date}</p>
          </div>
          <button
            className="delete-button"
            onClick={() => handleDelete(notice.noticeId)}
          >
            Delete
          </button>
        </Col>
      </Row>
    ))}
  </Container>
   
  )
}
