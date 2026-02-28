import React, { useState } from 'react';
import axios from 'axios';
import "./formCSS.css"
import { Navigate, useNavigate } from 'react-router-dom';

import StudentSideBar from "../../NevigationBar/StudentSideBar";



function FeedbackForm() {
    
    const navigate = useNavigate();


    const [id, setId] = useState();
    const [module, setModule] = useState("N\A")
    const [knowledge, setKnowledge] = useState('N\A');
    const [punctuality, setPunctuality] = useState('N\A');
    const [speed, setSpeed] = useState('N\A');
    const [suggestion, setSuggestion] = useState('N\A');
    const [infrastructure, setInfrastructure] = useState('N\A');
    const [cleanliness, setCleanliness] = useState('N\A');


    function handleSubmit(event) {
        event.preventDefault();

        console.log("in submit");
        const data = {
            id,
            module,
            knowledge,
            punctuality,
            speed,
            suggestion,
            infrastructure,
            cleanliness
        };

        axios.post('http://localhost:8080/feedback/submit', data)
            .then(response => {
                console.log(response.data);
                alert("Feedback submitted successfully..!")
                navigate("/studenthome")
                // handle success
            })
            .catch(error => {
                console.log(error.response.data);
                // handle error
            });
    }



    return (
        <>
              <div><StudentSideBar></StudentSideBar></div>

            <h2 className='feed' >Feedback Form</h2>
            <form className="feedback-form" onSubmit={handleSubmit}>
                
                <div className="form-group">
  <label htmlFor="module">Module Name:</label>
  <select required id="module" value={module} onChange={(e) => setModule(e.target.value)}>
    <option value="">Select a module</option>
    <option value="Core Java">Core Java</option>
    <option value="WPT">WPT</option>
    <option value="Data Structures">Data Structures</option>
    <option value="Dot Net">Dot Net</option>
    <option value="SDM">SDM</option>

    {/* Add more options as needed */}
  </select>
</div>
                <br />
                <div className="form-group">
                    <label required htmlFor="knowledge">Knowledge:</label>
                    <div required className="radio-group">
                        <input  type="radio" id="knowledge-bad" name="knowledge" value="bad" onChange={(e) => setKnowledge(e.target.value)} />
                        <label htmlFor="knowledge-bad">Bad</label>

                        <input type="radio" id="knowledge-good" name="knowledge" value="good" onChange={(e) => setKnowledge(e.target.value)} />
                        <label htmlFor="knowledge-good">Good</label>

                        <input type="radio" id="knowledge-better" name="knowledge" value="better" onChange={(e) => setKnowledge(e.target.value)} />
                        <label htmlFor="knowledge-better">Better</label>

                        <input type="radio" id="knowledge-best" name="knowledge" value="best" onChange={(e) => setKnowledge(e.target.value)} />
                        <label htmlFor="knowledge-best">Best</label>
                    </div>
                </div>
                <br />
                <div className="form-group">
                    <label htmlFor="punctuality">Punctuality:</label>
                    <div className="radio-group">
                        <input type="radio" id="punctuality-bad" name="punctuality" value="bad" onChange={(e) => setPunctuality(e.target.value)} />
                        <label htmlFor="punctuality-bad">Bad</label>

                        <input type="radio" id="punctuality-good" name="punctuality" value="good" onChange={(e) => setPunctuality(e.target.value)} />
                        <label htmlFor="punctuality-good">Good</label>

                        <input type="radio" id="punctuality-better" name="punctuality" value="better" onChange={(e) => setPunctuality(e.target.value)} />
                        <label htmlFor="punctuality-better">Better</label>

                        <input type="radio" id="punctuality-best" name="punctuality" value="best" onChange={(e) => setPunctuality(e.target.value)} />
                        <label htmlFor="punctuality-best">Best</label>
                    </div>
                </div>
                <br />
                <div className="form-group">
                    <label htmlFor="speed">Speed:</label>
                    <div className="radio-group">
                        <input type="radio" id="speed-bad" name="speed" value="bad" onChange={(e) => setSpeed(e.target.value)} />
                        <label htmlFor="speed-bad">Bad</label>

                        <input type="radio" id="speed-good" name="speed" value="good" onChange={(e) => setSpeed(e.target.value)} />
                        <label htmlFor="speed-good">Good</label>

                        <input type="radio" id="speed-better" name="speed" value="better" onChange={(e) => setSpeed(e.target.value)} />
                        <label htmlFor="speed-better">Better</label>

                        <input type="radio" id="speed-best" name="speed" value="best" onChange={(e) => setSpeed(e.target.value)} />
                        <label htmlFor="speed-best">Best</label>
                    </div>
                </div>
                <br />
                <div className="form-group">
                    <label htmlFor="infrastructure">Infrastructure:</label>
                    <div className="radio-group">
                        <input type="radio" id="infrastructure-bad" name="infrastructure" value="bad" onChange={(e) => setInfrastructure(e.target.value)} />
                        <label htmlFor="infrastructure-bad">Bad</label>

                        <input type="radio" id="infrastructure-good" name="infrastructure" value="good" onChange={(e) => setInfrastructure(e.target.value)} />
                        <label htmlFor="infrastructure-good">Good</label>

                        <input type="radio" id="infrastructure-better" name="infrastructure" value="better" onChange={(e) => setInfrastructure(e.target.value)} />
                        <label htmlFor="infrastructure-better">Better</label>

                        <input type="radio" id="infrastructure-best" name="infrastructure" value="best" onChange={(e) => setInfrastructure(e.target.value)} />
                        <label htmlFor="infrastructure-best">Best</label>
                    </div>
                </div>
                <br />
                <div className="form-group">
                    <label htmlFor="cleanliness">Cleanliness:</label>
                    <div className="radio-group">
                        <input type="radio" id="cleanliness-bad" name="cleanliness" value="bad" onChange={(e) => setCleanliness(e.target.value)} />
                        <label htmlFor="cleanliness-bad">Bad</label>

                        <input type="radio" id="cleanliness-good" name="cleanliness" value="good" onChange={(e) => setCleanliness(e.target.value)} />
                        <label htmlFor="cleanliness-good">Good</label>

                        <input type="radio" id="cleanliness-better" name="cleanliness" value="better" onChange={(e) => setCleanliness(e.target.value)} />
                        <label htmlFor="cleanliness-better">Better</label>

                        <input type="radio" id="cleanliness-best" name="cleanliness" value="cleanliness" onChange={(e) => setCleanliness(e.target.value)} />
                        <label htmlFor="cleanliness-best">Best</label>
                    </div>
                </div>
                <br />
                <div>
                    <label>
                        Suggestion:
                        <input type="text" value={suggestion} onChange={(e) => setSuggestion(e.target.value)} />
                    </label>
                </div>

                <br />
                <button type="submit">Submit Feedback</button>
            </form>
        </>
    );



}

export default FeedbackForm;