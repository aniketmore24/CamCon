import React, { useState, useEffect } from "react";
import axios from "axios";

export default function TestDownload() {


    // const handleFileDownload = (name) => {
    //     console.log("before");
    //     axios({
            
    //       url: `http://localhost:8080/file/download/63fe552d3901403d56f1700d`,
    //       method: "GET",
    //       responseType: "blob",
    //     }).then(response =>  {
    
    //         console.log("after");

    //       const blob = new Blob([response.data], { type: "text/plain" });
    //       const url = window.URL.createObjectURL(blob);
    //       const link = document.createElement("a");
    //       link.href = url;
    //       link.setAttribute("download", name);
    //       document.body.appendChild(link);
    //       link.click();
    //       console.log("after222");

    //     });
    //   };

   // const [pdfLink, setPdfLink] = useState(null);

   const [pdfLink, setPdfLink] = useState(null);

   const handleDownloadPdf = async () => {
     try {
       const response = await fetch('http://localhost:8080/file/download/6401f102993b1b2c29b7eade', {
         method: 'GET',
         headers: {
           'Content-Type': 'application/pdf',
         },
       });
       const blob = await response.blob();
       const url = URL.createObjectURL(blob);
       setPdfLink(url);
       handleDownloadClick();
     } catch (error) {
       console.error(error);
     }
   };
 
   const handleDownloadClick = () => {
     const link = document.createElement('a');
     link.href = pdfLink;
     link.setAttribute('download', 'file-description.pdf');
     document.body.appendChild(link);
     link.click();
   };
 
   return (
     <div>
       <button onClick={handleDownloadPdf}>Download PDF</button>
       {/* {pdfLink && (
         <button onClick={handleDownloadClick}>Download File</button>
       )} */}
     </div>
   );
 }
 
