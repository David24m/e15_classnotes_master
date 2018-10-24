
var hideQuoteOfTheDay = function () {
  var qotd = document.getElementById('quote-of-the-day')
  qotd.classList.add('hide')
}

var recolourArticles = function () {
  var articles = document.querySelectorAll('article')

  // console.dir(articles)
  // console.dir(   Array.from(articles)   )

  for (var article of articles) {
    article.classList.add('blue')
  }
}

var makeNewQuote = function () {

  var quoteArticle = document.createElement('article')
  quoteArticle.classList.add('quote')

  var blockQuote = document.createElement('blockquote')
  blockQuote.textContent = "Should've been a jaguar"

  var cite = document.createElement('cite')
  cite.textContent = 'Harrison'

  blockQuote.appendChild(cite)

  quoteArticle.appendChild(blockQuote)

  var quotes = document.querySelector('section#quotes')
  quotes.appendChild(quoteArticle)

  console.dir(quotes)

}


var app = function() {
  // console.log('DOMContentLoaded event - JS running')

  var quotes = document.querySelectorAll('article.quote')
  quotes[1].className = 'red-quote'
  quotes[2].className += ' red-quote'
  quotes[3].classList.add('red-quote')
  // console.dir(quotes)

  hideQuoteOfTheDay()
  recolourArticles()

  makeNewQuote()
  makeNewQuote()
  makeNewQuote()

};

window.addEventListener('DOMContentLoaded', app)
