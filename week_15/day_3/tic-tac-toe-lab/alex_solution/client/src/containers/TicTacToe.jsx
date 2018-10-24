import React from 'react';
import Grid from '../components/Grid';
import GameStatus from '../components/GameStatus';
import WinStates from '../WinStates';

class TicTacToe extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      grid: Array(9).fill(null),
      currentPlayer: "X",
      winner: null
    };

    this.takeCell = this.takeCell.bind(this);
  }

  takeCell(location) {
    if (!this.state.grid[location] && !this.state.winner) {
      const newGrid = this.state.grid.slice();
      newGrid[location] = this.state.currentPlayer;
      this.setState({ grid: newGrid }, this.checkForGameOver);
    }
  }

  checkForGameOver() {
    const grid = this.state.grid;
    const currentPlayer = this.state.currentPlayer;
    let gameOver = false;
    WinStates.forEach((winState) => {
      if (grid[winState[0]] === currentPlayer && grid[winState[1]] === currentPlayer && grid[winState[2]] === currentPlayer) {
        gameOver = true;
        this.setState({ winner: currentPlayer })
      }
    })
    if (!gameOver && this.gridComplete()) {
      gameOver = true;
      this.setState({ winner: "DRAW" });
    }
    if (!gameOver)  {
      this.nextTurn()
    } else {
      this.newGame();
    }
  }

  newGame() {
    setTimeout(() => { this.resetState() }, 2000);
  }

  gridComplete() {
    return !this.state.grid.includes(null);
  }

  nextTurn() {
    const nextPlayer = this.state.currentPlayer === "X" ? "O" : "X";
    this.setState({ currentPlayer: nextPlayer });
  }

  resetState() {
    this.setState({
      grid: Array(9).fill(null),
      currentPlayer: "X",
      winner: null
    })
  }

  render() {
    return (
      <div>
        <Grid
          grid={this.state.grid}
          takeCell={this.takeCell}
        />
        <GameStatus
          winner={this.state.winner}
        />
      </div>
    )
  }
}

export default TicTacToe;