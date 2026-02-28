import React from 'react'
import NoticeDisplay from "./NoticeDisplay";
import { useState, useEffect } from 'react';
import axios from 'axios';
import StudentSideBar from '../../NevigationBar/StudentSideBar';
import AddNotice from './AddNotice';
import FacultySideBar from '../../NevigationBar/FacultySideBar ';


export default function NoticeGet() {

  const [notices, setNotices] = useState([]);


  useEffect(() => {
        const fetchNotices = async () => {
          try {
            console.log("before axios");
            const response = await axios.get('http://localhost:8080/noticeBoard/getAll');
            console.log("after axios");

            console.log(response.data);
            setNotices(response.data);
          } catch (error) {
            console.log(error);
          }
        };
        fetchNotices();
      }, []);
      

      // Using Lifting state up to instantly reflect add/delete notice operations
      const handleDelete = (id) => {

        const updatedNotices = notices.filter(notice => notice.noticeId !== id);
        
        setNotices(updatedNotices);
      };


      const handleAdd = (notice)=>{

        setNotices([...notices, notice])
      }
      
  
   
    
      return (
        
        <div>
          <div><FacultySideBar></FacultySideBar></div>
          
          <NoticeDisplay  notices={notices} deletenotice={handleDelete}  ></NoticeDisplay>
          <AddNotice addnotice={handleAdd} notice={notices} ></AddNotice>
          </div>
      );
  
}
