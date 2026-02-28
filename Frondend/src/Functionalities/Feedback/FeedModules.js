import React from 'react';
import { Link } from 'react-router-dom';
import "./fmod.css"
import AdminSidBar from "../../NevigationBar/AdminSidBar"


export default function FeedModules() {
    const modules = [
        { id: 1, name: 'Core Java' },
        { id: 2, name: 'WPT' },
        { id: 3, name: 'Data Structures' },
        { id: 2, name: 'Dot Net' },
        { id: 2, name: 'SDM' },

      ];
    
      return (
        <>        <AdminSidBar></AdminSidBar>
        <h3> Modules</h3>
        <table className='tab'>
          
          <thead>
            <tr>
              <th>Serial No.</th>
              <th>Module Name</th>
            </tr>
          </thead>
          <tbody>
            {modules.map((module, index) => (
              <tr key={module.id}>
                <td>{index + 1}</td>
                <td>
                  <Link to={`/feedback/${module.name}`}>{module.name}</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        </>

      );
}
