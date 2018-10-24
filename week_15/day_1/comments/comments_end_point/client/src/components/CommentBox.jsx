import React from 'react';
import CommentList from './CommentList';

class CommentBox extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      data: [
        {id:1, author: "Beth", text: "I love cats"},
        {id:2, author: "Alex", text: "Right!"}
      ]
    }

  }

  render() {
    return (
      <div className="comment-box">
        <CommentList data={this.state.data} />
      </div>

    )
  }
}

export default CommentBox;