package Ch3Graphics;

import java.awt.*;
import java.util.ArrayList;

/**
 * this program runs the art I created.
 * 5/25/2023
 * Kevin Dobruskin
 * version 1
 */

public class MyArt {
    public static final DrawingPanel drawingPanel = new DrawingPanel(650, 650);
    public static final Graphics pen = drawingPanel.getGraphics();
    public static ArrayList<double[]> plants = new ArrayList<>();

    public static void main(String[] args) {
        cratePlants();
        drawingPanel.setBackground(Color.black);
        while (true) {
            drawingPanel.clearWithoutRepaint();
            background();
            for (int i = 0; i < 8; i++) {
                plant(i, .1 - i * .01);
            }
            drawingPanel.sleep(100);
        }
    }

    /**
     * fills the plants in the plants array
     */
    public static void cratePlants(){
        for (int i = 0; i < 8; i++) {
            plants.add(new double[]{53 + i * 17.5, 53 + i * 18});
        }
    }

    /**
     * this draws the background
     */
    public static void background() {
        // sun
        pen.setColor(Color.yellow.brighter());
        pen.fillOval(280, 280, 100, 100);
        pen.setColor(Color.white);
        // the path the plants will follow
        int x = 0;
        for (int i = 0; i < 8; i++) {
            pen.drawOval(255 - x, 255 - x, 150 + (2 * x), 150 + (2 * x));
            x += 25;
        }
    }

    /**
     * this calls the methods to draw the plant and calculate the new position
     * @param plant the plant to be drawn
     * @param angle the angle the plant will move
     */
    public static void plant(int plant, double angle) {
        plantDraw(plant);
        calculate(plant, angle);
    }

    /**
     * this draws the plant
     * @param plant the plant to be drawn
     */
    private static void plantDraw(int plant) {
        var size = 0;
        var adjustment = 0.0;
        plantsNames direction = plantsNames.values()[plant];
        switch (direction) {
            case Mercury:
                pen.setColor(Color.red.darker());
                size = 5;
                adjustment = 2.5;
                break;
            case Venus:
                pen.setColor(Color.blue);
                size = 10;
                break;
            case Earth:
                pen.setColor(Color.green);
                size = 12;
                adjustment = -1;
                break;
            case Mars:
                pen.setColor(Color.red);
                size = 7;
                adjustment = 1.5;
                break;
            case Jupiter:
                pen.setColor(Color.yellow);
                size = 30;
                adjustment = -10;
                break;
            case Saturn:
                pen.setColor(Color.pink);
                size = 28;
                adjustment = -10.5;
                break;
            case Uranus:
                pen.setColor(Color.cyan);
                size = 18;
                adjustment = -4;
                break;
            case Neptune:
                pen.setColor(Color.cyan.darker());
                size = 18;
                adjustment = -4;
                break;
        }
        pen.fillOval((int) (plants.get(plant)[0] + 325 + adjustment), (int) (plants.get(plant)[1] + 325 + adjustment), size, size);
    }

    /**
     * this calculates the new position of the plant
     * @param plant the plant to be moved
     * @param angle the angle the plant will move
     */
    private static void calculate(int plant, double angle) {
        var x1 = (plants.get(plant)[0] * Math.cos(angle) - plants.get(plant)[1] * Math.sin(angle));
        var y1 = plants.get(plant)[0] * Math.sin(angle) + plants.get(plant)[1] * Math.cos(angle);
        plants.get(plant)[0] = x1;
        plants.get(plant)[1] = y1;
    }

    /**
     * this is the enum for the planets
     */
    private enum plantsNames{
        Mercury,Venus,Earth,Mars,Jupiter,Saturn,Uranus,Neptune
    }
}

