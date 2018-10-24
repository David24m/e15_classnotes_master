import React from 'react';
import ReactDOM from 'react-dom';
import TicTacToe from './containers/TicTacToe';

window.addEventListener('DOMContentLoaded', () => {
  const app = document.getElementById('app');
  ReactDOM.render(<TicTacToe/>, app);
});