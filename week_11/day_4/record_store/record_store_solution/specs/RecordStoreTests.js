var assert = require("assert");
var RecordStore = require("../RecordStore");
var Record = require("../Record.js");

describe("Record Store tests", function() {

  var recordStore;
  var record;
  var record2;

  beforeEach("Setup", function(){
    recordStore = new RecordStore("Zsolt Healy's Records", "Edinburgh");
    record = new Record("Nirvana", "Nevermind", "grunge", 9.99);
    record2 = new Record("Red Hot Chilli Peppers", "By The Way", "rock", 7.99);

  });

  it("Should have a name", function() {
    assert.strictEqual(recordStore.name, "Zsolt Healy's Records");
  });

  it("Should have a city", function() {
    assert.strictEqual(recordStore.city, "Edinburgh");
  });

  it("Should start with an empty inventory", function() {
    assert.strictEqual(recordStore.inventory.length, 0);
  });

  it("Should have a balance that starts at 0", function() {
    assert.strictEqual(recordStore.balance, 0);
  });

  it("Should be able to add a record to the inventory", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    assert.strictEqual(recordStore.inventory.length, 2);
  });

  it("Should be able to list the inventory", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    assert.strictEqual(recordStore.listInventory()[0], "Artist: Nirvana, Title: Nevermind, Genre: grunge, Price: 9.99");
  });

  it("can sell a record", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    recordStore.sellRecord(record2);
    assert.strictEqual(recordStore.inventory.length, 1);
  });

  it("balance should increase when selling record", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    recordStore.sellRecord(record2);
    assert.strictEqual(recordStore.balance, 7.99);
  });

  it("can report on finances", function() {
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    assert.strictEqual(recordStore.financeReport(), "Current Balance: 0 Current Stock Value: 17.98");
  });

  it("can return records of a given genre", function(){
    recordStore.addRecord(record);
    recordStore.addRecord(record2);
    var grungeRecords = recordStore.findRecordsByGenre("grunge");
    var expected = [record]
    assert.deepStrictEqual(grungeRecords, expected);
  });

})
