import React, { useEffect } from 'react'
import Navbar from '../NevigationBar/Navbar'
import StudentSideBar from '../NevigationBar/StudentSideBar'
import Test from './Test'
import logo from '../Images/iet2.jpg';
import { useNavigate,Navigate } from 'react-router-dom';



export default function StudentHome() {
 
  const navigate = useNavigate();


  useEffect(() =>{

    let role = sessionStorage.getItem("role");
    console.log(role);
    if(role == "faculty" || role == "Admin" || role == null)
    {
      navigate("/home")
    }

  },[] );

  
    function sub(){
        let user = sessionStorage.getItem("username");
      console.log(user);
    }
 
 
  return (
 <div 
    style={
      {
        backgroundImage : `url(${logo})`,
        backgroundSize : 'cover',
        height : '100vh',
        display : 'flex',
        justifyContent : 'center',
        alignItems : 'center',
        marginLeft : '250px'
      }
    }
  
  >
       
       <div><StudentSideBar></StudentSideBar></div>
      
        
        
      
        </div>
  )
}
