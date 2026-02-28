import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./ViewStuCSS.css"
import { Link } from 'react-router-dom';
import AdminSidBar from "../NevigationBar/AdminSidBar"


export default function ViewStudents() {
    const [students, setStudents] = useState([]);
    const [prn, setPrn] = useState('');
    const [message, setMessage] = useState('');
    const [open, setOpen] = useState(false);
  
   

    useEffect(() => {

      console.log("before get");
      axios.get('http://localhost:8080/students/getall')
        .then(response => {
          console.log("after get");
          console.log(response.data);

          setStudents(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    }, []);


    const handleInputChange = (event) => {
      setPrn(event.target.value);
    };

    // To delete Student
    const handleSubmit = (event) => {
      event.preventDefault();
      // Make a DELETE request to the server with the PRN to delete the student
      axios.delete(`http://localhost:8080/students/deletestudent/${prn}`)
        .then((response) => {
          if (response.status === 204) {
            setMessage(`Student with PRN ${prn} has been deleted.`);
            
          } else {
            setMessage(`Error deleting student with PRN ${prn}.`);
          }
        })
        .catch((error) => {
          setMessage(`Error deleting student with PRN ${prn}: ${error.message}.`);
        });
    };
  

    // <div>
    //   <button onClick={() => setOpen(true)} className='button'>Delete Student</button>
    //   {open && (
    //     <div>
    //       <h2>Delete Student</h2>
    //       <form onSubmit={handleSubmit} className="del">
    //         <label>
    //           PRN:
    //           <input type="text" value={prn} onChange={handleInputChange} />
    //         </label>
    //         <button type="submit" >Delete Student</button>
    //       </form>
    //       {message && <p>{message}</p>}
    //     </div>
    
    return (
      <div>
        <AdminSidBar></AdminSidBar>
        <h3>Students Data</h3>
      <table className='tab'>
        <thead>
          <tr>
            <th>PRN</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Qualification</th>
          </tr>
        </thead>
        <tbody>
          {students.map(student => (
            <tr key={student.id}>
              <td>{student.prn}</td>
              <td>{student.name}</td>
              <td>{student.dob}</td>
              <td>{student.phone}</td>
              <td>{student.email}</td>
              <td>{student.qualification}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div>
      <button className='button'><Link to="/AddStudent">Add Student</Link></button>
    </div>
      
      
      
    </div>
      
      
    );
}
