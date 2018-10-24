var requestHelper = require('./helpers/request_helper.js')
var makeFormWork = require('./views/form_view.js')
var renderList = require('./views/list_view.js')

window.addEventListener('DOMContentLoaded', function () {

  // If we'd had more time we would have put this UI code in its own file
  // Perhaps in a folder called 'views', a file called film_view.js

  makeFormWork()

  requestHelper.getRequest('http://localhost:3000/api/films', function (films) {
    console.log(films)

    renderList(films)

  })


})
