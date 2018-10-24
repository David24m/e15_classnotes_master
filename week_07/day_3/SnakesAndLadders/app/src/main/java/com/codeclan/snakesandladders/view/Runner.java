package com.codeclan.snakesandladders.view;

import com.codeclan.snakesandladders.model.Die;
import com.codeclan.snakesandladders.model.Game;
import com.codeclan.snakesandladders.model.Logger;
import com.codeclan.snakesandladders.model.Player;
import com.codeclan.snakesandladders.model.tiles.GroundHog;
import com.codeclan.snakesandladders.model.tiles.Jaguar;
import com.codeclan.snakesandladders.model.tiles.Juggler;
import com.codeclan.snakesandladders.model.tiles.Jump;

import java.util.Scanner;

/**
 * Created by stewartmackenzie-leigh on 13/09/2017.
 */

public class Runner {
    private Game game;
    private Scanner scanner;

    public Runner() {
        game = new Game(25, new Die(6), new ConsoleLogger());
        game.addTile(2, new Jump(6));
        game.addTile(3, new Jump(8));
        game.addTile(6, new GroundHog());
        game.addTile(12, new Juggler());
        game.addTile(14, new Jump(4));
        game.addTile(20, new Jump(18));
        game.addTile(23, new Jaguar());
        scanner = new Scanner(System.in);
    }

    public void addPlayer() {
        System.out.print("Enter player name: ");
        String name = this.scanner.nextLine();
        game.addPlayer(new Player(name));
    }

    public void addPlayers() {
        System.out.print("How many players? ");
        int numberOfPlayers = Integer.parseInt(this.scanner.nextLine());

        for (int i = 0; i < numberOfPlayers; i++) {
            this.addPlayer();
        }
    }

    public void playGame() {
        System.out.println("Welcome to Snakes & Ladders & other stuff");
        this.addPlayers();

        while (!this.game.playTurn()) {
            System.out.println("Press enter...");
            this.scanner.nextLine();
        }

        Player winner = this.game.getWinner();
        System.out.println(String.format("%s won!", winner.getName()));
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.playGame();
    }
}
