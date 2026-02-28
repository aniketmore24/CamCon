import React, { useState } from 'react';
import axios from 'axios';
import './AddNoCSS.css';

export default function AddNotice(props) {
    const [title, setTitle] = useState('');
  const [content, setDescription] = useState('');
  const [date, setDate] = useState(new Date());

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleDescriptionChange = (event) => {
    setDescription(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    axios.post('http://localhost:8080/noticeBoard/addNotice', { title, content, date })
      .then((response) => {
        console.log(response.data);
       // props.notices.push(response.data)
       props.addnotice(response.data)
      })
      .catch((error) => {
        console.error(error);
      });

     // props.useEffect();
  };

  return (
    <form onSubmit={handleSubmit} className="notice-form">
      <label>
        Title:
        <input type="text" className="field" value={title} onChange={handleTitleChange} />
      </label>
      <br />
      <label>
        Description:
        <textarea value={content} className="field" onChange={handleDescriptionChange} />
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  );
}
