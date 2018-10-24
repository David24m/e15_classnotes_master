var React = require('react');

var Card = React.createClass({

  handleFlip:function(){
    this.props.onFlip(this.props.index);
  },

  render: function(){
    var classes = "unflipped"
    if(this.props.characteristics.flipped){
      classes = "flipped"
    }
    return(
      <section className="container">
      <div id="card" className={classes} onClick={this.handleFlip}>
      <figure className="card-front" style={{backgroundImage: "url('" + this.props.characteristics.image + "')"}}></figure>
      <figure className="card-back"></figure>
      </div>
      </section>
    )
  }
});


module.exports = Card;
