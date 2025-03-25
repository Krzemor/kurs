package com.kodilla.rps;

import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private Player player;
    private final Enemy enemy;
    private int wins;
    private boolean end;

    public Game() {
        this.end = false;
        this.enemy = new Enemy();
        this.scanner = new Scanner(System.in);
    }

    private void setup() {
        System.out.println("Welcome to RPS Game! Please enter your username: ");
        String name = scanner.nextLine();
        player = new Player(name);

        System.out.println("Enter the number of wins required to win the game: ");
        wins = scanner.nextInt();
        scanner.nextLine();
    }

    private void displayResult(int enemyScore) {
        System.out.println("\nGame over!");
        if (player.getScore() > enemyScore) {
            System.out.println("Congratulations " + player.getUsername() + "! You won!");
        } else {
            System.out.println("Your enemy won the game :( Try again!");
        }
    }

    private boolean confirmEnd(String message) {
        System.out.println(message);
        String answer = scanner.nextLine().toLowerCase();
        return answer.equals("y");
    }

    private void afterGamePrompt() {
        System.out.print("Do you want to play again? (n - New game, x - Exit): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("x")) {
            end = true;
        } else if (!choice.equalsIgnoreCase("n")) {
            System.out.println("Invalid choice.");
            afterGamePrompt();
        }
    }

    private void play() {
        int enemyScore = 0;

        while (player.getScore() < wins && enemyScore < wins) {
            System.out.println("Chose your move (1-Rock, 2-Paper, 3-Scissors, x-Exit, n-New game): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": case "2": case "3":
                    Move playerMove = Move.fromInt(Integer.parseInt(choice));
                    Move enemyMove = enemy.getMove(playerMove);

                    System.out.println("Your move: " + playerMove);
                    System.out.println("Enemy move: " + enemyMove);

                    if (enemyMove == playerMove) {
                        System.out.println("It is a tie!");
                    } else if (playerMove == Move.ROCK && enemyMove == Move.SCISSORS ||
                            playerMove == Move.SCISSORS && enemyMove == Move.PAPER ||
                            playerMove == Move.PAPER && enemyMove == Move.ROCK) {
                        System.out.println("You win this round!");
                        player.incrementScore();
                    } else {
                        System.out.println("You lost this round!");
                        enemyScore++;
                    }
                    System.out.println("Your score: " + player.getUsername() + " " + player.getScore() + " - " + enemyScore + " Enemy\n");
                    break;

                case "x":
                   if (confirmEnd("Are you sure you want to exit? (y/n): ")) {
                       end = true;
                       return;
                   }
                   break;

                case "n":
                    if (confirmEnd("Are you sure you want to restart the game? (y/n): ")) {
                        return;
                    }
                    break;

                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
        displayResult(enemyScore);
    }

    public void start() {
        while (!end) {
            setup();
            play();
            afterGamePrompt();
        }
    }
}
