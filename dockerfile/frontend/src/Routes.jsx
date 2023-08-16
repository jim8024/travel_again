import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignIn from './SignIn';
import SignUp from './SignUp';
import App from './App';

export default function RouteApp() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<App/>} />
        <Route path="/signIn" element={<SignIn />} />
        <Route path="/signUp" element={<SignUp/>}/>
      </Routes>
    </Router>
  );
}