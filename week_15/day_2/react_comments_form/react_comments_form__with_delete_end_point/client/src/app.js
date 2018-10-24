import React from 'react'
import ReactDOM from 'react-dom'
import CommentBox from './components/CommentBox.jsx'

window.onload = () => {
  ReactDOM.render(
    <CommentBox/>,
    document.getElementById('app')
  )
}
