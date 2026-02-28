import React, { useState, useEffect } from "react";
import axios from "axios";
import "./DownloadCSS.css";
import { saveAs } from 'file-saver';
import { useParams } from 'react-router-dom';

import StudentSideBar from '../../NevigationBar/StudentSideBar';




export default function AssignmentDownload1() {
    const [files, setFiles] = useState([]);
    const [selectedFile, setSelectedFile] = useState(null);

    //const [pdfLink, setPdfLink] = useState(null);

    //Module id to retrive list of assignments of this module
    const { id } = useParams();


  // Load List of Assignments
    useEffect(() => {
      console.log("before get bi id axios");
      axios.get(`http://localhost:8080/file/getbyid/${id}`).then((response) => {
       // console.log(response.data);
        console.log("after get by id axios");
      setFiles(response.data);
      });
    }, []);
  

//Download File after download button click
    const handleFileDownload = (fileId, fileName) => {
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
          saveAs(blob, fileName);
        })
        .catch(error => {
          console.error('There was an error downloading the file:', error);
        });
    };

    // To select file from system
    const handleFileInput = (event) => {
        alert("in file input")
        
        setSelectedFile(event.target.files[0]);

    };

    // Upload file after submit button click
     const handleFileUpload = async(assId) => {
      
      //alert("in submit")
      const formData = new FormData();
      formData.append('file', selectedFile);
      formData.append("AssignmentId", assId)
      formData.append("PRN", sessionStorage.getItem("id"))

      console.log("before post ans");
  
      await axios.post('http://localhost:8080/submit/uploadassgnsub', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
        .then((response) => {
          console.log("before post ans");

          console.log(response.data);
          console.log("Upload done");
         // props.instantUpload(response.data)
         alert("Your Answer Submitted successfully..!")
        })
        .catch((error) => {
          console.error(error);
          //alert("Failed to upload your response")

        });
    };
              
    //<td>{file.description}</td>
  
    return (
      <>
      <div><StudentSideBar></StudentSideBar></div>
      <h2 className="note">Assignments</h2>
      <div className="file-table">
        <table>
          <thead>
            <tr>
              <th>Description</th>
              <th>Date</th>
              <th>Download</th>
              <th>Submit Answer </th>
            </tr>
          </thead>
          <tbody>
            {files.map((file) => (
              <tr key={file.id}>
                
                <td>{file.fileName}</td>
                {/*  d.toLocaleString("en-GB")
              .replace(',' ,''); */}
                <td>{file.date  }</td>
                <td>
                  <button
                    onClick={() => handleFileDownload(file.id, file.fileName)}
                  >
                    Download
                  </button>
                                  
            </td>
            <td>
            <input type="file" onChange={handleFileInput} className="file-input" />
            <button
                    onClick={() =>handleFileUpload(file.id)}
                  >
                    Submit 
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
