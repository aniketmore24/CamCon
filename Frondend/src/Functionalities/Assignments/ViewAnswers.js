import React from 'react'
import { useState, useEffect } from "react";
import "./DownloadCSS.css";
import { saveAs } from 'file-saver';
import { useParams } from 'react-router-dom';
import FacultySideBar from '../../NevigationBar/FacultySideBar ';
import axios from 'axios';

export default function ViewAnswers() {
    const [files, setFiles] = useState([]);

    //const [pdfLink, setPdfLink] = useState(null);

    //Assignment id to retrive list of assignments of this module
    const { id } = useParams();


  // Load List of Answers of given Assignment id
    useEffect(() => {
      console.log("before get bi id axios");
      axios.get(`http://localhost:8080/submit/subStud/${id}`).then((response) => {
       // console.log(response.data);
        console.log("after get by id axios");
      setFiles(response.data);
      });
    }, []);
  

//Download File after download button click
    const handleFileDownload = (fileId, PRN) => {
      console.log(fileId);
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
          saveAs(blob, PRN);
        })
        .catch(error => {
          console.error('There was an error downloading the file:', error);
        });
    };

     
    //<td>{file.description}</td>
  
    return (
      <>
      <div><FacultySideBar></FacultySideBar></div>
      <h3 className='sub'>Submitted Answers</h3>
      <div className="file-table">
        <table>
          <thead>
            <tr>    
              <th>PRN</th>         
              <th>Date</th>
              <th>Download</th>
            </tr>
          </thead>
          <tbody>
            {files.map((file) => (
              <tr key={file.id}>
              <td>{file.prn}</td>
                
           
                {/*  d.toLocaleString("en-GB")
              .replace(',' ,''); */}
                <td>{file.date  }</td>
                <td>
                  <button
                    onClick={() => handleFileDownload(file.ansId, file.prn)}
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
