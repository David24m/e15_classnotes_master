import React from 'react';
import ReactDOM from 'react-dom';
import CommentBox from './components/CommentBox';


window.addEventListener('DOMContentLoaded', () => {
  ReactDOM.render(
    <CommentBox/>,
    document.getElementById('app')
  )
});
