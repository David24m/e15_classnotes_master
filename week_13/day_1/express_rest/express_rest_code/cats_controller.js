var express = require('express')
var router = new express.Router()

var cats = ['Zeus', 'Lion', 'Jaguar']

// INDEX
router.get('/', function (req, res) {
  res.json(cats)
})

// SHOW
router.get('/:id', function (req, res) {
  var cat = cats[ req.params.id ]
  res.json(cat)
})

// CREATE
router.post('/', function (req, res) {
  // console.log( req.body )
  cats.push( req.body.newCat )
  res.json(cats)
})

// UPDATE
router.put('/:id', function (req, res) {
  var id = req.params.id
  var updatedCat = req.body.updatedCat

  cats[id] = updatedCat

  res.json(cats)
})

// DESTROY
router.delete('/:id', function (req, res) {
  var id = req.params.id

  cats.splice(id, 1)
  res.json(cats)
})



module.exports = router
