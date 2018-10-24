function sayHello(name) {

}

function () {

}

sayHello('Craig')



var myObject = {};

var anotherObject = new Object();

var person1 = {
  name: 'Zsolt',
  height: 'magnificently tall'
}

var person2 = {
  name: 'Craig',
  height: 'just kinda tall'
}

var Person = function (name, height, job) {
  this.name = name;
  this.height = height;



  this.talk = function () {
    console.log("Hi, I'm " + this.name)
  }
}

var person3 = new Person('Zsolt', 190);
var person4 = new Person('Craig', 180);

person3.talk();

// console.log(person3)

// var brokenPerson = new Person('Craig', null, 'instructor');

// console.log(brokenPerson);

// var randomFunction = function (name) {
//   this.name = name;
// }
//
//
// var object = randomFunction();
//
// console.log(object)
