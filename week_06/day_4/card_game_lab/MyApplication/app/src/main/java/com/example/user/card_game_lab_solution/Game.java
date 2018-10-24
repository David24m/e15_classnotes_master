package com.example.user.card_game_lab_solution;

import java.util.ArrayList;

/**
 * Created by user on 08/09/2017.
 */

public class Game {
    Dealer dealer;
    ArrayList<Player> players;

    public Game(Dealer dealer, ArrayList<Player> players) {
        this.dealer = dealer;
        this.players = players;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void playRound() {
        dealRound();
        Player winner = getWinner();
        winner.incrementPoints();
    }

    private Player getWinner() {
        int highestValue = Integer.MIN_VALUE;
        Player winner = null;

        for (Player player: players) {
            int currentValue = player.getCard().getValue();

            if (currentValue > highestValue) {
                highestValue = currentValue;
                winner = player;
            }
        }

        return winner;
    }

    private void dealRound() {
        for (Player player: players) {
            Card card = dealer.deal();
            player.setCard(card);
        }
    }
}


















