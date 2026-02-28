
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Routing from './Routing/Routing';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import LoginAuth from "./Login/loginAuth";
import StudentHome from './Home/StudentHome';
import FacultyHome from './Home/FacultyHome';



function App() {
  return (
    <div
    >
    
    <BrowserRouter>
     <Routing></Routing>
    </BrowserRouter>
    </div>
  );
}

export default App;
