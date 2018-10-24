var MongoClient = require('mongodb').MongoClient

var getAllFlowers = function (takeThisData) {
  MongoClient.connect('mongodb://localhost:27017/garden', function (err, db) {
    db.collection('flowers').find().toArray(function (err, docs) {
      console.log('docs:', docs)

      takeThisData(docs)
    })
  })
}

module.exports = getAllFlowers
