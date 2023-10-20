package Ch6FileProcessing;

import Ch3Graphics.DrawingPanel;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * this program graphs the popularity of a name in the most basic way possible
 * 6/4/2023
 * Kevin Dobruskin
 */

public class KevinDobruskinBabyNames {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("G:\\My Drive\\ijp\\workspace\\src\\Ch6FileProcessing\\babyNames.txt");
        Scanner scan = new Scanner(f);
        System.out.println("This program graphs the popularity of a name\nin Social Security baby name statistics\nrecorded since the year 1900.");
        System.out.print("Type a name ");
        String name = scanner.next();
        String searchName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        boolean doesExist = false;
        do {
            if (scan.next().equals(searchName)) {
                doesExist = true;
                System.out.println("Popularity ranking of name \""+ name + "\"");
                for (int i = 1900; i < 2010; i += 10) {
                    System.out.println(i + " " + scan.next());
                }
                DrawingPanel panel = new DrawingPanel(550, 560);
                Graphics pen = panel.getGraphics();
                pen.setColor(Color.YELLOW);
                pen.fillRect(0,0,550,30);
                pen.fillRect(0,530,550,30);
                pen.setColor(Color.BLACK);
                pen.setFont(new Font("TimesRoman", Font.BOLD, 15));
                pen.drawString("Ranking of name \""+ name + "\":", 0, 20);
                for (int i = 1900; i < 2010; i += 10) {
                    pen.drawString(i + "", 50*(i/10 - 190), 550 );
                }
                pen.setColor(Color.LIGHT_GRAY);
                for (int i = 0; i < 11; i++) {
                    pen.drawLine(0, 30 + 50*i, 550, 30 + 50*i);
                    pen.drawLine(30 +50*i, 30, 30 + 50*i, 530);
                }

                break;
            } else{
                scan.nextLine();
            }
        } while (scan.hasNextLine());
        if (!doesExist) {
            System.out.println("Name \"" + name + "\" not found.");
        }
        scanner.close();
        scan.close();
    }
}
