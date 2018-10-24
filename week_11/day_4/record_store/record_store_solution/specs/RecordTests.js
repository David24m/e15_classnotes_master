var assert = require('assert');
var Record = require('../Record.js');

describe("Record Tests", function() {

  var nevermind;

  beforeEach(function(){
    nevermind = new Record("Nirvana", "Nevermind", "grunge", 9.99);
  });

  it("Record should have a name", function() {
    assert.equal(nevermind.artist, "Nirvana");
  });

  it("Record should have title", function() {
    assert.equal(nevermind.title, "Nevermind");
  });

  it("Record should have price", function() {
    assert.equal(nevermind.price, 9.99);
  });

  it("Record should have genre", function() {
    assert.equal(nevermind.genre, "grunge");
  });

  it("Prints out details as a string", function() {
    assert.equal(nevermind.prettyPrint(), "Artist: Nirvana, Title: Nevermind, Genre: grunge, Price: 9.99");
  });

})
