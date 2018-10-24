var Cat = function(name) {
  this.name = name;
};
Cat.prototype.pet = function() {
  console.log(this.name + ' purrs');
}

var myCat = new Cat('Garfield');
myCat.click();

var unboundPet = myCat.pet;
unboundPet();

var boundPet = myCat.pet.bind(myCat);
boundPet();
console.log("hey")
