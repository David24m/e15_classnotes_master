var requestHelper = require('../helpers/request_helper.js')
var renderList = require('./list_view.js')

var onSubmit = function (event) {
  event.preventDefault()
  var form = event.target

  var titleInput = form['film-title']
  var genreInput = form['film-genre']
  var actorsInput = form['film-actors']

  var actors = actorsInput.value.split(',')

  var film = {
    title: titleInput.value,
    genre: genreInput.value,
    actors: actors
  }

  requestHelper.postRequest(
    'http://localhost:3000/api/films',
    function (result) {
      console.log('response to post request', result)
      renderList(result)
    },
    film
  )



}


var makeFormWork = function () {
  var form = document.querySelector('form#new-film-form')

  form.addEventListener('submit', onSubmit)


}


module.exports = makeFormWork
