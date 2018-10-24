import React from 'react';
import ReactDOM from 'react-dom';
import PiggyBank from './components/PiggyBank';

window.onload = function(){
  ReactDOM.render(
    <PiggyBank
        title="Beth's Money Pig"
        owner="Beth"
        depositAmount={5} />,
    document.getElementById('app')
  );
}
