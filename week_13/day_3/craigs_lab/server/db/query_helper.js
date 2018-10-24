var MongoClient = require('mongodb').MongoClient

var QueryHelper = function (dbUrl, collectionName) {
    this.dbUrl = dbUrl
    this.collectionName = collectionName
}

QueryHelper.prototype.all = function (onQueryComplete) {
  MongoClient.connect(this.dbUrl, function (err, db) {
    if (err) {
      console.error('Could not access DB - MongoClient threw an error:', err.message)
      onQueryComplete({error: 'Could not access database'})
    }
    var collection = db.collection(this.collectionName)
    collection.find().toArray(function (err, docs) {
      onQueryComplete(docs)
    })
  }.bind(this))
}

QueryHelper.prototype.save = function (data, onQueryComplete) {
  MongoClient.connect(this.dbUrl, function (err, db) {
    if (err) {
      console.error('Could not access DB - MongoClient threw an error:', err.message)
      onQueryComplete({error: 'Could not access database'})
    }
    var collection = db.collection(this.collectionName)
    collection.insert(data)
    collection.find().toArray(function (err, updatedDocs) {
      onQueryComplete(updatedDocs)
    })
  }.bind(this))

}


module.exports = QueryHelper
