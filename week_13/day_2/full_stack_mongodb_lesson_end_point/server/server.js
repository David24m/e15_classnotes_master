var express = require('express')
var app = express()

app.use(express.static(__dirname + '/../client/build'))

var filmsRouter = require('./controllers/films_controller.js')

app.use('/api/films', filmsRouter)

app.listen(3000, function () {
  console.log(Date.now(), 'server started on port ' + this.address().port)
})
