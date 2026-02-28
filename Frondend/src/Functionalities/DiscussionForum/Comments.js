import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import "./CommentsCSS.css"
import StudentSideBar from "../../NevigationBar/StudentSideBar";
import 'bootstrap/dist/css/bootstrap.min.css'; 

export default function Comments({match}) {
    const [topic, setTopic] = useState(null);
    
    const [comments, setComments] = useState([ {
        id: 1,
        text: "I agree with the points made in the original post.",
        date: "2022-05-01T14:30:00.000Z",
        author: "John Doe"
      }]);
    const [newCommentText, setNewCommentText] = useState("");
  
    const { id } = useParams();
    //.log(match.params.id);
    //const topicId = match.params.id;
  

    // To get Topic List
    useEffect(() => {
      axios
        .get(`http://localhost:8080/Discuss/findTopicById/${id}`)
        .then((response) => {
          setTopic(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
  
        // To get CommentList of selected topic by id
      axios
        .get(`http://localhost:8080/Post/getposts/${id}`)
        .then((response) => {
          setComments(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }, [id]);
  
    const handleNewCommentTextChange = (event) => {

      setNewCommentText(event.target.value);
    };
  
   const handleNewCommentSubmit = (event) => {
     event.preventDefault();console.log(sessionStorage.getItem("id"));
     console.log(sessionStorage.getItem("sname"))
     console.log(sessionStorage.getItem("username"))
     
      axios
        .post(`http://localhost:8080/Post/addPost`, {
          
            postContent: newCommentText,
            discussionTopic:  { "topicId" : id},
            author : sessionStorage.getItem("sname"),
           // console.log(sessionStorage.getItem("sname")),
           // author : "Aniket",
            students :{
            //"id" : sessionStorage.getItem("id")
              "studId":1},

             date : new Date()

        })
        .then((response) => {
          setComments([...comments, response.data]);
          setNewCommentText("");
        })
        .catch((error) => {
          console.error(error);
        });
   };
  
    // const handleNewCommentSubmit = (event) => {
    //     event.preventDefault();
    //     let newcomment = newCommentText
    //     console.log(newcomment);
    //     setComments([...comments, newcomment]);
    //   };


    return (
        <>    <div><StudentSideBar></StudentSideBar></div>
   
   <div className="whole">
      <h1>Discussion Forum</h1>
      <div className="container my-5">
        <div className="row">
          <div className="col-md-8">
            {topic && (
              <div className="card mb-3">
                <div className="card-body, desc">
                  <h3 className="card-title">{topic.topic}</h3>
                  <h5 className="card-text">{topic.description}</h5>
                </div>
              </div>
            )}
            <div className="card mb-3">
              <div className="card-body">
                <h3 className="card-title">Comments</h3>
                <ul className="list-group list-group-flush">
                  {comments.map((comment, index) => (
                    <li key={comment.id} className={`list-group-item ${index % 2 === 0 ? 'bg-muted':'bg-form'} rounded-3`}>
                      <h6 className="card-text">{comment.postContent}</h6>
                      <div className="d-flex justify-content-between">
                        <span className="text-muted">{comment.author}</span>
                        <span className="text-muted">{comment.date}</span>
                      </div>
                    </li>
                  ))}
                </ul>
              </div>
            </div>
            <div className="card mb-3">
              <div className="card-body">
                <form onSubmit={handleNewCommentSubmit}>
                  <div className="form-group">
                    <label htmlFor="new-comment-text">Add a new comment:</label>
                    <textarea
                      className="form-control"
                      id="new-comment-text"
                      value={newCommentText}
                      onChange={handleNewCommentTextChange}
                    ></textarea>
                  </div>
                  <button type="submit" className="btn btn-primary">Submit</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
    </>
    );
}
