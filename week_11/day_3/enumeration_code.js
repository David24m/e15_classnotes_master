// We have an array of numbers
var numbers = [1, 2, 3, 4, 5];

// We can loop through this array with a for loop
for (var item of numbers) {
  console.log('the number is ' + item);
}

// Web can use the Array method forEach to loop through them
// by passing forEach a callback function
numbers.forEach(function (number) {
  console.log('the number is ' + number);
});

// We can store this function in a variable and pass it in later if we want
var printNumber = function (number) {
  console.log('the number is ' + number)
}

numbers.forEach(printNumber);

// Behind the scenes of forEach, what's happening in there?
var ourForEach = function (array, callback) {
  for (var item of array) {
    callback(item)
  }
}

ourForEach(numbers, printNumber);

//////////////////////////////////






// Extra stuff from question about looping through objects / hashes
var object = {
  a: 1,
  b: 2,
  c: 3
}

var keys = Object.keys(object)

keys.forEach(function (key) {
  console.log('key: ' + key)
  var value = object[key]
  console.log('value: ' + value)
})
