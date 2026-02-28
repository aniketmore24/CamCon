import React from 'react'
import "./AboutCSS.css"
import StudentSideBar from '../NevigationBar/StudentSideBar'


export default function AboutUS() {
    return (
        <>
         <div><StudentSideBar></StudentSideBar></div>

        <div className='di'>
          <h3>About Us</h3>
          <p>We are a team of dedicated educators who are committed to providing high-quality education and resources to students around the world.</p>
          <p>Our mission is to empower students with the knowledge and skills they need to achieve their goals and reach their full potential.</p>
          
          <h3>Contact Us</h3>
          <p>If you have any questions or feedback, please feel free to contact us at:</p>
          <p>Email: info@studentportal.com</p>
          <p>Phone: 555-555-5555</p>
          <span>Aniket Hanmantrao More   -220945920011 <br></br>
               Nikhil Nandakumar Thorat  -220945920052 <br></br>
               Shantanu Mahendra Patti   - 220945920085 <br></br>
               Shubham Anilkumar Shinde  -220945920094 <br></br>
               </span>
        </div>
        </>
      );
}
