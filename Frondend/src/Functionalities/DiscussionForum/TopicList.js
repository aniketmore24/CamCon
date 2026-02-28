import React, { useState, useEffect } from "react";
import axios from "axios";
import "./TopicCSS.css"
import StudentSideBar from "../../NevigationBar/StudentSideBar";
import { Link } from "react-router-dom";


export default function TopicList() {
    const [topics, setTopics] = useState([ { id: 1, topic: "React vs Angular", description: "Which is better for web development?" },
    { id: 2, topic: "Favorite JavaScript libraries", description: "What are your favorite JS libraries and why?" },
    { id: 3, topic: "CSS frameworks", description: "What CSS frameworks do you use and recommend?" },
  ]);
    const [showNewTopicForm, setShowNewTopicForm] = useState(false);
    const [newTopicTitle, setNewTopicTitle] = useState("");
    const [newTopicDescription, setNewTopicDescription] = useState("");
  
    useEffect(() => {
      axios
        .get("http://localhost:8080/Discuss/getAll")
        .then((response) => {
          setTopics(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }, []);
  
    const handleNewTopicTitleChange = (event) => {
      setNewTopicTitle(event.target.value);
    };
  
    const handleNewTopicDescriptionChange = (event) => {
      setNewTopicDescription(event.target.value);
    };
  
    const handleNewTopicSubmit = (event) => {
      event.preventDefault();
      axios
        .post("http://localhost:8080/Discuss/CreateNewTopic", {
          topic: newTopicTitle,
          description: newTopicDescription,
        })
        .then((response) => {
          setTopics([...topics, response.data]);
          setNewTopicTitle("aa");
          setNewTopicDescription("bb");
          setShowNewTopicForm(false);
        })
        .catch((error) => {
          console.error(error);
        });

    // let newtopic ={topic:newTopicTitle , description: newTopicDescription}
    // setTopics([...topics, newtopic]);
    // setShowNewTopicForm(false);
    };
  
    const handleNewTopicClick = () => {
      setShowNewTopicForm(true);
    };
  
    return (

        <>    <div><StudentSideBar></StudentSideBar></div>
      <div className="topics-wrapper">
       <h2 >Discussion Forum</h2>
        {showNewTopicForm ? (
          <>
          <h3>Add New Topic</h3>
          <form class="addtopic" onSubmit={handleNewTopicSubmit}>
            <label>
              Topic Title:
              <input
                type="text"
                value={newTopicTitle}
                onChange={handleNewTopicTitleChange}
              />
            </label>
            <br />
            <label>
              Topic Description:
              <textarea
                value={newTopicDescription}
                onChange={handleNewTopicDescriptionChange}
              ></textarea>
            </label>
            <br />
            <button type="submit" className="sub">Submit</button>
            <button type="submit" className="cancel" onClick={() => setShowNewTopicForm(false)}>Cancel</button>
          </form>
          </>
        ) : (
          <button type="submit" className="sub" onClick={handleNewTopicClick}>Add New Topic</button>
        )}
        <table className="topics-table">
          <thead >
            <tr>
              <th className="headings">ID</th>
              <th className="headings">Topic</th>
              <th className="headings">Description</th>
            </tr>
          </thead>
          <tbody>
            {topics.map((topic) => (
              <tr key={topic.topicId} className="topic-row">
                <td>{topic.topicId}</td>
                <td>
                  <Link to={`/Comments/${topic.topicId}`}>{topic.topic}</Link>
                </td>            
                 <td>{topic.description}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      </>
    );
  }

