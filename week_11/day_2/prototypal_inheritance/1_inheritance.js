// var myPerson = new Object();
//
// myPerson.talk = function () {
//   console.log('Hi');
// }
//
// myPerson.talk();

var wisePerson = {
  giveAdvice: function () {
    console.log('Git commit more often');
  }
}

// var blankObject = Object.create(null);

// console.log('blankObject', blankObject);

var inheritingPerson = Object.create(wisePerson);

inheritingPerson.talk = function () {
  console.log('Hi');
}

console.log('inheritingPerson', inheritingPerson);

inheritingPerson.talk();
inheritingPerson.giveAdvice();
