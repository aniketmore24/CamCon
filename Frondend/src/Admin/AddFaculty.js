import React from 'react'
import { useState } from "react";
import axios from 'axios';
import "./AddStuCSS.css"
import AdminSidBar from "../NevigationBar/AdminSidBar"



export default function AddFaculty() {
    const [name, setName] = useState("");
  const [module, setModule] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/faculty/addfaculty", {
        name,
        module,
        phoneno : phone,
        emailid : email,
      });
      console.log(response.data);
      alert("Faculty member information added successfully");
    } catch (error) {
      console.error(error);
      alert("Failed to add faculty member information");
    }
  };

  return (
    <>
   <AdminSidBar></AdminSidBar>
    <form onSubmit={handleSubmit}>
    <h3>Add New Faculty</h3>

      <label>
        Name:
        <input
          type="text"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
      </label>
      <label>
        Module:
        <input
          type="text"
          value={module}
          onChange={(event) => setModule(event.target.value)}
        />
      </label>
      <label>
        Phone:
        <input
          type="tel"
          value={phone}
          onChange={(event) => setPhone(event.target.value)}
        />
      </label>
      <label>
        Email:
        <input
          type="email"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
    </>
  );

}
