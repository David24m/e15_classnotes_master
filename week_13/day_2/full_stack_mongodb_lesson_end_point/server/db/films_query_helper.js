var MongoClient = require('mongodb').MongoClient

var filmsQueryHelper = {
  url: 'mongodb://localhost:27017/film_reviews_site',
  all: function (onQueryFinished) {

    console.log(Date.now(), 'filmsQueryHelper.all')

    MongoClient.connect(this.url, function (err, db) {
      console.log(Date.now(), 'MongoClient.connect callback')

      var filmsCollection = db.collection('films')

      filmsCollection.find().toArray(function (err, docs) {
        console.log(Date.now(), '.find().toArray() callback')
        console.log(Date.now(), 'calling onQueryFinished with docs')
        onQueryFinished(docs)
      })

    })
  }
}







//
// // Making this object one property / method at a time
// var filmsQueryHelper = {}
// filmsQueryHelper.url = 'mongodb://localhost:27017/film_reviews_site'
// filmsQueryHelper.all = function () {
//   MongoClient.connect(this.url, function (err, db) {
//     // console.log('connected')
//
//
//     var filmsCollection = db.collection('films')
//
//     filmsCollection.find().toArray(function (err, docs) {
//       console.log(docs)
//     })
//
//   })
// }

module.exports = filmsQueryHelper
