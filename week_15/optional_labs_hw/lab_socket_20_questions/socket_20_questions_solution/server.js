var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function (req, res) {
  res.sendFile(`${__dirname}/client/build/index.html`);
});

app.use(express.static('client/build'));

io.on('connection', function(socket){

  socket.on('currentQuestion', (questionAnswer) => {
    io.sockets.emit('currentQuestion', questionAnswer);
  });

  socket.on('currentAnswer', (questionAnswer) => {
    io.sockets.emit('currentAnswer', questionAnswer);
  });

  socket.on('celebrity', (celebrity) => {
    io.sockets.emit('celebrity', celebrity);
  })

  socket.on('changeTurn', (playerTurn) => {
    io.sockets.emit('changeTurn', playerTurn)
  })

});

var server = http.listen(3000, function () {
  var host = server.address().address;
  var port = server.address().port;

  console.log('Example app listening at http://%s:%s', host, port);
});
