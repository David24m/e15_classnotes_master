var React = require('react');
var Card = require('./Card.jsx');

var Grid = React.createClass({

  render: function(){
    var cards = this.props.characters;

    var cardList = cards.map(function(card, index){
      return(
        <Card characteristics={card} key={index}  index={index} onFlip={this.props.onFlip}></Card>
        )
    }.bind(this))

    return(
      <div>
      {cardList}
      </div>
      )
  }
});


module.exports = Grid;
