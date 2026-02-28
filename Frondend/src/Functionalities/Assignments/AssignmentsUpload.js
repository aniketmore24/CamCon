import React from 'react'
import { useState, useEffect} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import "./AssCSS.css";
import FacultySideBar from "../../NevigationBar/FacultySideBar ";
import AssUploader from './AssUploader';


export default function AssignmentsUpload({ match }) {
    // const assignments = [
    //     { id: 1, d: 'Assignment 1', file: '/files/assignment1.pdf', date: '2022-01-15' },
    //     { id: 2, title: 'Assignment 2', file: '/files/assignment2.pdf', date: '2022-02-01' },
    //     { id: 3, title: 'Assignment 3', file: '/files/assignment3.pdf', date: '2022-02-15' },
    //   ];
    
    const [assignments, setAssignments] = useState([

          // { id: 1, title: 'Addition', file: 'Addition' },
          // { id: 2, title: 'Sub', file: 'Addition' },
      
          // { id: 3, title: 'Division', file: 'Addition' }
      
        ]);
      useEffect(() => {

        console.log("before axios");
        //axios.get(`/api/assignments/${match.params.id}`)
        axios.get(`http://localhost:8080/Assignment/getAll`)
          .then(response => {
            console.log("After");
            console.log(response.data);
            setAssignments(response.data);
          })
          .catch(error => {
            console.log(error);
          });
      },[] );
      //[match.params.id]
    //<td>{assignment.date}</td>
    //<td><a href={assignment.file} download>{assignment.file}</a></td>
    //<td>{assignment.title}</td>
    
       
      return (
        <>
       <div><FacultySideBar></FacultySideBar></div>
        <div className="container my-5">
          <div className="row justify-content-center">
            <div className="col-md-8">
              <h2 className="text-center mb-4">Assignments</h2>
              <table className="table table-striped">
                <thead>
                  <tr>
                    <th>Title</th>
                    <th>File</th>
                    <th>Date</th>
                  </tr>
                </thead>
                <tbody>
                  {assignments.map((assignment) => (
                    <tr key={assignment.id}>
                      <td>{assignment.id}</td>
                      <td><a href={assignment.file} download>{assignment.description}</a></td>
                     
                      <td>{assignment.date}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
              <AssUploader></AssUploader>
            </div>
          </div>
        </div>
        </>
      );
}
