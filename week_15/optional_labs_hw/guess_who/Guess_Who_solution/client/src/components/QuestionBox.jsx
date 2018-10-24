var React = require('react');

var QuestionBox = React.createClass({

  questionButtonClick: function(e){
    var chosenOption = document.getElementById("optionSelect").value;
    var chosenCharacteristic = document.getElementById("questionSelect").value;
    var answer = document.getElementById("answer");
    if(chosenOption === String(this.props.opponentCharacter[chosenCharacteristic])){
      answer.innerText = "Yes!";
      answer.style.color = "#84c103";
    }
    else {
      answer.innerText = "No.";
      answer.style.color = "#D50A1E";
    }
  },

  populateSelectOptions: function(event){
    var selectedCharacteristic = document.getElementById("questionSelect").value;
    var optionSelect = document.getElementById("optionSelect");
    var answer = document.getElementById("answer");
    answer.innerText = "";

    var getOptions = function(option){
     var optionList = [];
     for(var character of this.props.characters){
      if(!optionList.includes(character[option])){
        optionList.push(character[option]);
      }
    }

    var optionString = "";
    for(var option of optionList){
     optionString += "<option value='" + option + "'>" + option + "</option>";
   }
   return optionString;
 }.bind(this);

 if(selectedCharacteristic == "Choose characteristic:"){
  optionSelect.innerHTML = "<option>Choose an option:</option>"
}
else {
  optionSelect.innerHTML = getOptions(selectedCharacteristic);
}

},

getProperties: function(obj){
  var keys = [];
  for(var key in obj){
   keys.push(key);
 }
 return keys;
},

render: function(){


  var properties = this.getProperties(this.props.characters[0]);
  var propertyOptions = properties.map(function(property, index){
    if(property == "image" || property == "name" || property == "flipped"){
      return
    }
    return(
      <option value={property} key={index}>{property}</option>
      )
  });

  return(
    <div>
    Guess a characteristic: 
    <select id="questionSelect" onChange={this.populateSelectOptions}>
    <option>Choose characteristic:</option>
    {propertyOptions}
    </select>

    <select id="optionSelect">
    <option>Choose an option:</option>
    </select>

    <button onClick={this.questionButtonClick}>Do they have this?</button> 
    <span id="answer"></span>
    </div>
    )
}
});


module.exports = QuestionBox;