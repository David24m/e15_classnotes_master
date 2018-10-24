var React = require('react');
var ReactDOM = require('react-dom');
var MasterBox = require('./components/MasterBox.jsx');

window.onload = function(){
  ReactDOM.render(
    <MasterBox url='/api/characters/staff'></MasterBox>,
    document.getElementById('app')
  );
}
