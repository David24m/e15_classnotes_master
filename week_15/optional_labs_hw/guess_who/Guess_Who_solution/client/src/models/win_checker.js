var winChecker = {
  checkForWin: function(guessedName, chosenCharacter){

    if(guessedName === chosenCharacter.name){
      return true;
    }
    return false;
  }
}

module.exports = winChecker;