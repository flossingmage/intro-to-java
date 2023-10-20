package Ch6FileProcessing;

import Ch3Graphics.DrawingPanel;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static MyUtilMethod.MyUtilMethod.playAgain;

/**
 * this program graphs the popularity of a name it also allows the user to change the year range
 * 6/4/2023
 * Kevin Dobruskin
 */

public class KevinDobruskinBabyNamesV2 {
    private static final int years = 1900;
    private static final int numOfDecades = (2010 - years) / 10;
    private static final int widthOfPanels = 50;

    public static void main(String[] args) throws FileNotFoundException {
        do {
            Scanner scan = new Scanner(new File("G:\\My Drive\\ijp\\workspace\\src\\Ch6FileProcessing\\babyNames.txt"));
            String name = intro();
            if (!CheckForName(name, scan)) {
                System.out.println("Name \"" + name + "\" not found.");
            }
        } while (playAgain("Do you want to play again? "));
        
    }

    /**
     * this method prints the intro and gets the name
     *
     * @return the name
     */
    private static String intro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program graphs the popularity of a name\nin Social Security baby name statistics\nrecorded since the year " + years + ".");
        System.out.print("\nType a name ");
        String name = scanner.next();
        scanner.close();
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    /**
     * this method prints the popularity of the name in the terminal
     *
     * @param name the name that is being graphed
     */
    private static int[] printNameInfo(String name, Scanner scan) {
        System.out.println("Popularity ranking of name \"" + name + "\"");
        int offset = 0;
        int[] decades = new int[numOfDecades];
        for (int x = 0; x < numOfDecades - 11; x++) {
            System.out.println((years + offset) + " 0");
            decades[x] = 0;
            offset += 10;
        }
        for (int x = 0; x < 11 - numOfDecades; x++) {
            scan.next();
        }
        for (int i = years + offset; i < 2010; i += 10) {
            decades[(i - years) / 10] = scan.nextInt();
            System.out.println(i + " " + decades[(i - years) / 10]);
        }
        return decades;
    }

    /**
     * this method creates the graph
     *
     * @param name    the name that is being graphed
     * @param decades the popularity of the name in each decade
     */
    private static void drawGraph(String name, int[] decades) {
        DrawingPanel panel = new DrawingPanel(widthOfPanels * numOfDecades, 560);
        Graphics pen = panel.getGraphics();
        drawYellowBars(pen, name);
        drawGrayLines(pen);
        drawLineGraph(pen, decades);
    }

    /**
     * this method returns the y value of the point on the graph
     *
     * @param y the y value of the point
     * @return the y value of the point on the graph
     */
    private static int valueOfY(int y) {
        if (y == 0) {
            return 530;
        }
        return Math.abs(y / 2) + 30;
    }

    /**
     * this method draws the yellow bars at the top and bottom of the panel
     *
     * @param pen  the pen that draws the lines
     * @param name the name that is being graphed
     */
    private static void drawYellowBars(Graphics pen, String name) {
        // this draws the yellow bars at the top and bottom
        pen.setColor(Color.YELLOW);
        pen.fillRect(0, 0, widthOfPanels * numOfDecades, 30);
        pen.fillRect(0, 530, widthOfPanels * numOfDecades, 30);
        pen.setColor(Color.BLACK);
        // this draws the text at the top and bottom
        pen.setFont(new Font("SansSerif", Font.BOLD, 16));
        pen.drawString("Ranking of name \"" + name + "\":", 0, 20);
        for (int i = years; i < 2010; i += 10) {
            pen.drawString(i + "", widthOfPanels * ((i / 10) - (years / 10)), 550);
        }
    }

    /**
     * this method draws the line graph
     *
     * @param pen     the pen that draws the lines
     * @param decades the popularity of the name in each decade
     */
    private static void drawLineGraph(Graphics pen, int[] decades) {
        for (int i = 0; i < numOfDecades; i++) {
            int x = widthOfPanels * i;
            pen.setColor(Color.black);
            pen.drawString(decades[i] + "", x, valueOfY(decades[i]));
            if (i != 0) {
                pen.setColor(Color.RED);
                pen.drawLine(x - widthOfPanels, valueOfY(decades[i - 1]), x, valueOfY(decades[i]));
            }
        }
    }

    /**
     * this method draws the gray lines
     *
     * @param pen the pen that draws the lines
     */
    private static void drawGrayLines(Graphics pen) {
        // this draws the gray lines
        pen.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < (widthOfPanels * 4 / 5) + 1; i++) {
            pen.drawLine(0, 30 + widthOfPanels * i, widthOfPanels * numOfDecades, 30 + widthOfPanels * i);
            pen.drawLine(widthOfPanels * i, 30, widthOfPanels * i, 530);
        }
    }

    /**
     * this method checks if the name exists. If the name exists it calls the methods to print the info and draw the graph
     *
     * @param name the name that is being graphed
     * @return true if the name exists
     */
    private static boolean CheckForName(String name, Scanner scan) {
        boolean doesExist = false;
        do {

            if (scan.next().equals(name)) {
                doesExist = true;
                int[] decades = printNameInfo(name, scan);
                drawGraph(name, decades);
                break;
            } else {
                scan.nextLine();
            }
        } while (scan.hasNextLine());
        return doesExist;
    }
}