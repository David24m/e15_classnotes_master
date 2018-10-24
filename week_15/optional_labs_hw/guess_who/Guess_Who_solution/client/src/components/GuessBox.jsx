var React = require('react');

var GuessBox = React.createClass({

  buttonClick: function(e){
    var chosenCharacter = document.getElementById("guessCharacter").value;
    var winAnswer = document.getElementById("winAnswer");

    if(this.props.winChecker.checkForWin(chosenCharacter, this.props.opponentCharacter)){
      winAnswer.innerText = "Correct! You win!!";
      winAnswer.style.color = "#84c103";
    }
    else {
      winAnswer.innerText = "Wrong, you lose!";
      winAnswer.style.color = "#D50A1E";
    }

  },

  render: function(){

    var dropDownOptions = this.props.characters.map(function(character, index){
      return(
        <option value={character.name} key={index}>{character.name}</option>
        )
    });

    return(
      <div id="guessBox">
      Make a Guess:
      <select id="guessCharacter">
      {dropDownOptions}
      </select>
      <button className="guessButton" onClick={this.buttonClick}>Guess!</button>
      <div id="winAnswer"></div>
      </div>
      )
  }
});


module.exports = GuessBox;