package Ch3Graphics;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 * this program runs a very basic version of the random walk program
 * 5/20/2023
 * Kevin Dobruskin
 */
public class KevinDobruskinRandomWalk {
    private enum Direction { UP, DOWN, RIGHT, LEFT;

        private static final Random rand = new Random();

        public static Direction randomDirection()  {
            Direction[] directions = values();
            return directions[rand.nextInt(4)];
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var numberOfSteps = 0;
        double[] playerPosition = {0, 0};
        System.out.print("Radius: ");
        int radius = scanner.nextInt();
        DrawingPanel drawingPanel = new DrawingPanel(300, 300);
        Graphics pen = drawingPanel.getGraphics();
        pen.drawOval((150-radius),(150-radius),radius*2,radius*2);
        do {
            pen.fillRect((int) (150 + playerPosition[0]), (int) (150 + playerPosition[1]), 1, 1);
            Direction direction = Direction.randomDirection();
            switch (direction){
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
            numberOfSteps++;
        } while (Math.sqrt(Math.pow(Math.abs(playerPosition[0]), 2) + Math.pow(Math.abs(playerPosition[1]), 2)) < radius);
        System.out.println("you escaped in " + numberOfSteps + " steps");
    }
}
