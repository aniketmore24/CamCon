import React, { useState, useEffect } from "react";
import axios from "axios";
import "./DownloadCSS.css";
import { saveAs } from 'file-saver';
import { useParams } from 'react-router-dom';

import StudentSideBar from '../../NevigationBar/StudentSideBar';




export default function AssignmentDownload1() {
    const [files, setFiles] = useState([]);
    //const [pdfLink, setPdfLink] = useState(null);
    const { id } = useParams();


    useEffect(() => {
      console.log("before get axios");
      axios.get(`http://localhost:8080/notes/getbyid/${id}`).then((response) => {
        console.log(response.data);
        console.log("after axios");
      setFiles(response.data);
      });
    }, []);
  

    const handleFileDownload = (fileId, fileName) => {
      console.log(fileId);
      console.log(fileName);

      fetch(`http://localhost:8080/file/download/${fileId}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/pdf',
        },
      })
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.blob();
        })
        .then(blob => {
          saveAs(blob, fileName);
        })
        .catch(error => {
          console.error('There was an error downloading the file:', error);
        });
    };
              
    //<td>{file.description}</td>
  
    return (
      <>
      <div><StudentSideBar></StudentSideBar></div>
      <h2 className="note">Notes</h2>
      <div className="file-table">
        <table>
          <thead>
            <tr>
             
              <th>Description</th>
              <th>Date</th>
              <th>Download</th>
            </tr>
          </thead>
          <tbody>
            {files.map((file) => (
              <tr key={file.id}>
                
                
                <td>{file.fileName}</td>
                <td>{file.date}</td>
                <td>
                  <button
                    onClick={() => handleFileDownload(file.notesId, file.fileName)}
                  >
                    Download
                  </button>
                  
                </td>
                
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      </>
    );
}
