import React from 'react'
import { useState } from "react";
import axios from "axios";
import { Navigate, useNavigate } from 'react-router-dom';
import StudentHome from '../Home/StudentHome';
import FacultyHome from '../Home/FacultyHome';
import SideBar1 from '../Test/Side';
import logo from '../Images/ietlogo.jpg';


export default function LoginAuth() {
    console.log("in login");
    
    
      const [username, setUsername] = useState("");
      const [password, setPassword] = useState("");
      const [role, setRole] = useState("");
      const [error, setError] = useState("");
      const navigate = useNavigate();
    
      const handleUsernameChange = (event) => {

        console.log("uname");
        setUsername(event.target.value);
      };
    
      const handlePasswordChange = (event) => {
        console.log("password");

        setPassword(event.target.value);
      };
    
      const handleRoleChange = (event) => {
        console.log(event.target.value);

        setRole(event.target.value);
      };
    
      const handleSubmit = async (event) => {
       

        event.preventDefault();
        try {
          const response = await axios.post("http://localhost:8080/LogIn/Authentication", {
            username,
            password,
            role,
          });
          console.log(response.data);

          // Storing in session for future use
          sessionStorage.setItem("id",response.data.student.prn);
          sessionStorage.setItem("username", response.data.username);
          sessionStorage.setItem("password", response.data.password);
          sessionStorage.setItem("role", response.data.role);
          console.log(response.data.student.name);
          const sname = response.data.student.name
          sessionStorage.setItem("sname",sname);

          if(response.status == 200)
          {
          if (response.data) {
            if (response.data.role === "Student") {
              // redirect to student home page
              navigate("/StudentHome");
            } else if (response.data.role === "Faculty") {
              // redirect to faculty home page
              navigate("/FacultyHome");
            }else if (response.data.role === "Admin") {
              // redirect to faculty home page
              navigate("/AdminHome");
            }
          }
        }
        else{
          console.log("else");
          navigate("/home");
         
        }
         } catch (error) {
        //   console.error(error.response.data);
        //   setError(error.response.data.message);
        //   navigate("/Home");

         }
      }
    
      return (
        <div
        
        
        >
                <img
          src={logo}
          width="100"
          height="100"
          className="d-inline-block align-top"
          alt="CamCon Logo"
        />
        <div class="container px-5 my-5 w-50 p-3 mx-auto col-10 col-md-8 col-lg-6 "> 
        <form id="contactForm" data-sb-form-api-token="API_TOKEN" onSubmit={handleSubmit}>
            <div class="form-floating mb-3">
                <input class="form-control" id="uname" type="text" placeholder="Enter Username" data-sb-validations="required" 
                  value={username}
                  onChange={handleUsernameChange}/>
                <label for="uname">User Name</label>
                <div class="invalid-feedback" data-sb-feedback="newField:required">New Field is required.</div>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="password" type="password" placeholder="New Field 1" data-sb-validations="required"
                 value={password}
                 onChange={handlePasswordChange} />
                <label for="password">Password</label>
                <div class="invalid-feedback" data-sb-feedback="newField1:required">New Field 1 is required.</div>
            </div>
            
           
            <div class="d-grid">
                <button class="btn btn-primary btn-block mb-4" id="submitButton" type="submit">Login</button>
            </div>
            {error && <p>{error}</p>}
        </form>
        {/* </div> */}
    </div>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </div>
      );
    

    
   
}
