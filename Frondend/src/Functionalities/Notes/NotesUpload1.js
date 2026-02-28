import React, { useState, useEffect} from "react";
import axios from "axios";
import { useParams } from 'react-router-dom';
import "./DownloadCSS.css";
import NoUploader from "./NoUploader";
import { saveAs } from 'file-saver';
import $ from "jquery";
import FacultySideBar from "../../NevigationBar/FacultySideBar ";


export default function AssignmentsUpload1() {
  const [files, setFiles] = useState([]);
 // const [pdfLink, setPdfLink] = useState(null);
 const { id } = useParams();


  useEffect(() => {
    console.log("module "+id);
    axios.get(`http://localhost:8080/notes/getbyid/${id}`).then((response) => {
      console.log(response.data);
      
    setFiles(response.data);
    });
  }, []);

  // const handleFileDownload = async (id, fileName) => {
  //   console.log("Assign id :"+id);
  //   try {
  //     const response = await fetch('http://localhost:8080/file/download/${id}', {
  //       method: 'GET',
  //       headers: {
  //         'Content-Type': 'application/pdf',
  //       },
  //     });

  //     console.log("After Axios Assign id :"+id);

  //    // console.log(response.data.fileName);
  //     const blob = await response.blob();
  //     const url = URL.createObjectURL(blob);
  //     setPdfLink(url);
  //     handleDownloadClick(fileName);
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // const handleDownloadClick = (fileName) => {
  //   const link = document.createElement('a');
  //   link.href = pdfLink;
  //   link.setAttribute('download', fileName);
  //   document.body.appendChild(link);
  //   link.click();
  // };


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


  return (
    <>
    <div><FacultySideBar></FacultySideBar></div>

    <div className="file-table">
    <h2>Notes</h2>

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
                  onClick={() => handleFileDownload(file.id, file.fileName)}
                >
                  Download
                </button>
                
              </td>
              
            </tr>
          ))}
        </tbody>
      </table>
      <NoUploader id={id}></NoUploader>
    </div>
    </>
  );
}
