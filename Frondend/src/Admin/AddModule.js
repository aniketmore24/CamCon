import axios from "axios";
import React, { useState } from "react";
import "./AddMoCSS.css"
import AdminSidBar from "../NevigationBar/AdminSidBar"


export default function AddModule() {
    const [name, setName] = useState("");
    const [facultyId, setFacultyId] = useState("");
  
    const handleSubmit = async (event) => {
      event.preventDefault();
      try {
        const response = await axios.post("http://localhost:8080/subject/addmodule", { sName :name, fid : facultyId });
        console.log(response.data);
        alert("Module information added successfully");
      } catch (error) {
        console.error(error);
        alert("Failed to add module information");
      }
    };
  
    return (
      <>
          <AdminSidBar></AdminSidBar>
      <form onSubmit={handleSubmit}>
      <h3>Add New Module</h3>

        <label>
          Module Name:
          <input
            type="text"
            value={name}
            onChange={(event) => setName(event.target.value)}
          />
        </label>
        <label>
          Faculty ID:
          <input
            type="text"
            value={facultyId}
            onChange={(event) => setFacultyId(event.target.value)}
          />
        </label>
        <button type="submit">Submit</button>
      </form>
      </>
    );
}
