var renderList = function (films) {
  var mainDiv = document.getElementById('main')

  // This is grubby:
  mainDiv.innerHTML = ''

  var list = document.createElement('ul')

  films.forEach(function (film) {
    var listItem = document.createElement('li')

    listItem.innerText = film.title

    list.appendChild(listItem)
  })


  mainDiv.appendChild(list)
}

module.exports = renderList
