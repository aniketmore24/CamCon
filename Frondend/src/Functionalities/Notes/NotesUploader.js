
import React, { useState } from 'react';
import axios from 'axios';
import "./UploaderCSS.css"


export default function AssUploader() {
  
    
    const [selectedFile, setSelectedFile] = useState(null);

  const handleFileInput = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleFileUpload = () => {
    const formData = new FormData();
    formData.append('file', selectedFile);

    axios.post('http://localhost:8080/file/upload', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div className="file-uploader">
        <h5>Upload new Assignment</h5>
      <input type="file" onChange={handleFileInput} className="file-input" />
      <button onClick={handleFileUpload} className="file-upload-btn">Upload</button>
    </div>
  );
}
