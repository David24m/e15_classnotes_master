var Fish = function (name, colour) {
  this.name = name;
  this.colour = colour;

  this.swim = function () {
    console.log('splash');
  }
}

var nemo = new Fish('Nemo', 'orange');

// nemo.swim();
// console.log(nemo);



var Fish = function (name, colour) {
  this.name = name;
  this.colour = colour;
}

Fish.prototype.swim = function () {
  console.log('splash');
}

Fish.prototype.eat = function (food) {
  console.log('yummy ' + food)
}

var nemo = new Fish('Nemo', 'orange');

nemo.swim();
console.log(nemo);










// getPrototypeOf is ES6
console.log('Fish proto', Object.getPrototypeOf(nemo) );

// ES5 version
nemo.__proto__
