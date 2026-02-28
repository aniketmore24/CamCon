import React from 'react'
import NoticeDisplayStudent from "./NoticeDisplayStudent";
import { useState, useEffect } from 'react';
import axios from 'axios';
import StudentSideBar from '../../NevigationBar/StudentSideBar';

export default function NoticeGet() {
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
      
  
    const [notices, setNotices] = useState([
        // { id: 1, title: 'Notice 1', description: 'This is notice 1sdddddddddddddddddddddddddddddddddddddddddddddddddddddd', date: '2022-02-28' },
        // { id: 2, title: 'Notice 2', description: 'This is notice 2ddddddddddddddddddddddddddddddddddddddddddddddddss', date: '2022-03-01' },
        // { id: 3, title: 'Notice 3', description: 'This is notice 3aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', date: '2022-03-02' },
      ]);
    
      return (
        
        <div>
          <div><StudentSideBar></StudentSideBar></div>
          
          <NoticeDisplayStudent notices={notices} ></NoticeDisplayStudent>
          </div>
      );
  
}
