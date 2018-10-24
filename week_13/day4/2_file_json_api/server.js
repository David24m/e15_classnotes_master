var express = require('express')
var app = express()
var getAllFlowers = require('./db.js')

app.get('/api/flowers', function (req, res) {
  getAllFlowers(function (data) {
    res.json(data)
  })
})

app.listen(3000, function () {
  console.log('a server yay')
})
