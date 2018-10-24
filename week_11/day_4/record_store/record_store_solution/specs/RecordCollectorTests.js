var assert = require("assert");
var RecordCollector = require("../RecordCollector.js");
var RecordStore = require("../RecordStore.js");
var Record = require("../Record.js");

describe("Record Collector", function() {

  var recordStore;
  var record;
  var record2;
  var recordCollector;

  beforeEach("Setup", function() {
    recordStore = new RecordStore("Zsolt Healy's Records", "Edinburgh");
    record = new Record("Nirvana", "Nevermind", "grunge", 10);
    record2 = new Record("Red Hot Chilli Peppers", "By The Way", "rock", 7.50);
    record3 = new Record("AC/DC", "Highway to hell", "rock", 7.50);
    recordCollector = new RecordCollector("Craig", 8.00);
  });

  it("has cash of 8.00", function() {
    assert.strictEqual(recordCollector.cash, 8.00);
  });

  it("can buy a record", function() {
    recordCollector.buyRecord(record2);
    assert.strictEqual(recordCollector.collection.length, 1);
  });

  it("cash goes down when buying record", function() {
    recordCollector.buyRecord(record2);
    assert.strictEqual(recordCollector.cash, 0.50);
  });

  it("can't buy record if not enough cash", function() {
    assert.strictEqual(recordCollector.buyRecord(record), "Sorry you can't afford this record");
    assert.strictEqual(recordCollector.collection.length, 0);
  });

  it("can sell record", function() {
    recordCollector.buyRecord(record2);
    recordCollector.sellRecord(record2);
    assert.strictEqual(recordCollector.collection.length, 0);
  });

  it("cash increases when selling", function() {
    recordCollector.buyRecord(record2);
    recordCollector.sellRecord(record2);
    assert.strictEqual(recordCollector.cash, 8.00);
  });

  it("can find total value of collection", function() {
    recordCollector.cash = 100
    recordCollector.buyRecord(record);
    recordCollector.buyRecord(record2);
    assert.strictEqual(recordCollector.totalValue(), 17.50);
  });

  it("can find total value of a given genre", function() {
    recordCollector.cash = 100
    recordCollector.buyRecord(record2);
    recordCollector.buyRecord(record3);
    assert.strictEqual(recordCollector.totalValueByGenre("rock"), 15);
  });

  it("can sort their records by value", function() {
    recordCollector.cash = 100
    recordCollector.buyRecord(record2);
    recordCollector.buyRecord(record);
    assert.deepStrictEqual(recordCollector.sortRecordsByValue(), [record, record2]);
  });

  it("can find the most valuable record", function() {
    recordCollector.cash = 100
    recordCollector.buyRecord(record);
    recordCollector.buyRecord(record3);
    assert.deepStrictEqual(recordCollector.mostValuableRecord(), record);
  });

  it("can compare value with another collector", function() {
    recordCollector.cash = 100
    recordCollector.buyRecord(record);
    recordCollector.buyRecord(record3);
    var recordCollector2 = new RecordCollector("Alex", 10);
    recordCollector2.buyRecord(record2);
    assert.strictEqual(recordCollector.compareCollection(recordCollector2), "Craig's collection is more valuable");
  });

})
