
import React, { useState } from 'react';
import axios from 'axios';
import "./UploaderCSS.css"


export default function AssUploader(props) {
  
    
    const [selectedFile, setSelectedFile] = useState(null);
    const id = props.id;

  const handleFileInput = (event) => {

    console.log("in file input");
    setSelectedFile(event.target.files[0]);
  };

  const handleFileUpload = () => {
    const formData = new FormData();
    formData.append('file', selectedFile);
    formData.append("moduleId", id)



    axios.post('http://localhost:8080/file/upload', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then((response) => {
        console.log(response.data);
        console.log("Upload done");
       // props.instantUpload(response.data)
       alert("Upload Successfull..!")
      })
      .catch((error) => {
        console.error(error);
        alert("Couldn't upload file")
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
