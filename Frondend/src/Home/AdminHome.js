import AdminSidBar from "../NevigationBar/AdminSidBar"
import logo from '../Images/iet5.jpg';
import React, { useEffect } from 'react'
import { useNavigate,Navigate } from 'react-router-dom';




export default function AdminHome() {
 
  const navigate = useNavigate();

  useEffect(() =>{

    let role = sessionStorage.getItem("role");
    console.log(role);
    if(role == "Student" || role == "Faculty" || role == null)
    {
      navigate("/home")
    }

  },[] );
 
 
  return (
    <div>   <AdminSidBar></AdminSidBar>

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
    </div>
  )
}
