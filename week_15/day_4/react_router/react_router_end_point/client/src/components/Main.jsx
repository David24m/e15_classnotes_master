import React, { Component } from 'react'
import {Link} from 'react-router-dom'

class Main extends Component {
  

  render() {
 
    return (
      <div>
        <h4>Main App</h4>
        <ul>
          <li><Link to="/home">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/pricing">Pricing</Link></li>
        </ul>
     
      </div>
    )
  }

  
}


export default Main
