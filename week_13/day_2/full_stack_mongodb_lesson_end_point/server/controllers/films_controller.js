var filmsQueryHelper = require('../db/films_query_helper.js')
var express = require('express')
var filmsRouter = express.Router()

filmsRouter.get('/', function (req, res) {
  console.log(Date.now(), '/api/films route hit')


  filmsQueryHelper.all(function (films) {
    console.log(Date.now(), 'filmsQueryHelper.all callback')
    res.json(films)
  })

  // // could also name the function first:
  // var onQueryFinished = function (films) {
  //   console.log('filmsQueryHelper.all callback')
  //   res.json(films)
  // }
  // filmsQueryHelper.all(onQueryFinished)

})

module.exports = filmsRouter
