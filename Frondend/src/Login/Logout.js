import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import "./logoutCSS.css"


export default function Logout() {
    const navigate = useNavigate();

  useEffect(() => {
    
    sessionStorage.clear();
   
    console.log('User logged out.');
    navigate('/home');
  }, []);

  return (
    <div>
      <h1>Logging Out...</h1>
      <p>Please wait while we log you out of the website.</p>
    </div>
  );
}



