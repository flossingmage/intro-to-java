package Ch3Graphics;

import java.awt.*;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * this program plays the random walk game
 * 5/21/2023
 * Kevin Dobruskin
 * version 2
 */
public class KevinDobruskinRandomWalkV2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int sizeOfPanel = 500;
    private static final DrawingPanel drawingPanel = new DrawingPanel(sizeOfPanel, sizeOfPanel);
    private static final Graphics pen = drawingPanel.getGraphics();

    public static void main(String[] args) throws IOException {
        var numberOfGames = 1;
        var leastSteps = randomWalk();
        var totalNumberOfSteps = leastSteps;
        while (playAgain()) {
            var numberOfSteps = randomWalk();
            totalNumberOfSteps += numberOfSteps;
            if (numberOfSteps < leastSteps) {
                leastSteps = numberOfSteps;
            }
            numberOfGames++;
        }
        Stats(numberOfGames, totalNumberOfSteps, leastSteps);
        scanner.close();
    }

    /**
     * this sets the game up to be played and then plays it
     *
     * @return number of steps taken that game
     */
    public static int randomWalk() {
        var numberOfSteps = 0;
        drawingPanel.clear();
        int[] playerPosition = {0, 0};
        int radius = getRadius();
        pen.drawOval(((sizeOfPanel / 2) - radius), ((sizeOfPanel / 2) - radius), radius * 2, radius * 2);
        numberOfSteps = playerEscape(playerPosition, radius);
        System.out.println("you escaped in " + numberOfSteps + " steps");
        return numberOfSteps;
    }

    /**
     * this runs the game
     *
     * @param playerPosition the position of the player
     * @param radius         the radius of the circle
     * @return the number of steps the player has taken
     */
    public static int playerEscape(int[] playerPosition, int radius) {
        int numberOfSteps = 0;
        do {
            playerMove(playerPosition);
            drawingPanel.sleep(1);
            numberOfSteps++;
        } while (Math.sqrt(Math.pow(playerPosition[0], 2) + Math.pow(playerPosition[1], 2)) < radius);
        return numberOfSteps;
    }

    /**
     * this gets the radius from the user
     *
     * @return the radius
     */
    public static int getRadius() {
        int aInt;
        System.out.print("Radius: ");
        String radius = scanner.next();
        try {
            aInt = Integer.parseInt(radius);
        } catch (NumberFormatException e) {
            System.out.println("Can only be an int try again");
            return getRadius();
        }
        return aInt;
    }

    /**
     * this moves the player in a random direction
     *
     * @param playerPosition the position of the player
     */
    private static void playerMove(int[] playerPosition) {
        pen.fillRect((sizeOfPanel / 2) + playerPosition[0], (sizeOfPanel / 2) + playerPosition[1], 1, 1);
        Direction direction = Direction.randomDirection();
        switch (direction) {
            case UP:
                playerPosition[0] += 1;
                break;
            case DOWN:
                playerPosition[0] -= 1;
                break;
            case RIGHT:
                playerPosition[1] += 1;
                break;
            case LEFT:
                playerPosition[1] -= 1;
                break;
        }
    }

    /**
     * this asks the user if they want to play again
     *
     * @return if they want to play again
     */
    private static boolean playAgain() {
        System.out.print("Do you want to play again? (yes/no) ");
        char answer = scanner.next().toLowerCase().charAt(0);
        System.out.println();
        return answer == ('y');
    }

    /**
     * this prints the stats of the game
     *
     * @param numberOfGames      the number of games played
     * @param totalNumberOfSteps the total number of steps taken
     * @param leastSteps         the lest steps taken in a game
     */
    public static void Stats(int numberOfGames, int totalNumberOfSteps, int leastSteps) {
        System.out.println("Stats:");
        System.out.println("Total walks: " + numberOfGames);
        System.out.println("Total steps: " + totalNumberOfSteps);
        System.out.println("Best walk: " + leastSteps);
    }

    /**
     * this is the enum that is used to randomly pick a direction
     */
    private enum Direction {
        UP, DOWN, RIGHT, LEFT;

        private static final Random rand = new Random();

        public static Direction randomDirection() {
            Direction[] directions = values();
            return directions[rand.nextInt(4)];
        }
    }
}
