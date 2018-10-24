package com.codeclan.snakesandladders.model;

import com.codeclan.snakesandladders.model.tiles.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Game implements GameState {
    private List<Player> players;
    private int currentPlayerIndex;
    private Map<Integer, Tile> board;
    private int winTile;
    private NumberGenerator numberGenerator;
    private Logger logger;

    public Game(int boardSize, NumberGenerator numberGenerator, Logger logger) {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = -1;
        this.board = new HashMap<>();
        this.winTile = boardSize - 1;
        this.numberGenerator = numberGenerator;
        this.logger = logger;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addTile(int position, Tile tile) {
        this.board.put(position, tile);
    }

    public Player getWinner() {
        for (Player player: players) {
            if (player.getPosition() >= this.winTile) {
                return player;
            }
        }

        return null;
    }

    private Player nextPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1)
                % this.players.size();
        return this.getCurrentPlayer();
    }

    public boolean playTurn() {
        // advance to the next player and advance their position
        Player player = this.nextPlayer();
        logger.logMessage(String.format("It's %s's turn...", player.getName()));

        int roll = this.numberGenerator.getNumber();
        logger.logMessage(String.format("You rolled a %d.", roll));
        player.advancePosition(roll);
        logger.logMessage(String.format("You are now at position %d.", player.getPosition()));

        // see if there is a tile on the square they've landed on
        Tile tile = this.board.get(player.getPosition());

        // if there is, apply the tile effect
        if (tile != null) {
            tile.doEffect(this);
        }

        return this.getWinner() != null;
    }


    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }

    @Override
    public Map<Integer, Tile> getBoard() {
        return board;
    }

    @Override
    public int getCurrentPlayerIndex() {
        return this.currentPlayerIndex;
    }

    @Override
    public void setCurrentPlayerIndex(int index) {
        this.currentPlayerIndex = index;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
