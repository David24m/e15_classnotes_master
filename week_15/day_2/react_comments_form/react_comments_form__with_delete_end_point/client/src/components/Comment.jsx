import React from 'react'

class Comment extends React.Component {

  handleDelete() {
    this.props.onCommentDelete(this.props.id);
  }

  render() {
    return (
      <div className="comment">
        <h4 className="commentAuthor">
          { this.props.author }
        </h4>
        { this.props.children }
        <button onClick={ this.handleDelete.bind(this) } className="delete">Delete</button>
      </div>
    )
  }
  
}

export default Comment
