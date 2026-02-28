import React, { useState, useEffect } from "react";
import axios from "axios";
import AdminSidBar from "../../NevigationBar/AdminSidBar"
import { useParams } from 'react-router-dom';


import "./FeedbackTable.css";

function FeedbackTable() {

  const { name } = useParams();
  const [feedback, setFeedback] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/feedback/getbymodule/${name}`).then((response) => {
      setFeedback(response.data);
      console.log(response.data);
    });
  }, []);

  // Group feedback items by module
  const modules = feedback.reduce((acc, item) => {
    if (acc[item.module]) {
      acc[item.module].push(item);
    } else {
      acc[item.module] = [item];
    }
    return acc;
  }, {});

  return (
    <>
              <AdminSidBar></AdminSidBar>

    <div className="feedback-table">
      
      {Object.entries(modules).map(([module, items]) => (
        <div className="feedback-module" key={module}>
          <h3 className="head">{module} Feedback</h3>
          <table>
            <thead>
              <tr>
                <th>Knowledge</th>
                <th>Punctuality</th>
                <th>Speed</th>
                
                <th>Infrastructure</th>
                <th>Cleanliness</th>
                <th>Suggestion</th>
              </tr>
            </thead>
            <tbody>
              {items.map((item, index) => (
                <tr className="feedback-item" key={index}>
                  <td>{item.knowledge}</td>
                  <td>{item.punctuality}</td>
                  <td>{item.speed}</td>
                 
                  <td>{item.infrastructure}</td>
                  <td>{item.cleanliness}</td>
                  <td>{item.suggestion}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ))}
    </div>
    </>
  );
}

export default FeedbackTable;
