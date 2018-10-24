import React from 'react';
import Comment from './Comment'

class CommentList extends React.Component {
  render() {

    const commentNodes = this.props.data.map(function(comment) {
      return (
        <Comment author={comment.author} key={comment.id}>
          {comment.text}
        </Comment>
      )
    })


    return (
      <div className="comment-list">
        {commentNodes}
      </div>
    )
  }
}

export default CommentList;