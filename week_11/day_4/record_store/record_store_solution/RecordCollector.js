function RecordCollector(name, cash) {
  this.name = name;
  this.collection = [];
  this.cash = cash;
}

RecordCollector.prototype.buyRecord = function (record) {
  if (this.cash < record.price) {
    return "Sorry you can't afford this record";
  }
  this.cash -= record.price;
  this.collection.push(record);
}

RecordCollector.prototype.sellRecord = function (record) {
  var recordIndex = this.collection.indexOf(record);
  this.collection.splice(recordIndex, 1);

  this.cash += record.price;
}

RecordCollector.prototype.totalValue = function(){
  var totalValue = this.collection.reduce(function(sum, record){
    return sum + record.price;
  }, 0)
  return totalValue;
}

RecordCollector.prototype.totalValueByGenre = function(genre){
  var recordsByGenre = this.collection.filter(function(record){
    return record.genre === genre;
  })
  var valueByGenre = recordsByGenre.reduce(function(sum, record){
    return sum + record.price;
  }, 0)
  return valueByGenre;

}

RecordCollector.prototype.sortRecordsByValue = function (){
  this.collection = this.collection.sort(function(a,b){
    return b.price - a.price;
  })
  return this.collection;
}

RecordCollector.prototype.mostValuableRecord = function() {
  var sortedCollection = this.sortRecordsByValue();
  return sortedCollection[0];
}

RecordCollector.prototype.compareCollection = function(collectorToCompare) {
  if(this.totalValue() > collectorToCompare.totalValue()){
    return this.name + "'s collection is more valuable";
  } else {
    return collectorToCompare.name + "'s collection is more valuable";
  }
}

module.exports = RecordCollector;
