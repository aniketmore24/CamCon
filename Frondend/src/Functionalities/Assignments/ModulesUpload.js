import React from 'react'
import { Link } from 'react-router-dom';
import { useState } from 'react';
import "./ModuleCSS.css"
import FacultySideBar from "../../NevigationBar/FacultySideBar ";
import { useEffect } from 'react';
import axios from 'axios';


export default function Modules() {

    useEffect(() => {
        axios.get('http://localhost:8080/subject/getAll')
          .then(response => {
            setModules(response.data);
          })
          .catch(error => {
            console.log(error);
          });
      }, []);
      

    const [modules, setModules] = useState([
        { id: 1, name: 'Module 1' },
        { id: 2, name: 'Module 2' },
        { id: 3, name: 'Module 3' },
        { id: 4, name: 'Module 4' },
      ]);



  return (

    <>
       <div><FacultySideBar></FacultySideBar></div>
    <div className="container my-5" >
    <div className="row justify-content-center">
      <div className="col-md-8">
        <h2 className="text-center mb-4">Module List</h2>
        <table className="table table-striped">
          <thead>
            <tr>
            <th className='td'>Sr No.</th>
              <th className='td'>Module Name</th>
            </tr>
          </thead>
          <tbody>
            {/* Map over modules and display them in a table */}
            {modules.map((module) => (
              <tr key={module.id}>
                <td className='td'>
                  <Link >{module.subId}</Link>
                </td>
                <td className='td'>
                  <Link to={`/AssignmentsUpload/${module.subId}`}>{module.sName}</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  </div>

  </>
  )
}
