package Ch6FileProcessing;

import Ch3Graphics.DrawingPanel;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static MyUtilMethod.MyUtilMethod.playAgain;


/**
 * this program graphs the popularity of a name it also allows the user to change the year range and without the use of arrays
 * 6/4/2023
 * Kevin Dobruskin
 */

public class KevinDobruskinBabyNamesV3 {
    private static final int years = 1900;
    private static final int numOfDecades = (2010 - years) / 10;
    private static final int widthOfPanels = 50;

    public static void main(String[] args) throws FileNotFoundException {
        do {
            PrintStream out2 = new PrintStream("G:\\My Drive\\ijp\\workspace\\src\\Ch6FileProcessing\\offLoadHere");
            Scanner fileScanner = new Scanner(new File("G:\\My Drive\\ijp\\workspace\\src\\Ch6FileProcessing\\babyNames.txt"));
            String name = intro();
            if (!CheckForName(name, fileScanner, out2)) {
                System.out.println("Name \"" + name + "\" not found.");
            }
        } while (playAgain("Do you want to play again (y/n): "));
        System.exit(0);
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
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    /**
     * this method prints the popularity of the name in the terminal and graph
     *
     * @param name the name that is being graphed
     * @param fileScanner the file scanner
     * @param pen  the pen that is used to draw the panel.
     */
    private static void printNameInfo(String name, Scanner fileScanner, Graphics pen, PrintStream out2) {
        out2.println("Popularity ranking of name \"" + name + "\"");
        int offset = 0;
        int prev = 0;
        int current = 0;
        int XAxis = 0;
        for (int x = 0; x < numOfDecades - 11; x++) {
            out2.println((years + offset) + " 0");
            offset += 10;
            prev = drawLineGraph(pen, prev, current, XAxis);
            XAxis += widthOfPanels;
        }
        for (int x = 0; x < 11 - numOfDecades; x++) {
            fileScanner.next();

        }
        for (int i = years + offset; i < 2010; i += 10) {
            current = fileScanner.nextInt();
            out2.println(i + " " + current);
            prev = drawLineGraph(pen, prev, current, XAxis);
            XAxis += widthOfPanels;
        }
    }

    /**
     * this method creates the graph
     *
     * @param name the name that is being graphed
     */
    private static Graphics drawGraph(String name) {
        DrawingPanel panel = new DrawingPanel(widthOfPanels * numOfDecades, 560);
        Graphics pen = panel.getGraphics();
        drawYellowBars(pen, name);
        drawGrayLines(pen);
        return pen;
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
     * @param prev    the previous value
     * @param current the current value
     * @param XAxis   the x value of the point
     * @return the current value
     */
    private static int drawLineGraph(Graphics pen, int prev, int current, int XAxis) {
        pen.setColor(Color.black);
        pen.drawString(current + "", XAxis, valueOfY(current));
        pen.setColor(Color.RED);
        pen.drawLine(XAxis - widthOfPanels, valueOfY(prev), XAxis, valueOfY(current));
        return current;
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
     * @param fileScanner the file scanner
     * @return true if the name exists
     */
    private static boolean CheckForName(String name, Scanner fileScanner, PrintStream out2) {
        boolean doesExist = false;
        do {

            if (fileScanner.next().equals(name)) {
                doesExist = true;
                Graphics pen = drawGraph(name);
                printNameInfo(name, fileScanner, pen, out2);

                break;
            } else {
                fileScanner.nextLine();
            }
        } while (fileScanner.hasNextLine());
        return doesExist;
    }
}