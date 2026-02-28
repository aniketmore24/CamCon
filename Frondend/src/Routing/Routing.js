import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import LoginAuth from "../Login/loginAuth";
import StudentHome from '../Home/StudentHome';
import FacultyHome from '../Home/FacultyHome';
import Test from '../Home/Test';
import NoticeGet from '../Functionalities/NoticeBoard/NoticeGet';
import AssignmentDownload1 from '../Functionalities/Assignments/AssignmentDownload1';
import ModulesDownload from '../Functionalities/Assignments/ModulesDownload';
import ModulesUpload from "../Functionalities/Assignments/ModulesUpload"
import AssignmentsUpload1 from '../Functionalities/Assignments/AssignmentsUpload1';
import NoticeAdd from '../Functionalities/NoticeBoard/NoticeAdd';
import TestDownload from '../Test/TestDownload';
import TopicList from '../Functionalities/DiscussionForum/TopicList';
import Comments from '../Functionalities/DiscussionForum/Comments';
import NModulesDownload from '../Functionalities/Notes/NModulesDownload';
import NotesDownload1 from '../Functionalities/Notes/NotesDownload1';
import NModulesUpload from '../Functionalities/Notes/NModulesUpload';
import NotesUpload1 from '../Functionalities/Notes/NotesUpload1';
import AddStudent from '../Admin/AddStudent';
import AddFaculty from '../Admin/AddFaculty';
import AddModule from '../Admin/AddModule';
import ViewAnswers from '../Functionalities/Assignments/ViewAnswers';
import SideBar1 from '../Test/Side';
import ViewStudents from '../Admin/ViewStudents';
import AboutUs from '../Home/AboutUS';
import Logout from '../Login/Logout';
import FeedbackForm from '../Functionalities/Feedback/feedback';
import FeedbackTable from '../Functionalities/Feedback/AdminFeedback'
import FeedModules from '../Functionalities/Feedback/FeedModules';
import AdminHome from '../Home/AdminHome';




export default function Routing() {
  return (
    
    
   
        <Routes>

        <Route exact path="home" element={<LoginAuth />}></Route>
        <Route path="/studenthome" element={<StudentHome/>}></Route>
        <Route path="FacultyHome" element={<FacultyHome/>}></Route>
        <Route path="Notice" element={<NoticeGet/>}></Route>
        <Route path="/AssignmentDownload" element={<ModulesDownload/>}></Route>
        <Route path="/assignment/:id" element={<AssignmentDownload1/>}></Route>
        <Route path="/AssignmentUpload" element={<ModulesUpload/>}></Route>
        <Route path="/AssignmentsUpload/:id" element={<AssignmentsUpload1/>}></Route>
        <Route path="AddNotice" element={<NoticeAdd/>}></Route>
        <Route path="TestD" element={<TestDownload/>}></Route>
        <Route path="Discussion" element={<TopicList/>}></Route>
        <Route path="Comments/:id" element={<Comments/>}></Route>
        <Route path="NotesDownload" element={<NModulesDownload/>}></Route>
        <Route path="/NotesDownload/:id" element={<NotesDownload1/>}></Route>
        <Route path="NotesUpload" element={<NModulesUpload/>}></Route>
        <Route path="/NotesUpload/:id" element={<NotesUpload1/>}></Route>
        <Route path="/AddStudent" element={<AddStudent/>}></Route>
        <Route path="/AddFaculty" element={<AddFaculty/>}></Route>
        <Route path="/AddModule" element={<AddModule/>}></Route>
        <Route path="/viewanswers/:id" element={<ViewAnswers/>}></Route>
        <Route path="/side" element={<SideBar1/>}></Route>
        <Route path="/viewstudents" element={<ViewStudents/>}></Route>
        <Route path="/about" element={<AboutUs/>}></Route>
        <Route path="/logout" element={<Logout/>}></Route>
        <Route path="/feedbackform" element={<FeedbackForm/>}></Route>
        <Route path="/showfeedback" element={<FeedModules/>}></Route>
        <Route path="/feedback/:name" element={<FeedbackTable/>}></Route>
        <Route path="/AdminHome" element={<AdminHome/>}></Route>






        



        
        





        </Routes>

   
    
  )
}
