import React, { useEffect } from 'react'
import Navbar from '../NevigationBar/Navbar'
import StudentSideBar from '../NevigationBar/StudentSideBar';
import FacultySideBar from "../NevigationBar/FacultySideBar ";
import logo from '../Images/iet3.webp';
import { useNavigate,Navigate } from 'react-router-dom';


export default function FacultyHome() {
 
  const navigate = useNavigate();

  useEffect(() =>{

    let role = sessionStorage.getItem("role");
    console.log(role);
    if(role == "Student" || role == "Admin" || role == null)
    {
      navigate("/home")
    }

  },[] );
 
 
 
  return (

    <>
    <div><FacultySideBar></FacultySideBar></div>
    <div style={
      {
        backgroundImage : `url(${logo})`,
        backgroundSize : 'cover',
        height : '100vh',
        display : 'flex',
        justifyContent : 'center',
        alignItems : 'center',
        marginLeft : '250px'
      }
    }></div>
    </>
  )
}
