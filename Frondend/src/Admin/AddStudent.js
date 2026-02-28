import React from "react";
import { useState } from "react";
import axios from "axios";
import "./AddStuCSS.css"
import AdminSidBar from "../NevigationBar/AdminSidBar"



export default function AddStudent() {
  const [name, setName] = useState("");
  const [DOB, setDob] = useState("");
  const [email, setEmail] = useState("");
  const [Phone, setPhone] = useState("");
  const [qualification, setQualification] = useState("B.E.");
  const [otherQualification, setOtherQualification] = useState("");
  const [PRN, setPRN] = useState();


  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      let student = {
        prn : PRN ,
        name : name,
        dob : DOB,
        email : email,
        phone  : Phone,
        qualification: otherQualification || qualification,
      }
      const response = await axios.post("http://localhost:8080/students/addstudents", student);

      console.log(response.data); // Log the response from the server
      alert("Student information added successfully");
    } catch (error) {
      console.error(error);
      //alert("Failed to add student information");
    }
  };


  return (
    <>
    <AdminSidBar></AdminSidBar>
    
    <form onSubmit={handleSubmit}>
    <h3>Add New Student</h3>
    <label>
        PRN:
        <input
          type="text"
          value={PRN}
          onChange={(event) => setPRN(event.target.value)}
        />
      </label>
      
      <label>
        Name:
        <input
          type="text"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
      </label>
      <br />
      <label>
        DOB:
        <input
          type="text"
          value={DOB}
          onChange={(event) => setDob(event.target.value)}
        />
      </label>
      <br />
      <label>
        Email:
        <input
          type="email"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
        />
      </label>
      <br />
      <label>
        Phone:
        <input
          type="text"
          value={Phone}
          onChange={(event) => setPhone(event.target.value)}
        />
      </label>
      <br />
      <label>
        Qualification: 
        <select
          value={qualification}
          onChange={(event) => {
            setQualification(event.target.value);
            if (event.target.value !== "Other") {
              setOtherQualification("");
            }
          }}
        >
          <option value="B.E.">B.E.</option>
          <option value="M.E.">M.E.</option>
          <option value="BSc">BSc</option>
          <option value="MSc">MSc</option>
          <option value="Bcom">Bcom</option>
          <option value="Mcom">Mcom</option>
          <option value="Other">Other</option>
        </select>
      </label>
      {qualification === "Other" && (
        <label>
          Other Qualification:
          <input
            type="text"
            value={otherQualification}
            onChange={(event) => setOtherQualification(event.target.value)}
          />
        </label>
      )}
      <br />
      <button type="submit">Submit</button>
    </form>
    </>
  );
}
